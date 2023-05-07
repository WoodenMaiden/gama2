/*******************************************************************************************************
 *
 * IGamlBuilderListener.java, in gaml.compiler, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.compiler.validation;

import gaml.core.descriptions.IDescription;
import gaml.core.descriptions.ModelDescription;
import gaml.core.descriptions.ValidationContext;

/**
 * The class IGamlBuilder.
 *
 * @author drogoul
 * @since 2 mars 2012
 *
 */
public interface IGamlBuilderListener {

	/**
	 * Validation ended.
	 *
	 * @param model
	 *
	 * @param experiments
	 *            the experiments
	 * @param status
	 *            the status
	 */
	void validationEnded(ModelDescription model, final Iterable<? extends IDescription> experiments,
			final ValidationContext status);
}
