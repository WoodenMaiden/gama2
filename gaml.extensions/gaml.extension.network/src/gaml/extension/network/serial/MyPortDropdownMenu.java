/*******************************************************************************************************
 *
 * MyPortDropdownMenu.java, in gaml.extension.network, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.extension.network.serial;

import javax.swing.JComboBox;

import com.fazecast.jSerialComm.SerialPort;

/**
 * The Class MyPortDropdownMenu.
 */
public class MyPortDropdownMenu extends JComboBox<String> {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Refresh menu.
	 */
	public void refreshMenu() {
		this.removeAllItems();
		final var portNames = SerialPort.getCommPorts();
		for (final SerialPort portName : portNames) { this.addItem(portName.getSystemPortName()); }
	}
}
