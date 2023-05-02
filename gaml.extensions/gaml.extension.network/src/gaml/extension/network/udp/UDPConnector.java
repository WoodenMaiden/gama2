/*******************************************************************************************************
 *
 * UDPConnector.java, in gaml.extension.network, is part of the source code of the GAMA modeling and simulation platform
 * (v.1.9.2).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gaml.extension.network.udp;

import java.net.BindException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import gama.core.extensions.messaging.GamaMessage;
import gama.core.metamodel.agent.IAgent;
import gama.core.runtime.IScope;
import gama.core.runtime.exceptions.GamaRuntimeException;
import gama.core.util.IList;
import gaml.core.operators.Cast;
import gaml.extension.network.common.Connector;
import gaml.extension.network.common.ConnectorMessage;
import gaml.extension.network.common.GamaNetworkException;
import gaml.extension.network.common.IConnector;
import gaml.extension.network.common.socket.SocketService;

/**
 * The Class UDPConnector.
 */
public class UDPConnector extends Connector {

	/** The udp server. */
	public static String _UDP_SERVER = "__udp_server";

	/** The is server. */
	private boolean is_server = false;

	/**
	 * Instantiates a new UDP connector.
	 *
	 * @param scope
	 *            the scope
	 * @param as_server
	 *            the as server
	 */
	public UDPConnector(final IScope scope, final boolean as_server) {
		is_server = as_server;
	}

	@Override
	public List<ConnectorMessage> fetchMessageBox(final IAgent agent) {
		return super.fetchMessageBox(agent);
	}

	@SuppressWarnings ("unchecked")
	@Override
	public Map<IAgent, LinkedList<ConnectorMessage>> fetchAllMessages() {
		for (final IAgent agt : this.receivedMessage.keySet()) {
			final var m = (IList<ConnectorMessage>) agt.getAttribute("messages" + agt);
			if (m != null) {
				receivedMessage.get(agt).addAll(m);
				m.clear();
				agt.setAttribute("message" + agt, m);
			}
		}
		return super.fetchAllMessages();
	}

	/**
	 * Open server socket.
	 *
	 * @param agent
	 *            the agent
	 */
	public void openServerSocket(final IAgent agent) {
		final var port = Cast.asInt(agent.getScope(), this.getConfigurationParameter(IConnector.SERVER_PORT));

		if (agent.getScope().getSimulation().getAttribute(UDPConnector._UDP_SERVER + port) == null) {
			try {
				final var sersock = new DatagramSocket(port);
				final var ssThread = new MultiThreadedUDPSocketServer(agent, sersock,
						this.getConfigurationParameter(IConnector.PACKET_SIZE));
				ssThread.start();
				agent.getScope().getSimulation().setAttribute(UDPConnector._UDP_SERVER + port, ssThread);

			} catch (final Exception e) {
				throw GamaRuntimeException.create(e, agent.getScope());
			}
		}
	}

	@Override
	protected void connectToServer(final IAgent agent) throws GamaNetworkException {
		if (is_server) { openServerSocket(agent); }
	}

	@Override
	protected void sendMessage(final IAgent sender, final String receiver, final String cont)
			throws GamaNetworkException {
		var content = cont.replace("\b\r", "@b@@r@");
		content = content.replace("\n", "@n@");

		final var sport = this.getConfigurationParameter(IConnector.SERVER_PORT);
		final var port = Cast.asInt(sender.getScope(), sport);
		final var sURL = this.getConfigurationParameter(IConnector.SERVER_URL);

		try (final var clientSocket = new DatagramSocket();) {
			final var IPAddress = InetAddress.getByName(sURL);
			final var sendData = content.getBytes();
			final var sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
			sendPacket.setData(sendData);
			clientSocket.send(sendPacket);
		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void send(final IAgent sender, final String receiver, final GamaMessage content) {
		this.sendMessage(sender, receiver, (String) content.getContents(sender.getScope()));
	}

	@Override
	protected void subscribeToGroup(final IAgent agt, final String boxName) throws GamaNetworkException {}

	@Override
	protected void unsubscribeGroup(final IAgent agt, final String boxName) throws GamaNetworkException {}

	@Override
	protected boolean isAlive(final IAgent agent) throws GamaNetworkException {
		final var sport = this.getConfigurationParameter(IConnector.SERVER_PORT);
		final var port = Cast.asInt(agent.getScope(), sport);
		final var sersock = (Thread) agent.getScope().getSimulation().getAttribute(UDPConnector._UDP_SERVER + port);
		if (sersock != null && sersock.isAlive()) return true;

		return false;
	}

	@Override
	protected void releaseConnection(final IScope scope) throws GamaNetworkException {
		final var sport = this.getConfigurationParameter(IConnector.SERVER_PORT);
		final var port = Cast.asInt(scope, sport);
		final var UDPsersock =
				(MultiThreadedUDPSocketServer) scope.getSimulation().getAttribute(UDPConnector._UDP_SERVER + port);
		try {
			if (UDPsersock != null) {
				UDPsersock.getMyServerSocket().close();
				UDPsersock.interrupt();
				scope.getSimulation().setAttribute(UDPConnector._UDP_SERVER + port, null);
			}
		} catch (final Exception e) {
			throw GamaRuntimeException.create(e, scope);
		}
	}

	@Override
	public SocketService getSocketService() { return null; }

}