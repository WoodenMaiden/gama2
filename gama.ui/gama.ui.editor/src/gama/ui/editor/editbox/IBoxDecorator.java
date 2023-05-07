/*******************************************************************************************************
 *
 * IBoxDecorator.java, in gama.ui.editor, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.editor.editbox;

import org.eclipse.swt.custom.StyledText;

/**
 * The Interface IBoxDecorator.
 */
public interface IBoxDecorator {

	/**
	 * Gets the provider.
	 *
	 * @return the provider
	 */
	IBoxProvider getProvider();

	/**
	 * Sets the provider.
	 *
	 * @param newProvider the new provider
	 */
	void setProvider(IBoxProvider newProvider);

	/**
	 * Sets the styled text.
	 *
	 * @param st the new styled text
	 */
	void setStyledText(StyledText st);

	/**
	 * Sets the settings.
	 *
	 * @param settings the new settings
	 */
	void setSettings(IBoxSettings settings);

	/**
	 * Enable updates.
	 *
	 * @param visible the visible
	 */
	void enableUpdates(boolean visible);

	/**
	 * Decorate.
	 *
	 * @param mouseClickSupport the mouse click support
	 */
	void decorate(boolean mouseClickSupport);

	/**
	 * Undecorate.
	 */
	void undecorate();

	/**
	 * Force update.
	 */
	void forceUpdate();

	// void selectCurrentBox();
	// void unselectCurrentBox();
}
