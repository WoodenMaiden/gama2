/*******************************************************************************************************
 *
 * DXFLineTypeTableHandler.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.parser.table;

import gama.dependencies.kabeja.dxf.DXFLineType;
import gama.dependencies.kabeja.parser.DXFValue;


/**
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXFLineTypeTableHandler extends AbstractTableHandler {
    public final static String TABLE_KEY = "LTYPE";
    public final static int GROUPCODE_LTYPE_NAME = 2;
    public final static int GROUPCODE_LTYPE_DESCRIPTION = 3;
    public final static int GROUPCODE_LTYPE_ALIGNMENT = 72;
    public final static int GROUPCODE_LTYPE_SEGMENT = 49;
    public final static int GROUPCODE_LTYPE_LENGTH = 40;
    public final static int GROUPCODE_LTYPE_SEGMENT_COUNT = 73;
    public final static int GROUPCODE_LTYPE_SCALE = 46;
    private DXFLineType ltype;
    private int segmentCount = 0;
    private double[] pattern;

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#endParsing()
     */
    public void endParsing() {
        ltype.setPattern(pattern);
        doc.addDXFLineType(ltype);
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#getTableKey()
     */
    public String getTableKey() {
        
        return TABLE_KEY;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#parseGroup(int,
     *      de.miethxml.kabeja.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case GROUPCODE_LTYPE_NAME:
            ltype.setName(value.getValue());

            break;

        case GROUPCODE_LTYPE_DESCRIPTION:
            ltype.setDescritpion(value.getValue());

            break;

        case GROUPCODE_LTYPE_SEGMENT_COUNT:

            int count = value.getIntegerValue();
            pattern = new double[count];
            segmentCount = 0;

            break;

        case GROUPCODE_LTYPE_SEGMENT:
            pattern[segmentCount] = value.getDoubleValue();
            segmentCount++;

            break;

        case GROUPCODE_LTYPE_LENGTH:
            ltype.setPatternLength(value.getDoubleValue());

            break;

        case GROUPCODE_LTYPE_ALIGNMENT:
            ltype.setAlignment(value.getIntegerValue());

            break;

        case GROUPCODE_LTYPE_SCALE:
            ltype.setScale(value.getDoubleValue());

            break;

        default:
            break;
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#startParsing()
     */
    public void startParsing() {
        ltype = new DXFLineType();
        segmentCount = 0;
        pattern = null;
    }
}
