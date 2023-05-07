/*******************************************************************************************************
 *
 * SAXFilterConfig.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.tools;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 */
public class SAXFilterConfig {

	/** The properties. */
	private final Map<String, String> properties;

	/** The filter name. */
	private String filterName;

	/**
	 * Instantiates a new SAX filter config.
	 *
	 * @param properties
	 *            the properties
	 */
	public SAXFilterConfig(final Map<String, String> properties) {
		this.properties = properties;
	}

	/**
	 * Instantiates a new SAX filter config.
	 */
	public SAXFilterConfig() {
		this(new HashMap<>());
	}

	/**
	 * Gets the properties.
	 *
	 * @return the properties
	 */
	public Map getProperties() { return this.properties; }

	/**
	 * Adds the property.
	 *
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 */
	public void addProperty(final String name, final String value) {
		this.properties.put(name, value);
	}

	/**
	 * @return Returns the filterName.
	 */
	public String getFilterName() { return filterName; }

	/**
	 * @param filterName
	 *            The filterName to set.
	 */
	public void setFilterName(final String filterName) { this.filterName = filterName; }
}
