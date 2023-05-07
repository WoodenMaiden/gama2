/*******************************************************************************************************
 *
 * SyntacticTopLevelElement.java, in gama.core, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.core.compilation.ast;

import org.eclipse.emf.ecore.EObject;

import gaml.core.statements.Facets;

/**
 * The Class SyntacticTopLevelElement.
 */
public class SyntacticTopLevelElement extends SyntacticSpeciesElement {

	/**
	 * Instantiates a new syntactic top level element.
	 *
	 * @param keyword the keyword
	 * @param facets the facets
	 * @param statement the statement
	 */
	SyntacticTopLevelElement(final String keyword, final Facets facets, final EObject statement) {
		super(keyword, facets, statement);
	}

	/* (non-Javadoc)
	 * @see gaml.core.compilation.ast.AbstractSyntacticElement#visitGrids(gaml.core.compilation.ast.ISyntacticElement.SyntacticVisitor)
	 */
	@Override
	public void visitGrids(final SyntacticVisitor visitor) {
		visitAllChildren(visitor, GRID_FILTER);
	}

}