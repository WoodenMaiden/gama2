/*******************************************************************************************************
 *
 * DXFCircle.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.dxf;

import gama.dependencies.kabeja.dxf.helpers.Point;
import gama.dependencies.kabeja.math.ParametricPlane;


/**
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 *
 */
public class DXFCircle extends DXFEntity {
    private Point center;
    private double radius;

    /**
     *
     */
    public DXFCircle() {
    }

    public double getRadius() {
        return radius;
    }

    /**
     * @param radius
     *            The radius to set.
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setCenterPoint(Point p) {
        this.center = p;
    }

    public Point getCenterPoint() {
        return center;
    }

    public Bounds getBounds() {
        Bounds bounds = new Bounds();
        ParametricPlane plane = new ParametricPlane(this.getExtrusion());
        Point p = plane.getPoint(this.center.getX(), this.center.getY());
        bounds.setMaximumX(p.getX() + radius);
        bounds.setMinimumX(p.getX() - radius);
        bounds.setMaximumY(p.getY() + radius);
        bounds.setMinimumY(p.getY() - radius);

        return bounds;
    }

    public String getType() {
        return DXFConstants.ENTITY_TYPE_CIRCLE;
    }

    public double getLength() {
        return 2 * Math.PI * this.radius;
    }

    public Point getPointAt(double angle) {
        // the local part
        double x = this.radius * Math.cos(Math.toRadians(angle));
        double y = radius * Math.sin(Math.toRadians(angle));

        // the wcs part
        ParametricPlane plane = new ParametricPlane(this.getExtrusion());
        Point p = plane.getPoint(x + this.center.getX(), y +
                this.center.getY());

        return p;
    }
}
