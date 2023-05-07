/*******************************************************************************************************
 *
 * GamaFileReducer.java, in gaml.extension.serialization, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.extension.serialization.type.reduced;

import gama.core.runtime.IScope;
import gama.core.util.file.IGamaFile;
import gaml.core.types.GamaFileType;

/**
 * The Class GamaFileReducer.
 */
@SuppressWarnings ({ "rawtypes" })
public class GamaFileReducer {

	/** The path. */
	private final String path;

	/**
	 * Instantiates a new gama file reducer.
	 *
	 * @param scope
	 *            the scope
	 * @param f
	 *            the f
	 */
	public GamaFileReducer(final IScope scope, final IGamaFile f) {
		path = f.getPath(scope);
	}

	/**
	 * Construct object.
	 *
	 * @param scope
	 *            the scope
	 * @return the i gama file
	 */
	public IGamaFile constructObject(final IScope scope) {
		return GamaFileType.createFile(scope, path, null);// , attributes) ;
	}
}
