/*******************************************************************************************************
 *
 * SAXSerializer.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.xml;

import java.io.OutputStream;

import org.xml.sax.ContentHandler;

import gama.dependencies.kabeja.processing.Configurable;


/**
 *This interface describes a Serializer, which will serialize the SAX-Events
 *to the given stream.
 *<h3>Lifecycle</h3>
 *
 * <ol>
 * <li>setProperties</li>
 * <li>getSuffix()</li>
 * <li>getMimeType()</li>
 * <li>setOutput()</li>
 * <li>startDocument and all other methods from org.xml.sax.ContentHandler </li>
 * </ol>
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 */
public interface SAXSerializer extends ContentHandler, Configurable {
    public String getSuffix();

    public String getMimeType();

    public void setOutput(OutputStream out);
}
