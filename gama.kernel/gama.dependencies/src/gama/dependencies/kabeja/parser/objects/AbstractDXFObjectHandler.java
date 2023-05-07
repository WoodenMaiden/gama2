/*******************************************************************************************************
 *
 * AbstractDXFObjectHandler.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.parser.objects;

import gama.dependencies.kabeja.dxf.DXFDocument;
import gama.dependencies.kabeja.dxf.objects.DXFObject;
import gama.dependencies.kabeja.parser.DXFValue;


/**
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 */
public abstract class AbstractDXFObjectHandler implements DXFObjectHandler {
    public final static int GROUPCODE_SOFTPOINTER_ID = 330;
    public final static int GROUPCODE_HARDOWNER_ID = 360;
    public final static int GROUPCODE_HANDLE_ID = 5;
    protected DXFDocument doc;

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.Handler#releaseDXFDocument()
     */
    public void releaseDXFDocument() {
        doc = null;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.Handler#setDXFDocument(de.miethxml.kabeja.dxf.DXFDocument)
     */
    public void setDXFDocument(DXFDocument doc) {
        this.doc = doc;
    }

    protected void parseCommonGroupCode(int groupCode, DXFValue value,
        DXFObject obj) {
        switch (groupCode) {
        case GROUPCODE_HANDLE_ID:
            obj.setID(value.getValue());

            break;

        case GROUPCODE_HARDOWNER_ID:
            obj.setHardOwnerID(value.getValue());

            break;

        case GROUPCODE_SOFTPOINTER_ID:
            obj.setSoftPointerID(value.getValue());

            break;
        }
    }
}
