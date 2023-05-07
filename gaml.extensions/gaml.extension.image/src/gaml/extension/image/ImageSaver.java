/*******************************************************************************************************
 *
 * ImageSaver.java, in gaml.extension.image, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.extension.image;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.imageio.ImageIO;

import gama.core.common.interfaces.ISaveDelegate;
import gama.core.runtime.IScope;
import gaml.core.expressions.IExpression;
import gaml.core.types.IType;
import gaml.core.types.Types;

/**
 * The Class ImageSaver.
 */
public class ImageSaver extends gaml.core.statements.save.ImageSaver implements ISaveDelegate {

	/**
	 * Gets the data type.
	 *
	 * @return the data type
	 */
	@Override
	public IType getDataType() { return Types.get(GamaImageType.ID); }

	/**
	 * Save.
	 *
	 * @param scope
	 *            the scope
	 * @param item
	 *            the item
	 * @param file
	 *            the file
	 * @param code
	 *            the code
	 * @param addHeader
	 *            the add header
	 * @param t
	 *            the t
	 * @param attributesToSave
	 *            the attributes to save
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Override
	public void save(final IScope scope, final IExpression item, final File file, final String code,
			final boolean addHeader, final String t, final Object attributesToSave) throws IOException {
		final var image = GamaImageType.staticCast(scope, item.value(scope), false);
		if (image == null) { return; }
		if (image.getAlpha(scope) && !"png".equals(t)) {

		}
		final var type = "image".equals(t) ? "png" : "jpeg".equals(t) ? "jpg" : t;
		ImageIO.write(image, type, file);

	}

	/**
	 * Compute file types.
	 *
	 * @return the sets the
	 */
	@Override
	public Set<String> computeFileTypes() {
		return Set.of(ImageIO.getWriterFileSuffixes());
	}

}
