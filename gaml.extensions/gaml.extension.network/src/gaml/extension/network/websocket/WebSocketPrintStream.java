/*******************************************************************************************************
 *
 * WebSocketPrintStream.java, in gaml.extension.network, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.extension.network.websocket;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.java_websocket.server.WebSocketServer;

/**
 * The Class WebSocketPrintStream.
 */
public class WebSocketPrintStream extends PrintStream {

	/**
	 * Instantiates a new web socket print stream.
	 *
	 * @param fileName
	 *            the file name
	 * @param charset
	 *            the charset
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public WebSocketPrintStream(final String fileName, final Charset charset) throws IOException {
		super(fileName, charset);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new web socket print stream.
	 *
	 * @param out
	 *            the out
	 * @param autoFlush
	 *            the auto flush
	 * @param encoding
	 *            the encoding
	 * @throws UnsupportedEncodingException
	 *             the unsupported encoding exception
	 */
	public WebSocketPrintStream(final OutputStream out, final boolean autoFlush, final String encoding)
			throws UnsupportedEncodingException {
		super(out, autoFlush, encoding);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new web socket print stream.
	 *
	 * @param out
	 *            the out
	 * @param autoFlush
	 *            the auto flush
	 * @param charset
	 *            the charset
	 */
	public WebSocketPrintStream(final OutputStream out, final boolean autoFlush, final Charset charset) {
		super(out, autoFlush, charset);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new web socket print stream.
	 *
	 * @param out
	 *            the out
	 * @param autoFlush
	 *            the auto flush
	 */
	public WebSocketPrintStream(final OutputStream out, final boolean autoFlush) {
		super(out, autoFlush);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new web socket print stream.
	 *
	 * @param out
	 *            the out
	 */
	public WebSocketPrintStream(final OutputStream out) {
		super(out);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new web socket print stream.
	 *
	 * @param file
	 *            the file
	 * @param csn
	 *            the csn
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws UnsupportedEncodingException
	 *             the unsupported encoding exception
	 */
	public WebSocketPrintStream(final File file, final String csn)
			throws FileNotFoundException, UnsupportedEncodingException {
		super(file, csn);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new web socket print stream.
	 *
	 * @param file
	 *            the file
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public WebSocketPrintStream(final File file) throws FileNotFoundException {
		super(file);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new web socket print stream.
	 *
	 * @param file
	 *            the file
	 * @param charset
	 *            the charset
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public WebSocketPrintStream(final File file, final Charset charset) throws IOException {
		super(file, charset);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new web socket print stream.
	 */
	public WebSocketPrintStream() {
		super(System.out);
	}

	/**
	 * Instantiates a new web socket print stream.
	 *
	 * @param fileName
	 *            the file name
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public WebSocketPrintStream(final String fileName) throws FileNotFoundException {
		super(fileName);
		// TODO Auto-generated constructor stub
	}

	/** The mm. */
	WebSocketServer mm;

	/**
	 * Instantiates a new web socket print stream.
	 *
	 * @param out
	 *            the out
	 * @param myChatServer
	 *            the my chat server
	 */
	public WebSocketPrintStream(final OutputStream out, final WebSocketServer myChatServer) {
		super(out);
		mm = myChatServer;
	}

	@Override
	public void println(final String x) {

		super.println(x);
		mm.broadcast(x);
	}

}