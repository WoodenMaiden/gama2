/*******************************************************************************************************
 *
 * CommandResponse.java, in gama.headless, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.headless.listener;

import gama.core.util.IMap;
import gama.core.util.file.json.Jsoner;
import gama.headless.core.GamaServerMessage;
import gama.headless.core.GamaServerMessageType;

public class CommandResponse  extends GamaServerMessage {

	public final IMap<String, Object> commandParameters;
	protected boolean isJson=false;
	
	public CommandResponse(final GamaServerMessageType t,final Object content, final IMap<String, Object> parameters, final boolean isJSON) {
		super(t, content);
		this.commandParameters = parameters;
		this.isJson=isJSON;
	}
	
	@Override
	public String toJson() {
		var params = commandParameters.copy(null);
		params.remove("server");
		return "{ "
				+ "\"type\": \"" + type + "\","
				+ "\"content\": " + ((isJson) ? content : Jsoner.serialize(content)) + ","

//				+ "\"content\": " + ((isJson) ? (content!=""?content:"\"\"") : Jsoner.serialize(content)) + ","
				+ "\"command\": " + Jsoner.serialize(params) 
				+ "}";
	}

}
