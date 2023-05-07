/*******************************************************************************************************
 *
 * GamaGetter.java, in gama.core, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.core.compilation;

import gama.core.runtime.IScope;

/**
 * The Interface GamaGetter.
 *
 * @param <T> the generic type
 */
@FunctionalInterface
public interface GamaGetter<T> {
	
	/**
	 * Gets the.
	 *
	 * @param scope the scope
	 * @param arguments the arguments
	 * @return the t
	 */
	T get(IScope scope, Object... arguments);

}
