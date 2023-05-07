/*******************************************************************************************************
 *
 * GamlActivator.java, in gaml.compiler, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.compiler;

import java.util.concurrent.CompletableFuture;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import gama.dev.DEBUG;
import gaml.compiler.expression.GamlExpressionCompiler;
import gaml.compiler.resource.GamlResourceInfoProvider;
import gaml.core.compilation.GAML;
import gaml.core.expressions.GamlExpressionFactory;

/**
 * The Class GamlActivator.
 */
public class GamlActivator implements BundleActivator {

	@Override
	public void start(final BundleContext context) throws Exception {
		// Spawns a new thread in order to escape the "activator/osgi" thread as soon as possible (see #3636)
		CompletableFuture.runAsync(() -> {
			DEBUG.TIMER_WITH_EXCEPTIONS("GAML: Initializing parser", "done in", () -> {
				GamlExpressionFactory.registerParserProvider(GamlExpressionCompiler::new);
				GAML.registerInfoProvider(GamlResourceInfoProvider.INSTANCE);
				GAML.registerGamlEcoreUtils(EGaml.getInstance());
			});
		});

	}

	@Override
	public void stop(final BundleContext context) throws Exception {

	}

}
