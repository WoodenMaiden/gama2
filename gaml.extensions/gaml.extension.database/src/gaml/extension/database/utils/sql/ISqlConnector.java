/*******************************************************************************************************
 *
 * ISqlConnector.java, in gaml.extension.database, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.extension.database.utils.sql;

import java.util.Map;

import gama.core.runtime.IScope;

public interface ISqlConnector {
	SqlConnection connection(final IScope scope, final String venderName, final String url, final String port, final String dbName,
			final String userName, final String password, final Boolean transformed);

	Map<String, Object> getConnectionParameters(final IScope scope, String host, String dbtype, String port, String database, String user, String passwd);
	
}
