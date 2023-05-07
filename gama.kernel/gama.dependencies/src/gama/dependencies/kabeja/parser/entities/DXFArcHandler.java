/*******************************************************************************************************
 *
 * DXFArcHandler.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.parser.entities;

import gama.dependencies.kabeja.dxf.DXFArc;
import gama.dependencies.kabeja.dxf.DXFEntity;
import gama.dependencies.kabeja.parser.DXFValue;


/**
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 */
public class DXFArcHandler extends AbstractEntityHandler {
    public static final String ENTITY_NAME = "ARC";
    public static final int RADIUS = 40;
    public static final int START_ANGLE = 50;
    public static final int END_ANGLE = 51;
    public static final int COUNTERCLOCKWISE = 73;
    private DXFArc arc;

    /**
     *
     */
    public DXFArcHandler() {
        super();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.DXFEntityHandler#endDXFEntity()
     */
    public void endDXFEntity() {
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.DXFEntityHandler#getDXFEntity()
     */
    public DXFEntity getDXFEntity() {
        return arc;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.DXFEntityHandler#getDXFEntityName()
     */
    public String getDXFEntityName() {
        return ENTITY_NAME;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.DXFEntityHandler#isFollowSequence()
     */
    public boolean isFollowSequence() {
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.DXFEntityHandler#parseGroup(int,
     *      org.dxf2svg.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case GROUPCODE_START_X:
            arc.getCenterPoint().setX(value.getDoubleValue());

            break;

        case GROUPCODE_START_Y:
            arc.getCenterPoint().setY(value.getDoubleValue());

            break;

        case RADIUS:
            arc.setRadius(value.getDoubleValue());

            break;

        case START_ANGLE:
            arc.setStartAngle(value.getDoubleValue());

            break;

        case END_ANGLE:
            arc.setEndAngle(value.getDoubleValue());

            break;

        case COUNTERCLOCKWISE:
            arc.setCounterClockwise(value.getBooleanValue());

            break;

        default:
            super.parseCommonProperty(groupCode, value, arc);

            break;
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.DXFEntityHandler#startDXFEntity()
     */
    public void startDXFEntity() {
        arc = new DXFArc();
    }
}
