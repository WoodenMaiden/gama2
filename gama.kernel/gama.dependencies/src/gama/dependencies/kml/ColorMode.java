/*******************************************************************************************************
 *
 * ColorMode.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.dependencies.kml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * ColorMode
 * <p>
 * normal, random 
 * </p>
 * 
 * See Also: 
 * See any element that extends <ColorStyle>
 * 
 * 
 * 
 */
@XmlType(name = "colorModeEnumType")
@XmlEnum
public enum ColorMode {

    @XmlEnumValue("normal")
    NORMAL("normal"),
    @XmlEnumValue("random")
    RANDOM("random");
    private final String value;

    ColorMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ColorMode fromValue(String v) {
        for (ColorMode c: ColorMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
