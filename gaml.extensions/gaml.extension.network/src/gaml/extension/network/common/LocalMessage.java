/*******************************************************************************************************
 *
 * LocalMessage.java, in gaml.extension.network, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.extension.network.common;

import gama.core.extensions.messaging.GamaMessage;
import gama.core.runtime.IScope;

/**
 * The Class LocalMessage.
 */
public class LocalMessage implements ConnectorMessage {

	/** The internal message. */
	private final Object internalMessage;

	/** The receiver. */
	private final String receiver;

	/** The sender. */
	private final String sender;

	/**
	 * Instantiates a new local message.
	 *
	 * @param sender
	 *            the sender
	 * @param receiver
	 *            the receiver
	 * @param ct
	 *            the ct
	 */
	public LocalMessage(final String sender, final String receiver, final Object ct) {
		this.sender = sender;
		this.receiver = receiver;
		this.internalMessage = ct;
	}

	@Override
	public String getSender() { return sender; }

	@Override
	public String getReceiver() { return receiver; }

	@Override
	public String getPlainContents() { return this.internalMessage.toString(); }

	@Override
	public boolean isPlainMessage() { return false; }

	@Override
	public GamaMessage getContents(final IScope scope) {
		GamaMessage message = null;
		if (internalMessage instanceof GamaMessage) {
			message = (GamaMessage) internalMessage;
		} else {
			message = new GamaMessage(scope, sender, receiver, internalMessage);
		}
		message.hasBeenReceived(scope);
		return message;
	}

	@Override
	public boolean isCommandMessage() {

		return false;
	}

}
