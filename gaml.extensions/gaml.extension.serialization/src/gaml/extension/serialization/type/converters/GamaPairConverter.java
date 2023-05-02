/*******************************************************************************************************
 *
 * GamaPairConverter.java, in gaml.extension.serialization, is part of the source code of the GAMA modeling and
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
import gama.core.util.GamaPair;
import gama.dev.DEBUG;
import gaml.extension.serialization.type.reduced.GamaPairReducer;

/**
 * The Class GamaPairConverter.
 */
@SuppressWarnings ({ "rawtypes" })
public class GamaPairConverter extends AbstractGamaConverter<GamaPair, GamaPair> {

	/**
	 * Instantiates a new gama pair converter.
	 *
	 * @param target
	 *            the target
	 */
	public GamaPairConverter(final Class<GamaPair> target) {
		super(target);
	}

	@Override
	public void write(final IScope scope, final GamaPair mp, final HierarchicalStreamWriter arg1,
			final MarshallingContext arg2) {
		DEBUG.OUT("ConvertAnother : GamaPair " + mp.getClass());
		arg2.convertAnother(new GamaPairReducer(mp));
		DEBUG.OUT("END -- ConvertAnother : GamaPair " + mp.getClass());
	}

	@Override
	public GamaPair read(final IScope scope, final HierarchicalStreamReader reader,
			final UnmarshallingContext context) {
		final GamaPairReducer rmt = (GamaPairReducer) context.convertAnother(null, GamaPairReducer.class);
		return rmt.constructObject();
	}

}
