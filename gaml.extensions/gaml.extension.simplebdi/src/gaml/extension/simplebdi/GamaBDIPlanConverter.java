/*******************************************************************************************************
 *
 * GamaBDIPlanConverter.java, in gaml.extension.simplebdi, is part of the source code of the GAMA modeling and
 * simulation platform (v.1.9.2).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gaml.extension.simplebdi;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import gama.core.runtime.IScope;
import gama.dev.DEBUG;
import gaml.extension.serialization.type.converters.AbstractGamaConverter;

/**
 * The Class GamaBDIPlanConverter.
 */
public class GamaBDIPlanConverter extends AbstractGamaConverter<BDIPlan, BDIPlan> {

	/**
	 * Instantiates a new gama BDI plan converter.
	 *
	 * @param target
	 *            the target
	 */
	public GamaBDIPlanConverter(final Class<BDIPlan> target) {
		super(target);
	}

	/**
	 * Read.
	 *
	 * @param scope
	 *            the scope
	 * @param arg0
	 *            the arg 0
	 * @param arg1
	 *            the arg 1
	 * @return the BDI plan
	 */
	@Override
	public BDIPlan read(final IScope scope, final HierarchicalStreamReader arg0, final UnmarshallingContext arg1) {
		return null;
	}

	/**
	 * Serialize.
	 *
	 * @param writer
	 *            the writer
	 * @param context
	 *            the context
	 * @param plan
	 *            the plan
	 */
	@Override
	public void write(final IScope scope, final BDIPlan plan, final HierarchicalStreamWriter writer,
			final MarshallingContext context) {
		DEBUG.OUT("ConvertAnother : BDIPlan " + plan.getClass() + " " + plan.getGamlType().getContentType());
		DEBUG.OUT("END --- ConvertAnother : BDIPlan ");

	}
}
