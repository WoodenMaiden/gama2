/*******************************************************************************************************
 *
 * Converters.java, in gaml.extension.serialization, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.extension.serialization.factory;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gama.core.metamodel.agent.IAgent;
import gama.core.metamodel.agent.SavedAgent;
import gama.core.metamodel.population.IPopulation;
import gama.core.runtime.IScope;
import gama.core.util.GamaColor;
import gama.core.util.GamaPair;
import gama.core.util.IList;
import gama.core.util.IMap;
import gama.core.util.file.IGamaFile;
import gama.core.util.graph.IGraph;
import gama.core.util.matrix.IMatrix;
import gama.core.util.path.GamaPath;
import gaml.core.species.ISpecies;
import gaml.core.types.IType;
import gaml.core.types.Types;
import gaml.extension.serialization.type.converter;
import gaml.extension.serialization.type.converters.GamaAgentConverter;
import gaml.extension.serialization.type.converters.GamaAgentConverterNetwork;
import gaml.extension.serialization.type.converters.GamaBasicTypeConverter;
import gaml.extension.serialization.type.converters.GamaColorConverter;
import gaml.extension.serialization.type.converters.GamaFileConverter;
import gaml.extension.serialization.type.converters.GamaGraphConverter;
import gaml.extension.serialization.type.converters.GamaListConverter;
import gaml.extension.serialization.type.converters.GamaListConverterNetwork;
import gaml.extension.serialization.type.converters.GamaMapConverter;
import gaml.extension.serialization.type.converters.GamaMatrixConverter;
import gaml.extension.serialization.type.converters.GamaPairConverter;
import gaml.extension.serialization.type.converters.GamaPathConverter;
import gaml.extension.serialization.type.converters.GamaPopulationConverter;
import gaml.extension.serialization.type.converters.GamaSpeciesConverter;
import gaml.extension.serialization.type.converters.IGamaConverter;
import gaml.extension.serialization.type.converters.LogConverter;
import gaml.extension.serialization.type.converters.ReferenceAgentConverter;
import gaml.extension.serialization.type.converters.SavedAgentConverter;
import gaml.extension.serialization.type.reference.ReferenceAgent;

/**
 * The Class Converters.
 */
public abstract class Converters {

	/** The Constant REGULAR. */
	private final static IGamaConverter[] REGULAR;

	/** The Constant NETWORK. */
	private final static IGamaConverter[] NETWORK;

	/** The Constant DISCOVERED. */
	private final static IGamaConverter[] DISCOVERED;

	static {
		final List<IGamaConverter> converters = new ArrayList<>();
		Types.builtInTypes.getAllTypes().forEach(t -> {
			converter converter = t.getClass().getAnnotation(converter.class);
			if (converter != null) {
				try {
					Constructor<? extends IGamaConverter> constructor = converter.value().getConstructor(Class.class);
					converters.add(constructor.newInstance(t.toClass()));
				} catch (Exception e) {}
			}
		});
		DISCOVERED = converters.toArray(new IGamaConverter[converters.size()]);
		REGULAR = concat(new IGamaConverter[] { new GamaBasicTypeConverter(IType.class),
				new GamaAgentConverter(IAgent.class), new GamaListConverter(IList.class),
				new GamaMapConverter(IMap.class), new GamaPairConverter(GamaPair.class),
				new GamaMatrixConverter(IMatrix.class), new GamaGraphConverter(IGraph.class),
				new GamaFileConverter(IGamaFile.class), new GamaColorConverter(GamaColor.class),
				new LogConverter(Object.class), new SavedAgentConverter(SavedAgent.class),
				new GamaPopulationConverter(IPopulation.class), new GamaSpeciesConverter(ISpecies.class),
				new ReferenceAgentConverter(ReferenceAgent.class), new GamaPathConverter(GamaPath.class) }, DISCOVERED);

		NETWORK = concat(new IGamaConverter[] { new GamaBasicTypeConverter(IType.class),
				new GamaAgentConverterNetwork(IAgent.class), new GamaListConverterNetwork(IList.class),
				new GamaMapConverter(IMap.class), new GamaPairConverter(GamaPair.class),
				new GamaMatrixConverter(IMatrix.class), new GamaGraphConverter(IGraph.class),
				new GamaFileConverter(IGamaFile.class), new GamaColorConverter(GamaColor.class),
				new LogConverter(Object.class), new SavedAgentConverter(SavedAgent.class),
				new GamaPopulationConverter(IPopulation.class), new GamaSpeciesConverter(ISpecies.class),
				new GamaPathConverter(GamaPath.class) }, DISCOVERED);
	}

	/**
	 * Converter factory.
	 *
	 * @param cs
	 *            the cs
	 * @return the converter[]
	 */
	public static IGamaConverter[] converterFactory(final IScope cs) {
		for (IGamaConverter c : REGULAR) { c.setScope(cs); }
		return REGULAR;
	}

	/**
	 * Converter network factory.
	 *
	 * @param cs
	 *            the cs
	 * @return the converter[]
	 */
	public static IGamaConverter[] converterNetworkFactory(final IScope cs) {
		for (IGamaConverter c : NETWORK) { c.setScope(cs); }
		return NETWORK;
	}

	/**
	 * Concat with array copy.
	 *
	 * @param <T>
	 *            the generic type
	 * @param array1
	 *            the array 1
	 * @param array2
	 *            the array 2
	 * @return the t[]
	 */
	static <T> T[] concat(final T[] array1, final T[] array2) {
		T[] result = Arrays.copyOf(array1, array1.length + array2.length);
		System.arraycopy(array2, 0, result, array1.length, array2.length);
		return result;
	}
	// END TODO
}
