/*******************************************************************************************************
 *
 * AbstractSAXFilter.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.xml;

import java.util.HashMap;
import java.util.Map;

import org.xml.sax.helpers.XMLFilterImpl;


/**
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 */
public abstract class AbstractSAXFilter extends XMLFilterImpl
    implements SAXFilter {
    protected Map properties = new HashMap();

    /* (non-Javadoc)
     * @see org.kabeja.xml.SAXFilter#setProperties(java.util.Map)
     */
    public void setProperties(Map properties) {
        this.properties = properties;
    }

    public Map getProperties() {
        return this.properties;
    }
}
