/*******************************************************************************************************
 *
 * SplinePoint.java, in gama.dependencies, is part of the source code of the
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
public class SplinePoint extends Point {
    public static final int TYPE_CONTROLPOINT = 0;
    public static final int TYPE_FITPOINT = 1;
    public static final int TYPE_STARTTANGENT = 2;
    public static final int TYPE_ENDTANGENT = 3;
    protected int type = 0;

    /**
     * @return Returns the controlPoint.
     */
    public boolean isControlPoint() {
        return this.type == TYPE_CONTROLPOINT;
    }

    /**
     * @return Returns the endTangent.
     */
    public boolean isEndTangent() {
        return this.type == TYPE_ENDTANGENT;
    }

    /**
     * @return Returns the fitPoint.
     */
    public boolean isFitPoint() {
        return this.type == TYPE_FITPOINT;
    }

    /**
     * @return Returns the startTangent.
     */
    public boolean isStartTangent() {
        return this.type == TYPE_STARTTANGENT;
    }

    /**
     * Sets the type of the point
     * @param type
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * gets the type of the point
     * @return
     */
    public int getType() {
        return this.type;
    }
}
