/*******************************************************************************************************
 *
 * HTTPRequestConnector.java, in gaml.extension.network, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.extension.network.httprequest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import gama.core.extensions.messaging.GamaMailbox;
import gama.core.extensions.messaging.GamaMessage;
import gama.core.extensions.messaging.MessagingSkill;
import gama.core.metamodel.agent.IAgent;
import gama.core.runtime.IScope;
import gama.core.util.GamaList;
import gama.core.util.IMap;
import gaml.extension.network.common.Connector;
import gaml.extension.network.common.GamaNetworkException;
import gaml.extension.network.common.IConnector;
import gaml.extension.network.common.socket.SocketService;
import gaml.extension.network.httprequest.utils.Utils;

/**
 * The Class HTTPRequestConnector.
 */
public class HTTPRequestConnector extends Connector {

	/** The timeout. */
	public static Integer DEFAULT_TIMEOUT = 5000;

	/** The default host. */
	public static String DEFAULT_HOST = "localhost";

	/** The default port. */
	public static String DEFAULT_PORT = "80";

	/** The ss thread. */
	// MultiThreadedArduinoReceiver ssThread;

	String host;

	/** The port. */
	String port;

	/** The request. */
	//
	private HttpRequest request;

	/**
	 * Instantiates a new HTTPRequest connector.
	 *
	 * @param scope
	 *            the scope
	 */
	public HTTPRequestConnector(final IScope scope) {}

	@Override
	protected void connectToServer(final IAgent agent) throws GamaNetworkException {
		final var host_tmp = this.getConfigurationParameter(IConnector.SERVER_URL);
		final var port_tmp = this.getConfigurationParameter(IConnector.SERVER_PORT);

		host = host_tmp == null ? HTTPRequestConnector.DEFAULT_HOST : host_tmp;
		port = port_tmp == null ? HTTPRequestConnector.DEFAULT_PORT : port_tmp;
	}

	@Override
	protected boolean isAlive(final IAgent agent) throws GamaNetworkException {

		return false;
	}

	@Override
	protected void subscribeToGroup(final IAgent agt, final String boxName) throws GamaNetworkException {

	}

	@Override
	protected void unsubscribeGroup(final IAgent agt, final String boxName) throws GamaNetworkException {

	}

	@Override
	protected void releaseConnection(final IScope scope) throws GamaNetworkException {

	}

	@SuppressWarnings ({ "rawtypes", "unchecked" })
	@Override
	public void send(final IAgent sender, final String receiver, final GamaMessage content) {
		final Object cont = content.getContents(sender.getScope());
		try {
			if (!(cont instanceof final GamaList listContent)) throw GamaNetworkException.cannotSendMessage(null,
					"The content expected to be sent is well formatted, a list [method,body,headers] is expected.");
			URI uri = null;
			try {
				uri = Utils.buildURI(host, "" + port, receiver);
			} catch (final URISyntaxException e) {
				e.printStackTrace();
			}
			final var requestBuilder = HttpRequest.newBuilder().uri(uri);
			// Management of the content.
			// The various cases are the following ones:
			// - [method] or [method,headers] if method ="GET" or "DELETE"
			// - [method,body] or [method,body,headers] otherwise ("POST", "PUT")

			IMap<String, String> headers = null;
			var body = "";

			// Element at 0 is the HTTP Method
			final var method = (String) listContent.get(0);

			if ("GET".equals(method) || "DELETE".equals(method)) {
				// either no headers or headers at location 1 of the listContent
				headers = listContent.size() > 1 ? (IMap<String, String>) listContent.get(1) : null;
				if (listContent.size() > 2) throw GamaNetworkException.cannotSendMessage(null, "" + uri
						+ ". GET/DELETE HTTP method are expecting [method] or [method,headers] only. No body.");
			} else { // "POST" / "PUT"
				if (listContent.size() <= 1) throw GamaNetworkException.cannotSendMessage(null,
						"" + uri + ". POST/PUT HTTP method are expecting a body.");
				body = (String) listContent.get(1);
				// body = Jsoner.serialize(listContent.get(1));
				headers = listContent.size() > 2 ? (IMap<String, String>) listContent.get(2) : null;
			}

			if (headers != null) {
				for (final String key : headers.keySet()) { requestBuilder.header(key, headers.get(key)); }
			}

			request = switch (method) {
				case "GET" -> requestBuilder.GET().build();
				case "POST" -> requestBuilder.POST(HttpRequest.BodyPublishers.ofString(body)).build();
				case "PUT" -> requestBuilder.PUT(HttpRequest.BodyPublishers.ofString(body)).build();
				case "DELETE" -> requestBuilder.DELETE().build();
				default -> throw GamaNetworkException.cannotSendMessage(null, "Bad HTTP action");
			};

			this.sendMessage(sender, receiver, body);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void sendMessage(final IAgent sender, final String receiver, final String content)
			throws GamaNetworkException {

		try {

			final HttpResponse<String> response =
					HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

			// Manage the response of the request
			final IMap<String, Object> responseMap = Utils.formatResponse(response);

			@SuppressWarnings ("unchecked") GamaMailbox<GamaMessage> mailbox =
					(GamaMailbox<GamaMessage>) sender.getAttribute(MessagingSkill.MAILBOX_ATTRIBUTE);
			if (mailbox == null) {
				mailbox = new GamaMailbox<>();
				sender.setAttribute(MessagingSkill.MAILBOX_ATTRIBUTE, mailbox);
			}

			final GamaMessage msg = new GamaMessage(sender.getScope(), "HTTP", sender.getName(), responseMap);

			mailbox.add(msg);

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public SocketService getSocketService() { return null; }

}
