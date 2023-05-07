/*******************************************************************************************************
 *
 * SAXFilter.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.xml;

import org.xml.sax.ContentHandler;

import gama.dependencies.kabeja.processing.Configurable;


/**
 * A SAXFilter consumes SAX events and passes SAX event to the next
 * org.xml.sax.ContentHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 */
public interface SAXFilter extends ContentHandler, Configurable {
    public void setContentHandler(ContentHandler handler);
}
