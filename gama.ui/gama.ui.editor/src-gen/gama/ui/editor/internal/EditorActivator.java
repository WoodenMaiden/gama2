/*******************************************************************************************************
 *
 * EditorActivator.java, in gama.ui.editor, is part of the source code of the GAMA modeling and simulation platform
 * (v.1.9.2).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.editor.internal;

import java.util.Collections;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.util.Modules2;
import org.osgi.framework.BundleContext;

import com.google.common.collect.Maps;
import com.google.inject.Guice;
import com.google.inject.Injector;

import gaml.compiler.GamlRuntimeModule;
import gaml.compiler.ui.GamlUiModule;

/**
 * This class was generated. Customizations should only happen in a newly introduced subclass.
 */
public class EditorActivator extends AbstractUIPlugin {

	/** The Constant PLUGIN_ID. */
	public static final String PLUGIN_ID = "gama.ui.editor";

	/** The Constant GAML_COMPILER_GAML. */
	public static final String GAML_COMPILER_GAML = "gaml.compiler.Gaml";

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(EditorActivator.class);

	/** The instance. */
	private static EditorActivator INSTANCE;

	/** The injectors. */
	private final Map<String, Injector> injectors =
			Collections.synchronizedMap(Maps.<String, Injector> newHashMapWithExpectedSize(1));

	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
	}

	@Override
	public void stop(final BundleContext context) throws Exception {
		injectors.clear();
		INSTANCE = null;
		super.stop(context);
	}

	/**
	 * Gets the single instance of EditorActivator.
	 *
	 * @return single instance of EditorActivator
	 */
	public static EditorActivator getInstance() { return INSTANCE; }

	/**
	 * Gets the injector.
	 *
	 * @param language
	 *            the language
	 * @return the injector
	 */
	public Injector getInjector(final String language) {
		synchronized (injectors) {
			Injector injector = injectors.get(language);
			if (injector == null) { injectors.put(language, injector = createInjector(language)); }
			return injector;
		}
	}

	/**
	 * Creates the injector.
	 *
	 * @param language
	 *            the language
	 * @return the injector
	 */
	protected Injector createInjector(final String language) {
		try {
			com.google.inject.Module runtimeModule = getRuntimeModule(language);
			com.google.inject.Module sharedStateModule = getSharedStateModule();
			com.google.inject.Module uiModule = getUiModule(language);
			com.google.inject.Module mergedModule = Modules2.mixin(runtimeModule, sharedStateModule, uiModule);
			return Guice.createInjector(mergedModule);
		} catch (Exception e) {
			logger.error("Failed to create injector for " + language);
			logger.error(e.getMessage(), e);
			throw new RuntimeException("Failed to create injector for " + language, e);
		}
	}

	/**
	 * Gets the runtime module.
	 *
	 * @param grammar
	 *            the grammar
	 * @return the runtime module
	 */
	protected com.google.inject.Module getRuntimeModule(final String grammar) {
		if (GAML_COMPILER_GAML.equals(grammar)) return new GamlRuntimeModule();
		throw new IllegalArgumentException(grammar);
	}

	/**
	 * Gets the ui module.
	 *
	 * @param grammar
	 *            the grammar
	 * @return the ui module
	 */
	protected com.google.inject.Module getUiModule(final String grammar) {
		if (GAML_COMPILER_GAML.equals(grammar)) return new GamlUiModule(this);
		throw new IllegalArgumentException(grammar);
	}

	/**
	 * Gets the shared state module.
	 *
	 * @return the shared state module
	 */
	protected com.google.inject.Module getSharedStateModule() { return new SharedStateModule(); }

}
