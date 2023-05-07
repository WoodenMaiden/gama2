/*******************************************************************************************************
 *
 * DXFRay.java, in gama.dependencies, is part of the source code of the
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
public class DXFRay extends DXFEntity {
    protected Point basePoint = new Point();
    protected Vector direction = new Vector();

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.dxf.DXFEntity#getBounds()
     */
    public Bounds getBounds() {
        // we will only add the base point
        //the end is infinite
        Bounds bounds = new Bounds();
        bounds.addToBounds(basePoint);

        return bounds;
    }

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.dxf.DXFEntity#getType()
     */
    public String getType() {
        return DXFConstants.ENTITY_TYPE_RAY;
    }

    /**
     * @return Returns the basePoint.
     */
    public Point getBasePoint() {
        return basePoint;
    }

    /**
     * @param basePoint The basePoint to set.
     */
    public void setBasePoint(Point basePoint) {
        this.basePoint = basePoint;
    }

    /**
     * @return Returns the direction.
     */
    public Vector getDirection() {
        return direction;
    }

    /**
     * @param direction The direction to set.
     */
    public void setDirection(Vector direction) {
        this.direction = direction;
    }

    public double getLength() {
        return 0;
    }
}
