/*******************************************************************************************************
 *
 * EditorsCategory.java, in gama.ui.experiment, is part of the source code of the GAMA modeling and simulation platform
 * (v.1.9.2).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.experiment.parameters;

import gama.core.util.GamaColor;

/**
 * The EditorsCategory.
 */
public record EditorsCategory(String name, GamaColor color, Boolean expanded) {

}
