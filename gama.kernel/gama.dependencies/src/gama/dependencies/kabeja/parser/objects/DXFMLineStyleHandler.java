/*******************************************************************************************************
 *
 * DXFMLineStyleHandler.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.parser.objects;

import gama.dependencies.kabeja.dxf.DXFConstants;
import gama.dependencies.kabeja.dxf.objects.DXFMLineStyle;
import gama.dependencies.kabeja.dxf.objects.DXFMLineStyleElement;
import gama.dependencies.kabeja.dxf.objects.DXFObject;
import gama.dependencies.kabeja.parser.DXFValue;


public class DXFMLineStyleHandler extends AbstractDXFObjectHandler {
    public static final int GROUPCODE_MLINE_STYLE_NAME = 2;
    public static final int GROUPCODE_MLINE_STYLE_FLAGS = 70;
    public static final int GROUPCODE_MLINE_STYLE_DESCRIPTION = 3;
    public static final int GROUPCODE_MLINE_STYLE_FILL_COLOR = 62;
    public static final int GROUPCODE_MLINE_STYLE_START_ANGLE = 51;
    public static final int GROUPCODE_MLINE_STYLE_END_ANGLE = 52;
    public static final int GROUPCODE_MLINE_STYLE_ELEMENT_COUNT = 71;
    public static final int GROUPCODE_MLINE_STYLE_ELEMENT_OFFSET = 49;
    public static final int GROUPCODE_MLINE_STYLE_ELEMENT_COLOR = 62;
    public static final int GROUPCODE_MLINE_STYLE_ELEMENT_LINE_STYLE = 6;
    protected DXFMLineStyle style;
    protected DXFMLineStyleElement element;
    protected boolean processLineElement = false;

    public void endObject() {
    }

    public DXFObject getDXFObject() {
        return this.style;
    }

    public String getObjectType() {
        return DXFConstants.OBJECT_TYPE_MLINESTYLE;
    }

    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case GROUPCODE_MLINE_STYLE_ELEMENT_OFFSET:
            this.element = new DXFMLineStyleElement();
            this.element.setOffset(value.getDoubleValue());
            this.style.addDXFMLineStyleElement(element);
            this.processLineElement = true;

            break;

        case GROUPCODE_MLINE_STYLE_ELEMENT_COLOR:

            if (this.processLineElement) {
                this.element.setLineColor(value.getIntegerValue());
            } else {
                this.style.setFillColor(value.getIntegerValue());
            }

            break;

        case GROUPCODE_MLINE_STYLE_ELEMENT_LINE_STYLE:
            this.element.setLineType(value.getValue());

            break;

        case GROUPCODE_MLINE_STYLE_NAME:
            this.style.setName(value.getValue());

            break;

        case GROUPCODE_MLINE_STYLE_DESCRIPTION:
            this.style.setDescrition(value.getValue());

            break;

        case GROUPCODE_MLINE_STYLE_START_ANGLE:
            this.style.setStartAngle(value.getDoubleValue());

            break;

        case GROUPCODE_MLINE_STYLE_END_ANGLE:
            this.style.setEndAngle(value.getDoubleValue());

            break;

        case GROUPCODE_MLINE_STYLE_FLAGS:
            this.style.setFlags(value.getIntegerValue());

            break;

        default:
            super.parseCommonGroupCode(groupCode, value, this.style);
        }
    }

    public void startObject() {
        this.style = new DXFMLineStyle();
        this.processLineElement = false;
    }
}
