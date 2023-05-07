/*******************************************************************************************************
 *
 * GamaListener.java, in gama.headless, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.headless.listener;

import java.io.File;
import java.io.PrintStream;
import java.net.UnknownHostException;
import java.util.concurrent.ConcurrentHashMap;

import gama.core.runtime.GAMA;
import gama.core.util.file.json.Jsoner;
import gama.headless.Application;
import gama.headless.common.Globals;
import gama.headless.core.GamaServerGUIHandler;
import gama.headless.core.GamaServerMessage;
import gama.headless.core.GamaServerMessageType;
import gama.headless.job.ManualExperimentJob;


/**
 * Class in charge of creating the socket server and handling top-level exceptions for gama-server
 *
 */
public class GamaListener {
	
	/** The instance. */
	private GamaWebSocketServer instance;
	
	/** The simulations. */
	final private ConcurrentHashMap<String, ConcurrentHashMap<String, ManualExperimentJob>> launched_experiments = new ConcurrentHashMap<String, ConcurrentHashMap<String, ManualExperimentJob>>();
	public ConcurrentHashMap<String, ConcurrentHashMap<String, ManualExperimentJob>> getLaunched_experiments() {
		return launched_experiments;
	}

	private static PrintStream errorStream;

	public GamaListener(final int p, final Application a, final boolean secure, final String jksPath, final String spwd, final String kpwd) {
		File currentJavaJarFile = new File(
				GamaListener.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		String currentJavaJarFilePath = currentJavaJarFile.getAbsolutePath();

		Globals.TEMP_PATH = currentJavaJarFilePath.replace(currentJavaJarFile.getName(), "") + "../temp";

		Globals.IMAGES_PATH = Globals.TEMP_PATH + "\\snapshot";
		GAMA.setHeadLessMode(true, new GamaServerGUIHandler()); //todo: done here and in headless simulation loader, should be refactored
		createSocketServer(p, a, secure, jksPath, spwd, kpwd);
	}
	
	/**
	 * Creates the socket server.
	 *
	 * @throws UnknownHostException the unknown host exception
	 */
	public void createSocketServer(final int port, final Application a, final boolean ssl, final String jksPath, final String spwd, final String kpwd) {
		instance = new GamaWebSocketServer(port, a, this, ssl,jksPath,spwd,kpwd);
		instance.start();
		System.out.println("Gama Listener started on port: " + instance.getPort());
		
		errorStream =  new PrintStream(System.err) {
			
			@Override
			public void println(String x) {
				super.println(x);
				instance.broadcast(Jsoner.serialize(new GamaServerMessage(GamaServerMessageType.GamaServerError , x)));
			}
		};
		System.setErr(errorStream);
		
		try {

			//empty loop to keep alive the server and catch exceptions
			while (true) {
			}
			
		} catch (Exception ex) {
			ex.printStackTrace(); //will be broadcasted to every client
		}
	}

	public ConcurrentHashMap<String, ConcurrentHashMap<String, ManualExperimentJob>> getAllExperiments() {
		return launched_experiments;
	}

	public ConcurrentHashMap<String, ManualExperimentJob> getExperimentsOf(final String socket) {
		return launched_experiments.get(socket);
	}

	public ManualExperimentJob getExperiment(final String socket, final String expid) {
		if (launched_experiments.get(socket) == null)
			return null;
		return launched_experiments.get(socket).get(expid);
	}

}
