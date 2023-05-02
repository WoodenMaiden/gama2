/*******************************************************************************************************
 *
 * IListener.java, in gaml.extension.network, is part of the source code of the GAMA modeling and simulation platform
 * (v.1.9.2).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gaml.extension.network.common.socket;

import java.nio.ByteBuffer;

/**
 * The listener interface for receiving i events. The class that is interested in processing a i event implements this
 * interface, and the object created with that class is registered with a component using the component's
 * <code>addIListener<code> method. When the i event occurs, that object's appropriate method is invoked.
 *
 * @see IEvent
 */
public interface IListener {

	/**
	 * On open.
	 *
	 * @param conn
	 *            the conn
	 */
	void onOpen(AbstractProtocol conn);

	/**
	 * On close.
	 *
	 * @param conn
	 *            the conn
	 * @param code
	 *            the code
	 * @param reason
	 *            the reason
	 * @param remote
	 *            the remote
	 */
	void onClose(AbstractProtocol conn, int code, String reason, boolean remote);

	/**
	 * On message.
	 *
	 * @param conn
	 *            the conn
	 * @param message
	 *            the message
	 */
	void onMessage(AbstractProtocol conn, String message);

	/**
	 * On message.
	 *
	 * @param conn
	 *            the conn
	 * @param message
	 *            the message
	 */
	void onMessage(AbstractProtocol conn, ByteBuffer message);

	/**
	 * On error.
	 *
	 * @param conn
	 *            the conn
	 * @param ex
	 *            the ex
	 */
	void onError(AbstractProtocol conn, Exception ex);

	/**
	 * On start.
	 */
	void onStart();
}
