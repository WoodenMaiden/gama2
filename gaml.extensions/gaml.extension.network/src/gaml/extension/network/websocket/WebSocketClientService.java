/*******************************************************************************************************
 *
 * WebSocketClientService.java, in gaml.extension.network, is part of the source code of the GAMA modeling and
 * simulation platform (v.1.9.2).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gaml.extension.network.websocket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

import gaml.extension.network.common.IConnector;
import gaml.extension.network.common.MessageFactory;
import gaml.extension.network.common.MessageFactory.MessageType;
import gaml.extension.network.tcp.ClientService;

/**
 * The Class ClientService.
 */
public class WebSocketClientService extends ClientService {

	/** The client. */
	protected GamaClient client;

	/**
	 * Instantiates a new web socket client service.
	 *
	 * @param sk
	 *            the sk
	 * @param connector
	 *            the connector
	 */
	public WebSocketClientService(final Socket sk, final IConnector connector) {
		super(sk, connector);
	}

	/**
	 * Instantiates a new web socket client service.
	 *
	 * @param server
	 *            the server
	 * @param port
	 *            the port
	 * @param connector
	 *            the connector
	 */
	public WebSocketClientService(final String server, final int port, final IConnector connector) {
		super(server, port, connector);
	}

	@Override
	public void startService() throws UnknownHostException, IOException {
		if (socket == null) {
			try {
				final var address = new URI("ws://" + this.server + ":" + this.port);
				client = new GamaClient(address, this);
				client.connectBlocking();
				socket = client.getSocket();

			} catch (final URISyntaxException | InterruptedException e) {

				e.printStackTrace();
			}
		}
		isAlive = true;

		this.start();

	}

	@SuppressWarnings ("unchecked")
	@Override
	public void run() {
		while (this.isAlive) {}

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
		this.isAlive = false;
		if (sender != null) { sender.close(); }
		try {
			if (receiver != null) { receiver.close(); }
			socket.close();
		} catch (final IOException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void sendMessage(final String message, final String receiver) throws IOException {
		sendMessage(message);
	}

	@Override
	public void sendMessage(final String message) throws IOException {
		if (socket == null || !isOnline()) { return; }

		sender = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

		var msg = message;

		// If raw connection we do not append an end of line nor escape anything
		if (!connector.isRaw()) { msg = message.replace("\n", "@n@").replace("\b\r", "@b@@r@") + "\n"; }
		client.send(msg);

	}

}
