/*******************************************************************************************************
 *
 * DXFMLineStyleElement.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.dxf.objects;

public class DXFMLineStyleElement {
    protected int lineColor = 0;
    protected String lineType = "BYLAYER";
    protected double offset;

    public int getLineColor() {
        return lineColor;
    }

    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
    }

    public String getLineType() {
        return lineType;
    }

    public void setLineType(String lineStyle) {
        this.lineType = lineStyle;
    }

    public double getOffset() {
        return offset;
    }

    public void setOffset(double offset) {
        this.offset = offset;
    }
}
