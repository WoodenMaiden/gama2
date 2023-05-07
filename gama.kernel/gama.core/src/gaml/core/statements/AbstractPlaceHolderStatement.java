/*******************************************************************************************************
 *
 * AbstractPlaceHolderStatement.java, in gama.core, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.core.statements;

import gama.core.runtime.IScope;
import gaml.core.descriptions.IDescription;

/**
 * The Class AbstractPlaceHolderStatement.
 */
public abstract class AbstractPlaceHolderStatement extends AbstractStatement {

	/**
	 * Instantiates a new abstract place holder statement.
	 *
	 * @param desc the desc
	 */
	public AbstractPlaceHolderStatement(final IDescription desc) {
		super(desc);
	}

	@Override
	protected Object privateExecuteIn(final IScope stack) {
		return null;
	}

}
