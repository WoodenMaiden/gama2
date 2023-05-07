/*******************************************************************************************************
 *
 * DXF3DFaceHandler.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.parser.entities;

import gama.dependencies.kabeja.dxf.DXF3DFace;
import gama.dependencies.kabeja.dxf.DXFConstants;


/**
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 */
public class DXF3DFaceHandler extends DXFSolidHandler {
    protected String ENTITY_NAME = "TRACE";

    public String getDXFEntityName() {
        return DXFConstants.ENTITY_TYPE_3DFACE;
    }

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#startDXFEntity()
     */
    public void startDXFEntity() {
        solid = new DXF3DFace();
    }
}
