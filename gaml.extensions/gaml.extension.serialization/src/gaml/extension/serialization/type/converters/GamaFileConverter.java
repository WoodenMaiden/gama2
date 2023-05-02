/*******************************************************************************************************
 *
 * GamaFileConverter.java, in gaml.extension.serialization, is part of the source code of the GAMA modeling and
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
import gama.core.util.file.IGamaFile;
import gama.dev.DEBUG;
import gaml.extension.serialization.type.reduced.GamaFileReducer;

/**
 * The Class GamaFileConverter.
 */
public class GamaFileConverter extends AbstractGamaConverter<IGamaFile, IGamaFile> {

	/**
	 * Instantiates a new gama file converter.
	 *
	 * @param target
	 *            the target
	 */
	public GamaFileConverter(final Class<IGamaFile> target) {
		super(target);
	}

	@Override
	public void write(final IScope scope, final IGamaFile gamaFile, final HierarchicalStreamWriter writer,
			final MarshallingContext context) {
		DEBUG.OUT("ConvertAnother : GamaFileConverter " + gamaFile.getClass());
		context.convertAnother(new GamaFileReducer(scope, gamaFile));
		DEBUG.OUT("===========END ConvertAnother : GamaFile");
	}

	@Override
	public IGamaFile read(final IScope scope, final HierarchicalStreamReader reader,
			final UnmarshallingContext context) {
		final GamaFileReducer rmt = (GamaFileReducer) context.convertAnother(null, GamaFileReducer.class);
		return rmt.constructObject(scope);
	}

}
