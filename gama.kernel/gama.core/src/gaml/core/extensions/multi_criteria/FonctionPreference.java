/*******************************************************************************************************
 *
 * FonctionPreference.java, in gama.core, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.core.extensions.multi_criteria;

/**
 * The Interface FonctionPreference.
 */
public interface FonctionPreference {

	/**
	 * Valeur.
	 *
	 * @param diff the diff
	 * @return the double
	 */
	public double valeur(double diff);

	/**
	 * Copie.
	 *
	 * @return the fonction preference
	 */
	public FonctionPreference copie();
}
