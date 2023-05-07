/*******************************************************************************************************
 *
 * DXFTableHandler.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.parser.table;

import gama.dependencies.kabeja.dxf.DXFDocument;
import gama.dependencies.kabeja.parser.DXFValue;
import gama.dependencies.kabeja.parser.Handler;


/**
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 */
public interface DXFTableHandler extends Handler {
    public String getTableKey();

    public void setDXFDocument(DXFDocument doc);

    public void startParsing();

    public void parseGroup(int groupCode, DXFValue value);

    public void endParsing();
}
