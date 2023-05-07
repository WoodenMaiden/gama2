/*******************************************************************************************************
 *
 * DXFAttribHandler.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.parser.entities;

import gama.dependencies.kabeja.dxf.DXFAttrib;
import gama.dependencies.kabeja.dxf.DXFConstants;
import gama.dependencies.kabeja.parser.DXFValue;


/**
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 */
public class DXFAttribHandler extends DXFTextHandler {
    public static final int ATTRIB_VERTICAL_ALIGN = 74;
    public static final int ATTRIB_TEXT_LENGTH = 73;

    public DXFAttribHandler() {
        super();
    }

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#parseGroup(int, de.miethxml.kabeja.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case ATTRIB_TEXT_LENGTH:

            //ignore not used by
            break;

        case ATTRIB_VERTICAL_ALIGN:
            text.setValign(value.getIntegerValue());

            break;

        default:
            super.parseGroup(groupCode, value);
        }
    }

    public void startDXFEntity() {
        text = new DXFAttrib();
    }

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#getDXFEntityName()
     */
    public String getDXFEntityName() {
        return DXFConstants.ENTITY_TYPE_ATTRIB;
    }
}
