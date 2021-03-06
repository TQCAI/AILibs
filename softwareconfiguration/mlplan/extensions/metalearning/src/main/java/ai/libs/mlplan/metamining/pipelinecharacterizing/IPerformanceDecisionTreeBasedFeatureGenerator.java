package ai.libs.mlplan.metamining.pipelinecharacterizing;

import java.util.Map;

import org.api4.java.ai.ml.core.exception.TrainingException;
import org.api4.java.common.math.IVector;

/**
 * A feature generator that is based on a decision tree. Generates new features
 * for given features together with performance values based on paths in a
 * decision tree constructed from the given examples.
 *
 * @author Helena Graf
 *
 */
public interface IPerformanceDecisionTreeBasedFeatureGenerator {

	/**
	 * Constructs an internal decision tree so that the feature generator can be
	 * used in the future to predict features for some new vector
	 * ({@link #predict(IVector)}).
	 *
	 * @param intermediatePipelineRepresentationsWithPerformanceValues
	 *            maps a features to performance value. Should only contain
	 *            numerical features.
	 * @throws Exception
	 *             if something goes wrong while constructing the tree
	 */
	void train(Map<IVector, Double> intermediatePipelineRepresentationsWithPerformanceValues) throws TrainingException;

	/**
	 * Predicts a feature vector based on a path in the constructed decision tree:
	 * Each node in the tree is given a unique index. Then, for the given vector,
	 * the tree is traversed and a feature vector is generated based on which nodes
	 * are encountered during the traversal.
	 *
	 * @param intermediatePipelineRepresentation
	 *            the feature vector for which to generate a new representation
	 * @return the new representation of the given feature vector
	 */
	IVector predict(IVector intermediatePipelineRepresentation);
}