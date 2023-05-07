/*******************************************************************************************************
 *
 * StepByStepHandler.java, in gama.ui.experiment, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.experiment.commands;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.menus.UIElement;

import gama.core.runtime.GAMA;
import gama.ui.shared.bindings.GamaKeyBindings;

/**
 * The Class StepByStepHandler.
 */
public class StepByStepHandler extends AbstractHandler implements IElementUpdater {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		GAMA.stepFrontmostExperiment();
		return this;
	}

	@Override
	public void updateElement(final UIElement element, final Map parameters) {
		element.setTooltip("Runs the experiment one step at a time (" + GamaKeyBindings.STEP_STRING + ")");
		element.setText("Step Experiment (" + GamaKeyBindings.STEP_STRING + ")");
	}

}
