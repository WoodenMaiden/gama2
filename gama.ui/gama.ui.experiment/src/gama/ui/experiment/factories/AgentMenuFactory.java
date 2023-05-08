/*******************************************************************************************************
 *
 * AgentMenuFactory.java, in gama.ui.experiment, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.experiment.factories;

import java.util.Collection;

import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.services.AbstractServiceFactory;
import org.eclipse.ui.services.IServiceLocator;

import gama.core.metamodel.agent.IAgent;
import gama.ui.experiment.menus.AgentsMenu;
import gama.ui.shared.interfaces.IAgentMenuFactory;
import gama.ui.shared.menus.MenuAction;

/**
 * A factory for creating AgentMenu objects.
 */
public class AgentMenuFactory extends AbstractServiceFactory implements IAgentMenuFactory {

	/**
	 * Fill population sub menu.
	 *
	 * @param menu
	 *            the menu
	 * @param species
	 *            the species
	 * @param actions
	 *            the actions
	 */
	@Override
	public void fillPopulationSubMenu(final Menu menu, final Collection<? extends IAgent> species,
			final MenuAction... actions) {
		AgentsMenu.fillPopulationSubMenu(menu, species, actions);

	}

	@Override
	public Object create(final Class serviceInterface, final IServiceLocator parentLocator,
			final IServiceLocator locator) {
		return this;
	}

}
