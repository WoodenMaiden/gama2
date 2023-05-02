/*******************************************************************************************************
 *
 * GamaPathReducer.java, in gaml.extension.serialization, is part of the source code of the GAMA modeling and simulation
 * platform (v.1.9.2).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gaml.extension.serialization.type.reduced;

import gama.core.kernel.simulation.SimulationAgent;
import gama.core.runtime.IScope;
import gama.core.util.IList;
import gama.core.util.IReference;
import gama.core.util.graph.IGraph;
import gama.core.util.path.GamaPath;
import gama.core.util.path.PathFactory;
import gaml.extension.serialization.type.reference.ReferencePath;

/**
 * The Class GamaPathReducer.
 */
public class GamaPathReducer {

	/** The g. */
	IGraph<Object, Object> g;

	/** The start. */
	Object start;

	/** The target. */
	Object target;

	/** The edges. */
	IList<Object> edges;

	/**
	 * Instantiates a new gama path reducer.
	 *
	 * @param p
	 *            the p
	 */
	public GamaPathReducer(final GamaPath p) {
		g = p.getGraph();
		start = p.getStartVertex();
		target = p.getEndVertex();
		edges = p.getEdgeList();
	}

	/**
	 * Unreference reducer.
	 *
	 * @param sim
	 *            the sim
	 */
	@SuppressWarnings ("unchecked")
	public void unreferenceReducer(final SimulationAgent sim) {
		g = (IGraph) IReference.getObjectWithoutReference(g, sim);
		start = IReference.getObjectWithoutReference(start, sim);
		target = IReference.getObjectWithoutReference(target, sim);
		edges = (IList) IReference.getObjectWithoutReference(edges, sim);
	}

	/**
	 * Construct object.
	 *
	 * @param scope
	 *            the scope
	 * @return the gama path
	 */
	public GamaPath constructObject(final IScope scope) {

		GamaPath path = null;
		if (IReference.isReference(g) || IReference.isReference(start) || IReference.isReference(target)
				|| IReference.isReference(edges)) {
			path = new ReferencePath(this);
		} else {
			path = PathFactory.newInstance(g, start, target, edges);
		}
		return path;
	}
}
