/*******************************************************************************************************
 *
 * StreamGenerator.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.io;

import java.io.OutputStream;
import java.util.Map;

import gama.dependencies.kabeja.dxf.DXFDocument;


/**
 *
 * This interface describes a Generator, which will generate  output  the given stream.
 *<h3>Lifecycle</h3>
 *
 * <ol>
 * <li>setProperties</li>
 * <li>getSuffix()</li>
 * <li>getMimeType()</li>
 * <li>generate()</li>
 * </ol>
 *@author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public interface StreamGenerator {
    public void setProperties(Map properties);

    public String getSuffix();

    public String getMimeType();

    /**
     * Output the generation result to the given stream.
     * @param doc the @see DXFDocument to  output
     * @param out
     */
    public void generate(DXFDocument doc, OutputStream out);
}
