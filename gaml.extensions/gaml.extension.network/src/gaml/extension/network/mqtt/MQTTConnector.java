/*******************************************************************************************************
 *
 * MQTTConnector.java, in gaml.extension.network, is part of the source code of the GAMA modeling and simulation
 * platform (v.1.9.2).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gaml.extension.network.mqtt;

import java.util.Calendar;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import gama.core.metamodel.agent.IAgent;
import gama.core.runtime.GAMA;
import gama.core.runtime.IScope;
import gama.dev.DEBUG;
import gaml.extension.network.common.Connector;
import gaml.extension.network.common.GamaNetworkException;
import gaml.extension.network.common.IConnector;
import gaml.extension.network.common.socket.SocketService;

/**
 * The Class MQTTConnector.
 */
public final class MQTTConnector extends Connector {

	static {
		DEBUG.OFF();
	}

	/** The default user. */
	public static String DEFAULT_USER = "gama_demo";

	/** The default local name. */
	public static String DEFAULT_LOCAL_NAME = "gama-" + Calendar.getInstance().getTimeInMillis() + "@";

	/** The default password. */
	public static String DEFAULT_PASSWORD = "gama_demo";

	/** The default host. */
	public static String DEFAULT_HOST = "vmpams.ird.fr";

	/** The default port. */
	public static String DEFAULT_PORT = "1935";

	/** The send connection. */
	protected MqttClient sendConnection = null;

	/** The simulation scope. */
	protected IScope simulationScope;

	/**
	 * Instantiates a new MQTT connector.
	 *
	 * @param scope
	 *            the scope
	 */
	public MQTTConnector(final IScope scope) {
		this.simulationScope = scope;
	}

	/**
	 * The Class Callback.
	 */
	class Callback implements MqttCallback {
		@Override
		public void connectionLost(final Throwable arg0) {
			throw GamaNetworkException.cannotBeConnectedFailure(GAMA.getSimulation().getScope());
		}

		@Override
		public void deliveryComplete(final IMqttDeliveryToken arg0) {
			DEBUG.OUT("message sended");
		}

		@Override
		public void messageArrived(final String topic, final MqttMessage message) throws Exception {
			final var body = message.toString();
			storeMessage("unknown", topic, body);
		}
	}

	@Override
	protected void releaseConnection(final IScope scope) {
		try {
			if (sendConnection != null && sendConnection.isConnected()) {
				sendConnection.disconnect();
				sendConnection = null;
			}
		} catch (final MqttException e) {
			throw GamaNetworkException.cannotBeDisconnectedFailure(scope);
		}
	}

	@Override
	protected void sendMessage(final IAgent sender, final String receiver, final String content) {
		final var mm = new MqttMessage(content.getBytes());
		try {
			DEBUG.OUT("is connected " + sendConnection.isConnected());
			sendConnection.publish(receiver, mm);
		} catch (final MqttException e) {
			DEBUG.OUT(GamaNetworkException.cannotSendMessage(sender.getScope(), receiver));
			throw GamaNetworkException.cannotSendMessage(sender.getScope(), receiver);
		}
	}

	@Override
	protected void subscribeToGroup(final IAgent agt, final String boxName) {
		try {

			sendConnection.subscribe(boxName);
		} catch (final MqttException e) {
			e.printStackTrace();
			throw GamaNetworkException.cannotSubscribeToTopic(agt.getScope(), e.toString());
		}

	}

	@Override
	public void unsubscribeGroup(final IAgent agt, final String boxName) throws GamaNetworkException {
		try {
			sendConnection.unsubscribe(boxName);
		} catch (final MqttException e) {
			throw GamaNetworkException.cannotUnsuscribeToTopic(simulationScope, boxName);
		}
	}

	@Override
	protected boolean isAlive(final IAgent agent) throws GamaNetworkException {
		return sendConnection.isConnected();
	}

	@Override
	protected void connectToServer(final IAgent agent) throws GamaNetworkException {
		if (sendConnection == null) {
			var server = this.getConfigurationParameter(IConnector.SERVER_URL);
			var port = this.getConfigurationParameter(IConnector.SERVER_PORT);
			var userName = this.getConfigurationParameter(IConnector.LOGIN);
			var password = this.getConfigurationParameter(IConnector.PASSWORD);
			var localName = this.getConfigurationParameter(IConnector.LOCAL_NAME);

			server = server == null ? MQTTConnector.DEFAULT_HOST : server;
			port = port == null ? MQTTConnector.DEFAULT_PORT : port;
			userName = userName == null ? MQTTConnector.DEFAULT_USER : userName;
			password = password == null ? MQTTConnector.DEFAULT_PASSWORD : userName;
			localName = localName == null ? MQTTConnector.DEFAULT_LOCAL_NAME + server : localName;

			DEBUG.OUT("url " + "tcp://" + server + ":" + port);

			try {
				sendConnection = new MqttClient("tcp://" + server + ":" + port, localName, new MemoryPersistence());
				final var connOpts = new MqttConnectOptions();
				connOpts.setCleanSession(true);
				sendConnection.setCallback(new Callback());
				connOpts.setCleanSession(true);
				connOpts.setKeepAliveInterval(30);
				connOpts.setUserName(userName);
				connOpts.setPassword(password.toCharArray());
				sendConnection.connect(connOpts);
				DEBUG.OUT("is connected  start " + sendConnection.isConnected());

			} catch (final MqttException e) {
				throw GamaNetworkException.cannotBeConnectedFailure(simulationScope);
			}

		}

	}

	@Override
	public SocketService getSocketService() {

		return null;
	}

}
