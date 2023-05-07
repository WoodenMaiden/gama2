/*******************************************************************************************************
 *
 * LayoutGrid.java, in gama.core, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.util.graph.layout;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import gama.core.metamodel.shape.GamaPoint;
import gama.core.metamodel.shape.IShape;
import gama.core.runtime.IScope;
import gama.core.util.GamaListFactory;
import gama.core.util.GamaMapFactory;
import gama.core.util.IList;
import gama.core.util.IMap;
import gama.core.util.graph.IGraph;
import gaml.core.operators.Containers;
import gaml.core.operators.Graphs;
import gaml.core.operators.Maths;
import gaml.core.operators.Random;
import gaml.core.operators.Spatial;
import gaml.core.operators.Spatial.Queries;
import gaml.core.types.Types;

/**
 * The Class LayoutGrid.
 */
public class LayoutGrid {

	/** The graph. */
	private final IGraph<IShape, IShape> graph;

	/** The coeff sq. */
	private final double coeffSq;

	/** The envelope geometry. */
	private final IShape envelopeGeometry;

	/**
	 * Instantiates a new layout grid.
	 *
	 * @param graph
	 *            the graph
	 * @param envelopeGeometry
	 *            the envelope geometry
	 * @param coeffSq
	 *            the coeff sq
	 */
	public LayoutGrid(final IGraph<IShape, IShape> graph, final IShape envelopeGeometry, final double coeffSq) {
		this.graph = graph;
		this.envelopeGeometry = envelopeGeometry;
		this.coeffSq = coeffSq;
	}

	/**
	 * Apply layout.
	 *
	 * @param scope
	 *            the scope
	 */
	@SuppressWarnings ("null")
	public void applyLayout(final IScope scope) {

		IList<IShape> places = null;
		IMap<IShape, GamaPoint> locs = GamaMapFactory.create();
		do {
			places = Spatial.Transformations.toSquares(scope, envelopeGeometry,
					Maths.round(graph.getVertices().size() * coeffSq), false);
		} while (places.size() < graph.getVertices().size());

		IShape currentV = null;
		int dmax = -1;
		final Map<IShape, Integer> degrees = new IdentityHashMap<>();
		final int nbV = graph.getVertices().size();
		for (final IShape v : graph.getVertices()) {
			final int d = graph.degreeOf(v);
			locs.put(v, v.getLocation().copy(scope));
			degrees.put(v, d);
			if (d > dmax) {
				dmax = d;
				currentV = v;
			}
		}
		IShape center = Queries.overlapping(scope, places, envelopeGeometry.getLocation()).firstValue(scope);
		places.remove(center);
		locs.put(currentV, center.getLocation());
		final List<IShape> open = new ArrayList<>();
		final List<IShape> remaining = new ArrayList<>();
		remaining.addAll(graph.getVertices());
		remaining.remove(currentV);

		final List<IShape> close = new ArrayList<>();
		close.add(currentV);

		while (close.size() < nbV) {
			IList<IShape> neigh = Graphs.predecessorsOf(scope, graph, currentV);
			neigh.addAll(Graphs.successorsOf(scope, graph, currentV));
			neigh = Random.opShuffle(scope, neigh);

			for (final IShape n : neigh) {
				if (remaining.contains(n)) {
					center = Queries.closest_to(scope, places, locs.get(currentV));
					places.remove(center);
					locs.put(n, center.getLocation());
					open.add(n);
					remaining.remove(n);
				}
			}
			if (remaining.isEmpty()) { break; }
			dmax = -1;
			java.util.Collections.shuffle(open, scope.getRandom().getGenerator());
			for (final IShape v : open) {
				final int d = degrees.get(v);
				if (d >= dmax) {
					dmax = d;
					currentV = v;
				}
			}
			open.remove(currentV);
			close.add(currentV);
			if (open.isEmpty()) {
				IShape nV = null;
				dmax = -1;
				java.util.Collections.shuffle(remaining, scope.getRandom().getGenerator());

				for (final IShape v : remaining) {
					final int d = degrees.get(v);
					if (d > dmax) {
						dmax = d;
						nV = v;
					}
				}
				remaining.remove(nV);
				open.add(nV);
				final Set<IShape> neigh2 = new LinkedHashSet<IShape>(Graphs.predecessorsOf(scope, graph, nV));
				neigh2.addAll(Graphs.successorsOf(scope, graph, nV));

				neigh2.removeAll(close);
				neigh2.removeAll(open);
				if (!neigh2.isEmpty()) {
					final IList<GamaPoint> pts = GamaListFactory.create(Types.POINT);
					for (final IShape n : neigh2) { pts.add(locs.get(n)); }
					final GamaPoint targetLoc = (GamaPoint) Containers.opMean(scope, pts);
					center = places.size() > 0 ? Queries.closest_to(scope, places, targetLoc.getLocation())
							: locs.get(nV);
				} else {

					center = places.size() > 0 ? places.anyValue(scope) : locs.get(nV);
				}
				places.remove(center);
				locs.put(nV, center.getLocation());

			}

		}

		for (IShape v : locs.keySet()) {
			v.setLocation(locs.get(v));

		}
	}

}
