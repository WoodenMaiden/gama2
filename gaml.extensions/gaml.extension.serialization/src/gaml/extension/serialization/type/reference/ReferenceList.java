/*******************************************************************************************************
 *
 * ReferenceList.java, in gaml.extension.serialization, is part of the source code of the GAMA modeling and simulation
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
import gama.core.util.GamaList;
import gama.core.util.IReference;
import gaml.extension.serialization.type.reduced.GamaListReducer;

/**
 * The Class ReferenceList.
 */
public class ReferenceList extends GamaList<Object> implements IReference {

	/** The agt attr. */
	ArrayList<AgentAttribute> agtAttr;

	/** The list reducer. */
	GamaListReducer listReducer;

	/**
	 * Instantiates a new reference list.
	 *
	 * @param l
	 *            the l
	 */
	public ReferenceList(final GamaListReducer l) {
		super(l.getValuesListReducer().size(), l.getContentTypeListReducer());
		addAll(l.getValuesListReducer());
		agtAttr = new ArrayList<>();
		listReducer = l;
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

		listReducer.unreferenceReducer(sim);
		return listReducer.constructObject(sim.getScope());
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
