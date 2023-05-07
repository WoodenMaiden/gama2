/*******************************************************************************************************
 *
 * WebSocketConnector.java, in gaml.extension.network, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.extension.network.websocket;

import java.io.IOException;
import java.util.ArrayList;

import gama.core.metamodel.agent.IAgent;
import gama.core.runtime.IScope;
import gaml.extension.network.common.CommandMessage.CommandType;
import gaml.extension.network.common.Connector;
import gaml.extension.network.common.GamaNetworkException;
import gaml.extension.network.common.IConnector;
import gaml.extension.network.common.MessageFactory;
import gaml.extension.network.common.socket.SocketService;

/**
 * The Class TCPConnection.
 */
public class WebSocketConnector extends Connector {

	/** The websocket server. */
	public static String _WEBSOCKET_SERVER = "__websocket_server";

	/** The websocket socket. */
	public static String _WEBSOCKET_SOCKET = "__websocket_socket";

	/** The websocket client. */
	public static String _WEBSOCKET_CLIENT = "__websocket_client";

	/** The websocket so timeout. */
	public static Integer _WEBSOCKET_SO_TIMEOUT = 100;

	/** The default host. */
	public static String DEFAULT_HOST = "localhost";

	/** The default port. */
	public static String DEFAULT_PORT = "1988";

	/** The socket. */
	private SocketService socket;

	/** The is server. */
	private final boolean isServer;

	/** The remote box name. */
	private final ArrayList<String> remoteBoxName;

	/**
	 * Instantiates a new TCP connection.
	 *
	 * @param scope
	 *            the scope
	 * @param isServer
	 *            the is server
	 */
	public WebSocketConnector(final IScope scope, final boolean isServer, final boolean isRaw) {
		this.isServer = isServer;
		this.setRaw(isRaw);
		this.remoteBoxName = new ArrayList<>();
	}

	/**
	 * Extract and apply command.
	 *
	 * @param sender
	 *            the sender
	 * @param message
	 *            the message
	 */
	protected void extractAndApplyCommand(final String sender, final String message) {
		final var mm = MessageFactory.unPackCommandMessage(sender, message);
		final var sttr = mm.getPlainContents();
		if (CommandType.NEW_GROUP.equals(mm.getCommand())) { this.remoteBoxName.add(sttr); }

		if (CommandType.REMOVE_GROUP.equals(mm.getCommand())) { this.remoteBoxName.remove(sttr); }
	}

	@Override
	protected void connectToServer(final IAgent agent) throws GamaNetworkException {
		if (isConnected) return;

		final var server = this.getConfigurationParameter(IConnector.SERVER_URL);
		final var port = Integer.parseInt(this.getConfigurationParameter(IConnector.SERVER_PORT));
		if (this.isServer) {
			socket = new WebSocketServerService(agent, port, this);
		} else {
			socket = new WebSocketClientService(server, port, this);
		}
		try {
			socket.startService();
		} catch (final IOException e) {
			e.printStackTrace();
		}
		this.setConnected();
	}

	@Override
	protected boolean isAlive(final IAgent agent) throws GamaNetworkException {
		return socket.isOnline();
	}

	@Override
	protected void subscribeToGroup(final IAgent agt, final String boxName) throws GamaNetworkException {
		if (!this.localMemberNames.containsKey(boxName)) { this.remoteBoxName.add(boxName); }
		if (!isRaw()) {
			final var cmd = MessageFactory.buildCommandMessage(socket.getLocalAddress(), socket.getRemoteAddress(),
					CommandType.NEW_GROUP, boxName);
			this.sendMessage(agt, socket.getRemoteAddress(), MessageFactory.packMessage(cmd));
		}
	}

	@Override
	protected void unsubscribeGroup(final IAgent agt, final String boxName) throws GamaNetworkException {
		this.remoteBoxName.remove(boxName);
		if (!isRaw()) {
			final var cmd = MessageFactory.buildCommandMessage(socket.getLocalAddress(), socket.getRemoteAddress(),
					CommandType.REMOVE_GROUP, boxName);
			this.sendMessage(agt, socket.getRemoteAddress(), MessageFactory.packMessage(cmd));
		}
	}

	@Override
	protected void releaseConnection(final IScope scope) throws GamaNetworkException {
		socket.stopService();
		socket = null;
		this.isConnected = false;
	}

	@Override
	protected void sendMessage(final IAgent sender, final String receiver, final String content)
			throws GamaNetworkException {
		try {
			if (socket != null) { socket.sendMessage(content); }
		} catch (final IOException e) {

			e.printStackTrace();
		}
	}

	@Override
	public SocketService getSocketService() { return socket; }

}
