/*******************************************************************************************************
 *
 * DXFDictionaryHandler.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.parser.objects;

import gama.dependencies.kabeja.dxf.DXFConstants;
import gama.dependencies.kabeja.dxf.objects.DXFDictionary;
import gama.dependencies.kabeja.dxf.objects.DXFObject;
import gama.dependencies.kabeja.parser.DXFValue;


public class DXFDictionaryHandler extends AbstractDXFObjectHandler {
    public final int GROUPCODE_RECORD_NAME = 3;
    public final int GROUPCODE_RECORD_ID = 350;
    protected DXFDictionary dictionary;
    protected String objectName;
    protected boolean rootDictionaryParsed = false;

    public void endObject() {
    }

    public DXFObject getDXFObject() {
        return dictionary;
    }

    public String getObjectType() {
        return DXFConstants.OBJECT_TYPE_DICTIONARY;
    }

    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case GROUPCODE_RECORD_NAME:
            this.objectName = value.getValue();

            break;

        case GROUPCODE_RECORD_ID:
            this.dictionary.putDXFObjectRelation(this.objectName,
                value.getValue());

            break;

        default:
            super.parseCommonGroupCode(groupCode, value, this.dictionary);
        }
    }

    public void startObject() {
        if (this.rootDictionaryParsed) {
            this.dictionary = new DXFDictionary();
        } else {
            this.dictionary = this.doc.getRootDXFDictionary();
            this.rootDictionaryParsed = true;
        }
    }
}
