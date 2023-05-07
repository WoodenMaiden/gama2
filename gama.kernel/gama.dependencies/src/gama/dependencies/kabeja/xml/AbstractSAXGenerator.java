/*******************************************************************************************************
 *
 * AbstractSAXGenerator.java, in gama.dependencies, is part of the source code of the
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
import gama.dependencies.kabeja.processing.AbstractConfigurable;


public abstract class AbstractSAXGenerator extends AbstractConfigurable
    implements SAXGenerator {
    protected DXFDocument doc;
    protected ContentHandler handler;
    protected Map context;

    public void generate(DXFDocument doc, ContentHandler handler, Map context)
        throws SAXException {
        this.doc = doc;
        this.handler = handler;
        this.context = context;
        this.generate();
    }

    /**
     * This method has to be overwritten by any subclass. At this point the
     * XMLGenerator is setup (properties, ContentHandler and DXFDocument) and
     * should emit the XML content to the ContentHandler.
     *
     */
    protected abstract void generate() throws SAXException;
}
