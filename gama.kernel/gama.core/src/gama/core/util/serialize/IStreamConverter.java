/*******************************************************************************************************
 *
 * IStreamConverter.java, in gama.core, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.util.serialize;

import gama.core.runtime.IScope;

public interface IStreamConverter {
	 abstract String convertObjectToJSONStream(final IScope scope, final Object o);
}
