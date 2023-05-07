/*******************************************************************************************************
 *
 * DXFTolerance.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.dxf;

import gama.dependencies.kabeja.dxf.helpers.Point;
import gama.dependencies.kabeja.dxf.helpers.Vector;


/**
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 *
 */
public class DXFTolerance extends DXFEntity {
    protected Point insertionPoint = new Point();
    protected String styleNameID = "";
    protected String text;
    protected Vector xaxisDirection = new Vector();

    /* (non-Javadoc)
     * @see org.kabeja.dxf.DXFEntity#getBounds()
     */
    public Bounds getBounds() {
        Bounds bounds = new Bounds();
        bounds.setValid(false);

        return bounds;
    }

    /* (non-Javadoc)
     * @see org.kabeja.dxf.DXFEntity#getType()
     */
    public String getType() {
        
        return DXFConstants.ENTITY_TYPE_TOLERANCE;
    }

    /**
     * @return Returns the insertionPoint.
     */
    public Point getInsertionPoint() {
        return insertionPoint;
    }

    /**
     * @param insertionPoint The insertionPoint to set.
     */
    public void setInsertionPoint(Point insertionPoint) {
        this.insertionPoint = insertionPoint;
    }

    /**
     * @return Returns the styleID.
     */
    public String getStyleID() {
        return styleNameID;
    }

    /**
     * @param styleNameID The styleID to set.
     */
    public void setStyleID(String styleNameID) {
        this.styleNameID = styleNameID;
    }

    /**
     * @return Returns the text.
     */
    public String getText() {
        return text;
    }

    /**
     * @param text The text to set.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return Returns the xaxisDirection.
     */
    public Vector getXaxisDirection() {
        return xaxisDirection;
    }

    /**
     * @param xaxisDirection The xaxisDirection to set.
     */
    public void setXaxisDirection(Vector xaxisDirection) {
        this.xaxisDirection = xaxisDirection;
    }

    public double getLength() {
        return 0;
    }
}
