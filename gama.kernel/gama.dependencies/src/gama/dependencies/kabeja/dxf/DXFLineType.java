/*******************************************************************************************************
 *
 * DXFLineType.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.dxf;


/**
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 *
 *
 *
 */
public class DXFLineType {
    private String name = "";
    private String descritpion = "";
    private double totalPatternLength = 0.0;
    private double[] pattern;
    private int elementCount = 0;
    private int[] offsetX;
    private int[] offsetY;
    private int alignment;
    protected double scale = 1.0;

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    public int getSegmentCount() {
        return elementCount;
    }

    public void setSegmentCount(int elementCount) {
        this.elementCount = elementCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[] getPattern() {
        return pattern;
    }

    public void setPattern(double[] pattern) {
        this.pattern = pattern;
    }

    public double getPatternLength() {
        return totalPatternLength;
    }

    public void setPatternLength(double patternLength) {
        this.totalPatternLength = patternLength;
    }

    /**
     * @return Returns the alignment.
     */
    public int getAlignment() {
        return alignment;
    }

    /**
     * @param alignment
     *            The alignment to set.
     */
    public void setAlignment(int alignment) {
        this.alignment = alignment;
    }

    /**
     * @return Returns the scale.
     */
    public double getScale() {
        return scale;
    }

    /**
     * @param scale The scale to set.
     */
    public void setScale(double scale) {
        this.scale = scale;
    }

    public boolean isScaleToFit() {
        if (alignment == 83) {
            return true;
        }

        return false;
    }
}
