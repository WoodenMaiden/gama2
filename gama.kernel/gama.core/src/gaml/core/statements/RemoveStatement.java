/*******************************************************************************************************
 *
 * RemoveStatement.java, in gama.core, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.core.statements;

import gama.annotations.common.interfaces.IKeyword;
import gama.annotations.precompiler.IConcept;
import gama.annotations.precompiler.ISymbolKind;
import gama.annotations.precompiler.GamlAnnotations.doc;
import gama.annotations.precompiler.GamlAnnotations.example;
import gama.annotations.precompiler.GamlAnnotations.facet;
import gama.annotations.precompiler.GamlAnnotations.facets;
import gama.annotations.precompiler.GamlAnnotations.inside;
import gama.annotations.precompiler.GamlAnnotations.symbol;
import gama.annotations.precompiler.GamlAnnotations.usage;
import gama.core.runtime.IScope;
import gama.core.runtime.exceptions.GamaRuntimeException;
import gama.core.util.IContainer;
import gama.core.util.graph.IGraph;
import gaml.core.compilation.annotations.serializer;
import gaml.core.compilation.annotations.validator;
import gaml.core.descriptions.IDescription;
import gaml.core.descriptions.StatementDescription;
import gaml.core.descriptions.SymbolDescription;
import gaml.core.descriptions.SymbolSerializer;
import gaml.core.expressions.IExpression;
import gaml.core.statements.AbstractContainerStatement.ContainerValidator;
import gaml.core.statements.RemoveStatement.RemoveSerializer;
import gaml.core.types.IType;

/**
 * Written by drogoul Modified on 6 févr. 2010
 *
 * @todo Description
 *
 */

@facets (
		value = { @facet (
				name = IKeyword.ITEM,
				type = IType.NONE,
				optional = true,
				doc = @doc ("any expression to remove from the container")),
				@facet (
						name = IKeyword.FROM,
						type = { IType.CONTAINER, IType.SPECIES, IType.AGENT, IType.GEOMETRY },
						optional = false,
						doc = { @doc ("an expression that evaluates to a container") }),
				@facet (
						name = IKeyword.INDEX,
						type = IType.NONE,
						optional = true,
						doc = @doc ("any expression, the key at which to remove the element from the container ")),
				@facet (
						name = IKeyword.EDGE,
						type = IType.NONE,
						optional = true,
						doc = @doc (
								deprecated = "Use 'remove edge(item)...' instead",
								value = "Indicates that the item to remove should be considered as an edge of the receiving graph")),
				@facet (
						name = IKeyword.VERTEX,
						type = IType.NONE,
						optional = true,
						doc = { @doc (
								deprecated = "Use 'remove node(item)' instead") }),
				@facet (
						name = IKeyword.NODE,
						type = IType.NONE,
						optional = true,
						doc = @doc (
								deprecated = "Use 'remove node(item)...' instead",
								value = "Indicates that the item to remove should be considered as a node of the receiving graph")),
				@facet (
						name = IKeyword.KEY,
						type = IType.NONE,
						optional = true,
						doc = @doc ("any expression, the key at which to remove the element from the container ")),
				@facet (
						name = IKeyword.ALL,
						type = IType.NONE,
						optional = true,
						doc = @doc ("an expression that evaluates to a container. If it is true and if the value a list, it removes the first instance of each element of the list. If it is true and the value is not a container, it will remove all instances of this value.")) },
		omissible = IKeyword.ITEM)
@symbol (
		name = IKeyword.REMOVE,
		kind = ISymbolKind.SINGLE_STATEMENT,
		with_sequence = false,
		concept = { IConcept.CONTAINER, IConcept.GRAPH, IConcept.NODE, IConcept.EDGE, IConcept.ATTRIBUTE,
				IConcept.SPECIES, IConcept.MAP, IConcept.MATRIX, IConcept.LIST })
@inside (
		kinds = { ISymbolKind.BEHAVIOR, ISymbolKind.SEQUENCE_STATEMENT, ISymbolKind.LAYER },
		symbols = IKeyword.CHART)
