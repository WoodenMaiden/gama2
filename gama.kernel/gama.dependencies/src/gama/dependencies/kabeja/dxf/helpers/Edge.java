/*******************************************************************************************************
 *
 * Edge.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.dxf.helpers;


/**
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 *
 */
public class Edge {
    protected Point startPoint = new Point();
    protected Point endPoint = new Point();

    /**
     * @return Returns the endPoint.
     */
    public Point getEndPoint() {
        return endPoint;
    }

    /**
     * @param endPoint The endPoint to set.
     */
    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    /**
     * @return Returns the startPoint.
     */
    public Point getStartPoint() {
        return startPoint;
    }

    /**
     * @param startPoint The startPoint to set.
     */
    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getIntersectionPoint(Edge e) {
        return null;
    }
}
