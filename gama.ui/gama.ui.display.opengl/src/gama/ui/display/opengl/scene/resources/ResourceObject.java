/*******************************************************************************************************
 *
 * ResourceObject.java, in gama.ui.display.opengl, is part of the source code of the GAMA modeling and simulation
 * platform (v.1.9.2).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.display.opengl.scene.resources;

import gama.core.util.file.GamaGeometryFile;
import gama.ui.display.opengl.scene.AbstractObject;
import gaml.core.statements.draw.DrawingAttributes;
import gaml.core.statements.draw.DrawingAttributes.DrawerType;

/**
 * The Class ResourceObject.
 */
public class ResourceObject extends AbstractObject<GamaGeometryFile, DrawingAttributes> {

	/**
	 * Instantiates a new resource object.
	 *
	 * @param file
	 *            the file
	 * @param attributes
	 *            the attributes
	 */
	public ResourceObject(final GamaGeometryFile file, final DrawingAttributes attributes) {
		super(file, attributes, DrawerType.RESOURCE);
	}

}
