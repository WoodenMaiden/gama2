/*******************************************************************************************************
 *
 * WebSocketServerService.java, in gaml.extension.network, is part of the source code of the GAMA modeling and
 * simulation platform (v.1.9.2).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gaml.extension.network.websocket;

import java.io.IOException;
import java.net.UnknownHostException;

import gama.core.metamodel.agent.IAgent;
import gaml.extension.network.common.IConnector;
import gaml.extension.network.common.MessageFactory;
import gaml.extension.network.common.MessageFactory.MessageType;
import gaml.extension.network.tcp.ServerService;
import gaml.extension.network.tcp.TCPConnector;

/**
 * The Class ServerService.
 */
public class WebSocketServerService extends ServerService {

	/** The server socket. */
	protected GamaServer serverSocket;

	/**
	 * Instantiates a new web socket server service.
	 *
	 * @param agent
	 *            the agent
	 * @param port
	 *            the port
	 * @param conn
	 *            the conn
	 */
	public WebSocketServerService(final IAgent agent, final int port, final IConnector conn) {
		super(agent, port, conn);
	}

	@Override
	public void startService() throws UnknownHostException, IOException {
		this.serverSocket = new GamaServer(port, this);
		this.isAlive = true;
		this.isOnline = true;
		this.start();
		this.serverSocket.start();
	}

	@Override
	public void run() {
		while (this.isAlive) {
			isOnline = true;

		}
		// DEBUG.OUT("closed ");
		try {
			myAgent.setAttribute(TCPConnector._TCP_SERVER + serverSocket.getPort(), null);
		} catch (final Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void sendMessage(final String msg) throws IOException {
		var message = msg;
		if (serverSocket == null || !isOnline()) { return; }
		if (!connector.isRaw()) {
			message = message.replace("\n", "@n@");
			message = message.replace("\b\r", "@b@@r@");
		}
		serverSocket.broadcast(message);
	}

	@Override
	public void receivedMessage(final String sender, final String message) {
		final var mte = MessageFactory.identifyMessageType(message);
		if (MessageType.COMMAND_MESSAGE.equals(mte)) {
			((WebSocketConnector) connector).extractAndApplyCommand(sender, message);
		} else {
			final var r =
					((WebSocketConnector) connector).isRaw() ? message : MessageFactory.unpackReceiverName(message);
			((WebSocketConnector) connector).storeMessage(sender, r, message);
		}
	}

	@Override
	public void stopService() {
		isOnline = false;
		isAlive = false;

		if (sender != null) { sender.close(); }
		if (serverSocket != null) {
			try {
				serverSocket.stop(1000);
			} catch (final InterruptedException e) {

				e.printStackTrace();
			}
		}
		this.interrupt();
	}

}
