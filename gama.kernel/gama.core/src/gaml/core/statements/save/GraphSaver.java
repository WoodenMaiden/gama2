/*******************************************************************************************************
 *
 * GraphSaver.java, in gama.core, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.core.statements.save;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import org.jgrapht.nio.GraphExporter;

import gama.core.runtime.IScope;
import gama.core.runtime.exceptions.GamaRuntimeException;
import gama.core.util.graph.writer.GraphExporters;
import gaml.core.expressions.IExpression;
import gaml.core.operators.Cast;
import gaml.core.types.IType;
import gaml.core.types.Types;

/**
 * The Class GraphSaver.
 */
public class GraphSaver extends AbstractSaver {

	/**
	 * Save.
	 *
	 * @param scope
	 *            the scope
	 * @param item
	 *            the item
	 * @param file
	 *            the file
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Override
	@SuppressWarnings ("unchecked")
	public void save(final IScope scope, final IExpression item, final File file, final String code,
			final boolean addHeader, final String type, final Object attributesToSave) {
		GraphExporter<?, ?> exp = GraphExporters.getGraphWriter(type);
		final var g = Cast.asGraph(scope, item);
		if (g != null) {
			if (exp == null) throw GamaRuntimeException.error("Format is not recognized ('" + type + "')", scope);
			exp.exportGraph(g, file.getAbsoluteFile());
		}
	}

	/**
	 * Compute file types.
	 *
	 * @return the string[]
	 */
	@Override
	public Set<String> getFileTypes() { return GraphExporters.getAvailableWriters(); }

	@Override
	public IType getDataType() { return Types.GRAPH; }

	@Override
	protected Set<String> computeFileTypes() {
		// Let them be retrieved dynamically and not cached
		return Collections.EMPTY_SET;
	}
}
