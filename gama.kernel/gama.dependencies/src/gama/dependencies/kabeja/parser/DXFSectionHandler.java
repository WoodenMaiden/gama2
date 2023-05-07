/*******************************************************************************************************
 *
 * DXFSectionHandler.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.parser;

import gama.dependencies.kabeja.dxf.DXFDocument;
import gama.dependencies.kabeja.parser.dxf.DXFHandler;


/**
 * This interface descripe a Section Handler, which should handle a SECTION
 * block.
 * <h3>Lifecycle</h3>
 * <ol>
 * <li>setDXFDocument</li>
 * <li>startSection</li>
 * <li>parseGroup (multiple)</li>
 * <li>endSection</li>
 * </lo>
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 *
 *
 */
public interface DXFSectionHandler extends Handler, DXFHandler {
    public String getSectionKey();

    public void setDXFDocument(DXFDocument doc);

    public void startSection();

    public void endSection();
}
