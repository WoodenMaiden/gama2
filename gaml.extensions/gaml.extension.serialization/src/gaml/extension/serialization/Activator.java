/*******************************************************************************************************
 *
 * Activator.java, in gaml.extension.serialization, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.extension.serialization;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import gama.core.util.file.json.Jsoner;
import gaml.extension.serialization.inject.ConverterJSON;

/**
 * The Class Activator.
 */
public class Activator implements BundleActivator {

	@Override
	public void start(final BundleContext context) throws Exception {
		Jsoner.streamConverter = new ConverterJSON();
	}

	@Override
	public void stop(final BundleContext context) throws Exception {

	}
}
