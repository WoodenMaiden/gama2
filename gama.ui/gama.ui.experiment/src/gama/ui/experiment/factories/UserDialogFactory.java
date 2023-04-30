/*******************************************************************************************************
 *
 * UserDialogFactory.java, in gama.ui.experiment, is part of the source code of the GAMA modeling and simulation
 * platform (v.1.9.2).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.experiment.factories;

import org.eclipse.ui.services.AbstractServiceFactory;
import org.eclipse.ui.services.IServiceLocator;

import gama.core.runtime.IScope;
import gama.ui.experiment.user.UserControlDialog;
import gama.ui.shared.interfaces.IUserDialogFactory;
import gaml.core.architecture.user.UserPanelStatement;

/**
 * A factory for creating UserDialog objects.
 */
public class UserDialogFactory extends AbstractServiceFactory implements IUserDialogFactory {

	/**
	 * Open user dialog.
	 *
	 * @param scope
	 *            the scope
	 * @param panel
	 *            the panel
	 */
	@Override
	public void openUserDialog(final IScope scope, final UserPanelStatement panel) {
		final UserControlDialog dialog = new UserControlDialog(scope, panel);
		dialog.open();
	}

	/**
	 * Close user dialog.
	 */
	@Override
	public void closeUserDialog() {
		final UserControlDialog d = UserControlDialog.current;
		if (d != null) { d.close(); }
	}

	@Override
	public Object create(final Class serviceInterface, final IServiceLocator parentLocator,
			final IServiceLocator locator) {
		return this;
	}

}
