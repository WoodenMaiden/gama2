/*******************************************************************************************************
 *
 * DXFImageDefHandler.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.parser.objects;

import gama.dependencies.kabeja.dxf.DXFConstants;
import gama.dependencies.kabeja.dxf.objects.DXFImageDefObject;
import gama.dependencies.kabeja.dxf.objects.DXFObject;
import gama.dependencies.kabeja.parser.DXFValue;


/**
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 */
public class DXFImageDefHandler extends AbstractDXFObjectHandler {
    public final static int GROUPCODE_FILENAME = 1;
    protected DXFImageDefObject imageDef;

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.objects.DXFObjectHandler#getObjectType()
     */
    public String getObjectType() {
        return DXFConstants.OBJECT_TYPE_IMAGEDEF;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.objects.DXFObjectHandler#startObject()
     */
    public void startObject() {
        imageDef = new DXFImageDefObject();
        imageDef.setDXFDocument(this.doc);
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.objects.DXFObjectHandler#endObject()
     */
    public void endObject() {
        
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.objects.DXFObjectHandler#getDXFObject()
     */
    public DXFObject getDXFObject() {
        
        return imageDef;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.objects.DXFObjectHandler#parseGroup(int,
     *      de.miethxml.kabeja.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case GROUPCODE_FILENAME:
            imageDef.setFilename(value.getValue());

            break;

        default:
            super.parseCommonGroupCode(groupCode, value, imageDef);

            break;
        }
    }
}
