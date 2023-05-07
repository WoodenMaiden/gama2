/*******************************************************************************************************
 *
 * Configurable.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.processing;

import java.util.Map;


public interface Configurable {
    /**
     * Set configuration properties of the component
     *
     * @param properties
     */
    public void setProperties(Map properties);

    /**
     * Get the configuration Properties of the component.
     *
     * @return
     */
    public Map getProperties();
}
