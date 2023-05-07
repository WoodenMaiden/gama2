/*******************************************************************************************************
 *
 * DXFSolidHandler.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.parser.entities;

import gama.dependencies.kabeja.dxf.DXFEntity;
import gama.dependencies.kabeja.dxf.DXFSolid;
import gama.dependencies.kabeja.parser.DXFValue;


/**
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 */
public class DXFSolidHandler extends AbstractEntityHandler {
    public final static int POINT2_X = 11;
    public final static int POINT2_Y = 21;
    public final static int POINT2_Z = 31;
    public final static int POINT3_X = 12;
    public final static int POINT3_Y = 22;
    public final static int POINT3_Z = 32;
    public final static int POINT4_X = 13;
    public final static int POINT4_Y = 23;
    public final static int POINT4_Z = 33;
    protected String ENTITY_NAME = "SOLID";
    protected DXFSolid solid;

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#endDXFEntity()
     */
    public void endDXFEntity() {
        
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#getDXFEntity()
     */
    public DXFEntity getDXFEntity() {
        return solid;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#getDXFEntityName()
     */
    public String getDXFEntityName() {
        return ENTITY_NAME;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#isFollowSequence()
     */
    public boolean isFollowSequence() {
        
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#parseGroup(int,
     *      de.miethxml.kabeja.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        //point 1
        case GROUPCODE_START_X:
            solid.getPoint1().setX(value.getDoubleValue());

            break;

        case GROUPCODE_START_Y:
            solid.getPoint1().setY(value.getDoubleValue());

            break;

        case GROUPCODE_START_Z:
            solid.getPoint1().setZ(value.getDoubleValue());

            break;

        //point 2
        case POINT2_X:
            solid.getPoint2().setX(value.getDoubleValue());

            break;

        case POINT2_Y:
            solid.getPoint2().setY(value.getDoubleValue());

            break;

        case POINT2_Z:
            solid.getPoint2().setZ(value.getDoubleValue());

            break;

        //point 3
        case POINT3_X:
            solid.getPoint3().setX(value.getDoubleValue());

            break;

        case POINT3_Y:
            solid.getPoint3().setY(value.getDoubleValue());

            break;

        case POINT3_Z:
            solid.getPoint3().setZ(value.getDoubleValue());

            break;

        //point 4
        case POINT4_X:
            solid.getPoint4().setX(value.getDoubleValue());

            break;

        case POINT4_Y:
            solid.getPoint4().setY(value.getDoubleValue());

            break;

        case POINT4_Z:
            solid.getPoint4().setZ(value.getDoubleValue());

            break;

        default:
            super.parseCommonProperty(groupCode, value, solid);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#startDXFEntity()
     */
    public void startDXFEntity() {
        solid = new DXFSolid();
    }
}
