/*******************************************************************************************************
 *
 * GamaFoldingActionContributor.java, in gama.ui.editor, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.editor.editor.folding;

import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.actions.IActionContributor;

//hook for using our own action group, where we want to have a string collapse action
/**
 * adapted from
 * {@link org.eclipse.xtext.ui.editor.folding.FoldingActionContributor}
 */
public class GamaFoldingActionContributor implements IActionContributor {

	/** The folding action group. */
	private GamaFoldingActionGroup foldingActionGroup;

	@Override
	public void contributeActions(final XtextEditor editor) {
		foldingActionGroup = new GamaFoldingActionGroup(editor, editor.getInternalSourceViewer());
	}

	@Override
	public void editorDisposed(final XtextEditor editor) {
		if (foldingActionGroup != null)
			foldingActionGroup.dispose();
	}
}
