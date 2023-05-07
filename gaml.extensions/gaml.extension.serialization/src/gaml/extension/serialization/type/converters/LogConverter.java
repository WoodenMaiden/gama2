/*******************************************************************************************************
 *
 * LogConverter.java, in gaml.extension.serialization, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.extension.serialization.type.converters;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import gama.core.runtime.IScope;
import gama.dev.DEBUG;

/**
 * The Class LogConverter.
 */
public class LogConverter extends AbstractGamaConverter<Object, Object> {

	/**
	 * Instantiates a new log converter.
	 *
	 * @param target
	 *            the target
	 */
	public LogConverter(final Class<Object> target) {
		super(target);
	}

	@Override
	public boolean canConvert(final Class arg0) {
		DEBUG.OUT("LOG Converter: " + arg0 + " super " + arg0.getSuperclass());
		return false;
	}

	@Override
	public void write(IScope scope, final Object arg0, final HierarchicalStreamWriter arg1, final MarshallingContext arg2) {}

	@Override
	public Object read(IScope scope, final HierarchicalStreamReader arg0, final UnmarshallingContext arg1) {
		return null;
	}
}
