/*******************************************************************************************************
 *
 * DXFLayerTableHandler.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.parser.table;

import gama.dependencies.kabeja.dxf.DXFConstants;
import gama.dependencies.kabeja.dxf.DXFLayer;
import gama.dependencies.kabeja.parser.DXFValue;


/**
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 */
public class DXFLayerTableHandler extends AbstractTableHandler {
    public final static String TABLE_KEY = "LAYER";
    public final static int GROUPCODE_LAYER_NAME = 2;
    public final static int GROUPCODE_LAYER_LINETYPE = 6;
    public final static int GROUPCODE_LAYER_COLORNUMBER = 62;
    public final static int GROUPCODE_LAYER_PLOTTINGFLAG = 290;
    public final static int GROUPCODE_LAYER_LINEWEIGHT = 370;
    public final static int GROUPCODE_LAYER_PLOTSTYLENAME = 390;
    private DXFLayer layer;

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.table.TableHandler#getTableKey()
     */
    public String getTableKey() {
        return TABLE_KEY;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.table.TableHandler#parseGroup(int,
     *      java.lang.String)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case GROUPCODE_LAYER_NAME:
            layer.setName(value.getValue());

            break;

        case GROUPCODE_LAYER_COLORNUMBER:
            layer.setColor(value.getIntegerValue());

            break;

        case GROUPCODE_LAYER_LINETYPE:
            layer.setLineType(value.getValue());

            break;

        case DXFConstants.GROUPCODE_STANDARD_FLAGS:
            layer.setFlags(value.getIntegerValue());

            break;

        case GROUPCODE_LAYER_LINEWEIGHT:
            layer.setLineWeight(value.getIntegerValue());

            break;

        case GROUPCODE_LAYER_PLOTSTYLENAME:
            layer.setPlotStyle(value.getValue());

            break;
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.table.TableHandler#endParsing()
     */
    public void endParsing() {
        doc.addDXFLayer(layer);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.table.TableHandler#startParsing()
     */
    public void startParsing() {
        layer = new DXFLayer();
        layer.setDXFDocument(doc);
    }
}
