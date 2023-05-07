/*******************************************************************************************************
 *
 * DXFLine.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.dxf;

import gama.dependencies.kabeja.dxf.helpers.Point;
import gama.dependencies.kabeja.math.MathUtils;


/**
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 *
 *
 */
public class DXFLine extends DXFEntity {
    private Point start;
    private Point end;

    public DXFLine() {
        start = new Point();
        end = new Point();
    }

    public void setProperty(int groupcode, String value) {
    }

    public void setStartPoint(Point start) {
        this.start = start;
    }

    /**
     * @return Returns the end.
     */
    public Point getEndPoint() {
        return end;
    }

    /**
     * @param end
     *            The end to set.
     */
    public void setEndPoint(Point end) {
        this.end = end;
    }

    /**
     * @return Returns the start.
     */
    public Point getStartPoint() {
        return start;
    }

    public Bounds getBounds() {
        Bounds bounds = new Bounds();
        bounds.addToBounds(this.end);
        bounds.addToBounds(this.start);

        return bounds;
    }

    public String getType() {
        return DXFConstants.ENTITY_TYPE_LINE;
    }

    public double getLength() {
        return MathUtils.distance(this.start, this.end);
    }
}
