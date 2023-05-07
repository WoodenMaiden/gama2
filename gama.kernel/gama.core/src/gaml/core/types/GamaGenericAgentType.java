/*******************************************************************************************************
 *
 * GamaGenericAgentType.java, in gama.core, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.core.types;

import gama.annotations.common.interfaces.IKeyword;
import gama.annotations.precompiler.IConcept;
import gama.annotations.precompiler.ISymbolKind;
import gama.annotations.precompiler.GamlAnnotations.doc;
import gama.annotations.precompiler.GamlAnnotations.type;
import gama.core.metamodel.agent.IAgent;
import gama.core.runtime.IScope;
import gama.core.runtime.exceptions.GamaRuntimeException;
import gaml.core.descriptions.SpeciesDescription;

/**
 * The "generic" agent type.
 *
 * Written by drogoul Modified on 1 ao�t 2010
 *
 * @todo Description
 * @modified 08 juin 2012
 *
 */
@type (
		name = IKeyword.AGENT,
		id = IType.AGENT,
		wraps = { IAgent.class },
		kind = ISymbolKind.Variable.REGULAR,
		concept = { IConcept.TYPE, IConcept.SPECIES },
		doc = @doc ("The basic and default type of agents in GAML"))
public class GamaGenericAgentType extends GamaAgentType {

	/**
	 * Instantiates a new gama generic agent type.
	 */
	public GamaGenericAgentType() {
		super(null, IKeyword.AGENT, IType.AGENT, IAgent.class);
	}

	/**
	 * Sets the species.
	 *
	 * @param sd
	 *            the new species
	 */
	public void setSpecies(final SpeciesDescription sd) { species = sd; }

	@Override
	public IAgent cast(final IScope scope, final Object obj, final Object param, final IType<?> keyType,
			final IType<?> contentsType, final boolean copy) throws GamaRuntimeException {
		return cast(scope, obj, param, copy);
	}

	@Override
	@doc ("Returns an agent if the argument is already an agent, otherwise returns null")
	public IAgent cast(final IScope scope, final Object obj, final Object param, final boolean copy)
			throws GamaRuntimeException {
		if (obj == null) return getDefault();
		if (obj instanceof IAgent a) return a;
		return getDefault();
	}

	@Override
	public Doc getDocumentation() { return new ConstantDoc("Generic type of all agents in a model"); }

	@Override
	public boolean isSuperTypeOf(final IType<?> type) {
		return type != this && type instanceof GamaAgentType;
	}

}
