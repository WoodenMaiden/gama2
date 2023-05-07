/*******************************************************************************************************
 *
 * IDisposable.java, in gama.annotations, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.annotations.common.interfaces;

/**
 * Class IDisposable.
 * 
 * @author drogoul
 * @since 13 avr. 2014
 * 
 */
public interface IDisposable {

	/**
	 * Dispose.
	 */
	default void dispose() {}

}
