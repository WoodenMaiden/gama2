/*******************************************************************************************************
 *
 * DisplayMode.java, in gama.dependencies, is part of the source code of the
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
 * DisplayMode
 * <p>
 * default, hide 
 * </p>
 * 
 * See Also: 
 * See <BalloonStyle>
 * 
 * 
 * 
 */
@XmlType(name = "displayModeEnumType")
@XmlEnum
public enum DisplayMode {

    @XmlEnumValue("default")
    DEFAULT("default"),
    @XmlEnumValue("hide")
    HIDE("hide");
    private final String value;

    DisplayMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DisplayMode fromValue(String v) {
        for (DisplayMode c: DisplayMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
