/*******************************************************************************************************
 *
 * GamlStandaloneSetup.java, in gaml.compiler, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/

package gaml.compiler;

import com.google.inject.Injector;

import gaml.compiler.GamlStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without equinox extension registry
 */
public class GamlStandaloneSetup extends GamlStandaloneSetupGenerated {

	/**
	 * Do setup.
	 *
	 * @return the injector
	 */
	public static Injector doSetup() {
		return new GamlStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
	}
}
