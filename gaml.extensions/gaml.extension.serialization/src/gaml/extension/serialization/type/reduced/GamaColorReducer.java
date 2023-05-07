/*******************************************************************************************************
 *
 * GamaColorReducer.java, in gaml.extension.serialization, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.extension.serialization.type.reduced;

import gama.core.util.GamaColor;

/**
 * The Class GamaColorReducer.
 */
public class GamaColorReducer {

	/** The r. */
	private final float r;

	/** The g. */
	private final float g;

	/** The b. */
	private final float b;

	/** The a. */
	private final float a;

	/**
	 * Instantiates a new gama color reducer.
	 *
	 * @param c
	 *            the c
	 */
	public GamaColorReducer(final GamaColor c) {
		r = c.red();
		g = c.green();
		b = c.blue();
		a = c.alpha();
	}

	/**
	 * Construct object.
	 *
	 * @return the object
	 */
	public GamaColor constructObject() {
		return new GamaColor(r / 255.0, g / 255.0, b / 255.0, a / 255.0);
	}

}
