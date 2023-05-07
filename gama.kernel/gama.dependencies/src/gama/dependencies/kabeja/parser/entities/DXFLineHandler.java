/*******************************************************************************************************
 *
 * DXFLineHandler.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.parser.entities;

import gama.dependencies.kabeja.dxf.DXFDocument;
import gama.dependencies.kabeja.dxf.DXFEntity;
import gama.dependencies.kabeja.dxf.DXFLine;
import gama.dependencies.kabeja.dxf.helpers.Point;
import gama.dependencies.kabeja.parser.DXFValue;


/**
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 */
public class DXFLineHandler extends AbstractEntityHandler {
    public final static String ENTITY_NAME = "LINE";
    private DXFLine line;
    private DXFDocument doc;
    private String layerID = "";

    public DXFLineHandler() {
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#getEntityName()
     */
    public String getDXFEntityName() {
        return ENTITY_NAME;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#parseGroup(int,
     *      java.lang.String)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case GROUPCODE_START_X:
            line.getStartPoint().setX(value.getDoubleValue());

            break;

        case GROUPCODE_START_Y:
            line.getStartPoint().setY(value.getDoubleValue());

            break;

        case GROUPCODE_START_Z:
            line.getStartPoint().setZ(value.getDoubleValue());

            break;

        case END_X:
            line.getEndPoint().setX(value.getDoubleValue());

            break;

        case END_Y:
            line.getEndPoint().setY(value.getDoubleValue());

            break;

        case END_Z:
            line.getEndPoint().setZ(value.getDoubleValue());

            break;
        }

        super.parseCommonProperty(groupCode, value, line);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#getEntity()
     */
    public DXFEntity getDXFEntity() {
        return line;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#startParsing()
     */
    public void startDXFEntity() {
        line = new DXFLine();
        line.setStartPoint(new Point());
        line.setEndPoint(new Point());
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#endParsing()
     */
    public void endDXFEntity() {
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#setDXFDocument(org.dxf2svg.xml.DXFDocument)
     */
    public void setDXFDocument(DXFDocument doc) {
        this.doc = doc;
    }

    /* (non-Javadoc)
     * @see org.dxf2svg.parser.entities.EntityHandler#isFollowSequence()
     */
    public boolean isFollowSequence() {
        return false;
    }
}
