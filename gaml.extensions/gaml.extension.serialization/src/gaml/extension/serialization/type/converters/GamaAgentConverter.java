/*******************************************************************************************************
 *
 * GamaAgentConverter.java, in gaml.extension.serialization, is part of the source code of the GAMA modeling and
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

import gama.core.metamodel.agent.IAgent;
import gama.core.runtime.IScope;
import gama.dev.DEBUG;
import gaml.extension.serialization.type.reference.ReferenceAgent;

/**
 * The Class GamaAgentConverter.
 */
@SuppressWarnings ({ "rawtypes" })
public class GamaAgentConverter extends AbstractGamaConverter<IAgent, IAgent> {

	/**
	 * Instantiates a new gama agent converter.
	 *
	 * @param target
	 *            the target
	 */
	public GamaAgentConverter(final Class<IAgent> target) {
		super(target);
	}

	@Override
	public boolean canConvert(final Class clazz) {
		if (ReferenceAgent.class.equals(clazz)) return false;
		return super.canConvert(clazz);
	}

	@Override
	public void write(final IScope scope, final IAgent agt, final HierarchicalStreamWriter writer,
			final MarshallingContext context) {
		writer.startNode("agentReference");
		DEBUG.OUT("ConvertAnother : AgentConverter " + agt.getClass());
		context.convertAnother(new ReferenceAgent(null, null, agt));
		DEBUG.OUT("===========END ConvertAnother : GamaAgent");
		writer.endNode();
	}

	@Override
	public IAgent read(final IScope scope, final HierarchicalStreamReader reader, final UnmarshallingContext arg1) {
		reader.moveDown();
		try {
			return (ReferenceAgent) arg1.convertAnother(null, ReferenceAgent.class);
		} finally {
			reader.moveUp();
		}
	}

}
