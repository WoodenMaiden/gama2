/*******************************************************************************************************
 *
 * RuleStatement.java, in gama.core, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.core.architecture.rule_based;

import static gama.annotations.common.interfaces.IKeyword.WHEN;

import gama.annotations.common.interfaces.IKeyword;
import gama.annotations.precompiler.IConcept;
import gama.annotations.precompiler.ISymbolKind;
import gama.annotations.precompiler.GamlAnnotations.doc;
import gama.annotations.precompiler.GamlAnnotations.facet;
import gama.annotations.precompiler.GamlAnnotations.facets;
import gama.annotations.precompiler.GamlAnnotations.inside;
import gama.annotations.precompiler.GamlAnnotations.symbol;
import gama.core.runtime.IScope;
import gama.core.runtime.exceptions.GamaRuntimeException;
import gaml.core.descriptions.IDescription;
import gaml.core.expressions.IExpression;
import gaml.core.operators.Cast;
import gaml.core.statements.AbstractStatementSequence;
import gaml.core.types.IType;

/**
 * The Class RuleStatement. A simple definition of a rule (set of statements which execution depend on a condition and a
 * priority).
 *
 * @author drogoul
 */

@symbol (
		name = RuleStatement.RULE,
		kind = ISymbolKind.BEHAVIOR,
		with_sequence = true,
		unique_name = true,
		concept = { IConcept.BEHAVIOR, IConcept.ARCHITECTURE })
@inside (
		symbols = { RuleBasedArchitecture.RULES },
		kinds = { ISymbolKind.SPECIES, ISymbolKind.EXPERIMENT, ISymbolKind.MODEL })
@facets (
		value = { @facet (
				name = WHEN,
				type = IType.BOOL,
				optional = false,
				doc = @doc ("The condition to fulfill in order to execute the statements embedded in the rule. when: true makes the rule always activable")),
				@facet (
						name = RuleStatement.PRIORITY,
						type = IType.FLOAT,
						optional = true,
						doc = @doc ("An optional priority for the rule, which is used to sort activable rules and run them in that order ")),
				@facet (
						name = IKeyword.NAME,
						type = IType.ID,
						optional = false,
						doc = @doc ("the identifier of the rule")) },
		omissible = IKeyword.NAME)
@doc ("A simple definition of a rule (set of statements which execution depend on a condition and a priority).")
public class RuleStatement extends AbstractStatementSequence {

	/** The Constant PRIORITY. */
	protected static final String PRIORITY = "priority";
	
	/** The Constant RULE. */
	protected static final String RULE = "rule";
	
	/** The condition. */
	protected final IExpression priority, condition;

	/**
	 * Instantiates a new rule statement.
	 *
	 * @param desc the desc
	 */
	public RuleStatement(final IDescription desc) {
		super(desc);
		setName(desc.getName());
		priority = getFacet(PRIORITY);
		condition = getFacet(WHEN);
	}

	/**
	 * Compute priority.
	 *
	 * @param scope the scope
	 * @return the double
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	public Double computePriority(final IScope scope) throws GamaRuntimeException {
		return priority == null ? 0d : Cast.asFloat(scope, priority.value(scope));
	}

	/**
	 * Compute condition.
	 *
	 * @param scope the scope
	 * @return the boolean
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	public Boolean computeCondition(final IScope scope) throws GamaRuntimeException {
		return Cast.asBool(scope, condition.value(scope));
	}

}
