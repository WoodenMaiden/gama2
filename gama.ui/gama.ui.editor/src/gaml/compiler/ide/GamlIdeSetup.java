/*******************************************************************************************************
 *
 * GamlIdeSetup.java, in gama.ui.editor, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.compiler.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import gaml.compiler.GamlRuntimeModule;
import gaml.compiler.GamlStandaloneSetup;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
public class GamlIdeSetup extends GamlStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new GamlRuntimeModule(), new GamlIdeModule()));
	}
	
}
