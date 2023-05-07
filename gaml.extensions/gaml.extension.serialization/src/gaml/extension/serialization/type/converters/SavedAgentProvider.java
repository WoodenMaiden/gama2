/*******************************************************************************************************
 *
 * SavedAgentProvider.java, in gaml.extension.serialization, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.extension.serialization.type.converters;

import java.util.Stack;

import gama.core.metamodel.agent.MutableSavedAgent;

public class SavedAgentProvider {

	
	private static Object lockInstance 	= new Object();
	private static Object lockStack 	= new Object();

	protected Stack<MutableSavedAgent> stack;
	
	protected SavedAgentProvider() {
		stack = new Stack<MutableSavedAgent>();
	}
	
	
	protected static SavedAgentProvider instance;
	
	public static SavedAgentProvider getInstance() {
		synchronized(lockInstance) {
			if(instance == null) {
				instance = new SavedAgentProvider();
			}
			return instance;			
		}
	}
	
	public static MutableSavedAgent getCurrent() {
		synchronized(lockStack) {
			return getInstance().stack.empty() ? null : getInstance().stack.lastElement();
		}
	}
	
	public static void push(MutableSavedAgent a) {
		synchronized(lockStack) {
			getInstance().stack.add(a);			
		}
	}
	
	public static MutableSavedAgent pop() {
		synchronized(lockStack){
			return getInstance().stack.pop();
		}
	}
	
	
}
