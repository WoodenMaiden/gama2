/*******************************************************************************************************
 *
 * DXFMLineSegmentElement.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.dxf.helpers;

public class DXFMLineSegmentElement {
    protected double[] lengthParameters;
    protected double[] fillParameters;

    public double[] getLengthParameters() {
        return lengthParameters;
    }

    public void setLengthParameters(double[] lengthParameters) {
        this.lengthParameters = lengthParameters;
    }

    public void setLengthParameter(int index, double v) {
        this.lengthParameters[index] = v;
    }

    public double[] getFillParameters() {
        return fillParameters;
    }

    public void setFillParameters(double[] fillParameters) {
        this.fillParameters = fillParameters;
    }

    public void setFillParameter(int index, double v) {
        this.fillParameters[index] = v;
    }
}
