/*******************************************************************************************************
 *
 * GamaGraphGraph6.java, in gama.core, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.util.file;

import gama.annotations.precompiler.IConcept;
import gama.annotations.precompiler.GamlAnnotations.doc;
import gama.annotations.precompiler.GamlAnnotations.file;
import gama.core.runtime.IScope;
import gama.core.runtime.exceptions.GamaRuntimeException;
import gaml.core.species.ISpecies;
import gaml.core.types.IType;

/**
 * The Class GamaGraphGraph6.
 */
@file (
		name = "graph6",
		extensions = { "graph6" },
		buffer_type = IType.GRAPH,
		concept = { IConcept.GRAPH, IConcept.FILE },
		doc = @doc ("Represents files that contain Graph information. The internal representation is a graph"))
@SuppressWarnings ({ "unchecked", "rawtypes" })
public class GamaGraphGraph6 extends GamaGraphFile {

	/**
	 * Instantiates a new gama graph graph 6.
	 *
	 * @param scope
	 *            the scope
	 * @param pn
	 *            the pn
	 * @throws GamaRuntimeException
	 *             the gama runtime exception
	 */
	@doc ("References a graph6 file by its filename")
	public GamaGraphGraph6(final IScope scope, final String pn) throws GamaRuntimeException {
		super(scope, pn);
	}

	/**
	 * Instantiates a new gama graph graph 6.
	 *
	 * @param scope
	 *            the scope
	 * @param pathName
	 *            the path name
	 * @param nodeSpecies
	 *            the node species
	 */
	@doc ("References a graph6 file by its filename and the species to use to instantiate the nodes")
	public GamaGraphGraph6(final IScope scope, final String pathName, final ISpecies nodeSpecies) {
		super(scope, pathName, nodeSpecies);
	}

	/**
	 * Instantiates a new gama graph graph 6.
	 *
	 * @param scope
	 *            the scope
	 * @param pathName
	 *            the path name
	 * @param nodeSpecies
	 *            the node species
	 * @param edgeSpecies
	 *            the edge species
	 */
	@doc ("References a graph6 file by its filename and the species to use to instantiate the nodes and the edges")
	public GamaGraphGraph6(final IScope scope, final String pathName, final ISpecies nodeSpecies,
			final ISpecies edgeSpecies) {
		super(scope, pathName, nodeSpecies, edgeSpecies);
	}

	@Override
	protected String getFileType() { return "graph6"; }

}
