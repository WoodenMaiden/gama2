/*******************************************************************************************************
 *
 * AbstractDXFStreamFilter.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.parser.dxf.filter;

import java.util.Map;

import gama.dependencies.kabeja.parser.dxf.DXFHandler;


public abstract class AbstractDXFStreamFilter implements DXFStreamFilter {
    protected Map properties;
    protected DXFHandler handler;

    public void setProperties(Map properties) {
        this.properties = properties;
    }

    public void setDXFHandler(DXFHandler handler) {
        this.handler = handler;
    }
}
