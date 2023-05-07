/*******************************************************************************************************
 *
 * ReferenceAgentConverter.java, in gaml.extension.serialization, is part of the source code of the
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
import gaml.extension.serialization.type.reference.ReferenceAgent;
import gaml.extension.serialization.type.reference.ReferenceToAgent;

/**
 * The Class ReferenceAgentConverter.
 */
@SuppressWarnings ({ "rawtypes" })
public class ReferenceAgentConverter extends AbstractGamaConverter<ReferenceAgent, ReferenceAgent> {

	/**
	 * Instantiates a new reference agent converter.
	 *
	 * @param target
	 *            the target
	 */
	public ReferenceAgentConverter(final Class<ReferenceAgent> target) {
		super(target);
	}

	@Override
	public void write(final IScope scope, final ReferenceAgent refSavedAgt, final HierarchicalStreamWriter writer,
			final MarshallingContext context) {
		writer.startNode("attributeValue");
		context.convertAnother(refSavedAgt.getAttributeValue());
		writer.endNode();
	}

	@Override
	public ReferenceAgent read(final IScope scope, final HierarchicalStreamReader reader,
			final UnmarshallingContext arg1) {
		reader.moveDown();
		try {
			return new ReferenceAgent(null, null, (ReferenceToAgent) arg1.convertAnother(null, ReferenceToAgent.class));
		} finally {
			reader.moveUp();
		}
	}

}
