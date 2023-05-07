/*******************************************************************************************************
 *
 * ImageConstantSupplier.java, in gaml.extension.image, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.extension.image;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import gaml.core.constants.IConstantAcceptor;
import gaml.core.constants.IConstantsSupplier;

/**
 * The Class ImageConstantSupplier.
 */
public class ImageConstantSupplier implements IConstantsSupplier {

	/**
	 * Supply constants to.
	 *
	 * @param acceptor
	 *            the acceptor
	 */
	@Override
	public void supplyConstantsTo(final IConstantAcceptor acceptor) {
		final var is = getClass().getResourceAsStream("icons/gama.png");
		GamaImage im;
		try {
			im = GamaImage.from(ImageIO.read(is), true);
			acceptor.accept("gama_logo", im, "The official logo of GAMA in a 500x500 image", null, false);
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

}
