/*******************************************************************************************************
 *
 * DXFEllipseHandler.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.parser.entities;

import gama.dependencies.kabeja.dxf.DXFEllipse;
import gama.dependencies.kabeja.dxf.DXFEntity;
import gama.dependencies.kabeja.parser.DXFValue;


/**
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 *
 *
 */
public class DXFEllipseHandler extends AbstractEntityHandler {
    public final static String ENTITY_NAME = "ELLIPSE";
    public final static int RATIO = 40;
    public final static int START_PARAMETER = 41;
    public final static int END_PARAMTER = 42;
    public static final int COUNTERCLOCKWISE = 73;
    private DXFEllipse ellipse;

    public void endDXFEntity() {
    }

    public DXFEntity getDXFEntity() {
        return ellipse;
    }

    public String getDXFEntityName() {
        return ENTITY_NAME;
    }

    public boolean isFollowSequence() {
        return false;
    }

    public void parseGroup(int groupCode, DXFValue value) {
        //    	System.out.println(" "+groupCode);
        //    	System.out.println(value.getValue());
        switch (groupCode) {
        case GROUPCODE_START_X:
            ellipse.getCenterPoint().setX(value.getDoubleValue());

            break;

        case GROUPCODE_START_Y:
            ellipse.getCenterPoint().setY(value.getDoubleValue());

            break;

        case GROUPCODE_START_Z:
            ellipse.getCenterPoint().setZ(value.getDoubleValue());

            break;

        case END_X:
            ellipse.getMajorAxisDirection().setX(value.getDoubleValue());

            break;

        case END_Y:
            ellipse.getMajorAxisDirection().setY(value.getDoubleValue());

            break;

        case END_Z:
            ellipse.getMajorAxisDirection().setZ(value.getDoubleValue());

            break;

        case RATIO:
            ellipse.setRatio(value.getDoubleValue());

            break;

        case START_PARAMETER:
            ellipse.setStartParameter(value.getDoubleValue());

            break;

        case END_PARAMTER:
            ellipse.setEndParameter(value.getDoubleValue());

            break;

        case COUNTERCLOCKWISE:
            ellipse.setCounterClockwise(value.getBooleanValue());

            break;

        default:
            super.parseCommonProperty(groupCode, value, ellipse);

            break;
        }
    }

    public void startDXFEntity() {
        //System.out.println("0\nELLIPSE");
        ellipse = new DXFEllipse();
        ellipse.setDXFDocument(doc);
    }
}
