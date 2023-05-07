/*******************************************************************************************************
 *
 * SyncExperimentState.java, in gama.ui.experiment, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.experiment.commands;

import org.eclipse.core.commands.State;

import gama.core.runtime.GAMA;

/**
 * The Class SyncExperimentState.
 */
public class SyncExperimentState extends State {

	@Override
	public Object getValue() {

		return GAMA.isSynchronized();

	}

	@Override
	public void setValue(final Object value) {
		super.setValue(value);
		if (value instanceof Boolean b) {
			if (b) {
				GAMA.synchronizeFrontmostExperiment();
			} else {
				GAMA.desynchronizeFrontmostExperiment();
			}
		}
	}

}
