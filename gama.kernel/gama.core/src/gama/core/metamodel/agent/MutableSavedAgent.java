/*******************************************************************************************************
 *
 * MutableSavedAgent.java, in gama.core, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.metamodel.agent;

import java.util.List;
import java.util.Map;

public class MutableSavedAgent extends SavedAgent {
	
	public MutableSavedAgent() {
		super();
		
	}
	
	public List<SavedAgent> putInnerPop(String key, List<SavedAgent> value) {
		return innerPopulations.put(key, value);
	}
	

	public void setInnerPop(Map<String, List<SavedAgent>> innerPop) {
		innerPopulations = innerPop;
	}
	
	public void setIndex(int idx) {
		index = idx;
	}
	
}