/*******************************************************************************************************
 *
 * GamaListConverter.java, in gaml.extension.serialization, is part of the source code of the GAMA modeling and
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
import gama.core.util.IList;
import gama.dev.DEBUG;
import gaml.extension.serialization.type.reduced.GamaListReducer;

/**
 * The Class GamaListConverter.
 */
public class GamaListConverter extends AbstractGamaConverter<IList, IList> {

	/**
	 * Instantiates a new gama list converter.
	 *
	 * @param target
	 *            the target
	 */
	public GamaListConverter(final Class<IList> target) {
		super(target);
	}

	@Override
	public void write(final IScope scope, final IList list, final HierarchicalStreamWriter writer,
			final MarshallingContext context) {
		DEBUG.OUT("ConvertAnother : IList " + list.getClass() + " " + list.getGamlType().getContentType());
		context.convertAnother(new GamaListReducer(list));
		DEBUG.OUT("END --- ConvertAnother : IList ");

	}

	@Override
	public IList read(final IScope scope, final HierarchicalStreamReader reader, final UnmarshallingContext context) {
		final GamaListReducer rmt = (GamaListReducer) context.convertAnother(null, GamaListReducer.class);
		return rmt.constructObject(scope);
	}

}
