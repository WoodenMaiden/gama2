/*******************************************************************************************************
 *
 * Handler.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.parser;

import gama.dependencies.kabeja.dxf.DXFDocument;


/**
 * This is a simple marker-interface. Every parser part must implement this
 * interface.
 *
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 *
 *
 */
public interface Handler {
    public void setDXFDocument(DXFDocument doc);

    public void releaseDXFDocument();
}
