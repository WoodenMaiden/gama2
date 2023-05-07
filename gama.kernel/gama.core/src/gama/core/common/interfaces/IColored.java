/*******************************************************************************************************
 *
 * IColored.java, in gama.core, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.common.interfaces;

import java.util.List;

import gama.core.runtime.IScope;
import gama.core.util.GamaColor;
import gama.core.util.GamaListFactory;
import gaml.core.types.Types;

public interface IColored {

	GamaColor getColor(IScope scope);

	default List<GamaColor> getColors(final IScope scope) {
		return GamaListFactory.wrap(Types.COLOR, getColor(scope));
	}

}
