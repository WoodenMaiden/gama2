/*******************************************************************************************************
 *
 * IVarDescriptionUser.java, in gama.core, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.core.descriptions;

import gama.core.util.ICollector;

/**
 * The Interface IVarDescriptionUser.
 */
public interface IVarDescriptionUser {

	/**
	 * Collects the attributes defined in species that are being used in this structure
	 *
	 * @param species
	 *            the description of a species
	 * @param alreadyProcessed
	 *            a set of IVarDescriptionUser that have already been processed
	 * @param result
	 *            a collector which can be fed with the description of the attributes defined in the species if they
	 *            happend to be used by this expression or one of its sub-expression
	 */
	default void collectUsedVarsOf(final SpeciesDescription species,
			final ICollector<IVarDescriptionUser> alreadyProcessed, final ICollector<VariableDescription> result) {}

}
