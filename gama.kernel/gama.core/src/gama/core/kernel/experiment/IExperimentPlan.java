/*******************************************************************************************************
 *
 * IExperimentPlan.java, in gama.core, is part of the source code of the GAMA modeling and simulation platform
 * (v.1.9.2).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.core.kernel.experiment;

import java.util.List;
import java.util.Map;

import gama.core.kernel.batch.IExploration;
import gama.core.kernel.experiment.IParameter.Batch;
import gama.core.kernel.model.IModel;
import gama.core.kernel.simulation.SimulationAgent;
import gama.core.outputs.FileOutput;
import gama.core.outputs.IOutputManager;
import gama.core.runtime.IScope;
import gaml.core.descriptions.ExperimentDescription;
import gaml.core.expressions.IExpression;
import gaml.core.species.ISpecies;

/**
 * Written by drogoul Modified on 31 mai 2011
 *
 * @todo Description
 *
 */
public interface IExperimentPlan extends ISpecies {

	/** The test category name. */
	String TEST_CATEGORY_NAME = "Configuration of tests";

	/** The explorable category name. */
	String EXPLORABLE_CATEGORY_NAME = "Parameters to explore";

	/** The system category prefix. */
	String SYSTEM_CATEGORY_PREFIX = "Random number generation";

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	IModel getModel();

	/**
	 * Sets the model.
	 *
	 * @param model
	 *            the new model
	 */
	void setModel(final IModel model);

	/**
	 * Gets the original simulation outputs.
	 *
	 * @return the original simulation outputs
	 */
	IOutputManager getOriginalSimulationOutputs();

	/**
	 * Refresh all outputs.
	 */
	void refreshAllOutputs();

	/**
	 * Pause all outputs.
	 */
	void pauseAllOutputs();

	/**
	 * Resume all outputs.
	 */
	void resumeAllOutputs();

	/**
	 * Close all outputs.
	 */
	void closeAllOutputs();

	/**
	 * Gets the experiment outputs.
	 *
	 * @return the experiment outputs
	 */
	IOutputManager getExperimentOutputs();

	/**
	 * Checks for parameter.
	 *
	 * @param name
	 *            the name
	 * @return true, if successful
	 */
	boolean hasParameter(String name);

	/**
	 * Gets the agent.
	 *
	 * @return the agent
	 */
	ExperimentAgent getAgent();

	/**
	 * Gets the experiment scope.
	 *
	 * @return the experiment scope
	 */
	IScope getExperimentScope();

	/**
	 * Open.
	 */
	void open();

	/**
	 * Reload.
	 */
	void reload();

	/**
	 * Gets the current simulation.
	 *
	 * @return the current simulation
	 */
	SimulationAgent getCurrentSimulation();

	/**
	 * Gets the parameters.
	 *
	 * @return the parameters
	 */
	Map<String, IParameter> getParameters();

	/**
	 * Gets the exploration algorithm.
	 *
	 * @return the exploration algorithm
	 */
	IExploration getExplorationAlgorithm();

	/**
	 * Gets the log.
	 *
	 * @return the log
	 */
	FileOutput getLog();

	/**
	 * Checks if is batch.
	 *
	 * @return true, if is batch
	 */
	boolean isBatch();

	/**
	 * Checks if is memorize.
	 *
	 * @return true, if is memorize
	 */
	boolean isMemorize();

	/**
	 * Gets the explorable parameters.
	 *
	 * @return the explorable parameters
	 */
	Map<String, Batch> getExplorableParameters();

	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	IExperimentController getController();

	/**
	 * Set the controller.
	 *
	 * @return the controller
	 */
	void setController(IExperimentController ec);

	/**
	 * @return
	 */
	boolean isHeadless();

	/**
	 * Sets the headless.
	 *
	 * @param headless
	 *            the new headless
	 */
	void setHeadless(boolean headless);

	/**
	 * Gets the experiment type.
	 *
	 * @return the experiment type
	 */
	String getExperimentType();

	/**
	 * Keeps seed.
	 *
	 * @return true, if successful
	 */
	boolean keepsSeed();

	/**
	 * Keeps simulations.
	 *
	 * @return true, if successful
	 */
	boolean keepsSimulations();

	/**
	 * Checks for parameters or user commands.
	 *
	 * @return true, if successful
	 */
	boolean hasParametersOrUserCommands();

	/**
	 * Recompute and refresh all outputs.
	 */
	void recomputeAndRefreshAllOutputs();

	/**
	 * Gets the active output managers.
	 *
	 * @return the active output managers
	 */
	Iterable<IOutputManager> getActiveOutputManagers();

	/**
	 * Sets the concurrency.
	 *
	 * @param exp
	 *            the new concurrency, expected to be an expression returning an integer.
	 */
	void setConcurrency(IExpression exp);

	/**
	 * Checks if is autorun.
	 *
	 * @return true, if is autorun
	 */
	boolean isAutorun();

	/**
	 * Checks if is test.
	 *
	 * @return true, if is test
	 */
	boolean isTest();

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	@Override
	ExperimentDescription getDescription();

	/**
	 * Should be benchmarked.
	 *
	 * @return true, if successful
	 */
	boolean shouldBeBenchmarked();

	/**
	 * Gets the displayables.
	 *
	 * @return the displayables
	 */
	List<IExperimentDisplayable> getDisplayables();

}