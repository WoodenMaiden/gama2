/*******************************************************************************************************
 *
 * DXFShapeHandler.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.parser.entities;

import gama.dependencies.kabeja.dxf.DXFConstants;
import gama.dependencies.kabeja.dxf.DXFEntity;
import gama.dependencies.kabeja.dxf.DXFShape;
import gama.dependencies.kabeja.parser.DXFValue;


/**
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 */
public class DXFShapeHandler extends AbstractEntityHandler {
    public final static int GROUPCODE_NAME = 2;
    public final static int GROUPCODE_SIZE = 40;
    public final static int GROUPCODE_SCALE_X = 41;
    public final static int GROUPCODE_OBLIQUE_ANGLE = 51;
    protected DXFShape shape;

    /*
     * (non-Javadoc)
     *
     * @see org.kabeja.parser.entities.DXFEntityHandler#getDXFEntityName()
     */
    public String getDXFEntityName() {
        return DXFConstants.ENTITY_TYPE_SHAPE;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.kabeja.parser.entities.DXFEntityHandler#endDXFEntity()
     */
    public void endDXFEntity() {
    }

    /*
     * (non-Javadoc)
     *
     * @see org.kabeja.parser.entities.DXFEntityHandler#getDXFEntity()
     */
    public DXFEntity getDXFEntity() {
        return shape;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.kabeja.parser.entities.DXFEntityHandler#isFollowSequence()
     */
    public boolean isFollowSequence() {
        
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.kabeja.parser.entities.DXFEntityHandler#parseGroup(int,
     *      org.kabeja.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case GROUPCODE_START_X:
            shape.getInsertPoint().setX(value.getDoubleValue());

            break;

        case GROUPCODE_START_Y:
            shape.getInsertPoint().setY(value.getDoubleValue());

            break;

        case GROUPCODE_START_Z:
            shape.getInsertPoint().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_OBLIQUE_ANGLE:
            shape.setObliqueAngle(value.getDoubleValue());

            break;

        case GROUPCODE_ROTATION_ANGLE:
            shape.setRotation(value.getDoubleValue());

            break;

        case GROUPCODE_NAME:
            shape.setName(value.getValue());

            break;

        case GROUPCODE_SIZE:
            shape.setHeight(value.getDoubleValue());

            break;

        default:
            super.parseCommonProperty(groupCode, value, shape);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.kabeja.parser.entities.DXFEntityHandler#startDXFEntity()
     */
    public void startDXFEntity() {
        shape = new DXFShape();
    }
}
