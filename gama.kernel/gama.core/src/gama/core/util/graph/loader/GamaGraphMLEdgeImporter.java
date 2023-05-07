/*******************************************************************************************************
 *
 * GamaGraphMLEdgeImporter.java, in gama.core, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.util.graph.loader;

import java.util.HashMap;
import java.util.Map;

import org.jgrapht.graph.DefaultEdge;

public class GamaGraphMLEdgeImporter extends DefaultEdge {

	private static final long serialVersionUID = 2989298487961024016L;

    private Map<String,String> attributes = new HashMap<>();

    public void addAttribute(String k, String v) {attributes.put(k, v); }
    public Map<String,String> getAttributes() { return attributes; }
}
