/*******************************************************************************************************
 *
 * GamaColorConverter.java, in gaml.extension.serialization, is part of the source code of the GAMA modeling and
 * simulation platform (v.1.9.2).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gaml.extension.serialization.type.converters;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import gama.core.runtime.IScope;
import gama.core.util.GamaColor;
import gama.dev.DEBUG;
import gaml.extension.serialization.type.reduced.GamaColorReducer;

/**
 * The Class GamaColorConverter.
 */
@SuppressWarnings ("rawtypes")
public class GamaColorConverter extends AbstractGamaConverter<GamaColor, GamaColor> {

	/**
	 * Instantiates a new gama color converter.
	 *
	 * @param scope
	 *            the scope
	 * @param target
	 *            the target
	 */
	public GamaColorConverter(final Class<GamaColor> target) {
		super(target);
	}

	@Override
	public void write(final IScope scope, final GamaColor color, final HierarchicalStreamWriter writer,
			final MarshallingContext context) {
		final GamaColor mc = color;
		DEBUG.OUT("ConvertAnother : GamaColor " + mc.getClass());
		context.convertAnother(new GamaColorReducer(mc));
		DEBUG.OUT("END -- ConvertAnother : GamaColor " + mc.getClass());
	}

	@Override
	public GamaColor read(final IScope scope, final HierarchicalStreamReader reader,
			final UnmarshallingContext context) {
		final GamaColorReducer gcr = (GamaColorReducer) context.convertAnother(null, GamaColorReducer.class);
		return gcr.constructObject();
	}

}
