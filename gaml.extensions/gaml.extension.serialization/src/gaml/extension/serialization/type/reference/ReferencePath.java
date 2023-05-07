/*******************************************************************************************************
 *
 * ReferencePath.java, in gaml.extension.serialization, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.extension.serialization.type.reference;

import java.util.ArrayList;

import gama.core.kernel.simulation.SimulationAgent;
import gama.core.util.IReference;
import gama.core.util.path.GamaPath;
import gaml.extension.serialization.type.reduced.GamaPathReducer;

/**
 * The Class ReferencePath.
 */
public class ReferencePath extends GamaPath implements IReference {

	/** The agt attr. */
	ArrayList<AgentAttribute> agtAttr;

	/** The path reducer. */
	GamaPathReducer pathReducer;

	/**
	 * Instantiates a new reference path.
	 *
	 * @param p
	 *            the p
	 */
	public ReferencePath(final GamaPathReducer p) {
		agtAttr = new ArrayList<AgentAttribute>();
		pathReducer = p;
	}

	/**
	 * Construct referenced object.
	 *
	 * @param sim
	 *            the sim
	 * @return the object
	 */
	@Override
	public Object constructReferencedObject(final SimulationAgent sim) {
		pathReducer.unreferenceReducer(sim);
		return pathReducer.constructObject(sim.getScope());
	}

	/**
	 * Gets the agent attributes.
	 *
	 * @return the agent attributes
	 */
	@Override
	public ArrayList<AgentAttribute> getAgentAttributes() { return agtAttr; }

	/**
	 * Equals.
	 *
	 * @param o
	 *            the o
	 * @return true, if successful
	 */
	public boolean equals(final Object o) {
		if (o == this) return true;
		return false;
	}
}
