/*******************************************************************************************************
 *
 * ExperimentClock.java, in gama.core, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.kernel.experiment;

import gama.core.kernel.simulation.SimulationClock;
import gama.core.runtime.IScope;
import gama.core.util.GamaDate;

/**
 * The Class ExperimentClock.
 */
public class ExperimentClock extends SimulationClock {

	/**
	 * Instantiates a new experiment clock.
	 *
	 * @param scope
	 *            the scope
	 */
	public ExperimentClock(final IScope scope) {
		super(scope);
	}

	@Override
	public void waitDelay() {}

	/**
	 * @param totalDuration
	 */
	public void setTotalDuration(final long totalDuration) { this.totalDuration = totalDuration; }

	/**
	 * Sets the last duration.
	 *
	 * @param duration
	 *            the new last duration
	 */
	public void setLastDuration(final long duration) { this.duration = duration; }

	@Override
	public StringBuilder getInfo(final StringBuilder sb) {
		final int c = getCycle();
		return sb.append("Experiment: ").append(c).append(c <= 1 ? " cycle " : " cycles ").append("elapsed");
	}

	// Quick and dirty solution to avoid that Experiments have one cycle left compared to simulations
	@Override
	public void setStartingDate(final GamaDate starting_date) {
		this.startingDate = starting_date;
		this.currentDate = starting_date;
	}
}