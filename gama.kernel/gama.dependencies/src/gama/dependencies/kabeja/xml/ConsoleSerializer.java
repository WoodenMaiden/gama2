/*******************************************************************************************************
 *
 * ConsoleSerializer.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.xml;

import java.io.OutputStream;


/**
 * @author simon
 *
 */
public class ConsoleSerializer extends SAXPrettyOutputter {
    /* (non-Javadoc)
     * @see org.kabeja.xml.SAXSerializer#setOutput(java.io.OutputStream)
     */
    public void setOutput(OutputStream out) {
        //switch output to console
        super.setOutput(System.out);
    }
}
