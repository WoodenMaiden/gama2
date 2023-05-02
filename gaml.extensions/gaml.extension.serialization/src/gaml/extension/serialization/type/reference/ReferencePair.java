/*******************************************************************************************************
 *
 * ReferencePair.java, in gaml.extension.serialization, is part of the source code of the GAMA modeling and simulation
 * platform (v.1.9.2).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gaml.extension.serialization.type.reference;

import java.util.ArrayList;

import gama.core.kernel.simulation.SimulationAgent;
import gama.core.util.GamaPair;
import gama.core.util.IReference;
import gaml.core.types.Types;
import gaml.extension.serialization.type.reduced.GamaPairReducer;

/**
 * The Class ReferencePair.
 */
public class ReferencePair extends GamaPair<Object, Object> implements IReference {

	/** The agt attr. */
	ArrayList<AgentAttribute> agtAttr;

	/** The pair reducer. */
	GamaPairReducer pairReducer;

	/**
	 * Instantiates a new reference pair.
	 *
	 * @param p
	 *            the p
	 */
	public ReferencePair(final GamaPairReducer p) {
		super(null, null, Types.NO_TYPE, Types.NO_TYPE);
		agtAttr = new ArrayList<>();
		pairReducer = p;
	}

	/**
	 * Gets the pair reducer.
	 *
	 * @return the pair reducer
	 */
	public GamaPairReducer getPairReducer() { return pairReducer; }

	/**
	 * Construct referenced object.
	 *
	 * @param sim
	 *            the sim
	 * @return the object
	 */
	@Override
	public Object constructReferencedObject(final SimulationAgent sim) {
		pairReducer.unreferenceReducer(sim);
		return pairReducer.constructObject();
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
