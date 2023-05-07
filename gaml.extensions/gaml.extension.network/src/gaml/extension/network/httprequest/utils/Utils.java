/*******************************************************************************************************
 *
 * Utils.java, in gaml.extension.network, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.extension.network.httprequest.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.List;

import gama.core.runtime.IScope;
import gama.core.util.GamaMapFactory;
import gama.core.util.IList;
import gama.core.util.IMap;
import gama.core.util.file.json.DeserializationException;
import gama.core.util.file.json.Jsoner;
import gaml.core.types.Types;

/**
 * The Class Utils.
 */
public class Utils {

	/**
	 * Builds the URI.
	 *
	 * @param host
	 *            the host
	 * @param port
	 *            the port
	 * @param url
	 *            the url
	 * @return the uri
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	public static URI buildURI(final String host, final String port, final String url) throws URISyntaxException {
		var uri = "";
		final var local_port = port != null ? ":" + port : "";

		if (host.startsWith("http://") || host.startsWith("https://")) {
			uri = host + local_port + url;
		} else {
			uri = "http://" + host + local_port + url;
		}

		return new URI(uri);// URLEncoder.encode(uri, StandardCharsets.UTF_8));
	}

	/**
	 * Parses the BODY.
	 *
	 * @param scope
	 *            the scope
	 * @param body
	 *            the body
	 * @return the i list
	 */
	public static IList parseBODY(final IScope scope, final String body) {
		// TODO Transform lee boy en map/list si response en JSON

		return null;
	}

	/**
	 * Format response.
	 *
	 * @param response
	 *            the response
	 * @return the i map
	 */
	public static IMap<String, Object> formatResponse(final HttpResponse<String> response) {
		IMap<String, Object> responseMap = null;

		try {
			responseMap = GamaMapFactory.create();

			responseMap.put("CODE", response.statusCode());

			final Object jsonBody = "".equals(response.body()) ? "" : Jsoner.deserialize(response.body());
			responseMap.put("BODY", jsonBody);

			final IMap<String, List<String>> mapHeaders =
					GamaMapFactory.wrap(Types.STRING, Types.STRING, false, response.headers().map());
			responseMap.put("HEADERS", mapHeaders);
		} catch (final DeserializationException e) {
			e.printStackTrace();
		}

		return responseMap;
	}

}
