package ai.libs.hasco.pcsbasedoptimization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ai.libs.hasco.model.ComponentInstance;
import ai.libs.jaicore.basic.IObjectEvaluator;

/**
 * 
 * @author kadirayk
 *
 */
public class BOHBOptimizer extends AbstractPCSBasedOptimizer {

	private Logger logger = LoggerFactory.getLogger(BOHBOptimizer.class);
	private Double minBudget;
	private Double maxBudget;
	private Integer nIterations;
	private String executionPath;

	/**
	 * returns a builder for the optional parameters, mandatory parameters must be
	 * given
	 * 
	 * @param input
	 * @param evaluator
	 * @return
	 */
	public static Builder BOHBOptimizerBuilder(PCSBasedOptimizerInput input,
			IObjectEvaluator<ComponentInstance, Double> evaluator) {
		return new Builder(input, evaluator);
	}

	private BOHBOptimizer(Builder builder) {
		input = builder.input;
		evaluator = builder.evaluator;
		minBudget = builder.minBudget;
		maxBudget = builder.maxBudget;
		nIterations = builder.nIterations;
		executionPath = builder.executionPath;
	}

	public static class Builder {
		private PCSBasedOptimizerInput input;
		private IObjectEvaluator<ComponentInstance, Double> evaluator;
		private Double minBudget;
		private Double maxBudget;
		private Integer nIterations;
		private String executionPath;

		public Builder(PCSBasedOptimizerInput input, IObjectEvaluator<ComponentInstance, Double> evaluator) {
			this.input = input;
			this.evaluator = evaluator;
		}

		/**
		 * executionPath is the folder that BOHBOptimizer script runs, pcs files will
		 * also be created here
		 * 
		 * @param executionPath
		 * @return
		 */
		public Builder executionPath(String executionPath) {
			this.executionPath = executionPath;
			return this;
		}
		
		/**
		 * The smallest budget to consider. Needs to be positive!
		 * 
		 * @param minBudget
		 * @return
		 */
		public Builder minBudget(Double minBudget) {
			this.minBudget = minBudget;
			return this;
		}

		/**
		 * The largest budget to consider. Needs to be larger than min_budget!
		 * 
		 * @param maxBudget
		 * @return
		 */
		public Builder maxBudget(Double maxBudget) {
			this.maxBudget = maxBudget;
			return this;
		}

		/**
		 * Number of iterations
		 * @param nIterations
		 * @return
		 */
		public Builder nIterations(Integer nIterations) {
			this.nIterations = nIterations;
			return this;
		}

		public BOHBOptimizer build() {
			return new BOHBOptimizer(this);
		}

	}

	@Override
	public void optimize(String componentName) throws OptimizationException {
		if (StringUtils.isEmpty(executionPath)) {
			throw new OptimizationException("executionPath must be set for Optimizer");
		}
		String filePath = executionPath;

		// start server thread
		startGrpcServer();

		String[] arr = componentName.split("\\.");
		String name = arr[arr.length - 1];

		try {
			setPcsFileForComponent(name, filePath);
		} catch (IOException e1) {
			logger.error(e1.getMessage());
			throw new OptimizationException(
					MessageFormat.format("Unable to set PCS file with path={0} for Component={1}", filePath, name));
		}

		String command = setOptions();

		// start BOHB
		startBOHBOptimizerScript(filePath, command);
	}

	/**
	 * Start the python script in its execution directory
	 * @param filePath
	 * @param command
	 * @throws OptimizationException
	 */
	private void startBOHBOptimizerScript(String filePath, String command) throws OptimizationException {
		PCSBasedOptimizerConfig config = PCSBasedOptimizerConfig.get("conf/smac-optimizer-config.properties");
		Integer port = config.getPort();
		ScenarioFileUtil.updateParam(filePath, "gRPC_port", String.valueOf(port));
		
		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd " + filePath + " && " + command);
		builder.redirectErrorStream(true);
		Process p = null;
		try {
			p = builder.start();
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw new OptimizationException(
					MessageFormat.format("Unable spawn python process={0} in path={1} ", command, filePath));
		}
		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

		String line = null;
		while (true) {
			try {
				line = r.readLine();
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
			System.out.println("BOHB out: " + line);
			if (line == null) {
				break;
			}
		}
	}

	/**
	 * options are appended to the command
	 * @return
	 */
	private String setOptions() {
		StringBuilder command = new StringBuilder("python BOHBOptimizerRunner.py");
		if (minBudget != null) {
			command.append(" --min_budget ").append(minBudget);
		}
		if (maxBudget != null) {
			command.append(" --max_budget ").append(maxBudget);
		}
		if (nIterations != null) {
			command.append(" --n_iterations ").append(nIterations);
		}
		return command.toString();
	}

}
