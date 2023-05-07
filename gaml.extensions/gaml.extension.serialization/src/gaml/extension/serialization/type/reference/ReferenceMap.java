/*******************************************************************************************************
 *
 * ReferenceMap.java, in gaml.extension.serialization, is part of the source code of the
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
import gama.core.util.GamaMap;
import gama.core.util.IReference;
import gaml.extension.serialization.type.reduced.GamaMapReducer;

/**
 * The Class ReferenceMap.
 */
public class ReferenceMap extends GamaMap implements IReference {

	/** The agt attr. */
	ArrayList<AgentAttribute> agtAttr;

	/** The map reducer. */
	GamaMapReducer mapReducer;

	/**
	 * Instantiates a new reference map.
	 *
	 * @param m
	 *            the m
	 */
	public ReferenceMap(final GamaMapReducer m) {
		super(m.getValues().size(), m.getKeysType(), m.getDataType());
		agtAttr = new ArrayList<>();
		mapReducer = m;
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
		mapReducer.unreferenceReducer(sim);
		return mapReducer.constructObject(sim.getScope());
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
	@Override
	public boolean equals(final Object o) {
		if (o == this) return true;
		return false;
	}
}
