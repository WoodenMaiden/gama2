/*******************************************************************************************************
 *
 * AlertBox.java, in gaml.extension.network, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.extension.network.serial;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * The Class AlertBox.
 */
public class AlertBox {

	/** The alert window. */
	JFrame alertWindow;

	/**
	 * Instantiates a new alert box.
	 *
	 * @param obj
	 *            the obj
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 */
	public AlertBox(final Dimension obj, final String title, final String message) {
		alertWindow = new JFrame();
		alertWindow.setTitle(title);
		alertWindow.setSize(obj);
		alertWindow.setPreferredSize(obj);
		alertWindow.setLayout(new BorderLayout());
		alertWindow.setLocationRelativeTo(null);
		final var lblMessage = new JLabel(message, SwingConstants.CENTER);
		final var btnOk = new JButton("Ok");
		btnOk.addActionListener(e -> {
			alertWindow.setVisible(false);
			alertWindow.dispose();
		});
		alertWindow.add(btnOk, BorderLayout.SOUTH);
		alertWindow.add(lblMessage, BorderLayout.CENTER);
	}

	/**
	 * Display.
	 */
	public void display() {
		alertWindow.setVisible(true);
	}
}
