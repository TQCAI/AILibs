package autofe.db.search;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.function.ToDoubleFunction;

import org.api4.java.ai.graphsearch.problem.implicit.graphgenerator.INodeGoalTester;
import org.api4.java.ai.graphsearch.problem.pathsearch.pathevaluation.IPathEvaluator;
import org.api4.java.algorithm.exceptions.AlgorithmException;
import org.api4.java.algorithm.exceptions.AlgorithmExecutionCanceledException;
import org.api4.java.algorithm.exceptions.AlgorithmTimeoutedException;
import org.api4.java.datastructure.graph.ILabeledPath;
import org.api4.java.datastructure.graph.implicit.IGraphGenerator;
import org.api4.java.datastructure.graph.implicit.ISingleRootGenerator;
import org.api4.java.datastructure.graph.implicit.ISuccessorGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ai.libs.jaicore.search.algorithms.standard.bestfirst.BestFirst;
import ai.libs.jaicore.search.algorithms.standard.rdfs.RandomizedDepthFirstSearch;
import ai.libs.jaicore.search.model.other.SearchGraphPath;
import ai.libs.jaicore.search.probleminputs.GraphSearchInput;
import ai.libs.jaicore.search.probleminputs.GraphSearchWithSubpathEvaluationsInput;
import autofe.db.model.database.AbstractFeature;
import autofe.db.model.database.BackwardFeature;
import autofe.db.model.database.Database;
import autofe.db.sql.DatabaseConnector;
import autofe.db.sql.DatabaseConnectorImpl;
import autofe.db.sql.RetrieveInstancesFromDatabaseFailedException;
import autofe.db.util.DBUtils;
import autofe.util.EvaluationUtils;
import weka.core.Instances;

public class DatabaseNodeEvaluator implements IPathEvaluator<DatabaseNode, String, Double> {

	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseNodeEvaluator.class);

	private static final int RANDOM_COMPLETION_PATH_LENGTH = 2;
	private static final long DEFAULT_SEED = 1;

	private int randomCompletionPathLength;
	private long seed;
	private String evaluationFunctionName;
	private DatabaseConnector databaseConnector;
	private DatabaseGraphGenerator generator;
	private Database db;
	private Random random;

	public DatabaseNodeEvaluator(final DatabaseGraphGenerator generator) {
		// Only use this constructor for test purposes
		this.generator = generator;
		this.randomCompletionPathLength = RANDOM_COMPLETION_PATH_LENGTH;
		this.seed = DEFAULT_SEED;
		this.db = generator.getDatabase();
		this.databaseConnector = new DatabaseConnectorImpl(this.db);
		this.random = new Random(this.seed);
		this.evaluationFunctionName = "COCO";
	}

	public DatabaseNodeEvaluator(final DatabaseGraphGenerator generator, final int randomCompletionPathLength, final long seed, final String evaluationFunction) {
		this.generator = generator;
		this.randomCompletionPathLength = randomCompletionPathLength;
		this.seed = seed;
		this.db = generator.getDatabase();
		this.databaseConnector = new DatabaseConnectorImpl(this.db);
		this.random = new Random(seed);
		this.evaluationFunctionName = evaluationFunction;
	}

	@Override
	public Double f(final ILabeledPath<DatabaseNode, String> node) throws InterruptedException, NoSolutionFromRandomCompletionException, DatasetEvaluationFailedException {
		if (node.getHead().getSelectedFeatures().isEmpty()) {
			LOGGER.warn("Return default value (0) for empty node");
			return 0.0;
		}
		if (node.getHead().isFinished()) {
			LOGGER.warn("Skip random completion for finished node!");
			Instances instances;
			try {
				instances = this.databaseConnector.getInstances(node.getHead().getSelectedFeatures());
			} catch (RetrieveInstancesFromDatabaseFailedException e) {
				throw new DatasetEvaluationFailedException("Could not get instances from database connector.", e);
			}
			double result = this.evaluateInstances(instances);
			LOGGER.debug("Evaluation result (without random completion) is {}", result);
			return result;
		}
		LOGGER.info("Evaluation node with features : {}", node.getHead().getSelectedFeatures());
		int requiredNumberOfFeatures = node.getHead().getSelectedFeatures().size() + this.randomCompletionPathLength;
		LOGGER.debug("Required features : {}", requiredNumberOfFeatures);

		GraphSearchInput<DatabaseNode, String> problem = new GraphSearchInput<>(new IGraphGenerator<DatabaseNode, String>() {
			@Override
			public ISingleRootGenerator<DatabaseNode> getRootGenerator() {
				return node::getHead;
			}

			@Override
			public ISuccessorGenerator<DatabaseNode, String> getSuccessorGenerator() {
				return DatabaseNodeEvaluator.this.generator.getSuccessorGenerator();
			}
		}, new INodeGoalTester<DatabaseNode, String>() {

			@Override
			public boolean isGoal(final DatabaseNode node) {
				if (node.getSelectedFeatures().size() > requiredNumberOfFeatures) {
					throw new IllegalStateException(String.format("Too many features! Required: %s , Actual: %s", requiredNumberOfFeatures, node.getSelectedFeatures().size()));
				} else if (node.getSelectedFeatures().size() < requiredNumberOfFeatures) {
					return false;
				} else {
					// Check whether node contains intermediate features
					for (AbstractFeature feature : node.getSelectedFeatures()) {
						if (feature instanceof BackwardFeature && DBUtils.isIntermediate(((BackwardFeature) feature).getPath(), DatabaseNodeEvaluator.this.db)) {
							return false;
						}
					}
					return true;
				}
			}
		});

		BestFirst<GraphSearchWithSubpathEvaluationsInput<DatabaseNode, String, Double>, DatabaseNode, String, Double> randomCompletionSearch = new RandomizedDepthFirstSearch<>(problem, this.random);

		SearchGraphPath<DatabaseNode, String> solution = null;
		try {
			solution = randomCompletionSearch.nextSolutionCandidate();
		} catch (NoSuchElementException | AlgorithmExecutionCanceledException e) {
			LOGGER.error("Error in random completion!", e);
		} catch (AlgorithmTimeoutedException e) {
			LOGGER.error("The random completion search timeouted.", e);
		} catch (AlgorithmException e) {
			LOGGER.error("An exception occurred during the random completion search.", e);
		}

		if (solution == null) {
			throw new NoSolutionFromRandomCompletionException("Random completion did not find a solution!");
		}
		DatabaseNode goalNode = solution.getNodes().get(solution.getNodes().size() - 1);
		LOGGER.debug("Result of random completion is node with features : {}", goalNode.getSelectedFeatures());

		// Terminate search
		randomCompletionSearch.cancel();

		Instances instances;
		try {
			instances = this.databaseConnector.getInstances(goalNode.getSelectedFeatures());
		} catch (RetrieveInstancesFromDatabaseFailedException e) {
			throw new DatasetEvaluationFailedException("Could not get instances for selected features from database connector.", e);
		}
		double result = this.evaluateInstances(instances);
		LOGGER.info("Evaluation result is {}", result);
		return result;
	}

	private double evaluateInstances(final Instances instances) throws DatasetEvaluationFailedException {
		ToDoubleFunction<Instances> benchmarkFunction = EvaluationUtils.getBenchmarkFunctionByName(this.evaluationFunctionName);
		try {
			return benchmarkFunction.applyAsDouble(instances);
		} catch (Exception e) {
			throw new DatasetEvaluationFailedException("Cannot evaluate instances", e);
		}
	}

	public DatabaseConnector getDatabaseConnector() {
		return this.databaseConnector;
	}

}
