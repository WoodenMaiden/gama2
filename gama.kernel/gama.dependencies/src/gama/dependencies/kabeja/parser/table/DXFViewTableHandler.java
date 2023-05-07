/*******************************************************************************************************
 *
 * DXFViewTableHandler.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.parser.table;

import gama.dependencies.kabeja.dxf.DXFConstants;
import gama.dependencies.kabeja.dxf.DXFView;
import gama.dependencies.kabeja.parser.DXFValue;


/**
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 */
public class DXFViewTableHandler extends AbstractTableHandler {
    public static final int GROUPCODE_NAME = 2;
    public static final int GROUPCODE_CENTER_X = 10;
    public static final int GROUPCODE_CENTER_Y = 20;
    public static final int GROUPCODE_CENTER_Z = 30;
    public static final int GROUPCODE_HEIGHT = 40;
    public static final int GROUPCODE_WIDTH = 41;
    public static final int GROUPCODE_VIEW_DIRECTION_X = 11;
    public static final int GROUPCODE_VIEW_DIRECTION_Y = 21;
    public static final int GROUPCODE_VIEW_DIRECTION_Z = 31;
    public static final int GROUPCODE_VIEW_TARGET_X = 12;
    public static final int GROUPCODE_VIEW_TARGET_Y = 22;
    public static final int GROUPCODE_VIEW_TARGET_Z = 32;
    public static final int GROUPCODE_LENS_LENGTH = 42;
    public static final int GROUPCODE_FRONT_CLIPPING = 43;
    public static final int GROUPCODE_BACK_CLIPPING = 44;
    public static final int GROUPCODE_TWIST_ANGLE = 50;
    public static final int GROUPCODE_RENDER_MODE = 281;
    public static final int GROUPCODE_UCS_ORIGIN_X = 110;
    public static final int GROUPCODE_UCS_ORIGIN_Y = 120;
    public static final int GROUPCODE_UCS_ORIGIN_Z = 130;
    public static final int GROUPCODE_UCS_X_AXIS_X = 111;
    public static final int GROUPCODE_UCS_X_AXIS_Y = 121;
    public static final int GROUPCODE_UCS_X_AXIS_Z = 131;
    public static final int GROUPCODE_UCS_Y_AXIS_X = 112;
    public static final int GROUPCODE_UCS_Y_AXIS_Y = 122;
    public static final int GROUPCODE_UCS_Y_AXIS_Z = 132;
    public static final int GROUPCODE_UCS_TYPE = 79;
    public static final int GROUPCODE_UCS_ELEVATION = 146;
    public static final int GROUPCODE_USE_UCS = 72;
    private DXFView view;

    public void endParsing() {
        this.doc.addDXFView(view);
    }

    /* (non-Javadoc)
     * @see org.kabeja.parser.table.DXFTableHandler#getTableKey()
     */
    public String getTableKey() {
        return DXFConstants.TABLE_KEY_VIEW;
    }

    /* (non-Javadoc)
     * @see org.kabeja.parser.table.DXFTableHandler#parseGroup(int, org.kabeja.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case GROUPCODE_CENTER_X:
            view.getCenterPoint().setX(value.getDoubleValue());

            break;

        case GROUPCODE_CENTER_Y:
            view.getCenterPoint().setY(value.getDoubleValue());

            break;

        case GROUPCODE_CENTER_Z:
            view.getCenterPoint().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_NAME:
            view.setName(value.getValue());

            break;

        case GROUPCODE_WIDTH:
            view.setWidth(value.getDoubleValue());

            break;

        case GROUPCODE_HEIGHT:
            view.setHeight(value.getDoubleValue());

            break;

        case GROUPCODE_FRONT_CLIPPING:
            view.setFrontClipping(value.getDoubleValue());

            break;

        case GROUPCODE_BACK_CLIPPING:
            view.setBackClipping(value.getDoubleValue());

            break;

        case GROUPCODE_LENS_LENGTH:
            view.setLensLength(value.getDoubleValue());

            break;

        case GROUPCODE_RENDER_MODE:
            view.setRenderMode(value.getIntegerValue());

            break;

        case GROUPCODE_TWIST_ANGLE:
            view.setTwistAngle(value.getDoubleValue());

            break;

        case GROUPCODE_USE_UCS:
            view.setUseUCS(value.getBooleanValue());

            break;

        case GROUPCODE_UCS_ELEVATION:
            view.setUcsElevation(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_ORIGIN_X:
            view.getUcsOrigin().setX(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_ORIGIN_Y:
            view.getUcsOrigin().setY(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_ORIGIN_Z:
            view.getUcsOrigin().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_X_AXIS_X:
            view.getUcsXAxis().setX(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_X_AXIS_Y:
            view.getUcsXAxis().setY(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_X_AXIS_Z:
            view.getUcsXAxis().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_Y_AXIS_X:
            view.getUcsYAxis().setX(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_Y_AXIS_Y:
            view.getUcsYAxis().setY(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_Y_AXIS_Z:
            view.getUcsYAxis().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_TYPE:
            view.setUcsType(value.getIntegerValue());

            break;
        }
    }

    /* (non-Javadoc)
     * @see org.kabeja.parser.table.DXFTableHandler#startParsing()
     */
    public void startParsing() {
        view = new DXFView();
    }
}
