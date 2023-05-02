/*******************************************************************************************************
 *
 * ConnectorMessage.java, in gaml.extension.network, is part of the source code of the GAMA modeling and simulation
 * platform (v.1.9.2).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gaml.extension.network.common;

import gama.core.extensions.messaging.GamaMessage;
import gama.core.runtime.IScope;

/**
 * The Interface ConnectorMessage.
 */
public interface ConnectorMessage {

	/**
	 * Gets the sender.
	 *
	 * @return the sender
	 */
	String getSender();

	/**
	 * Gets the receiver.
	 *
	 * @return the receiver
	 */
	String getReceiver();

	/**
	 * Gets the plain contents.
	 *
	 * @return the plain contents
	 */
	String getPlainContents();

	/**
	 * Checks if is plain message.
	 *
	 * @return true, if is plain message
	 */
	boolean isPlainMessage();

	/**
	 * Checks if is command message.
	 *
	 * @return true, if is command message
	 */
	boolean isCommandMessage();

	/**
	 * Gets the contents.
	 *
	 * @param scope
	 *            the scope
	 * @return the contents
	 */
	GamaMessage getContents(IScope scope);
}
