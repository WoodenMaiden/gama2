/*******************************************************************************************************
 *
 * DXFExtrusion.java, in gama.dependencies, is part of the source code of the
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
import gama.dependencies.kabeja.math.MathUtils;


/**
 * This class implements the arbitrary axis algorithm to extract the
 * direction x,y,z of the plane defined by the extrusion.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFExtrusion {
    private final static double v = 1.0 / 64.0;
    protected Vector n = new Vector(0.0, 0.0, 1.0);
    protected Vector x;
    protected Vector y;

    /**
     *
     * @return the x value of the extrusion direction.
     */
    public double getX() {
        return n.getX();
    }

    /**
     *
     * Set the x value of the extrusion direction.
     */
    public void setX(double x) {
        n.setX(x);
    }

    /**
     *
     * @return the y value of the extrusion direction.
     */
    public double getY() {
        return n.getY();
    }

    /**
     *
     * Set the x value of the extrusion direction.
     */
    public void setY(double y) {
        n.setY(y);
    }

    /**
     *
     * @return the z value of the extrusion direction.
     */
    public double getZ() {
        return n.getZ();
    }

    /**
     *
     * Set the x value of the extrusion direction.
     */
    public void setZ(double z) {
        n.setZ(z);
    }

    /**
     * Calculate and returns the x direction of the plane.
     * @return
     */
    public Vector getDirectionX() {
        if ((Math.abs(n.getX()) < v) && (Math.abs(n.getY()) < v)) {
            return MathUtils.crossProduct(DXFConstants.DEFAULT_Y_AXIS_VECTOR, n);
        } else {
            return MathUtils.crossProduct(DXFConstants.DEFAULT_Z_AXIS_VECTOR, n);
        }
    }

    /**
     * Calculate the y direction of the plane.
     * @return the calculate y direction
     */
    public Vector getDirectionY() {
        return MathUtils.crossProduct(n, getDirectionX());
    }

    public Point extrudePoint(Point basePoint, double elevation) {
        return MathUtils.getPointOfStraightLine(basePoint, this.n, elevation);
    }

    /**
     * Return the normal direction of the plane.
     * @return
     */
    public Vector getNormal() {
        return n;
    }

    /**
     * @see getNormal()
     * @return
     */
    public Vector getDirectionZ() {
        return n;
    }
}
