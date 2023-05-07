/*******************************************************************************************************
 *
 * AbstractGamlSemanticSequencer.java, in gaml.compiler, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.compiler.serializer;

import com.google.inject.Inject;
import gaml.compiler.gaml.Access;
import gaml.compiler.gaml.ActionArguments;
import gaml.compiler.gaml.ActionFakeDefinition;
import gaml.compiler.gaml.ActionRef;
import gaml.compiler.gaml.ArgumentDefinition;
import gaml.compiler.gaml.ArgumentPair;
import gaml.compiler.gaml.Array;
import gaml.compiler.gaml.BinaryOperator;
import gaml.compiler.gaml.Block;
import gaml.compiler.gaml.BooleanLiteral;
import gaml.compiler.gaml.DoubleLiteral;
import gaml.compiler.gaml.EquationFakeDefinition;
import gaml.compiler.gaml.EquationRef;
import gaml.compiler.gaml.ExperimentFileStructure;
import gaml.compiler.gaml.ExpressionList;
import gaml.compiler.gaml.Facet;
import gaml.compiler.gaml.Function;
import gaml.compiler.gaml.GamlPackage;
import gaml.compiler.gaml.HeadlessExperiment;
import gaml.compiler.gaml.If;
import gaml.compiler.gaml.Import;
import gaml.compiler.gaml.IntLiteral;
import gaml.compiler.gaml.Model;
import gaml.compiler.gaml.Point;
import gaml.compiler.gaml.Pragma;
import gaml.compiler.gaml.ReservedLiteral;
import gaml.compiler.gaml.S_Action;
import gaml.compiler.gaml.S_Assignment;
import gaml.compiler.gaml.S_Definition;
import gaml.compiler.gaml.S_DirectAssignment;
import gaml.compiler.gaml.S_Display;
import gaml.compiler.gaml.S_Do;
import gaml.compiler.gaml.S_Equations;
import gaml.compiler.gaml.S_Experiment;
import gaml.compiler.gaml.S_Global;
import gaml.compiler.gaml.S_If;
import gaml.compiler.gaml.S_Loop;
import gaml.compiler.gaml.S_Other;
import gaml.compiler.gaml.S_Reflex;
import gaml.compiler.gaml.S_Return;
import gaml.compiler.gaml.S_Set;
import gaml.compiler.gaml.S_Solve;
import gaml.compiler.gaml.S_Species;
import gaml.compiler.gaml.S_Try;
import gaml.compiler.gaml.S_Var;
import gaml.compiler.gaml.SkillFakeDefinition;
import gaml.compiler.gaml.SkillRef;
import gaml.compiler.gaml.StandaloneBlock;
import gaml.compiler.gaml.Statement;
import gaml.compiler.gaml.StringEvaluator;
import gaml.compiler.gaml.StringLiteral;
import gaml.compiler.gaml.TypeFakeDefinition;
import gaml.compiler.gaml.TypeInfo;
import gaml.compiler.gaml.TypeRef;
import gaml.compiler.gaml.Unary;
import gaml.compiler.gaml.Unit;
import gaml.compiler.gaml.UnitFakeDefinition;
import gaml.compiler.gaml.UnitName;
import gaml.compiler.gaml.VarFakeDefinition;
import gaml.compiler.gaml.VariableRef;
import gaml.compiler.gaml.imageDisplayStatement;
import gaml.compiler.gaml.speciesOrGridDisplayStatement;
import gaml.compiler.services.GamlGrammarAccess;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public abstract class AbstractGamlSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private GamlGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == GamlPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case GamlPackage.ACCESS:
				sequence_Access(context, (Access) semanticObject); 
				return; 
			case GamlPackage.ACTION_ARGUMENTS:
				sequence_ActionArguments(context, (ActionArguments) semanticObject); 
				return; 
			case GamlPackage.ACTION_FAKE_DEFINITION:
				sequence_ActionFakeDefinition(context, (ActionFakeDefinition) semanticObject); 
				return; 
			case GamlPackage.ACTION_REF:
				sequence_ActionRef(context, (ActionRef) semanticObject); 
				return; 
			case GamlPackage.ARGUMENT_DEFINITION:
				sequence_ArgumentDefinition(context, (ArgumentDefinition) semanticObject); 
				return; 
			case GamlPackage.ARGUMENT_PAIR:
				sequence_ArgumentPair(context, (ArgumentPair) semanticObject); 
				return; 
			case GamlPackage.ARRAY:
				sequence_Primary(context, (Array) semanticObject); 
				return; 
			case GamlPackage.BINARY_OPERATOR:
				if (rule == grammarAccess.getAndRule()
						|| action == grammarAccess.getAndAccess().getBinaryOperatorLeftAction_1_0()) {
					sequence_Addition_And_Binary_Cast_Comparison_Exponentiation_Multiplication(context, (BinaryOperator) semanticObject); 
					return; 
				}
				else if (action == grammarAccess.getPairAccess().getBinaryOperatorLeftAction_1_0()
						|| rule == grammarAccess.getIfRule()
						|| action == grammarAccess.getIfAccess().getIfLeftAction_1_0()
						|| rule == grammarAccess.getOrRule()
						|| action == grammarAccess.getOrAccess().getBinaryOperatorLeftAction_1_0()) {
					sequence_Addition_And_Binary_Cast_Comparison_Exponentiation_Multiplication_Or(context, (BinaryOperator) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getExpressionRule()
						|| rule == grammarAccess.getBinaryOperatorRule()
						|| rule == grammarAccess.getPairRule()) {
					sequence_Addition_And_Binary_Cast_Comparison_Exponentiation_Multiplication_Or_Pair(context, (BinaryOperator) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getCastRule()) {
					sequence_Addition_Binary_Cast_Comparison_Exponentiation_Multiplication(context, (BinaryOperator) semanticObject); 
					return; 
				}
				else if (action == grammarAccess.getCastAccess().getBinaryOperatorLeftAction_1_0_0()
						|| rule == grammarAccess.getComparisonRule()) {
					sequence_Addition_Binary_Comparison_Exponentiation_Multiplication(context, (BinaryOperator) semanticObject); 
					return; 
				}
				else if (action == grammarAccess.getComparisonAccess().getBinaryOperatorLeftAction_1_0_0()
						|| rule == grammarAccess.getAdditionRule()
						|| action == grammarAccess.getAdditionAccess().getBinaryOperatorLeftAction_1_0_0()) {
					sequence_Addition_Binary_Exponentiation_Multiplication(context, (BinaryOperator) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getBinaryRule()
						|| action == grammarAccess.getBinaryAccess().getBinaryOperatorLeftAction_1_0_0()) {
					sequence_Binary(context, (BinaryOperator) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getExponentiationRule()
						|| action == grammarAccess.getExponentiationAccess().getBinaryOperatorLeftAction_1_0_0()) {
					sequence_Binary_Exponentiation(context, (BinaryOperator) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getMultiplicationRule()
						|| action == grammarAccess.getMultiplicationAccess().getBinaryOperatorLeftAction_1_0_0()) {
					sequence_Binary_Exponentiation_Multiplication(context, (BinaryOperator) semanticObject); 
					return; 
				}
				else break;
			case GamlPackage.BLOCK:
				if (rule == grammarAccess.getBlockRule()) {
					sequence_Block(context, (Block) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getModelBlockRule()) {
					sequence_ModelBlock(context, (Block) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getDisplayBlockRule()) {
					sequence_displayBlock(context, (Block) semanticObject); 
					return; 
				}
				else break;
			case GamlPackage.BOOLEAN_LITERAL:
				sequence_TerminalExpression(context, (BooleanLiteral) semanticObject); 
				return; 
			case GamlPackage.DOUBLE_LITERAL:
				sequence_TerminalExpression(context, (DoubleLiteral) semanticObject); 
				return; 
			case GamlPackage.EQUATION_FAKE_DEFINITION:
				sequence_EquationFakeDefinition(context, (EquationFakeDefinition) semanticObject); 
				return; 
			case GamlPackage.EQUATION_REF:
				sequence_EquationRef(context, (EquationRef) semanticObject); 
				return; 
			case GamlPackage.EXPERIMENT_FILE_STRUCTURE:
				sequence_ExperimentFileStructure(context, (ExperimentFileStructure) semanticObject); 
				return; 
			case GamlPackage.EXPRESSION_LIST:
				sequence_ExpressionList(context, (ExpressionList) semanticObject); 
				return; 
			case GamlPackage.FACET:
				if (rule == grammarAccess.getFacetRule()) {
					sequence_ActionFacet_ClassicFacet_DefinitionFacet_FunctionFacet_TypeFacet_VarFacet(context, (Facet) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getActionFacetRule()) {
					sequence_ActionFacet(context, (Facet) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getClassicFacetRule()) {
					sequence_ClassicFacet(context, (Facet) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getDefinitionFacetRule()
						|| rule == grammarAccess.getGamlDefinitionRule()
						|| rule == grammarAccess.getVarDefinitionRule()) {
					sequence_DefinitionFacet(context, (Facet) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getFunctionFacetRule()) {
					sequence_FunctionFacet(context, (Facet) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeFacetRule()) {
					sequence_TypeFacet(context, (Facet) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getVarFacetRule()) {
					sequence_VarFacet(context, (Facet) semanticObject); 
					return; 
				}
				else break;
			case GamlPackage.FUNCTION:
				sequence_Function(context, (Function) semanticObject); 
				return; 
			case GamlPackage.HEADLESS_EXPERIMENT:
				sequence_HeadlessExperiment(context, (HeadlessExperiment) semanticObject); 
				return; 
			case GamlPackage.IF:
				sequence_If(context, (If) semanticObject); 
				return; 
			case GamlPackage.IMPORT:
				sequence_Import(context, (Import) semanticObject); 
				return; 
			case GamlPackage.INT_LITERAL:
				sequence_TerminalExpression(context, (IntLiteral) semanticObject); 
				return; 
			case GamlPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case GamlPackage.PARAMETER:
				sequence_Parameter(context, (gaml.compiler.gaml.Parameter) semanticObject); 
				return; 
			case GamlPackage.POINT:
				sequence_Primary(context, (Point) semanticObject); 
				return; 
			case GamlPackage.PRAGMA:
				sequence_Pragma(context, (Pragma) semanticObject); 
				return; 
			case GamlPackage.RESERVED_LITERAL:
				sequence_TerminalExpression(context, (ReservedLiteral) semanticObject); 
				return; 
			case GamlPackage.SACTION:
				sequence_S_Action(context, (S_Action) semanticObject); 
				return; 
			case GamlPackage.SASSIGNMENT:
				sequence_S_Equation(context, (S_Assignment) semanticObject); 
				return; 
			case GamlPackage.SDEFINITION:
				sequence_S_Definition(context, (S_Definition) semanticObject); 
				return; 
			case GamlPackage.SDIRECT_ASSIGNMENT:
				sequence_S_DirectAssignment(context, (S_DirectAssignment) semanticObject); 
				return; 
			case GamlPackage.SDISPLAY:
				sequence_S_Display(context, (S_Display) semanticObject); 
				return; 
			case GamlPackage.SDO:
				sequence_S_Do(context, (S_Do) semanticObject); 
				return; 
			case GamlPackage.SEQUATIONS:
				sequence_S_Equations(context, (S_Equations) semanticObject); 
				return; 
			case GamlPackage.SEXPERIMENT:
				sequence_S_Experiment(context, (S_Experiment) semanticObject); 
				return; 
			case GamlPackage.SGLOBAL:
				sequence_S_Global(context, (S_Global) semanticObject); 
				return; 
			case GamlPackage.SIF:
				sequence_S_If(context, (S_If) semanticObject); 
				return; 
			case GamlPackage.SLOOP:
				sequence_S_Loop(context, (S_Loop) semanticObject); 
				return; 
			case GamlPackage.SOTHER:
				sequence_S_Other(context, (S_Other) semanticObject); 
				return; 
			case GamlPackage.SREFLEX:
				sequence_S_Reflex(context, (S_Reflex) semanticObject); 
				return; 
			case GamlPackage.SRETURN:
				sequence_S_Return(context, (S_Return) semanticObject); 
				return; 
			case GamlPackage.SSET:
				sequence_S_Set(context, (S_Set) semanticObject); 
				return; 
			case GamlPackage.SSOLVE:
				sequence_S_Solve(context, (S_Solve) semanticObject); 
				return; 
			case GamlPackage.SSPECIES:
				sequence_S_Species(context, (S_Species) semanticObject); 
				return; 
			case GamlPackage.STRY:
				sequence_S_Try(context, (S_Try) semanticObject); 
				return; 
			case GamlPackage.SVAR:
				sequence_S_Var(context, (S_Var) semanticObject); 
				return; 
			case GamlPackage.SKILL_FAKE_DEFINITION:
				sequence_SkillFakeDefinition(context, (SkillFakeDefinition) semanticObject); 
				return; 
			case GamlPackage.SKILL_REF:
				sequence_SkillRef(context, (SkillRef) semanticObject); 
				return; 
			case GamlPackage.STANDALONE_BLOCK:
				sequence_StandaloneBlock(context, (StandaloneBlock) semanticObject); 
				return; 
			case GamlPackage.STATEMENT:
				sequence_S_1Expr_Facets_BlockOrEnd(context, (Statement) semanticObject); 
				return; 
			case GamlPackage.STRING_EVALUATOR:
				sequence_StringEvaluator(context, (StringEvaluator) semanticObject); 
				return; 
			case GamlPackage.STRING_LITERAL:
				sequence_StringLiteral(context, (StringLiteral) semanticObject); 
				return; 
			case GamlPackage.TYPE_FAKE_DEFINITION:
				sequence_TypeFakeDefinition(context, (TypeFakeDefinition) semanticObject); 
				return; 
			case GamlPackage.TYPE_INFO:
				sequence_TypeInfo(context, (TypeInfo) semanticObject); 
				return; 
			case GamlPackage.TYPE_REF:
				sequence_TypeRef(context, (TypeRef) semanticObject); 
				return; 
			case GamlPackage.UNARY:
				sequence_Unary(context, (Unary) semanticObject); 
				return; 
			case GamlPackage.UNIT:
				sequence_Unit(context, (Unit) semanticObject); 
				return; 
			case GamlPackage.UNIT_FAKE_DEFINITION:
				sequence_UnitFakeDefinition(context, (UnitFakeDefinition) semanticObject); 
				return; 
			case GamlPackage.UNIT_NAME:
				sequence_UnitRef(context, (UnitName) semanticObject); 
				return; 
			case GamlPackage.VAR_FAKE_DEFINITION:
				sequence_VarFakeDefinition(context, (VarFakeDefinition) semanticObject); 
				return; 
			case GamlPackage.VARIABLE_REF:
				sequence_VariableRef(context, (VariableRef) semanticObject); 
				return; 
			case GamlPackage.IMAGE_DISPLAY_STATEMENT:
				sequence_imageDisplayStatement(context, (imageDisplayStatement) semanticObject); 
				return; 
			case GamlPackage.SPECIES_OR_GRID_DISPLAY_STATEMENT:
				sequence_speciesOrGridDisplayStatement(context, (speciesOrGridDisplayStatement) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns Access
	 *     BinaryOperator returns Access
	 *     Pair returns Access
	 *     Pair.BinaryOperator_1_0 returns Access
	 *     If returns Access
	 *     If.If_1_0 returns Access
	 *     Or returns Access
	 *     Or.BinaryOperator_1_0 returns Access
	 *     And returns Access
	 *     And.BinaryOperator_1_0 returns Access
	 *     Cast returns Access
	 *     Cast.BinaryOperator_1_0_0 returns Access
	 *     Comparison returns Access
	 *     Comparison.BinaryOperator_1_0_0 returns Access
	 *     Addition returns Access
	 *     Addition.BinaryOperator_1_0_0 returns Access
	 *     Multiplication returns Access
	 *     Multiplication.BinaryOperator_1_0_0 returns Access
	 *     Exponentiation returns Access
	 *     Exponentiation.BinaryOperator_1_0_0 returns Access
	 *     Binary returns Access
	 *     Binary.BinaryOperator_1_0_0 returns Access
	 *     Unit returns Access
	 *     Unit.Unit_1_0_0 returns Access
	 *     Unary returns Access
	 *     Access returns Access
	 *     Access.Access_1_0 returns Access
	 *
	 * Constraint:
	 *     (left=Access_Access_1_0 ((op='[' right=ExpressionList?) | (op='.' (right=AbstractRef | right=StringLiteral))))
	 * </pre>
	 */
	protected void sequence_Access(ISerializationContext context, Access semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ActionArguments returns ActionArguments
	 *
	 * Constraint:
	 *     (args+=ArgumentDefinition args+=ArgumentDefinition*)
	 * </pre>
	 */
	protected void sequence_ActionArguments(ISerializationContext context, ActionArguments semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Facet returns Facet
	 *
	 * Constraint:
	 *     (
	 *         ((key=ClassicFacetKey | key='&lt;-' | key=SpecialFacetKey) expr=Expression) | 
	 *         (key=DefinitionFacetKey (name=Valid_ID | name=STRING)) | 
	 *         (key='-&gt;' (expr=Expression | expr=Expression)) | 
	 *         (key=TypeFacetKey (expr=TypeRef | expr=Expression)) | 
	 *         (key=ActionFacetKey (expr=ActionRef | block=Block)) | 
	 *         (key=VarFacetKey expr=VariableRef)
	 *     )
	 * </pre>
	 */
	protected void sequence_ActionFacet_ClassicFacet_DefinitionFacet_FunctionFacet_TypeFacet_VarFacet(ISerializationContext context, Facet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ActionFacet returns Facet
	 *
	 * Constraint:
	 *     (key=ActionFacetKey (expr=ActionRef | block=Block))
	 * </pre>
	 */
	protected void sequence_ActionFacet(ISerializationContext context, Facet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     GamlDefinition returns ActionFakeDefinition
	 *     ActionDefinition returns ActionFakeDefinition
	 *     ActionFakeDefinition returns ActionFakeDefinition
	 *
	 * Constraint:
	 *     name=Valid_ID
	 * </pre>
	 */
	protected void sequence_ActionFakeDefinition(ISerializationContext context, ActionFakeDefinition semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.GAML_DEFINITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.GAML_DEFINITION__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getActionFakeDefinitionAccess().getNameValid_IDParserRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ActionRef returns ActionRef
	 *
	 * Constraint:
	 *     ref=[ActionDefinition|Valid_ID]
	 * </pre>
	 */
	protected void sequence_ActionRef(ISerializationContext context, ActionRef semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.ACTION_REF__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.ACTION_REF__REF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getActionRefAccess().getRefActionDefinitionValid_IDParserRuleCall_1_0_1(), semanticObject.eGet(GamlPackage.Literals.ACTION_REF__REF, false));
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     And returns BinaryOperator
	 *     And.BinaryOperator_1_0 returns BinaryOperator
	 *
	 * Constraint:
	 *     (
	 *         (left=And_BinaryOperator_1_0 op='and' right=Cast) | 
	 *         (left=Cast_BinaryOperator_1_0_0 op='as' (right=TypeRef | right=TypeRef)) | 
	 *         (
	 *             left=Comparison_BinaryOperator_1_0_0 
	 *             (
	 *                 op='!=' | 
	 *                 op='=' | 
	 *                 op='&gt;=' | 
	 *                 op='&lt;=' | 
	 *                 op='&lt;' | 
	 *                 op='&gt;'
	 *             ) 
	 *             right=Addition
	 *         ) | 
	 *         (left=Addition_BinaryOperator_1_0_0 (op='+' | op='-') right=Multiplication) | 
	 *         (left=Multiplication_BinaryOperator_1_0_0 (op='*' | op='/') right=Exponentiation) | 
	 *         (left=Exponentiation_BinaryOperator_1_0_0 op='^' right=Binary) | 
	 *         (left=Binary_BinaryOperator_1_0_0 op=Valid_ID right=Unit)
	 *     )
	 * </pre>
	 */
	protected void sequence_Addition_And_Binary_Cast_Comparison_Exponentiation_Multiplication(ISerializationContext context, BinaryOperator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Pair.BinaryOperator_1_0 returns BinaryOperator
	 *     If returns BinaryOperator
	 *     If.If_1_0 returns BinaryOperator
	 *     Or returns BinaryOperator
	 *     Or.BinaryOperator_1_0 returns BinaryOperator
	 *
	 * Constraint:
	 *     (
	 *         (left=Or_BinaryOperator_1_0 op='or' right=And) | 
	 *         (left=And_BinaryOperator_1_0 op='and' right=Cast) | 
	 *         (left=Cast_BinaryOperator_1_0_0 op='as' (right=TypeRef | right=TypeRef)) | 
	 *         (
	 *             left=Comparison_BinaryOperator_1_0_0 
	 *             (
	 *                 op='!=' | 
	 *                 op='=' | 
	 *                 op='&gt;=' | 
	 *                 op='&lt;=' | 
	 *                 op='&lt;' | 
	 *                 op='&gt;'
	 *             ) 
	 *             right=Addition
	 *         ) | 
	 *         (left=Addition_BinaryOperator_1_0_0 (op='+' | op='-') right=Multiplication) | 
	 *         (left=Multiplication_BinaryOperator_1_0_0 (op='*' | op='/') right=Exponentiation) | 
	 *         (left=Exponentiation_BinaryOperator_1_0_0 op='^' right=Binary) | 
	 *         (left=Binary_BinaryOperator_1_0_0 op=Valid_ID right=Unit)
	 *     )
	 * </pre>
	 */
	protected void sequence_Addition_And_Binary_Cast_Comparison_Exponentiation_Multiplication_Or(ISerializationContext context, BinaryOperator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns BinaryOperator
	 *     BinaryOperator returns BinaryOperator
	 *     Pair returns BinaryOperator
	 *
	 * Constraint:
	 *     (
	 *         (left=Pair_BinaryOperator_1_0 op='::' right=If) | 
	 *         (left=Or_BinaryOperator_1_0 op='or' right=And) | 
	 *         (left=And_BinaryOperator_1_0 op='and' right=Cast) | 
	 *         (left=Cast_BinaryOperator_1_0_0 op='as' (right=TypeRef | right=TypeRef)) | 
	 *         (
	 *             left=Comparison_BinaryOperator_1_0_0 
	 *             (
	 *                 op='!=' | 
	 *                 op='=' | 
	 *                 op='&gt;=' | 
	 *                 op='&lt;=' | 
	 *                 op='&lt;' | 
	 *                 op='&gt;'
	 *             ) 
	 *             right=Addition
	 *         ) | 
	 *         (left=Addition_BinaryOperator_1_0_0 (op='+' | op='-') right=Multiplication) | 
	 *         (left=Multiplication_BinaryOperator_1_0_0 (op='*' | op='/') right=Exponentiation) | 
	 *         (left=Exponentiation_BinaryOperator_1_0_0 op='^' right=Binary) | 
	 *         (left=Binary_BinaryOperator_1_0_0 op=Valid_ID right=Unit)
	 *     )
	 * </pre>
	 */
	protected void sequence_Addition_And_Binary_Cast_Comparison_Exponentiation_Multiplication_Or_Pair(ISerializationContext context, BinaryOperator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Cast returns BinaryOperator
	 *
	 * Constraint:
	 *     (
	 *         (left=Cast_BinaryOperator_1_0_0 op='as' (right=TypeRef | right=TypeRef)) | 
	 *         (
	 *             left=Comparison_BinaryOperator_1_0_0 
	 *             (
	 *                 op='!=' | 
	 *                 op='=' | 
	 *                 op='&gt;=' | 
	 *                 op='&lt;=' | 
	 *                 op='&lt;' | 
	 *                 op='&gt;'
	 *             ) 
	 *             right=Addition
	 *         ) | 
	 *         (left=Addition_BinaryOperator_1_0_0 (op='+' | op='-') right=Multiplication) | 
	 *         (left=Multiplication_BinaryOperator_1_0_0 (op='*' | op='/') right=Exponentiation) | 
	 *         (left=Exponentiation_BinaryOperator_1_0_0 op='^' right=Binary) | 
	 *         (left=Binary_BinaryOperator_1_0_0 op=Valid_ID right=Unit)
	 *     )
	 * </pre>
	 */
	protected void sequence_Addition_Binary_Cast_Comparison_Exponentiation_Multiplication(ISerializationContext context, BinaryOperator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Cast.BinaryOperator_1_0_0 returns BinaryOperator
	 *     Comparison returns BinaryOperator
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             left=Comparison_BinaryOperator_1_0_0 
	 *             (
	 *                 op='!=' | 
	 *                 op='=' | 
	 *                 op='&gt;=' | 
	 *                 op='&lt;=' | 
	 *                 op='&lt;' | 
	 *                 op='&gt;'
	 *             ) 
	 *             right=Addition
	 *         ) | 
	 *         (left=Addition_BinaryOperator_1_0_0 (op='+' | op='-') right=Multiplication) | 
	 *         (left=Multiplication_BinaryOperator_1_0_0 (op='*' | op='/') right=Exponentiation) | 
	 *         (left=Exponentiation_BinaryOperator_1_0_0 op='^' right=Binary) | 
	 *         (left=Binary_BinaryOperator_1_0_0 op=Valid_ID right=Unit)
	 *     )
	 * </pre>
	 */
	protected void sequence_Addition_Binary_Comparison_Exponentiation_Multiplication(ISerializationContext context, BinaryOperator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Comparison.BinaryOperator_1_0_0 returns BinaryOperator
	 *     Addition returns BinaryOperator
	 *     Addition.BinaryOperator_1_0_0 returns BinaryOperator
	 *
	 * Constraint:
	 *     (
	 *         (left=Addition_BinaryOperator_1_0_0 (op='+' | op='-') right=Multiplication) | 
	 *         (left=Multiplication_BinaryOperator_1_0_0 (op='*' | op='/') right=Exponentiation) | 
	 *         (left=Exponentiation_BinaryOperator_1_0_0 op='^' right=Binary) | 
	 *         (left=Binary_BinaryOperator_1_0_0 op=Valid_ID right=Unit)
	 *     )
	 * </pre>
	 */
	protected void sequence_Addition_Binary_Exponentiation_Multiplication(ISerializationContext context, BinaryOperator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ArgumentDefinition returns ArgumentDefinition
	 *     GamlDefinition returns ArgumentDefinition
	 *     VarDefinition returns ArgumentDefinition
	 *
	 * Constraint:
	 *     (type=TypeRef name=Valid_ID default=Expression?)
	 * </pre>
	 */
	protected void sequence_ArgumentDefinition(ISerializationContext context, ArgumentDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns ArgumentPair
	 *     ArgumentPair returns ArgumentPair
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             op=Valid_ID | 
	 *             op=DefinitionFacetKey | 
	 *             op=TypeFacetKey | 
	 *             op=SpecialFacetKey | 
	 *             op=ActionFacetKey | 
	 *             op=VarFacetKey
	 *         )? 
	 *         right=Pair
	 *     )
	 * </pre>
	 */
	protected void sequence_ArgumentPair(ISerializationContext context, ArgumentPair semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Binary returns BinaryOperator
	 *     Binary.BinaryOperator_1_0_0 returns BinaryOperator
	 *
	 * Constraint:
	 *     (left=Binary_BinaryOperator_1_0_0 op=Valid_ID right=Unit)
	 * </pre>
	 */
	protected void sequence_Binary(ISerializationContext context, BinaryOperator semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.BINARY_OPERATOR__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.BINARY_OPERATOR__LEFT));
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.BINARY_OPERATOR__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.BINARY_OPERATOR__OP));
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.BINARY_OPERATOR__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.BINARY_OPERATOR__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getBinaryAccess().getBinaryOperatorLeftAction_1_0_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getBinaryAccess().getOpValid_IDParserRuleCall_1_0_1_0(), semanticObject.getOp());
		feeder.accept(grammarAccess.getBinaryAccess().getRightUnitParserRuleCall_1_1_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Exponentiation returns BinaryOperator
	 *     Exponentiation.BinaryOperator_1_0_0 returns BinaryOperator
	 *
	 * Constraint:
	 *     ((left=Exponentiation_BinaryOperator_1_0_0 op='^' right=Binary) | (left=Binary_BinaryOperator_1_0_0 op=Valid_ID right=Unit))
	 * </pre>
	 */
	protected void sequence_Binary_Exponentiation(ISerializationContext context, BinaryOperator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Multiplication returns BinaryOperator
	 *     Multiplication.BinaryOperator_1_0_0 returns BinaryOperator
	 *
	 * Constraint:
	 *     (
	 *         (left=Multiplication_BinaryOperator_1_0_0 (op='*' | op='/') right=Exponentiation) | 
	 *         (left=Exponentiation_BinaryOperator_1_0_0 op='^' right=Binary) | 
	 *         (left=Binary_BinaryOperator_1_0_0 op=Valid_ID right=Unit)
	 *     )
	 * </pre>
	 */
	protected void sequence_Binary_Exponentiation_Multiplication(ISerializationContext context, BinaryOperator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Block returns Block
	 *
	 * Constraint:
	 *     statements+=Statement*
	 * </pre>
	 */
	protected void sequence_Block(ISerializationContext context, Block semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ClassicFacet returns Facet
	 *
	 * Constraint:
	 *     ((key=ClassicFacetKey | key='&lt;-' | key=SpecialFacetKey) expr=Expression)
	 * </pre>
	 */
	protected void sequence_ClassicFacet(ISerializationContext context, Facet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     DefinitionFacet returns Facet
	 *     GamlDefinition returns Facet
	 *     VarDefinition returns Facet
	 *
	 * Constraint:
	 *     (key=DefinitionFacetKey (name=Valid_ID | name=STRING))
	 * </pre>
	 */
	protected void sequence_DefinitionFacet(ISerializationContext context, Facet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     GamlDefinition returns EquationFakeDefinition
	 *     EquationDefinition returns EquationFakeDefinition
	 *     EquationFakeDefinition returns EquationFakeDefinition
	 *
	 * Constraint:
	 *     name=Valid_ID
	 * </pre>
	 */
	protected void sequence_EquationFakeDefinition(ISerializationContext context, EquationFakeDefinition semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.GAML_DEFINITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.GAML_DEFINITION__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getEquationFakeDefinitionAccess().getNameValid_IDParserRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     EquationRef returns EquationRef
	 *
	 * Constraint:
	 *     ref=[EquationDefinition|Valid_ID]
	 * </pre>
	 */
	protected void sequence_EquationRef(ISerializationContext context, EquationRef semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.EQUATION_REF__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.EQUATION_REF__REF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getEquationRefAccess().getRefEquationDefinitionValid_IDParserRuleCall_1_0_1(), semanticObject.eGet(GamlPackage.Literals.EQUATION_REF__REF, false));
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Entry returns ExperimentFileStructure
	 *     ExperimentFileStructure returns ExperimentFileStructure
	 *
	 * Constraint:
	 *     exp=HeadlessExperiment
	 * </pre>
	 */
	protected void sequence_ExperimentFileStructure(ISerializationContext context, ExperimentFileStructure semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.EXPERIMENT_FILE_STRUCTURE__EXP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.EXPERIMENT_FILE_STRUCTURE__EXP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getExperimentFileStructureAccess().getExpHeadlessExperimentParserRuleCall_0(), semanticObject.getExp());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns ExpressionList
	 *     BinaryOperator returns ExpressionList
	 *     Pair returns ExpressionList
	 *     Pair.BinaryOperator_1_0 returns ExpressionList
	 *     If returns ExpressionList
	 *     If.If_1_0 returns ExpressionList
	 *     Or returns ExpressionList
	 *     Or.BinaryOperator_1_0 returns ExpressionList
	 *     And returns ExpressionList
	 *     And.BinaryOperator_1_0 returns ExpressionList
	 *     Cast returns ExpressionList
	 *     Cast.BinaryOperator_1_0_0 returns ExpressionList
	 *     Comparison returns ExpressionList
	 *     Comparison.BinaryOperator_1_0_0 returns ExpressionList
	 *     Addition returns ExpressionList
	 *     Addition.BinaryOperator_1_0_0 returns ExpressionList
	 *     Multiplication returns ExpressionList
	 *     Multiplication.BinaryOperator_1_0_0 returns ExpressionList
	 *     Exponentiation returns ExpressionList
	 *     Exponentiation.BinaryOperator_1_0_0 returns ExpressionList
	 *     Binary returns ExpressionList
	 *     Binary.BinaryOperator_1_0_0 returns ExpressionList
	 *     Unit returns ExpressionList
	 *     Unit.Unit_1_0_0 returns ExpressionList
	 *     Unary returns ExpressionList
	 *     Access returns ExpressionList
	 *     Access.Access_1_0 returns ExpressionList
	 *     Primary returns ExpressionList
	 *     ExpressionList returns ExpressionList
	 *
	 * Constraint:
	 *     ((exprs+=Expression exprs+=Expression*) | (exprs+=Parameter exprs+=Parameter*))
	 * </pre>
	 */
	protected void sequence_ExpressionList(ISerializationContext context, ExpressionList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     FunctionFacet returns Facet
	 *
	 * Constraint:
	 *     (key='-&gt;' (expr=Expression | expr=Expression))
	 * </pre>
	 */
	protected void sequence_FunctionFacet(ISerializationContext context, Facet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns Function
	 *     BinaryOperator returns Function
	 *     Pair returns Function
	 *     Pair.BinaryOperator_1_0 returns Function
	 *     If returns Function
	 *     If.If_1_0 returns Function
	 *     Or returns Function
	 *     Or.BinaryOperator_1_0 returns Function
	 *     And returns Function
	 *     And.BinaryOperator_1_0 returns Function
	 *     Cast returns Function
	 *     Cast.BinaryOperator_1_0_0 returns Function
	 *     Comparison returns Function
	 *     Comparison.BinaryOperator_1_0_0 returns Function
	 *     Addition returns Function
	 *     Addition.BinaryOperator_1_0_0 returns Function
	 *     Multiplication returns Function
	 *     Multiplication.BinaryOperator_1_0_0 returns Function
	 *     Exponentiation returns Function
	 *     Exponentiation.BinaryOperator_1_0_0 returns Function
	 *     Binary returns Function
	 *     Binary.BinaryOperator_1_0_0 returns Function
	 *     Unit returns Function
	 *     Unit.Unit_1_0_0 returns Function
	 *     Unary returns Function
	 *     Access returns Function
	 *     Access.Access_1_0 returns Function
	 *     Primary returns Function
	 *     AbstractRef returns Function
	 *     Function returns Function
	 *
	 * Constraint:
	 *     (left=ActionRef type=TypeInfo? right=ExpressionList?)
	 * </pre>
	 */
	protected void sequence_Function(ISerializationContext context, Function semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     HeadlessExperiment returns HeadlessExperiment
	 *
	 * Constraint:
	 *     (
	 *         key=_ExperimentKey 
	 *         firstFacet='name:'? 
	 *         (name=Valid_ID | name=STRING) 
	 *         importURI=STRING? 
	 *         facets+=Facet* 
	 *         block=Block?
	 *     )
	 * </pre>
	 */
	protected void sequence_HeadlessExperiment(ISerializationContext context, HeadlessExperiment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns If
	 *     BinaryOperator returns If
	 *     Pair returns If
	 *     Pair.BinaryOperator_1_0 returns If
	 *     If returns If
	 *
	 * Constraint:
	 *     (left=If_If_1_0 op='?' right=Or ifFalse=Or)
	 * </pre>
	 */
	protected void sequence_If(ISerializationContext context, If semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.IF__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.IF__LEFT));
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.IF__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.IF__OP));
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.IF__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.IF__RIGHT));
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.IF__IF_FALSE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.IF__IF_FALSE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getIfAccess().getIfLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getIfAccess().getOpQuestionMarkKeyword_1_1_0(), semanticObject.getOp());
		feeder.accept(grammarAccess.getIfAccess().getRightOrParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.accept(grammarAccess.getIfAccess().getIfFalseOrParserRuleCall_1_3_1_0(), semanticObject.getIfFalse());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Import returns Import
	 *     GamlDefinition returns Import
	 *     VarDefinition returns Import
	 *
	 * Constraint:
	 *     (importURI=STRING name=Valid_ID?)
	 * </pre>
	 */
	protected void sequence_Import(ISerializationContext context, Import semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ModelBlock returns Block
	 *
	 * Constraint:
	 *     statements+=S_Section*
	 * </pre>
	 */
	protected void sequence_ModelBlock(ISerializationContext context, Block semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Entry returns Model
	 *     Model returns Model
	 *     GamlDefinition returns Model
	 *     VarDefinition returns Model
	 *
	 * Constraint:
	 *     (pragmas+=Pragma* name=ID imports+=Import* block=ModelBlock)
	 * </pre>
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Parameter returns Parameter
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             builtInFacetKey=DefinitionFacetKey | 
	 *             builtInFacetKey=TypeFacetKey | 
	 *             builtInFacetKey=SpecialFacetKey | 
	 *             builtInFacetKey=ActionFacetKey | 
	 *             builtInFacetKey=VarFacetKey | 
	 *             left=VariableRef
	 *         ) 
	 *         right=Expression
	 *     )
	 * </pre>
	 */
	protected void sequence_Parameter(ISerializationContext context, gaml.compiler.gaml.Parameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Pragma returns Pragma
	 *
	 * Constraint:
	 *     (name=ID plugins=ExpressionList?)
	 * </pre>
	 */
	protected void sequence_Pragma(ISerializationContext context, Pragma semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns Array
	 *     BinaryOperator returns Array
	 *     Pair returns Array
	 *     Pair.BinaryOperator_1_0 returns Array
	 *     If returns Array
	 *     If.If_1_0 returns Array
	 *     Or returns Array
	 *     Or.BinaryOperator_1_0 returns Array
	 *     And returns Array
	 *     And.BinaryOperator_1_0 returns Array
	 *     Cast returns Array
	 *     Cast.BinaryOperator_1_0_0 returns Array
	 *     Comparison returns Array
	 *     Comparison.BinaryOperator_1_0_0 returns Array
	 *     Addition returns Array
	 *     Addition.BinaryOperator_1_0_0 returns Array
	 *     Multiplication returns Array
	 *     Multiplication.BinaryOperator_1_0_0 returns Array
	 *     Exponentiation returns Array
	 *     Exponentiation.BinaryOperator_1_0_0 returns Array
	 *     Binary returns Array
	 *     Binary.BinaryOperator_1_0_0 returns Array
	 *     Unit returns Array
	 *     Unit.Unit_1_0_0 returns Array
	 *     Unary returns Array
	 *     Access returns Array
	 *     Access.Access_1_0 returns Array
	 *     Primary returns Array
	 *
	 * Constraint:
	 *     exprs=ExpressionList?
	 * </pre>
	 */
	protected void sequence_Primary(ISerializationContext context, Array semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns Point
	 *     BinaryOperator returns Point
	 *     Pair returns Point
	 *     Pair.BinaryOperator_1_0 returns Point
	 *     If returns Point
	 *     If.If_1_0 returns Point
	 *     Or returns Point
	 *     Or.BinaryOperator_1_0 returns Point
	 *     And returns Point
	 *     And.BinaryOperator_1_0 returns Point
	 *     Cast returns Point
	 *     Cast.BinaryOperator_1_0_0 returns Point
	 *     Comparison returns Point
	 *     Comparison.BinaryOperator_1_0_0 returns Point
	 *     Addition returns Point
	 *     Addition.BinaryOperator_1_0_0 returns Point
	 *     Multiplication returns Point
	 *     Multiplication.BinaryOperator_1_0_0 returns Point
	 *     Exponentiation returns Point
	 *     Exponentiation.BinaryOperator_1_0_0 returns Point
	 *     Binary returns Point
	 *     Binary.BinaryOperator_1_0_0 returns Point
	 *     Unit returns Point
	 *     Unit.Unit_1_0_0 returns Point
	 *     Unary returns Point
	 *     Access returns Point
	 *     Access.Access_1_0 returns Point
	 *     Primary returns Point
	 *
	 * Constraint:
	 *     (left=Expression op=',' right=Expression z=Expression?)
	 * </pre>
	 */
	protected void sequence_Primary(ISerializationContext context, Point semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Statement returns Statement
	 *     S_1Expr_Facets_BlockOrEnd returns Statement
	 *     displayStatement returns Statement
	 *
	 * Constraint:
	 *     (key=_1Expr_Facets_BlockOrEnd_Key firstFacet=FirstFacetKey? expr=Expression facets+=Facet* block=Block?)
	 * </pre>
	 */
	protected void sequence_S_1Expr_Facets_BlockOrEnd(ISerializationContext context, Statement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Statement returns S_Action
	 *     S_Declaration returns S_Action
	 *     S_Action returns S_Action
	 *     displayStatement returns S_Action
	 *     GamlDefinition returns S_Action
	 *     VarDefinition returns S_Action
	 *     ActionDefinition returns S_Action
	 *
	 * Constraint:
	 *     (
	 *         key='action' 
	 *         firstFacet='name:'? 
	 *         name=Valid_ID 
	 *         args=ActionArguments? 
	 *         facets+=Facet* 
	 *         block=Block?
	 *     )
	 * </pre>
	 */
	protected void sequence_S_Action(ISerializationContext context, S_Action semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Statement returns S_Definition
	 *     S_Declaration returns S_Definition
	 *     S_Definition returns S_Definition
	 *     displayStatement returns S_Definition
	 *     GamlDefinition returns S_Definition
	 *     VarDefinition returns S_Definition
	 *     ActionDefinition returns S_Definition
	 *
	 * Constraint:
	 *     (
	 *         tkey=TypeRef 
	 *         firstFacet='name:'? 
	 *         (name=Valid_ID | name=STRING) 
	 *         args=ActionArguments? 
	 *         facets+=Facet* 
	 *         block=Block?
	 *     )
	 * </pre>
	 */
	protected void sequence_S_Definition(ISerializationContext context, S_Definition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Statement returns S_DirectAssignment
	 *     S_Assignment returns S_DirectAssignment
	 *     S_DirectAssignment returns S_DirectAssignment
	 *     displayStatement returns S_DirectAssignment
	 *
	 * Constraint:
	 *     (expr=Expression key=_AssignmentKey value=Expression facets+=Facet*)
	 * </pre>
	 */
	protected void sequence_S_DirectAssignment(ISerializationContext context, S_DirectAssignment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Statement returns S_Display
	 *     S_Display returns S_Display
	 *     displayStatement returns S_Display
	 *
	 * Constraint:
	 *     (key='display' firstFacet='name:'? (name=Valid_ID | name=STRING) facets+=Facet* block=displayBlock)
	 * </pre>
	 */
	protected void sequence_S_Display(ISerializationContext context, S_Display semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Statement returns S_Do
	 *     S_Do returns S_Do
	 *     displayStatement returns S_Do
	 *
	 * Constraint:
	 *     (key=_DoKey firstFacet='action:'? expr=AbstractRef facets+=Facet* block=Block?)
	 * </pre>
	 */
	protected void sequence_S_Do(ISerializationContext context, S_Do semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     S_Equation returns S_Assignment
	 *
	 * Constraint:
	 *     ((expr=Function | expr=VariableRef) key='=' value=Expression)
	 * </pre>
	 */
	protected void sequence_S_Equation(ISerializationContext context, S_Assignment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Statement returns S_Equations
	 *     S_Equations returns S_Equations
	 *     displayStatement returns S_Equations
	 *     GamlDefinition returns S_Equations
	 *     EquationDefinition returns S_Equations
	 *
	 * Constraint:
	 *     (key=_EquationsKey name=Valid_ID facets+=Facet* equations+=S_Equation*)
	 * </pre>
	 */
	protected void sequence_S_Equations(ISerializationContext context, S_Equations semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     S_Section returns S_Experiment
	 *     S_Experiment returns S_Experiment
	 *     GamlDefinition returns S_Experiment
	 *     VarDefinition returns S_Experiment
	 *
	 * Constraint:
	 *     (key=_ExperimentKey firstFacet='name:'? (name=Valid_ID | name=STRING) facets+=Facet* block=Block?)
	 * </pre>
	 */
	protected void sequence_S_Experiment(ISerializationContext context, S_Experiment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     S_Section returns S_Global
	 *     S_Global returns S_Global
	 *
	 * Constraint:
	 *     (key='global' facets+=Facet* block=Block?)
	 * </pre>
	 */
	protected void sequence_S_Global(ISerializationContext context, S_Global semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Statement returns S_If
	 *     S_If returns S_If
	 *     displayStatement returns S_If
	 *
	 * Constraint:
	 *     (key='if' firstFacet='condition:'? expr=Expression block=Block (else=S_If | else=Block)?)
	 * </pre>
	 */
	protected void sequence_S_If(ISerializationContext context, S_If semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Statement returns S_Loop
	 *     S_Loop returns S_Loop
	 *     S_Declaration returns S_Loop
	 *     displayStatement returns S_Loop
	 *     GamlDefinition returns S_Loop
	 *     VarDefinition returns S_Loop
	 *
	 * Constraint:
	 *     (key='loop' name=ID? facets+=Facet* block=Block)
	 * </pre>
	 */
	protected void sequence_S_Loop(ISerializationContext context, S_Loop semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Statement returns S_Other
	 *     S_Other returns S_Other
	 *     displayStatement returns S_Other
	 *
	 * Constraint:
	 *     (key=ID facets+=Facet* block=Block?)
	 * </pre>
	 */
	protected void sequence_S_Other(ISerializationContext context, S_Other semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Statement returns S_Reflex
	 *     S_Declaration returns S_Reflex
	 *     S_Reflex returns S_Reflex
	 *     displayStatement returns S_Reflex
	 *     GamlDefinition returns S_Reflex
	 *     VarDefinition returns S_Reflex
	 *
	 * Constraint:
	 *     (key=_ReflexKey (firstFacet='name:'? name=Valid_ID)? expr=Expression? block=Block)
	 * </pre>
	 */
	protected void sequence_S_Reflex(ISerializationContext context, S_Reflex semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Statement returns S_Return
	 *     S_Return returns S_Return
	 *     displayStatement returns S_Return
	 *
	 * Constraint:
	 *     (key='return' firstFacet='value:'? expr=Expression?)
	 * </pre>
	 */
	protected void sequence_S_Return(ISerializationContext context, S_Return semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Statement returns S_Set
	 *     S_Assignment returns S_Set
	 *     S_Set returns S_Set
	 *     displayStatement returns S_Set
	 *
	 * Constraint:
	 *     (key='set' expr=Expression value=Expression)
	 * </pre>
	 */
	protected void sequence_S_Set(ISerializationContext context, S_Set semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.STATEMENT__KEY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.STATEMENT__KEY));
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.STATEMENT__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.STATEMENT__EXPR));
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.SASSIGNMENT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.SASSIGNMENT__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getS_SetAccess().getKeySetKeyword_0_0(), semanticObject.getKey());
		feeder.accept(grammarAccess.getS_SetAccess().getExprExpressionParserRuleCall_1_0(), semanticObject.getExpr());
		feeder.accept(grammarAccess.getS_SetAccess().getValueExpressionParserRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Statement returns S_Solve
	 *     S_Solve returns S_Solve
	 *     displayStatement returns S_Solve
	 *
	 * Constraint:
	 *     (key=_SolveKey firstFacet='equation:'? expr=EquationRef facets+=Facet* block=Block?)
	 * </pre>
	 */
	protected void sequence_S_Solve(ISerializationContext context, S_Solve semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     S_Section returns S_Species
	 *     S_Species returns S_Species
	 *     Statement returns S_Species
	 *     S_Declaration returns S_Species
	 *     displayStatement returns S_Species
	 *     GamlDefinition returns S_Species
	 *     TypeDefinition returns S_Species
	 *     VarDefinition returns S_Species
	 *     ActionDefinition returns S_Species
	 *
	 * Constraint:
	 *     (key=_SpeciesKey firstFacet='name:'? name=ID facets+=Facet* block=Block?)
	 * </pre>
	 */
	protected void sequence_S_Species(ISerializationContext context, S_Species semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Statement returns S_Try
	 *     S_Try returns S_Try
	 *     displayStatement returns S_Try
	 *
	 * Constraint:
	 *     (key='try' block=Block catch=Block?)
	 * </pre>
	 */
	protected void sequence_S_Try(ISerializationContext context, S_Try semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Statement returns S_Var
	 *     S_Declaration returns S_Var
	 *     S_Var returns S_Var
	 *     displayStatement returns S_Var
	 *     GamlDefinition returns S_Var
	 *     VarDefinition returns S_Var
	 *
	 * Constraint:
	 *     (key=_VarOrConstKey firstFacet='name:'? name=Valid_ID facets+=Facet*)
	 * </pre>
	 */
	protected void sequence_S_Var(ISerializationContext context, S_Var semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     GamlDefinition returns SkillFakeDefinition
	 *     SkillFakeDefinition returns SkillFakeDefinition
	 *
	 * Constraint:
	 *     name=ID
	 * </pre>
	 */
	protected void sequence_SkillFakeDefinition(ISerializationContext context, SkillFakeDefinition semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.GAML_DEFINITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.GAML_DEFINITION__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSkillFakeDefinitionAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     SkillRef returns SkillRef
	 *
	 * Constraint:
	 *     ref=[SkillFakeDefinition|ID]
	 * </pre>
	 */
	protected void sequence_SkillRef(ISerializationContext context, SkillRef semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.SKILL_REF__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.SKILL_REF__REF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSkillRefAccess().getRefSkillFakeDefinitionIDTerminalRuleCall_1_0_1(), semanticObject.eGet(GamlPackage.Literals.SKILL_REF__REF, false));
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Entry returns StandaloneBlock
	 *     StandaloneBlock returns StandaloneBlock
	 *
	 * Constraint:
	 *     block=Block
	 * </pre>
	 */
	protected void sequence_StandaloneBlock(ISerializationContext context, StandaloneBlock semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.STANDALONE_BLOCK__BLOCK) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.STANDALONE_BLOCK__BLOCK));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getStandaloneBlockAccess().getBlockBlockParserRuleCall_1_0(), semanticObject.getBlock());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Entry returns StringEvaluator
	 *     StringEvaluator returns StringEvaluator
	 *
	 * Constraint:
	 *     (toto=ID expr=Expression)
	 * </pre>
	 */
	protected void sequence_StringEvaluator(ISerializationContext context, StringEvaluator semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.STRING_EVALUATOR__TOTO) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.STRING_EVALUATOR__TOTO));
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.STRING_EVALUATOR__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.STRING_EVALUATOR__EXPR));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getStringEvaluatorAccess().getTotoIDTerminalRuleCall_0_0(), semanticObject.getToto());
		feeder.accept(grammarAccess.getStringEvaluatorAccess().getExprExpressionParserRuleCall_2_0(), semanticObject.getExpr());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns StringLiteral
	 *     BinaryOperator returns StringLiteral
	 *     Pair returns StringLiteral
	 *     Pair.BinaryOperator_1_0 returns StringLiteral
	 *     If returns StringLiteral
	 *     If.If_1_0 returns StringLiteral
	 *     Or returns StringLiteral
	 *     Or.BinaryOperator_1_0 returns StringLiteral
	 *     And returns StringLiteral
	 *     And.BinaryOperator_1_0 returns StringLiteral
	 *     Cast returns StringLiteral
	 *     Cast.BinaryOperator_1_0_0 returns StringLiteral
	 *     Comparison returns StringLiteral
	 *     Comparison.BinaryOperator_1_0_0 returns StringLiteral
	 *     Addition returns StringLiteral
	 *     Addition.BinaryOperator_1_0_0 returns StringLiteral
	 *     Multiplication returns StringLiteral
	 *     Multiplication.BinaryOperator_1_0_0 returns StringLiteral
	 *     Exponentiation returns StringLiteral
	 *     Exponentiation.BinaryOperator_1_0_0 returns StringLiteral
	 *     Binary returns StringLiteral
	 *     Binary.BinaryOperator_1_0_0 returns StringLiteral
	 *     Unit returns StringLiteral
	 *     Unit.Unit_1_0_0 returns StringLiteral
	 *     Unary returns StringLiteral
	 *     Access returns StringLiteral
	 *     Access.Access_1_0 returns StringLiteral
	 *     Primary returns StringLiteral
	 *     TerminalExpression returns StringLiteral
	 *     StringLiteral returns StringLiteral
	 *
	 * Constraint:
	 *     op=STRING
	 * </pre>
	 */
	protected void sequence_StringLiteral(ISerializationContext context, StringLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.TERMINAL_EXPRESSION__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.TERMINAL_EXPRESSION__OP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getStringLiteralAccess().getOpSTRINGTerminalRuleCall_0(), semanticObject.getOp());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns BooleanLiteral
	 *     BinaryOperator returns BooleanLiteral
	 *     Pair returns BooleanLiteral
	 *     Pair.BinaryOperator_1_0 returns BooleanLiteral
	 *     If returns BooleanLiteral
	 *     If.If_1_0 returns BooleanLiteral
	 *     Or returns BooleanLiteral
	 *     Or.BinaryOperator_1_0 returns BooleanLiteral
	 *     And returns BooleanLiteral
	 *     And.BinaryOperator_1_0 returns BooleanLiteral
	 *     Cast returns BooleanLiteral
	 *     Cast.BinaryOperator_1_0_0 returns BooleanLiteral
	 *     Comparison returns BooleanLiteral
	 *     Comparison.BinaryOperator_1_0_0 returns BooleanLiteral
	 *     Addition returns BooleanLiteral
	 *     Addition.BinaryOperator_1_0_0 returns BooleanLiteral
	 *     Multiplication returns BooleanLiteral
	 *     Multiplication.BinaryOperator_1_0_0 returns BooleanLiteral
	 *     Exponentiation returns BooleanLiteral
	 *     Exponentiation.BinaryOperator_1_0_0 returns BooleanLiteral
	 *     Binary returns BooleanLiteral
	 *     Binary.BinaryOperator_1_0_0 returns BooleanLiteral
	 *     Unit returns BooleanLiteral
	 *     Unit.Unit_1_0_0 returns BooleanLiteral
	 *     Unary returns BooleanLiteral
	 *     Access returns BooleanLiteral
	 *     Access.Access_1_0 returns BooleanLiteral
	 *     Primary returns BooleanLiteral
	 *     TerminalExpression returns BooleanLiteral
	 *
	 * Constraint:
	 *     op=BOOLEAN
	 * </pre>
	 */
	protected void sequence_TerminalExpression(ISerializationContext context, BooleanLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.TERMINAL_EXPRESSION__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.TERMINAL_EXPRESSION__OP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTerminalExpressionAccess().getOpBOOLEANTerminalRuleCall_3_1_0(), semanticObject.getOp());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns DoubleLiteral
	 *     BinaryOperator returns DoubleLiteral
	 *     Pair returns DoubleLiteral
	 *     Pair.BinaryOperator_1_0 returns DoubleLiteral
	 *     If returns DoubleLiteral
	 *     If.If_1_0 returns DoubleLiteral
	 *     Or returns DoubleLiteral
	 *     Or.BinaryOperator_1_0 returns DoubleLiteral
	 *     And returns DoubleLiteral
	 *     And.BinaryOperator_1_0 returns DoubleLiteral
	 *     Cast returns DoubleLiteral
	 *     Cast.BinaryOperator_1_0_0 returns DoubleLiteral
	 *     Comparison returns DoubleLiteral
	 *     Comparison.BinaryOperator_1_0_0 returns DoubleLiteral
	 *     Addition returns DoubleLiteral
	 *     Addition.BinaryOperator_1_0_0 returns DoubleLiteral
	 *     Multiplication returns DoubleLiteral
	 *     Multiplication.BinaryOperator_1_0_0 returns DoubleLiteral
	 *     Exponentiation returns DoubleLiteral
	 *     Exponentiation.BinaryOperator_1_0_0 returns DoubleLiteral
	 *     Binary returns DoubleLiteral
	 *     Binary.BinaryOperator_1_0_0 returns DoubleLiteral
	 *     Unit returns DoubleLiteral
	 *     Unit.Unit_1_0_0 returns DoubleLiteral
	 *     Unary returns DoubleLiteral
	 *     Access returns DoubleLiteral
	 *     Access.Access_1_0 returns DoubleLiteral
	 *     Primary returns DoubleLiteral
	 *     TerminalExpression returns DoubleLiteral
	 *
	 * Constraint:
	 *     op=DOUBLE
	 * </pre>
	 */
	protected void sequence_TerminalExpression(ISerializationContext context, DoubleLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.TERMINAL_EXPRESSION__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.TERMINAL_EXPRESSION__OP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTerminalExpressionAccess().getOpDOUBLETerminalRuleCall_2_1_0(), semanticObject.getOp());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns IntLiteral
	 *     BinaryOperator returns IntLiteral
	 *     Pair returns IntLiteral
	 *     Pair.BinaryOperator_1_0 returns IntLiteral
	 *     If returns IntLiteral
	 *     If.If_1_0 returns IntLiteral
	 *     Or returns IntLiteral
	 *     Or.BinaryOperator_1_0 returns IntLiteral
	 *     And returns IntLiteral
	 *     And.BinaryOperator_1_0 returns IntLiteral
	 *     Cast returns IntLiteral
	 *     Cast.BinaryOperator_1_0_0 returns IntLiteral
	 *     Comparison returns IntLiteral
	 *     Comparison.BinaryOperator_1_0_0 returns IntLiteral
	 *     Addition returns IntLiteral
	 *     Addition.BinaryOperator_1_0_0 returns IntLiteral
	 *     Multiplication returns IntLiteral
	 *     Multiplication.BinaryOperator_1_0_0 returns IntLiteral
	 *     Exponentiation returns IntLiteral
	 *     Exponentiation.BinaryOperator_1_0_0 returns IntLiteral
	 *     Binary returns IntLiteral
	 *     Binary.BinaryOperator_1_0_0 returns IntLiteral
	 *     Unit returns IntLiteral
	 *     Unit.Unit_1_0_0 returns IntLiteral
	 *     Unary returns IntLiteral
	 *     Access returns IntLiteral
	 *     Access.Access_1_0 returns IntLiteral
	 *     Primary returns IntLiteral
	 *     TerminalExpression returns IntLiteral
	 *
	 * Constraint:
	 *     op=INTEGER
	 * </pre>
	 */
	protected void sequence_TerminalExpression(ISerializationContext context, IntLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.TERMINAL_EXPRESSION__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.TERMINAL_EXPRESSION__OP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTerminalExpressionAccess().getOpINTEGERTerminalRuleCall_1_1_0(), semanticObject.getOp());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns ReservedLiteral
	 *     BinaryOperator returns ReservedLiteral
	 *     Pair returns ReservedLiteral
	 *     Pair.BinaryOperator_1_0 returns ReservedLiteral
	 *     If returns ReservedLiteral
	 *     If.If_1_0 returns ReservedLiteral
	 *     Or returns ReservedLiteral
	 *     Or.BinaryOperator_1_0 returns ReservedLiteral
	 *     And returns ReservedLiteral
	 *     And.BinaryOperator_1_0 returns ReservedLiteral
	 *     Cast returns ReservedLiteral
	 *     Cast.BinaryOperator_1_0_0 returns ReservedLiteral
	 *     Comparison returns ReservedLiteral
	 *     Comparison.BinaryOperator_1_0_0 returns ReservedLiteral
	 *     Addition returns ReservedLiteral
	 *     Addition.BinaryOperator_1_0_0 returns ReservedLiteral
	 *     Multiplication returns ReservedLiteral
	 *     Multiplication.BinaryOperator_1_0_0 returns ReservedLiteral
	 *     Exponentiation returns ReservedLiteral
	 *     Exponentiation.BinaryOperator_1_0_0 returns ReservedLiteral
	 *     Binary returns ReservedLiteral
	 *     Binary.BinaryOperator_1_0_0 returns ReservedLiteral
	 *     Unit returns ReservedLiteral
	 *     Unit.Unit_1_0_0 returns ReservedLiteral
	 *     Unary returns ReservedLiteral
	 *     Access returns ReservedLiteral
	 *     Access.Access_1_0 returns ReservedLiteral
	 *     Primary returns ReservedLiteral
	 *     TerminalExpression returns ReservedLiteral
	 *
	 * Constraint:
	 *     op=KEYWORD
	 * </pre>
	 */
	protected void sequence_TerminalExpression(ISerializationContext context, ReservedLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.TERMINAL_EXPRESSION__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.TERMINAL_EXPRESSION__OP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTerminalExpressionAccess().getOpKEYWORDTerminalRuleCall_4_1_0(), semanticObject.getOp());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TypeFacet returns Facet
	 *
	 * Constraint:
	 *     (key=TypeFacetKey (expr=TypeRef | expr=Expression))
	 * </pre>
	 */
	protected void sequence_TypeFacet(ISerializationContext context, Facet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     GamlDefinition returns TypeFakeDefinition
	 *     TypeDefinition returns TypeFakeDefinition
	 *     ActionDefinition returns TypeFakeDefinition
	 *     TypeFakeDefinition returns TypeFakeDefinition
	 *
	 * Constraint:
	 *     name=ID
	 * </pre>
	 */
	protected void sequence_TypeFakeDefinition(ISerializationContext context, TypeFakeDefinition semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.GAML_DEFINITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.GAML_DEFINITION__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTypeFakeDefinitionAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TypeInfo returns TypeInfo
	 *
	 * Constraint:
	 *     (first=TypeRef second=TypeRef?)
	 * </pre>
	 */
	protected void sequence_TypeInfo(ISerializationContext context, TypeInfo semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TypeRef returns TypeRef
	 *
	 * Constraint:
	 *     ((ref=[TypeDefinition|ID] parameter=TypeInfo?) | parameter=TypeInfo)?
	 * </pre>
	 */
	protected void sequence_TypeRef(ISerializationContext context, TypeRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns Unary
	 *     BinaryOperator returns Unary
	 *     Pair returns Unary
	 *     Pair.BinaryOperator_1_0 returns Unary
	 *     If returns Unary
	 *     If.If_1_0 returns Unary
	 *     Or returns Unary
	 *     Or.BinaryOperator_1_0 returns Unary
	 *     And returns Unary
	 *     And.BinaryOperator_1_0 returns Unary
	 *     Cast returns Unary
	 *     Cast.BinaryOperator_1_0_0 returns Unary
	 *     Comparison returns Unary
	 *     Comparison.BinaryOperator_1_0_0 returns Unary
	 *     Addition returns Unary
	 *     Addition.BinaryOperator_1_0_0 returns Unary
	 *     Multiplication returns Unary
	 *     Multiplication.BinaryOperator_1_0_0 returns Unary
	 *     Exponentiation returns Unary
	 *     Exponentiation.BinaryOperator_1_0_0 returns Unary
	 *     Binary returns Unary
	 *     Binary.BinaryOperator_1_0_0 returns Unary
	 *     Unit returns Unary
	 *     Unit.Unit_1_0_0 returns Unary
	 *     Unary returns Unary
	 *
	 * Constraint:
	 *     (((op='°' | op='#') right=UnitRef) | ((op='-' | op='!' | op='my' | op='the' | op='not') right=Unary))
	 * </pre>
	 */
	protected void sequence_Unary(ISerializationContext context, Unary semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     GamlDefinition returns UnitFakeDefinition
	 *     UnitFakeDefinition returns UnitFakeDefinition
	 *
	 * Constraint:
	 *     name=ID
	 * </pre>
	 */
	protected void sequence_UnitFakeDefinition(ISerializationContext context, UnitFakeDefinition semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.GAML_DEFINITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.GAML_DEFINITION__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getUnitFakeDefinitionAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     UnitRef returns UnitName
	 *
	 * Constraint:
	 *     ref=[UnitFakeDefinition|ID]
	 * </pre>
	 */
	protected void sequence_UnitRef(ISerializationContext context, UnitName semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.UNIT_NAME__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.UNIT_NAME__REF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getUnitRefAccess().getRefUnitFakeDefinitionIDTerminalRuleCall_1_0_1(), semanticObject.eGet(GamlPackage.Literals.UNIT_NAME__REF, false));
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns Unit
	 *     BinaryOperator returns Unit
	 *     Pair returns Unit
	 *     Pair.BinaryOperator_1_0 returns Unit
	 *     If returns Unit
	 *     If.If_1_0 returns Unit
	 *     Or returns Unit
	 *     Or.BinaryOperator_1_0 returns Unit
	 *     And returns Unit
	 *     And.BinaryOperator_1_0 returns Unit
	 *     Cast returns Unit
	 *     Cast.BinaryOperator_1_0_0 returns Unit
	 *     Comparison returns Unit
	 *     Comparison.BinaryOperator_1_0_0 returns Unit
	 *     Addition returns Unit
	 *     Addition.BinaryOperator_1_0_0 returns Unit
	 *     Multiplication returns Unit
	 *     Multiplication.BinaryOperator_1_0_0 returns Unit
	 *     Exponentiation returns Unit
	 *     Exponentiation.BinaryOperator_1_0_0 returns Unit
	 *     Binary returns Unit
	 *     Binary.BinaryOperator_1_0_0 returns Unit
	 *     Unit returns Unit
	 *
	 * Constraint:
	 *     (left=Unit_Unit_1_0_0 (op='°' | op='#') right=UnitRef)
	 * </pre>
	 */
	protected void sequence_Unit(ISerializationContext context, Unit semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     VarFacet returns Facet
	 *
	 * Constraint:
	 *     (key=VarFacetKey expr=VariableRef)
	 * </pre>
	 */
	protected void sequence_VarFacet(ISerializationContext context, Facet semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.FACET__KEY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.FACET__KEY));
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.FACET__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.FACET__EXPR));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getVarFacetAccess().getKeyVarFacetKeyParserRuleCall_0_0(), semanticObject.getKey());
		feeder.accept(grammarAccess.getVarFacetAccess().getExprVariableRefParserRuleCall_1_0(), semanticObject.getExpr());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     GamlDefinition returns VarFakeDefinition
	 *     VarDefinition returns VarFakeDefinition
	 *     VarFakeDefinition returns VarFakeDefinition
	 *
	 * Constraint:
	 *     name=Valid_ID
	 * </pre>
	 */
	protected void sequence_VarFakeDefinition(ISerializationContext context, VarFakeDefinition semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.GAML_DEFINITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.GAML_DEFINITION__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getVarFakeDefinitionAccess().getNameValid_IDParserRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns VariableRef
	 *     BinaryOperator returns VariableRef
	 *     Pair returns VariableRef
	 *     Pair.BinaryOperator_1_0 returns VariableRef
	 *     If returns VariableRef
	 *     If.If_1_0 returns VariableRef
	 *     Or returns VariableRef
	 *     Or.BinaryOperator_1_0 returns VariableRef
	 *     And returns VariableRef
	 *     And.BinaryOperator_1_0 returns VariableRef
	 *     Cast returns VariableRef
	 *     Cast.BinaryOperator_1_0_0 returns VariableRef
	 *     Comparison returns VariableRef
	 *     Comparison.BinaryOperator_1_0_0 returns VariableRef
	 *     Addition returns VariableRef
	 *     Addition.BinaryOperator_1_0_0 returns VariableRef
	 *     Multiplication returns VariableRef
	 *     Multiplication.BinaryOperator_1_0_0 returns VariableRef
	 *     Exponentiation returns VariableRef
	 *     Exponentiation.BinaryOperator_1_0_0 returns VariableRef
	 *     Binary returns VariableRef
	 *     Binary.BinaryOperator_1_0_0 returns VariableRef
	 *     Unit returns VariableRef
	 *     Unit.Unit_1_0_0 returns VariableRef
	 *     Unary returns VariableRef
	 *     Access returns VariableRef
	 *     Access.Access_1_0 returns VariableRef
	 *     Primary returns VariableRef
	 *     AbstractRef returns VariableRef
	 *     VariableRef returns VariableRef
	 *
	 * Constraint:
	 *     ref=[VarDefinition|Valid_ID]
	 * </pre>
	 */
	protected void sequence_VariableRef(ISerializationContext context, VariableRef semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamlPackage.Literals.VARIABLE_REF__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamlPackage.Literals.VARIABLE_REF__REF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getVariableRefAccess().getRefVarDefinitionValid_IDParserRuleCall_1_0_1(), semanticObject.eGet(GamlPackage.Literals.VARIABLE_REF__REF, false));
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     displayBlock returns Block
	 *
	 * Constraint:
	 *     statements+=displayStatement*
	 * </pre>
	 */
	protected void sequence_displayBlock(ISerializationContext context, Block semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     displayStatement returns imageDisplayStatement
	 *     imageDisplayStatement returns imageDisplayStatement
	 *
	 * Constraint:
	 *     (key=_ImageLayerKey expr=Expression facets+=Facet*)
	 * </pre>
	 */
	protected void sequence_imageDisplayStatement(ISerializationContext context, imageDisplayStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     displayStatement returns speciesOrGridDisplayStatement
	 *     speciesOrGridDisplayStatement returns speciesOrGridDisplayStatement
	 *
	 * Constraint:
	 *     (key=_SpeciesKey expr=Expression facets+=Facet* block=displayBlock?)
	 * </pre>
	 */
	protected void sequence_speciesOrGridDisplayStatement(ISerializationContext context, speciesOrGridDisplayStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
