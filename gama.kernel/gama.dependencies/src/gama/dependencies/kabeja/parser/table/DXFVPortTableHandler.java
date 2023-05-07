/*******************************************************************************************************
 *
 * DXFVPortTableHandler.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.parser.table;

import gama.dependencies.kabeja.dxf.DXFConstants;
import gama.dependencies.kabeja.dxf.DXFViewport;
import gama.dependencies.kabeja.parser.DXFValue;


/**
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 */
public class DXFVPortTableHandler extends AbstractTableHandler {
    public final static int GROUPCODE_VPORT_NAME = 2;
    public final static int GROUPCODE_VPORT_LOWER_LEFT_X = 10;
    public final static int GROUPCODE_VPORT_LOWER_LEFT_Y = 20;
    public final static int GROUPCODE_VPORT_UPPER_RIGHT_X = 11;
    public final static int GROUPCODE_VPORT_UPPER_RIGHT_Y = 21;
    public final static int GROUPCODE_VPORT_CENTER_POINT_X = 12;
    public final static int GROUPCODE_VPORT_CENTER_POINT_Y = 22;
    public final static int GROUPCODE_VPORT_SNAP_BASE_POINT_X = 13;
    public final static int GROUPCODE_VPORT_SNAP_BASE_POINT_Y = 23;
    public final static int GROUPCODE_HEIGHT = 40;
    public final static int GROUPCODE_ASPECT_RATIO = 41;
    private DXFViewport viewport;

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#endParsing()
     */
    public void endParsing() {
        doc.addDXFViewport(viewport);
    }

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#getTableKey()
     */
    public String getTableKey() {
        return DXFConstants.TABLE_KEY_VPORT;
    }

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#parseGroup(int, de.miethxml.kabeja.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case GROUPCODE_VPORT_NAME:
            viewport.setViewportID(value.getValue());

            if ("*active".equals(value.getValue().toLowerCase())) {
                viewport.setActive(true);
            }

            break;

        case GROUPCODE_VPORT_CENTER_POINT_X:
            viewport.getCenterPoint().setX(value.getDoubleValue());

            break;

        case GROUPCODE_VPORT_CENTER_POINT_Y:
            viewport.getCenterPoint().setY(value.getDoubleValue());

            break;

        case GROUPCODE_VPORT_LOWER_LEFT_X:
            viewport.getLowerLeftCorner().setX(value.getDoubleValue());

            break;

        case GROUPCODE_VPORT_LOWER_LEFT_Y:
            viewport.getLowerLeftCorner().setY(value.getDoubleValue());

            break;

        case GROUPCODE_HEIGHT:
            viewport.setHeight(value.getDoubleValue());

            break;

        case GROUPCODE_ASPECT_RATIO:
            viewport.setAspectRatio(value.getDoubleValue());

            break;
        }
    }

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#startParsing()
     */
    public void startParsing() {
        viewport = new DXFViewport();
    }
}
