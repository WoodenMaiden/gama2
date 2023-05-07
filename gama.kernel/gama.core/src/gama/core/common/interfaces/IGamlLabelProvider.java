/*******************************************************************************************************
 *
 * IGamlLabelProvider.java, in gama.core, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.common.interfaces;

import gaml.core.compilation.ast.ISyntacticElement;

/**
 * The Interface IGamlLabelProvider.
 */
public interface IGamlLabelProvider {

	/**
	 * Gets the text.
	 *
	 * @param element the element
	 * @return the text
	 */
	String getText(ISyntacticElement element);

	/**
	 * Gets the image.
	 *
	 * @param element the element
	 * @return the image
	 */
	
	Object getImageDescriptor(ISyntacticElement element);

}
