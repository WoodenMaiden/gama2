/*******************************************************************************************************
 *
 * InspectSpeciesHandler.java, in gama.ui.experiment, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.experiment.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import gama.core.outputs.ValuedDisplayOutputFactory;
import gama.core.runtime.GAMA;
import gama.core.runtime.exceptions.GamaRuntimeException;
import gaml.core.species.ISpecies;

/**
 * The Class InspectSpeciesHandler.
 */
public class InspectSpeciesHandler extends AbstractHandler { // NO_UCD (unused code)

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		try {
			ValuedDisplayOutputFactory.browse(GAMA.getSimulation(), (ISpecies) null);
		} catch (final GamaRuntimeException e) {
			throw new ExecutionException(e.getMessage());
		}
		return null;
	}
}
