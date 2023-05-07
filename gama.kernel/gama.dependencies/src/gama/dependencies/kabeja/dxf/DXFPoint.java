/*******************************************************************************************************
 *
 * DXFPoint.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.dxf;

import gama.dependencies.kabeja.dxf.helpers.Point;


/**
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 *
 */
public class DXFPoint extends DXFEntity {
    protected Point p = new Point();

    public DXFPoint() {
    }

    public DXFPoint(double x, double y, double z) {
        this.p.setX(x);
        this.p.setY(y);
        this.p.setZ(z);
    }

    public DXFPoint(Point p) {
        this.p = p;
    }

    /**
     * @return Returns the x.
     */
    public double getX() {
        return this.p.getX();
    }

    /**
     * @param x
     *            The x to set.
     */
    public void setX(double x) {
        this.p.setX(x);
    }

    /**
     * @return Returns the y.
     */
    public double getY() {
        return this.p.getY();
    }

    /**
     * @param y
     *            The y to set.
     */
    public void setY(double y) {
        this.p.setY(y);
    }

    /**
     * @return Returns the z.
     */
    public double getZ() {
        return this.p.getZ();
    }

    /**
     * @param z
     *            The z to set.
     */
    public void setZ(double z) {
        this.p.setZ(z);
    }

    public Bounds getBounds() {
        Bounds bounds = new Bounds();
        bounds.addToBounds(p);

        return bounds;
    }

    public String getType() {
        return DXFConstants.ENTITY_TYPE_POINT;
    }

    public Point getPoint() {
        return this.p;
    }

    public void setPoint(Point p) {
        this.p = p;
    }

    public double getLength() {
        // a point has no length
        return 0;
    }
}
