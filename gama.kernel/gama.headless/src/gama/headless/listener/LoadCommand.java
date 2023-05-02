/*******************************************************************************************************
 *
 * LoadCommand.java, in gama.headless, is part of the source code of the GAMA modeling and simulation platform
 * (v.1.9.2).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.headless.listener;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.java_websocket.WebSocket;

import gama.core.common.GamlFileExtension;
import gama.core.kernel.model.IModel;
import gama.core.util.IMap;
import gama.core.util.file.json.GamaJsonList;
import gama.dev.DEBUG;
import gama.headless.common.Globals;
import gama.headless.core.GamaHeadlessException;
import gama.headless.core.GamaServerMessageType;
import gama.headless.core.HeadlessSimulationLoader;
import gama.headless.job.ExperimentJob;
import gama.headless.job.IExperimentJob;
import gama.headless.job.JobListFactory.JobPlanExperimentID;
import gama.headless.job.ManualExperimentJob;
import gama.headless.script.ExperimentationPlanFactory;
import gaml.core.descriptions.ExperimentDescription;

/**
 * The Class LoadCommand.
 */
public class LoadCommand implements ISocketCommand {
	@Override
	public CommandResponse execute(final WebSocket socket, final IMap<String, Object> map) {

		final GamaWebSocketServer gamaWebSocketServer = (GamaWebSocketServer) map.get("server");
		final Object model = map.get("model");
		final Object experiment = map.get("experiment");
		DEBUG.OUT("launch");
		DEBUG.OUT(model);
		DEBUG.OUT(experiment);

		if (model == null || experiment == null) return new CommandResponse(GamaServerMessageType.MalformedRequest,
				"For 'load', mandatory parameters are: 'model' and 'experiment'", map, false);
		try {
			return launchGamlSimulation(gamaWebSocketServer, socket, (GamaJsonList) map.get("parameters"),
					map.get("until") != null ? map.get("until").toString() : "", map);
		} catch (Exception e) {
			DEBUG.OUT(e);
			return new CommandResponse(GamaServerMessageType.UnableToExecuteRequest, e, map, false);
		}
	}

	/**
	 * Launch gaml simulation.
	 *
	 * @param gamaWebSocketServer
	 *            the gama web socket server
	 * @param socket
	 *            the socket
	 * @param params
	 *            the params
	 * @param end
	 *            the end
	 * @param map
	 *            the map
	 * @return the command response
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws GamaHeadlessException
	 *             the gama headless exception
	 */
	public CommandResponse launchGamlSimulation(final GamaWebSocketServer gamaWebSocketServer, final WebSocket socket,
			final GamaJsonList params, final String end, final IMap<String, Object> map)
			throws IOException, GamaHeadlessException {

		final String pathToModel = map.get("model").toString();
		final String socket_id =
				map.get("socket_id") != null ? map.get("socket_id").toString() : "" + socket.hashCode();

		File ff = new File(pathToModel);

		if (!ff.exists()) {
			DEBUG.OUT(ff.getAbsolutePath() + " does not exist");
			return new CommandResponse(GamaServerMessageType.UnableToExecuteRequest,
					"'" + ff.getAbsolutePath() + "' does not exist", map, false);
		}
		if (!GamlFileExtension.isGaml(ff.getAbsoluteFile().toString())) {
			DEBUG.OUT(ff.getAbsolutePath() + " is not a gaml file");
			return new CommandResponse(GamaServerMessageType.UnableToExecuteRequest,
					"'" + ff.getAbsolutePath() + "' is not a gaml file", map, false);
		}

		final String argExperimentName = map.get("experiment").toString();

		// we check if the experiment is present in the file
		var listExperimentsInFile = getExperimentsInFile(ff.getAbsolutePath().toString());
		if (!listExperimentsInFile.stream().anyMatch(jb -> jb.getExperimentName().equals(argExperimentName)))
			return new CommandResponse(GamaServerMessageType.UnableToExecuteRequest,
					"'" + argExperimentName + "' is not an experiment present in '" + ff.getAbsolutePath() + "'", map,
					false);

		ManualExperimentJob selectedJob = null;

		var console = map.get("console") != null ? Boolean.parseBoolean("" + map.get("console")) : true;
		var status = map.get("status") != null ? Boolean.parseBoolean("" + map.get("status")) : false;
		var dialog = map.get("dialog") != null ? Boolean.parseBoolean("" + map.get("dialog")) : false;

		selectedJob = new ManualExperimentJob(ff.getAbsoluteFile().toString(), argExperimentName, gamaWebSocketServer,
				socket, params, console, status, dialog);

		Globals.OUTPUT_PATH = ".";// TODO: why ?

		selectedJob.endCond = end;
		selectedJob.controller.directOpenExperiment();
		// If the client has not ran any experiment yet, we initialize its experiments map
		if (gamaWebSocketServer.get_listener().getExperimentsOf(socket_id) == null) {
			final ConcurrentHashMap<String, ManualExperimentJob> exps = new ConcurrentHashMap<>();
			gamaWebSocketServer.get_listener().getAllExperiments().put(socket_id, exps);
		}
		gamaWebSocketServer.get_listener().getExperimentsOf(socket_id).put(selectedJob.getExperimentID(), selectedJob);

		gamaWebSocketServer.getDefaultApp().processorQueue.execute(selectedJob.controller.executionThread);
		return new CommandResponse(GamaServerMessageType.CommandExecutedSuccessfully, selectedJob.getExperimentID(),
				map, false);
	}

	/**
	 * Gets the experiments in file.
	 *
	 * @param modelPath
	 *            the model path
	 * @return the experiments in file
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws GamaHeadlessException
	 *             the gama headless exception
	 */
	List<IExperimentJob> getExperimentsInFile(final String modelPath) throws IOException, GamaHeadlessException {
		IModel model = HeadlessSimulationLoader.loadModel(new File(modelPath), null);
		Map<JobPlanExperimentID, IExperimentJob> originalJobs = new LinkedHashMap<>();
		for (final ExperimentDescription expD : model.getDescription().getExperiments()) {
			final IExperimentJob tj = ExperimentJob.loadAndBuildJob(expD, model.getFilePath(), model);
			// TODO AD Why 12 ??
			tj.setSeed(12);
			originalJobs.put(new JobPlanExperimentID(tj.getModelName(), tj.getExperimentName()), tj);
		}
		final List<IExperimentJob> jobs = new ArrayList<>();
		final long[] seeds = { ExperimentationPlanFactory.DEFAULT_SEED };
		for (final IExperimentJob locJob : originalJobs.values()) {
			final List<IExperimentJob> res = new ArrayList<>();
			for (final long sd : seeds) {
				final IExperimentJob job = new ExperimentJob((ExperimentJob) locJob);
				job.setSeed(sd);
				job.setFinalStep(ExperimentationPlanFactory.DEFAULT_FINAL_STEP);
				res.add(job);
			}
			jobs.addAll(res);
		}
		return jobs;
	}

}
