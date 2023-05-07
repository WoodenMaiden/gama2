/*******************************************************************************************************
 *
 * MeshObject.java, in gama.ui.display.opengl, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.display.opengl.scene.mesh;

import gama.core.util.matrix.IField;
import gama.ui.display.opengl.scene.AbstractObject;
import gaml.core.statements.draw.DrawingAttributes.DrawerType;
import gaml.core.statements.draw.MeshDrawingAttributes;

/**
 * The Class MeshObject.
 */
public class MeshObject extends AbstractObject<IField, MeshDrawingAttributes> {

	/**
	 * Instantiates a new mesh object.
	 *
	 * @param dem
	 *            the dem
	 * @param attributes
	 *            the attributes
	 */
	public MeshObject(final IField dem, final MeshDrawingAttributes attributes) {
		super(dem, attributes, DrawerType.MESH);
	}

}
