/*******************************************************************************************************
 *
 * GamaMatrixConverter.java, in gaml.extension.serialization, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.extension.serialization.type.converters;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import gama.core.runtime.IScope;
import gama.core.util.matrix.IMatrix;
import gama.dev.DEBUG;
import gaml.extension.serialization.type.reduced.GamaMatrixReducer;

/**
 * The Class GamaMatrixConverter.
 */
@SuppressWarnings ({ "rawtypes" })
public class GamaMatrixConverter extends AbstractGamaConverter<IMatrix, IMatrix> {

	/**
	 * Instantiates a new gama matrix converter.
	 *
	 * @param target
	 *            the target
	 */
	public GamaMatrixConverter(final Class<IMatrix> target) {
		super(target);
	}

	@Override
	public void write(final IScope scope, final IMatrix mat, final HierarchicalStreamWriter writer,
			final MarshallingContext context) {
		DEBUG.OUT("ConvertAnother : GamaMatrix " + mat.getClass());
		context.convertAnother(new GamaMatrixReducer(scope, mat));
		DEBUG.OUT("END --- ConvertAnother : GamaMatrix ");

	}

	@Override
	public IMatrix read(final IScope scope, final HierarchicalStreamReader reader, final UnmarshallingContext context) {
		final GamaMatrixReducer rmt = (GamaMatrixReducer) context.convertAnother(null, GamaMatrixReducer.class);
		return rmt.constructObject(scope);
	}

}
