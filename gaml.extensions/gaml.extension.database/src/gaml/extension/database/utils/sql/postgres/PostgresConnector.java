/*******************************************************************************************************
 *
 * PostgresConnector.java, in gaml.extension.database, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.extension.database.utils.sql.postgres;

import java.util.HashMap;
import java.util.Map;

import gama.core.runtime.IScope;
import gaml.extension.database.utils.sql.ISqlConnector;
import gaml.extension.database.utils.sql.SqlConnection;

public class PostgresConnector implements ISqlConnector {

	@Override
	public SqlConnection connection(final IScope scope, String venderName, String url, String port, String dbName, String userName,
			String password, Boolean transformed) {
		return new PostgresConnection(scope, venderName, url, port, dbName, userName, password, transformed);
	}

	@Override
	public Map<String, Object> getConnectionParameters(final IScope scope, String host, String dbtype, String port, String database,
			String user, String passwd) {

        Map<String, Object> params = new HashMap<>();
        params.put("dbtype", "postgis");
        params.put("host", host);
        params.put("port", port);
        params.put("schema", "public");
        params.put("database", database);
        params.put("user", user);
        params.put("passwd", passwd);
		
		return params;
	}

}
