/*******************************************************************************************************
 *
 * GamaListReducerNetwork.java, in gaml.extension.serialization, is part of the source code of the GAMA modeling and
 * simulation platform (v.1.9.2).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gaml.extension.serialization.type.reduced;

import gama.core.runtime.IScope;
import gama.core.util.GamaListFactory;
import gama.core.util.IList;
import gaml.core.types.Types;

/**
 * The Class GamaListReducerNetwork.
 */
@SuppressWarnings ({ "rawtypes" })
public class GamaListReducerNetwork extends GamaListReducer {

	/**
	 * Instantiates a new gama list reducer network.
	 *
	 * @param l
	 *            the l
	 */
	public GamaListReducerNetwork(final IList l) {
		super(l);
	}

	@Override
	public IList constructObject(final IScope scope) {
		return GamaListFactory.create(scope, Types.NO_TYPE, this.getValuesListReducer());
	}
}
