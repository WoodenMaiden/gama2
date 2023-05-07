/*******************************************************************************************************
 *
 * ISocketCommand.java, in gama.headless, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.headless.listener;

import org.java_websocket.WebSocket;

import gama.core.util.IMap;
import gama.headless.core.GamaServerMessage;

public interface ISocketCommand {
 

	public GamaServerMessage execute(final WebSocket socket, final IMap<String, Object> map);

	
}
