/*******************************************************************************************************
 *
 * GamlDescriptionLabelProvider.java, in gama.ui.editor, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.compiler.ui.labeling;

import org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider;

/**
 * Provides labels for IEObjectDescriptions and IResourceDescriptions.
 * 
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#label-provider
 */
public class GamlDescriptionLabelProvider extends DefaultDescriptionLabelProvider {

	// Labels and icons can be computed like this:
//	@Override
//	public String text(IEObjectDescription ele) {
//		return ele.getName().toString();
//	}
//	
//	@Override
//	public String image(IEObjectDescription ele) {
//		return ele.getEClass().getName() + ".gif";
//	}
}
