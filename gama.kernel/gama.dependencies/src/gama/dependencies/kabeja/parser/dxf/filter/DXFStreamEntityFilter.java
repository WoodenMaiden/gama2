/*******************************************************************************************************
 *
 * DXFStreamEntityFilter.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.parser.dxf.filter;

import gama.dependencies.kabeja.parser.DXFValue;
import gama.dependencies.kabeja.parser.ParseException;


abstract class DXFStreamEntityFilter extends DXFStreamSectionFilter {
    private static String SECTION_KEY = "ENTITIES";
    public static final int ENTITY_START = 0;
    protected boolean entitySection = false;
    protected boolean parseEntity = false;
    protected boolean parseHeader = false;

    protected void parseSection(int groupCode, DXFValue value)
        throws ParseException {
        if (parseHeader) {
            if (value.getValue().equals(SECTION_KEY)) {
                this.entitySection = true;
                this.parseHeader = false;
            }
        } else if (entitySection) {
            if (groupCode == ENTITY_START) {
                if (parseEntity) {
                    endEntity();
                } else {
                    parseEntity = true;
                }

                startEntity(value.getValue());
            }

            parseEntity(groupCode, value);

            return;
        }

        handler.parseGroup(groupCode, value);
    }

    protected void sectionEnd(String Section) throws ParseException {
        if (section.equals(SECTION_KEY)) {
            this.entitySection = false;
        }
    }

    protected void sectionStart(String Section) throws ParseException {
        if (section.equals(SECTION_KEY)) {
            this.parseHeader = true;
        }
    }

    protected abstract void startEntity(String type) throws ParseException;

    protected abstract void endEntity() throws ParseException;

    protected abstract void parseEntity(int groupCode, DXFValue value)
        throws ParseException;
}
