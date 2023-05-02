package gaml.extension.serialization.inject;

import gama.core.runtime.IScope;
import gama.core.util.serialize.IStreamConverter;
import gaml.extension.serialization.factory.StreamConverter;

public class ConverterJSON implements IStreamConverter {
	
	@Override
	public String convertObjectToJSONStream(IScope scope, Object o) {
		return StreamConverter.convertObjectToJSONStream(scope,o);
	}
}
