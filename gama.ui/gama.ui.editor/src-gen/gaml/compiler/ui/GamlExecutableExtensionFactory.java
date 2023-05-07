/*******************************************************************************************************
 *
 * GamlExecutableExtensionFactory.java, in gama.ui.editor, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.compiler.ui;

import com.google.inject.Injector;
import gama.ui.editor.internal.EditorActivator;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class GamlExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return FrameworkUtil.getBundle(EditorActivator.class);
	}
	
	@Override
	protected Injector getInjector() {
		EditorActivator activator = EditorActivator.getInstance();
		return activator != null ? activator.getInjector(EditorActivator.GAML_COMPILER_GAML) : null;
	}

}
