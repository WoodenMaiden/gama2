/*******************************************************************************************************
 *
 * ClipboardTester.java, in gama.ui.navigator, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.navigator;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.ui.PlatformUI;

/**
 * The Class ClipboardTester.
 */
public class ClipboardTester extends PropertyTester {

	@Override
	public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
		final Clipboard clipBoard = new Clipboard(PlatformUI.getWorkbench().getDisplay());
		final FileTransfer transfer = FileTransfer.getInstance();
		final String[] selection = (String[]) clipBoard.getContents(transfer);
		return selection != null;
	}

}
