/*******************************************************************************************************
 *
 * DXFDimensionStyleTableHandler.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.parser.table;

import gama.dependencies.kabeja.dxf.DXFDimensionStyle;
import gama.dependencies.kabeja.parser.DXFValue;
import gama.dependencies.kabeja.parser.entities.AbstractEntityHandler;


/**
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 */
public class DXFDimensionStyleTableHandler extends AbstractTableHandler {
    public final static int GROUPCODE_NAME = 2;
    private DXFDimensionStyle style;
    private String key = "DIMSTYLE";

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#endParsing()
     */
    public void endParsing() {
        doc.addDXFDimensionStyle(style);
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#getTableKey()
     */
    public String getTableKey() {
        return key;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#parseGroup(int,
     *      de.miethxml.kabeja.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case AbstractEntityHandler.FLAGS:
            style.setFlags(value.getIntegerValue());

            break;

        case GROUPCODE_NAME:
            style.setName(value.getValue());

            break;

        default:
            style.setProperty("" + groupCode, value.getValue());
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#startParsing()
     */
    public void startParsing() {
        style = new DXFDimensionStyle();
    }
}
