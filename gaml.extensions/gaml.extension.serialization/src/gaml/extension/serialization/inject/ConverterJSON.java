/*******************************************************************************************************
 *
 * ConverterJSON.java, in gaml.extension.serialization, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.extension.serialization.inject;

import gama.core.runtime.IScope;
import gama.core.util.serialize.IStreamConverter;
import gaml.extension.serialization.factory.StreamConverter;

public class ConverterJSON implements IStreamConverter {
	
	@Override
	public String convertObjectToJSONStream(IScope scope, Object o) {
		return StreamConverter.convertObjectToJSONStream(scope,o);
	}
}
