/*******************************************************************************************************
 *
 * GamaPopulationConverter.java, in ummisco.gama.serialize, is part of the source code of the GAMA modeling and
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
import gama.core.metamodel.population.IPopulation;
import gama.core.runtime.IScope;
import gama.core.util.IList;
import gama.dev.DEBUG;

/**
 * The Class GamaPopulationConverter.
 */
@SuppressWarnings ({ "rawtypes", "unchecked" })
public class GamaPopulationConverter extends AbstractGamaConverter<IPopulation, IList<IAgent>> {

	/**
	 * Instantiates a new gama population converter.
	 *
	 * @param target
	 *            the target
	 */
	public GamaPopulationConverter(final Class<IPopulation> target) {
		super(target);
	}

	@Override
	public void write(final IScope scope, final IPopulation pop, final HierarchicalStreamWriter writer,
			final MarshallingContext context) {
		DEBUG.OUT("ConvertAnother : GamaPopulationConverter " + pop.getClass());
		writer.startNode("agentSetFromPopulation");
		context.convertAnother(pop.getAgents(scope));
		writer.endNode();
		DEBUG.OUT("===========END ConvertAnother : GamaSavedAgentConverter");
	}

	@Override
	public IList<IAgent> read(final IScope scope, final HierarchicalStreamReader reader,
			final UnmarshallingContext context) {
		reader.moveDown();
		try {
			return (IList<IAgent>) context.convertAnother(null, IList.class);
		} finally {
			reader.moveUp();
		}
	}

}