@doc (
		value = "Allows the agent to remove an element from a container (a list, matrix, map...).",
		usages = { @usage (
				value = "This statement should be used in the following ways, depending on the kind of container used and the expected action on it:",
				examples = { @example (
						value = "remove expr from: expr_container;",
						isExecutable = false),
						@example (
								value = "remove index: expr from: expr_container;",
								isExecutable = false),
						@example (
								value = "remove key: expr from: expr_container;",
								isExecutable = false),
						@example (
								value = "remove all: expr from: expr_container;",
								isExecutable = false) }),
				@usage (
						value = "In the case of list, the facet `item:` is used to remove the first occurence of a given expression, whereas `all` is used to remove all the occurrences of the given expression.",
						examples = { @example ("list<int> removeList <- [3,2,1,2,3];"), @example (
								value = "remove 2 from: removeList;",
								var = "removeList",
								equals = "[3,1,2,3]",
								returnType = "null"),
								@example (
										value = "remove 3 all: true from: removeList;",
										var = "removeList",
										equals = "[1,2]",
										returnType = "null"),
								@example (
										value = "remove index: 1 from: removeList;",
										var = "removeList",
										equals = "[1]",
										returnType = "null") }),
				@usage (
						value = "In the case of map, the facet `key:` is used to remove the pair identified by the given key.",
						examples = { @example ("map<string,int> removeMap <- [\"x\"::5, \"y\"::7, \"z\"::7];"),
								@example (
										value = "remove key: \"x\" from: removeMap;",
										var = "removeMap",
										equals = "[\"y\"::7, \"z\"::7]",
										returnType = "null"),
								@example (
										value = "remove 7 all: true from: removeMap;",
										var = "removeMap",
										equals = "map([])",
										returnType = "null") }),
				@usage (
						value = "In addition, a map a be managed as a list with pair key as index. Given that, facets item:, all: and index: can be used in the same way:",
						examples = {
								@example ("map<string,int> removeMapList <- [\"x\"::5, \"y\"::7, \"z\"::7, \"t\"::5];"),
								@example (
										value = "remove 7 from: removeMapList;",
										var = "removeMapList",
										equals = "[\"x\"::5, \"z\"::7, \"t\"::5]",
										returnType = "null"),
								@example (
										value = "remove [5,7] all: true from: removeMapList;",
										var = "removeMapList",
										equals = "[\"t\"::5]",
										returnType = "null"),
								@example (
										value = "remove index: \"t\" from: removeMapList;",
										var = "removeMapList",
										equals = "map([])",
										returnType = "null") }),
				@usage (
						value = "In the case of a graph, both edges and nodes can be removes using node: and edge facets. If a node is removed, all edges to and from this node are also removed.",
						examples = { @example ("graph removeGraph <- as_edge_graph([{1,2}::{3,4},{3,4}::{5,6}]);"),
								@example (
										value = "remove node: {1,2} from: removeGraph;"),
								@example (
										value = "remove node(1,2) from: removeGraph;"),
								@example (
										value = "removeGraph.vertices",
										returnType = "list",
										equals = "[{3,4},{5,6}]"),
								@example (
										value = "removeGraph.edges",
										returnType = "list",
										equals = "[polyline({3,4}::{5,6})]"),
								@example (
										value = "remove edge: {3,4}::{5,6} from: removeGraph;"),
								@example (
										value = "remove edge({3,4},{5,6}) from: removeGraph;"),
								@example (
										value = "removeGraph.vertices",
										returnType = "list",
										equals = "[{3,4},{5,6}]"),
								@example (
										value = "removeGraph.edges",
										returnType = "list",
										equals = "[]") }),
				@usage (
						value = "In the case of an agent or a shape, `remove` allows to remove an attribute from the attributes map of the receiver. However, for agents, it will only remove attributes that have been added dynamically, not the ones defined in the species or in its built-in parent.",
						examples = { @example (
								value = "global {",
								isExecutable = false),
								@example (
										value = "   init {",
										isExecutable = false),
								@example (
										value = "      create speciesRemove;",
										isExecutable = false),
								@example (
										value = "      speciesRemove sR <- speciesRemove(0); 	// sR.a now equals 100",
										isExecutable = false),
								@example (
										value = "      remove key:\"a\" from: sR; 	// sR.a now equals nil",
										isExecutable = false),
								@example (
										value = "   }",
										isExecutable = false),
								@example (
										value = "}",
										isExecutable = false),
								@example (
										value = "",
										isExecutable = false),
								@example (
										value = "species speciesRemove {",
										isExecutable = false),
								@example (
										value = "   int a <- 100; ",
										isExecutable = false),
								@example (
										value = "}",
										isExecutable = false) }),
				@usage (
						value = "This statement can not be used on *matrix*.") },
		see = { "add", "put" })
@serializer (RemoveSerializer.class)
@validator (ContainerValidator.class)
public class RemoveStatement extends AbstractContainerStatement {

	/**
	 * The Class RemoveSerializer.
	 */
	public static class RemoveSerializer extends SymbolSerializer<StatementDescription> {

		@Override
		protected void serialize(final SymbolDescription cd, final StringBuilder sb, final boolean includingBuiltIn) {
			final IExpression item = cd.getFacetExpr(ITEM);
			final IExpression list = cd.getFacetExpr(TO);
			final IExpression allFacet = cd.getFacetExpr(ALL);
			final IExpression at = cd.getFacetExpr(AT);
			final boolean isAll = allFacet != null && allFacet.isConst() && "true".equals(allFacet.literalValue());
			sb.append(list.serialize(includingBuiltIn));
			if (at != null) {
				sb.append('[');
				sb.append(']');
			}
			sb.append(isAll ? " >>- " : " >- ");
			sb.append(at == null ? item.serialize(includingBuiltIn) : at.serialize(includingBuiltIn)).append(';');
		}
	}

	/**
	 * Instantiates a new removes the statement.
	 *
	 * @param desc the desc
	 */
	public RemoveStatement(final IDescription desc) {
		super(desc);
		setName("remove from " + list.serialize(false));
	}

	@SuppressWarnings ("rawtypes")
	@Override
	protected void apply(final IScope scope, final Object object, final Object position,
			final IContainer.Modifiable container) throws GamaRuntimeException {

		if (position == null) {
			// If key/at/index/node is not mentioned
			if (asAll) {
				// if we "remove all"
				if (asAllValues) {
					// if a container is passed
					container.removeValues(scope, (IContainer) object);
				} else {
					// otherwise if it is a simple value
					container.removeAllOccurrencesOfValue(scope, object);
				}
			} else {
				// if it is a simple remove
				container.removeValue(scope, object);
			}
		} else {
			if (asAllIndexes) {
				container.removeIndexes(scope, (IContainer) position);
			} else {
				// If a key/index/at/node is mentioned
				// simply remove the index.
				container.removeIndex(scope, position);
			}
		}

	}

	@Override
	protected Object buildValue(final IScope scope, final IGraph container) {
		return this.item.value(scope);
	}

	@Override
	protected Object buildIndex(final IScope scope, final IGraph container) {
		return this.index.value(scope);
	}
}
