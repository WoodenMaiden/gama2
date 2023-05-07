/*******************************************************************************************************
 *
 * Writer.java, in gama.headless, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.headless.xml;

import gama.headless.core.*;
import gama.headless.job.ExperimentJob;
import gama.headless.job.ListenedVariable;

/**
 * The Interface Writer.
 */
public interface Writer {

	/**
	 * Write simulation header.
	 *
	 * @param s the s
	 */
	public void writeSimulationHeader(ExperimentJob s);

	/**
	 * Write result step.
	 *
	 * @param step the step
	 * @param vars the vars
	 */
	public void writeResultStep(long step, ListenedVariable[] vars);

	/**
	 * Close.
	 */
	public void close();
}
