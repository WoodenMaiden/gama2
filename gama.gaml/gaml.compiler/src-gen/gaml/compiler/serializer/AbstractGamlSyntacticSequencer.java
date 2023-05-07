/*******************************************************************************************************
 *
 * AbstractGamlSyntacticSequencer.java, in gaml.compiler, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.compiler.serializer;

import com.google.inject.Inject;
import gaml.compiler.services.GamlGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public abstract class AbstractGamlSyntacticSequencer extends AbstractSyntacticSequencer {

	protected GamlGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Pragma___LeftSquareBracketKeyword_1_1_0_RightSquareBracketKeyword_1_1_2__q;
	protected AbstractElementAlias match_S_Equations_SemicolonKeyword_3_1_or___LeftCurlyBracketKeyword_3_0_0_RightCurlyBracketKeyword_3_0_2__;
	protected AbstractElementAlias match_S_Set_LessThanSignHyphenMinusKeyword_2_1_or_ValueKeyword_2_0;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (GamlGrammarAccess) access;
		match_Pragma___LeftSquareBracketKeyword_1_1_0_RightSquareBracketKeyword_1_1_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getPragmaAccess().getLeftSquareBracketKeyword_1_1_0()), new TokenAlias(false, false, grammarAccess.getPragmaAccess().getRightSquareBracketKeyword_1_1_2()));
		match_S_Equations_SemicolonKeyword_3_1_or___LeftCurlyBracketKeyword_3_0_0_RightCurlyBracketKeyword_3_0_2__ = new AlternativeAlias(false, false, new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getS_EquationsAccess().getLeftCurlyBracketKeyword_3_0_0()), new TokenAlias(false, false, grammarAccess.getS_EquationsAccess().getRightCurlyBracketKeyword_3_0_2())), new TokenAlias(false, false, grammarAccess.getS_EquationsAccess().getSemicolonKeyword_3_1()));
		match_S_Set_LessThanSignHyphenMinusKeyword_2_1_or_ValueKeyword_2_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getS_SetAccess().getLessThanSignHyphenMinusKeyword_2_1()), new TokenAlias(false, false, grammarAccess.getS_SetAccess().getValueKeyword_2_0()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_Pragma___LeftSquareBracketKeyword_1_1_0_RightSquareBracketKeyword_1_1_2__q.equals(syntax))
				emit_Pragma___LeftSquareBracketKeyword_1_1_0_RightSquareBracketKeyword_1_1_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_S_Equations_SemicolonKeyword_3_1_or___LeftCurlyBracketKeyword_3_0_0_RightCurlyBracketKeyword_3_0_2__.equals(syntax))
				emit_S_Equations_SemicolonKeyword_3_1_or___LeftCurlyBracketKeyword_3_0_0_RightCurlyBracketKeyword_3_0_2__(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_S_Set_LessThanSignHyphenMinusKeyword_2_1_or_ValueKeyword_2_0.equals(syntax))
				emit_S_Set_LessThanSignHyphenMinusKeyword_2_1_or_ValueKeyword_2_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ('[' ']')?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ID (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_Pragma___LeftSquareBracketKeyword_1_1_0_RightSquareBracketKeyword_1_1_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ('{' '}') | ';'
	 *
	 * This ambiguous syntax occurs at:
	 *     facets+=Facet (ambiguity) (rule end)
	 *     name=Valid_ID (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_S_Equations_SemicolonKeyword_3_1_or___LeftCurlyBracketKeyword_3_0_0_RightCurlyBracketKeyword_3_0_2__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     'value:' | '&lt;-'
	 *
	 * This ambiguous syntax occurs at:
	 *     expr=Expression (ambiguity) value=Expression
	 
	 * </pre>
	 */
	protected void emit_S_Set_LessThanSignHyphenMinusKeyword_2_1_or_ValueKeyword_2_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
