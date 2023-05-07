/*******************************************************************************************************
 *
 * GamaMatrixReducer.java, in gaml.extension.serialization, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.extension.serialization.type.reduced;

import gama.core.metamodel.shape.GamaPoint;
import gama.core.runtime.IScope;
import gama.core.util.IList;
import gama.core.util.matrix.GamaMatrix;
import gama.core.util.matrix.IMatrix;
import gaml.core.types.GamaMatrixType;
import gaml.core.types.IType;

/**
 * The Class GamaMatrixReducer.
 */
@SuppressWarnings ({ "rawtypes" })
public class GamaMatrixReducer {

	/** The content type matrix reducer. */
	private final IType contentTypeMatrixReducer;

	/** The values matrix reducer. */
	private final IList valuesMatrixReducer;

	/** The n rows. */
	private final int nRows;

	/** The n cols. */
	private final int nCols;

	/**
	 * Instantiates a new gama matrix reducer.
	 *
	 * @param scope
	 *            the scope
	 * @param m
	 *            the m
	 */
	public GamaMatrixReducer(final IScope scope, final IMatrix<?> m) {
		contentTypeMatrixReducer = m.getGamlType().getContentType();
		nRows = m.getRows(null);
		nCols = m.getCols(null);
		valuesMatrixReducer = m.listValue(scope, contentTypeMatrixReducer, true);
	}

	/**
	 * Construct object.
	 *
	 * @param scope
	 *            the scope
	 * @return the gama matrix
	 */
	public GamaMatrix constructObject(final IScope scope) {
		return (GamaMatrix) GamaMatrixType.from(scope, valuesMatrixReducer, contentTypeMatrixReducer,
				new GamaPoint(nCols, nRows));

	}
}
