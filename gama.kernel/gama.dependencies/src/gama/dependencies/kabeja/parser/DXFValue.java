/*******************************************************************************************************
 *
 * DXFValue.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.parser;


/**
 * This is a helper class, which convert to different output formats.
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 *
 */
public final class DXFValue {
    private String value;
    private int integerValue = Integer.MAX_VALUE;

    /**
     *
     */
    public DXFValue() {
        super();
    }

    public DXFValue(String value) {
        setValue(value);
    }

    public String getValue() {
        return value;
    }

    /**
     * @param value The value to set.
     */
    private void setValue(String value) {
        this.value = value.trim();
    }

    public double getDoubleValue() {
        return Double.parseDouble(value);
    }

    public int getIntegerValue() {
        return Integer.parseInt(value);
    }

    /**
     * Convert the DXF value to boolean
     * 0 -> false
     * 1 -> true
     * @return
     */
    public boolean getBooleanValue() {
        //0 -> true
        //else -> false
        return (getIntegerValue() == 0) ? true : false;
    }

    public String toString() {
        return value;
    }

    public boolean isBitSet(int pos) {
        if (this.integerValue == Integer.MAX_VALUE) {
            this.integerValue = getIntegerValue();
        }

        return (this.integerValue & pos) == pos;
    }
}
