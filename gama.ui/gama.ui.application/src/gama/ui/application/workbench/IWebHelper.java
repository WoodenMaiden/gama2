/*******************************************************************************************************
 *
 * IWebHelper.java, in gama.ui.application, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.application.workbench;

import java.net.URL;

/**
 * The Interface IWebHelper.
 */
public interface IWebHelper {

	/**
	 * Show welcome.
	 */
	void showWelcome();

	/**
	 * Show page.
	 *
	 * @param url the url
	 */
	void showPage(String url);

	/**
	 * Show URL.
	 *
	 * @param url the url
	 */
	void showURL(URL url);

}
