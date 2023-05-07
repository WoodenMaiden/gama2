/*******************************************************************************************************
 *
 * FlyToMode.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.dependencies.kml.gx;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for flyToModeEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="flyToModeEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="bounce"/>
 *     &lt;enumeration value="smooth"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "flyToModeEnumType")
@XmlEnum
public enum FlyToMode {

    @XmlEnumValue("bounce")
    BOUNCE("bounce"),
    @XmlEnumValue("smooth")
    SMOOTH("smooth");
    private final String value;

    FlyToMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FlyToMode fromValue(String v) {
        for (FlyToMode c: FlyToMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
