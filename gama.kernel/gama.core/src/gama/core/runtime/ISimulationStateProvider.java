/*******************************************************************************************************
 *
 * ISimulationStateProvider.java, in gama.core, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.runtime;

/**
 * The class ISimulationStateProvider.
 *
 * @author drogoul
 * @since 14 d�c. 2011
 *
 */
public interface ISimulationStateProvider {

	/**
	 * Change the UI state based on the state of the simulation (none, stopped, running or notready)
	 */
	void updateStateTo(final String state);

}