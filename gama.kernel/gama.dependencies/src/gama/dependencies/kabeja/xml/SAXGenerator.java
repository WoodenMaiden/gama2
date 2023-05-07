/*******************************************************************************************************
 *
 * SAXGenerator.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.xml;

import java.util.Map;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import gama.dependencies.kabeja.dxf.DXFDocument;
import gama.dependencies.kabeja.processing.Configurable;


/**
 * This interface describes a generator component, which emit convert the
 * DXFDocument to SAX-Event.
 * <h3>Lifecycle</h3>
 *
 * <ol>
 * <li>setProperties</li>
 * <li>generate(DXFDocument doc,ConentHandler handler)</li>
 * </ol>
 *
 * @author simon.mieth
 *
 */
public interface SAXGenerator extends Configurable {
    public void generate(DXFDocument doc, ContentHandler handler, Map context)
        throws SAXException;
}
