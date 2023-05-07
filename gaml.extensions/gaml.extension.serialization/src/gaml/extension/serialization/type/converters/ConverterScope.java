/*******************************************************************************************************
 *
 * ConverterScope.java, in gaml.extension.serialization, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.extension.serialization.type.converters;

import gama.core.runtime.IScope;

/**
 * The Class ConverterScope.
 *
 * TODO AD : What is the utility of this class ?
 */
public class ConverterScope {

	/** The scope. */
	IScope scope;

	/**
	 * Instantiates a new converter scope.
	 *
	 * @param s
	 *            the s
	 */
	public ConverterScope(final IScope s) {
		scope = s;
	}

	/**
	 * Gets the scope.
	 *
	 * @return the scope
	 */
	public IScope getScope() { return scope; }

}
