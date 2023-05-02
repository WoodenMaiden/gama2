/*******************************************************************************************************
 *
 * ArduinoConnector.java, in gaml.extension.network, is part of the source code of the GAMA modeling and simulation
 * platform (v.1.9.2).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gaml.extension.network.serial;

import gama.core.metamodel.agent.IAgent;
import gama.core.runtime.GAMA;
import gama.core.runtime.IScope;
import gama.core.runtime.exceptions.GamaRuntimeException;
import gaml.extension.network.common.Connector;
import gaml.extension.network.common.GamaNetworkException;
import gaml.extension.network.common.IConnector;
import gaml.extension.network.common.socket.SocketService;

/**
 * The Class ArduinoConnector.
 */
public class ArduinoConnector extends Connector {

	/** The arduino. */
	MyArduino arduino;

	/** The port. */
	String PORT = "";

	/** The baud. */
	int BAUD = 9600;

	/** The ss thread. */
	MultiThreadedArduinoReceiver ssThread;

	/**
	 * Instantiates a new arduino connector.
	 *
	 * @param scope
	 *            the scope
	 */
	public ArduinoConnector(final IScope scope) {}

	@Override
	protected void connectToServer(final IAgent agent) throws GamaNetworkException {
		final var portList = new MyPortDropdownMenu();
		portList.refreshMenu();

		// cu.usbmodem1441012
		for (var i = 0; i < portList.getItemCount(); i++) {
			System.out.println(portList.getItemAt(i));
			if (portList.getItemAt(i).contains("cu.usbmodem")) {
				System.out.println(portList.getItemAt(i));
				PORT = portList.getItemAt(i);
			}
		}
		if ("".equals(PORT)) { PORT = this.getConfigurationParameter(IConnector.SERVER_URL); }
		try {
			arduino = new MyArduino(PORT, BAUD);
		} catch (final Exception ex) {}
		if (arduino == null) {
			GAMA.reportError(agent.getScope(),
					GamaRuntimeException.warning("Cannot connect Arduino to Port: " + PORT, agent.getScope()), false);
			return;
		}
		if (arduino.openConnection()) { System.out.println("CONNECTION OPENED"); }

		ssThread = new MultiThreadedArduinoReceiver(agent, 100, arduino);
		ssThread.start();
	}

	@Override
	protected boolean isAlive(final IAgent agent) throws GamaNetworkException {
		return true;

		// return false;
	}

	@Override
	protected void subscribeToGroup(final IAgent agt, final String boxName) throws GamaNetworkException {}

	@Override
	protected void unsubscribeGroup(final IAgent agt, final String boxName) throws GamaNetworkException {}

	@Override
	protected void releaseConnection(final IScope scope) throws GamaNetworkException {
		if (ssThread != null) { ssThread.interrupt(); }
		if (arduino != null) {
			arduino.closeConnection();
			System.out.println("CONNECTION CLOSED");
		}

	}

	@Override
	protected void sendMessage(final IAgent sender, final String receiver, final String content)
			throws GamaNetworkException {

	}

	@Override
	public SocketService getSocketService() {

		return null;
	}

}
