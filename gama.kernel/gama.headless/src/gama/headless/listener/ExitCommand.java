/*******************************************************************************************************
 *
 * ExitCommand.java, in gama.headless, is part of the source code of the
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
import gama.headless.core.GamaServerMessageType;

public class ExitCommand implements ISocketCommand {
	@Override
	public CommandResponse execute(final WebSocket socket, IMap<String, Object> map) {
		//TODO: just for compilation purposes, but makes no sense
		System.exit(0);
		return new CommandResponse(GamaServerMessageType.CommandExecutedSuccessfully, "" , map, false);
	}
}
