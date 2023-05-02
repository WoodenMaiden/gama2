package gaml.extension.serialization;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import gama.core.util.file.json.Jsoner;
import gaml.extension.serialization.inject.ConverterJSON;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		Jsoner.streamConverter = new ConverterJSON();		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		
	}
}
