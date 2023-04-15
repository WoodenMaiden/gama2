/*******************************************************************************************************
 *
 * ShowErrors.java, in ummisco.gama.ui.experiment, is part of the source code of the
 * GAMA modeling and simulation platform (v.1.9.0).
 *
 * (c) 2007-2022 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.experiment.commands;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.menus.UIElement;

import gama.ui.experiment.views.ErrorView;
import msi.gama.common.preferences.GamaPreferences;
import msi.gama.runtime.GAMA;
import ummisco.gama.ui.utils.ViewsHelper;

/**
 * The Class ShowErrors.
 */
public class ShowErrors extends AbstractHandler implements IElementUpdater {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		GamaPreferences.Runtime.CORE_SHOW_ERRORS.set(!GamaPreferences.Runtime.CORE_SHOW_ERRORS.getValue());
		final ICommandService service =
				HandlerUtil.getActiveWorkbenchWindowChecked(event).getService(ICommandService.class);
		service.refreshElements(event.getCommand().getId(), null);
		if (GamaPreferences.Runtime.CORE_SHOW_ERRORS.getValue()) {
			GAMA.getGui().showView(null, ErrorView.ID, null, IWorkbenchPage.VIEW_VISIBLE);
		} else {
			ViewsHelper.hideView(ErrorView.ID);
		}
		return null;
	}

	@Override
	public void updateElement(final UIElement element, final Map parameters) {
		element.setChecked(GamaPreferences.Runtime.CORE_SHOW_ERRORS.getValue());
	}

}
