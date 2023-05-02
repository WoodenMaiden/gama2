/*******************************************************************************************************
 *
 * AbstractProtocol.java, in gaml.extension.network, is part of the source code of the GAMA modeling and simulation
 * platform (v.1.9.2).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gaml.extension.network.common.socket;

import gaml.extension.network.common.Connector;

/**
 * The Class AbstractProtocol.
 */
public abstract class AbstractProtocol implements IListener {

	/** The connector. */
	protected Connector _connector;
}
