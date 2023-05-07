/*******************************************************************************************************
 *
 * WebbException.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.webb;

/**
 * Runtime exception wrapping the real exception thrown by HttpUrlConnection et al.
 *
 * @author hgoebl
 */
public class WebbException extends RuntimeException {

	private Response<?> response;

	public WebbException(final String message) {
		super(message);
	}

	public WebbException(final String message, final Response<?> response) {
		super(message);
		this.response = response;
	}

	public WebbException(final Throwable cause) {
		super(cause);
	}

	/**
	 * Get the Response object (only available if exception has been raised by
	 * {@link com.goebl.david.Request#ensureSuccess()}.
	 *
	 * @return the <code>Response</code> object filled with error information like statusCode and errorBody.
	 */
	public Response<?> getResponse() {
		return response;
	}
}
