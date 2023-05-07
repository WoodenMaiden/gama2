/*******************************************************************************************************
 *
 * SwitchToModeling.java, in gama.ui.shared, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.shared.commands;

import gama.ui.application.workbench.PerspectiveHelper;

/**
 * The Class SwitchToModeling.
 */
public class SwitchToModeling extends SwitchToHandler {

	@Override
	public void execute() {
		PerspectiveHelper.openModelingPerspective(true, true);
	}
}
