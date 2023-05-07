/*******************************************************************************************************
 *
 * DXFStreamSectionFilter.java, in gama.dependencies, is part of the source code of the
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


abstract class DXFStreamSectionFilter extends AbstractDXFStreamFilter {
    private final static String SECTION_START = "SECTION";
    private final static String SECTION_END = "ENDSEC";
    private final static int COMMAND_CODE = 0;
    protected boolean sectionStarts = false;
    protected String section;

    public void parseGroup(int groupCode, DXFValue value)
        throws ParseException {
        if ((groupCode == COMMAND_CODE) &&
                SECTION_START.equals(value.getValue())) {
            sectionStarts = true;
        } else if (sectionStarts) {
            sectionStarts = false;
            section = value.getValue();
            sectionStart(section);
            parseSection(COMMAND_CODE, new DXFValue(SECTION_START));
            parseSection(groupCode, value);
        } else {
            parseSection(groupCode, value);
        }

        if ((groupCode == COMMAND_CODE) &&
                SECTION_END.equals(value.getValue())) {
            sectionEnd(section);
        }
    }

    protected abstract void parseSection(int groupCode, DXFValue value)
        throws ParseException;

    protected abstract void sectionStart(String Section)
        throws ParseException;

    protected abstract void sectionEnd(String Section)
        throws ParseException;
}
