/*******************************************************************************************************
 *
 * PreferencesHandler.java, in gama.ui.shared, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.shared.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import gama.ui.shared.views.GamaPreferencesView;

/**
 * The Class PreferencesHandler.
 */
public class PreferencesHandler extends AbstractHandler {

	// GamaPreferencesView view;

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		GamaPreferencesView.show();
		return null;
	}

}
