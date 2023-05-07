/*******************************************************************************************************
 *
 * DXFLayout.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.dxf.objects;

import gama.dependencies.kabeja.dxf.Bounds;
import gama.dependencies.kabeja.dxf.helpers.Point;
import gama.dependencies.kabeja.dxf.helpers.Vector;


public class DXFLayout extends DXFPlotSettings {
    protected Bounds limits = new Bounds();
    protected Point insertPoint = new Point();
    protected Bounds extent = new Bounds();
    protected Point originUCS = new Point();
    protected Vector xAxisUCS = new Vector(1.0, 0.0, 0.0);
    protected Vector yAxisUCS = new Vector(0.0, 1.0, 0.0);
    protected double elevation;
    protected int tabOrder;
    protected int orthographicTypeOfUCS;
    protected String paperSpaceBlockID;
    protected String lastActiveViewportID;
    protected String namedUCSID;
    protected String baseUCSID;

    public Bounds getLimits() {
        return limits;
    }

    public void setLimits(Bounds limits) {
        this.limits = limits;
    }

    public Point getInsertPoint() {
        return insertPoint;
    }

    public void setInsertPoint(Point insertPoint) {
        this.insertPoint = insertPoint;
    }

    public Bounds getExtent() {
        return extent;
    }

    public void setExtent(Bounds extent) {
        this.extent = extent;
    }

    public Point getOriginUCS() {
        return originUCS;
    }

    public void setOriginUCS(Point originUCS) {
        this.originUCS = originUCS;
    }

    public Vector getXAxisUCS() {
        return xAxisUCS;
    }

    public void setXAxisUCS(Vector axisUCS) {
        xAxisUCS = axisUCS;
    }

    public Vector getYAxisUCS() {
        return yAxisUCS;
    }

    public void setYAxisUCS(Vector axisUCS) {
        yAxisUCS = axisUCS;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public int getTabOrder() {
        return tabOrder;
    }

    public void setTabOrder(int tabOrder) {
        this.tabOrder = tabOrder;
    }

    public int getOrthographicTypeOfUCS() {
        return orthographicTypeOfUCS;
    }

    public void setOrthographicTypeOfUCS(int orthographicTypeOfUCS) {
        this.orthographicTypeOfUCS = orthographicTypeOfUCS;
    }

    public String getPaperSpaceBlockID() {
        return paperSpaceBlockID;
    }

    public void setPaperSpaceBlockID(String paperSpaceBlockID) {
        this.paperSpaceBlockID = paperSpaceBlockID;
    }

    public String getLastActiveViewportID() {
        return lastActiveViewportID;
    }

    public void setLastActiveViewportID(String lastActiveViewportID) {
        this.lastActiveViewportID = lastActiveViewportID;
    }

    public String getNamedUCSID() {
        return namedUCSID;
    }

    public void setNamedUCSID(String namedUCSID) {
        this.namedUCSID = namedUCSID;
    }

    public String getBaseUCSID() {
        return baseUCSID;
    }

    public void setBaseUCSID(String baseUCSID) {
        this.baseUCSID = baseUCSID;
    }
}
