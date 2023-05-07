/*******************************************************************************************************
 *
 * DisplayProcessor.java, in gama.processor, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.processor.precompiler;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import gama.annotations.precompiler.GamlAnnotations.display;

/**
 * The Class DisplayProcessor.
 */
public class DisplayProcessor extends ElementProcessor<display> {

	@Override
	protected Class<display> getAnnotationClass() { return display.class; }

	@Override
	public void createElement(final StringBuilder sb, final ProcessorContext context, final Element e,
			final display d) {
		String[] names = d.value();
		if (names == null) return;
		for (String name : names) {
			verifyDoc(context, e, "display " + name, d);
			sb.append(in).append("_display(").append(toJavaString(name)).append(",(a)->new ")
					.append(rawNameOf(context, e.asType())).append("(a));");
		}

	}

	@Override
	protected boolean validateElement(final ProcessorContext context, final Element e) {
		return assertClassExtends(context, true, (TypeElement) e,
				context.getType("gama.core.common.interfaces.IDisplaySurface"));
	}
}
