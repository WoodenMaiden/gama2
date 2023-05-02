/*******************************************************************************************************
 *
 * ReferenceGraph.java, in gaml.extension.serialization, is part of the source code of the GAMA modeling and simulation
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
import gama.core.util.IReference;
import gama.core.util.graph.GamaGraph;
import gaml.core.types.Types;
import gaml.extension.serialization.type.reduced.GamaGraphReducer;

/**
 * The Class ReferenceGraph.
 */
public class ReferenceGraph extends GamaGraph implements IReference {
	// IAgent agt;
	/** The agt attr. */
	// String attributeName;
	ArrayList<AgentAttribute> agtAttr;

	/** The graph reducer. */
	GamaGraphReducer graphReducer;

	/**
	 * Instantiates a new reference graph.
	 *
	 * @param g
	 *            the g
	 */
	public ReferenceGraph(final GamaGraphReducer g) {
		super(null, Types.NO_TYPE, Types.NO_TYPE);
		agtAttr = new ArrayList<>();
		graphReducer = g;
	}

	// public IAgent getAgt() {return agt;}
	// public String getAttributeName() {return attributeName;}

	// public void setAgentAndAttrName(IAgent _agt, String attrName) {
	// agt = _agt;
	// attributeName = attrName;
	// }

	/**
	 * Construct referenced object.
	 *
	 * @param sim
	 *            the sim
	 * @return the object
	 */
	@Override
	public Object constructReferencedObject(final SimulationAgent sim) {

		// graphReducer.setValuesGraphReducer((GamaMap)IReference.getObjectWithoutReference(graphReducer.getValuesGraphReducer(),sim));
		// graphReducer.setEdgesWeightsGraphReducer((GamaMap)IReference.getObjectWithoutReference(graphReducer.getWeightsGraphReducer(),sim));

		// Map<Object,Object> mapWithReferences = mapReducer.getValues();
		// HashMap<Object,Object> mapWithoutReferences = new HashMap<>();

		// for(Map.Entry<Object,Object> e : mapWithReferences.entrySet()) {
		// mapWithoutReferences.put(
		// IReference.getObjectWithoutReference(e.getKey(),sim),
		// IReference.getObjectWithoutReference(e.getValue(),sim));
		// }

		// mapReducer.setValues(mapWithoutReferences);

		graphReducer.unreferenceReducer(sim);
		return graphReducer.constructObject(sim.getScope());
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
