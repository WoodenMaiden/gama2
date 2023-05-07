/*******************************************************************************************************
 *
 * DXFRegionHandler.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.parser.entities;

import gama.dependencies.kabeja.dxf.DXFConstants;
import gama.dependencies.kabeja.dxf.DXFEntity;
import gama.dependencies.kabeja.dxf.DXFRegion;
import gama.dependencies.kabeja.parser.DXFValue;


/**
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 */
public class DXFRegionHandler extends AbstractEntityHandler {
    protected static final int DATA = 1;
    protected static final int APPEND_DATA = 3;
    protected DXFRegion region;
    protected StringBuffer data = new StringBuffer();

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.AbstractEntityHandler#getDXFEntityName()
     */
    public String getDXFEntityName() {
        
        return DXFConstants.ENTITY_TYPE_REGION;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#startDXFEntity()
     */
    public void startDXFEntity() {
        region = new DXFRegion();
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#parseGroup(int,
     *      de.miethxml.kabeja.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case DATA:
            //first cleanup
            checkBuffer();
            data.append(value.getValue());

            break;

        case APPEND_DATA:
            data.append(value.getValue());

            break;
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#getDXFEntity()
     */
    public DXFEntity getDXFEntity() {
        return region;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#endDXFEntity()
     */
    public void endDXFEntity() {
        checkBuffer();
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#isFollowSequence()
     */
    public boolean isFollowSequence() {
        return false;
    }

    protected String decodeDATA(String s) {
        char[] c = s.toCharArray();
        StringBuffer buf = new StringBuffer();

        for (int i = 0; i < c.length; i++) {
            if (Character.isWhitespace(c[i])) {
                buf.append(' ');
            } else {
                int code = Math.abs((c[i]) - 159);
                buf.append((char) code);
            }
        }

        return buf.toString();
    }

    protected void checkBuffer() {
        if (data.length() > 0) {
            region.appendACISDATA(decodeDATA(data.toString()));
            data.delete(0, data.length());
        }
    }
}
