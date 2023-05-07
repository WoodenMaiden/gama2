/*******************************************************************************************************
 *
 * GamlPackage.java, in gaml.compiler, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.compiler.gaml;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see gaml.compiler.gaml.GamlFactory
 * @model kind="package"
 * @generated
 */
public interface GamlPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "gaml";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://gaml/compiler/Gaml";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "gaml";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  GamlPackage eINSTANCE = gaml.compiler.gaml.impl.GamlPackageImpl.init();

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.EntryImpl <em>Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.EntryImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getEntry()
   * @generated
   */
  int ENTRY = 0;

  /**
   * The number of structural features of the '<em>Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.StandaloneBlockImpl <em>Standalone Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.StandaloneBlockImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getStandaloneBlock()
   * @generated
   */
  int STANDALONE_BLOCK = 1;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STANDALONE_BLOCK__BLOCK = ENTRY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Standalone Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STANDALONE_BLOCK_FEATURE_COUNT = ENTRY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.StringEvaluatorImpl <em>String Evaluator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.StringEvaluatorImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getStringEvaluator()
   * @generated
   */
  int STRING_EVALUATOR = 2;

  /**
   * The feature id for the '<em><b>Toto</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_EVALUATOR__TOTO = ENTRY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_EVALUATOR__EXPR = ENTRY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>String Evaluator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_EVALUATOR_FEATURE_COUNT = ENTRY_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.ModelImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getModel()
   * @generated
   */
  int MODEL = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__NAME = ENTRY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Pragmas</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__PRAGMAS = ENTRY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__IMPORTS = ENTRY_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__BLOCK = ENTRY_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = ENTRY_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.BlockImpl <em>Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.BlockImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getBlock()
   * @generated
   */
  int BLOCK = 4;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__STATEMENTS = 0;

  /**
   * The number of structural features of the '<em>Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.GamlDefinitionImpl <em>Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.GamlDefinitionImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getGamlDefinition()
   * @generated
   */
  int GAML_DEFINITION = 38;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GAML_DEFINITION__NAME = 0;

  /**
   * The number of structural features of the '<em>Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GAML_DEFINITION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.VarDefinitionImpl <em>Var Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.VarDefinitionImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getVarDefinition()
   * @generated
   */
  int VAR_DEFINITION = 41;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DEFINITION__NAME = GAML_DEFINITION__NAME;

  /**
   * The number of structural features of the '<em>Var Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DEFINITION_FEATURE_COUNT = GAML_DEFINITION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.ImportImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getImport()
   * @generated
   */
  int IMPORT = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__NAME = VAR_DEFINITION__NAME;

  /**
   * The feature id for the '<em><b>Import URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__IMPORT_URI = VAR_DEFINITION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_FEATURE_COUNT = VAR_DEFINITION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.PragmaImpl <em>Pragma</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.PragmaImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getPragma()
   * @generated
   */
  int PRAGMA = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRAGMA__NAME = 0;

  /**
   * The feature id for the '<em><b>Plugins</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRAGMA__PLUGINS = 1;

  /**
   * The number of structural features of the '<em>Pragma</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRAGMA_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.ExperimentFileStructureImpl <em>Experiment File Structure</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.ExperimentFileStructureImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getExperimentFileStructure()
   * @generated
   */
  int EXPERIMENT_FILE_STRUCTURE = 7;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPERIMENT_FILE_STRUCTURE__EXP = ENTRY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Experiment File Structure</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPERIMENT_FILE_STRUCTURE_FEATURE_COUNT = ENTRY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.HeadlessExperimentImpl <em>Headless Experiment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.HeadlessExperimentImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getHeadlessExperiment()
   * @generated
   */
  int HEADLESS_EXPERIMENT = 8;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HEADLESS_EXPERIMENT__KEY = 0;

  /**
   * The feature id for the '<em><b>First Facet</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HEADLESS_EXPERIMENT__FIRST_FACET = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HEADLESS_EXPERIMENT__NAME = 2;

  /**
   * The feature id for the '<em><b>Import URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HEADLESS_EXPERIMENT__IMPORT_URI = 3;

  /**
   * The feature id for the '<em><b>Facets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HEADLESS_EXPERIMENT__FACETS = 4;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HEADLESS_EXPERIMENT__BLOCK = 5;

  /**
   * The number of structural features of the '<em>Headless Experiment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HEADLESS_EXPERIMENT_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.StatementImpl <em>Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.StatementImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getStatement()
   * @generated
   */
  int STATEMENT = 9;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__KEY = 0;

  /**
   * The feature id for the '<em><b>First Facet</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__FIRST_FACET = 1;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__EXPR = 2;

  /**
   * The feature id for the '<em><b>Facets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__FACETS = 3;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__BLOCK = 4;

  /**
   * The number of structural features of the '<em>Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.S_GlobalImpl <em>SGlobal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.S_GlobalImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Global()
   * @generated
   */
  int SGLOBAL = 10;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SGLOBAL__KEY = STATEMENT__KEY;

  /**
   * The feature id for the '<em><b>First Facet</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SGLOBAL__FIRST_FACET = STATEMENT__FIRST_FACET;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SGLOBAL__EXPR = STATEMENT__EXPR;

  /**
   * The feature id for the '<em><b>Facets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SGLOBAL__FACETS = STATEMENT__FACETS;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SGLOBAL__BLOCK = STATEMENT__BLOCK;

  /**
   * The number of structural features of the '<em>SGlobal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SGLOBAL_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.S_SpeciesImpl <em>SSpecies</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.S_SpeciesImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Species()
   * @generated
   */
  int SSPECIES = 11;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SSPECIES__KEY = STATEMENT__KEY;

  /**
   * The feature id for the '<em><b>First Facet</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SSPECIES__FIRST_FACET = STATEMENT__FIRST_FACET;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SSPECIES__EXPR = STATEMENT__EXPR;

  /**
   * The feature id for the '<em><b>Facets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SSPECIES__FACETS = STATEMENT__FACETS;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SSPECIES__BLOCK = STATEMENT__BLOCK;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SSPECIES__NAME = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>SSpecies</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SSPECIES_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.S_ExperimentImpl <em>SExperiment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.S_ExperimentImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Experiment()
   * @generated
   */
  int SEXPERIMENT = 12;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEXPERIMENT__KEY = STATEMENT__KEY;

  /**
   * The feature id for the '<em><b>First Facet</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEXPERIMENT__FIRST_FACET = STATEMENT__FIRST_FACET;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEXPERIMENT__EXPR = STATEMENT__EXPR;

  /**
   * The feature id for the '<em><b>Facets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEXPERIMENT__FACETS = STATEMENT__FACETS;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEXPERIMENT__BLOCK = STATEMENT__BLOCK;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEXPERIMENT__NAME = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>SExperiment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEXPERIMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.S_DoImpl <em>SDo</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.S_DoImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Do()
   * @generated
   */
  int SDO = 13;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDO__KEY = STATEMENT__KEY;

  /**
   * The feature id for the '<em><b>First Facet</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDO__FIRST_FACET = STATEMENT__FIRST_FACET;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDO__EXPR = STATEMENT__EXPR;

  /**
   * The feature id for the '<em><b>Facets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDO__FACETS = STATEMENT__FACETS;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDO__BLOCK = STATEMENT__BLOCK;

  /**
   * The number of structural features of the '<em>SDo</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDO_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.S_DeclarationImpl <em>SDeclaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.S_DeclarationImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Declaration()
   * @generated
   */
  int SDECLARATION = 19;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDECLARATION__KEY = STATEMENT__KEY;

  /**
   * The feature id for the '<em><b>First Facet</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDECLARATION__FIRST_FACET = STATEMENT__FIRST_FACET;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDECLARATION__EXPR = STATEMENT__EXPR;

  /**
   * The feature id for the '<em><b>Facets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDECLARATION__FACETS = STATEMENT__FACETS;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDECLARATION__BLOCK = STATEMENT__BLOCK;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDECLARATION__NAME = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>SDeclaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDECLARATION_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.S_LoopImpl <em>SLoop</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.S_LoopImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Loop()
   * @generated
   */
  int SLOOP = 14;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLOOP__KEY = SDECLARATION__KEY;

  /**
   * The feature id for the '<em><b>First Facet</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLOOP__FIRST_FACET = SDECLARATION__FIRST_FACET;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLOOP__EXPR = SDECLARATION__EXPR;

  /**
   * The feature id for the '<em><b>Facets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLOOP__FACETS = SDECLARATION__FACETS;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLOOP__BLOCK = SDECLARATION__BLOCK;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLOOP__NAME = SDECLARATION__NAME;

  /**
   * The number of structural features of the '<em>SLoop</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLOOP_FEATURE_COUNT = SDECLARATION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.S_IfImpl <em>SIf</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.S_IfImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_If()
   * @generated
   */
  int SIF = 15;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIF__KEY = STATEMENT__KEY;

  /**
   * The feature id for the '<em><b>First Facet</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIF__FIRST_FACET = STATEMENT__FIRST_FACET;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIF__EXPR = STATEMENT__EXPR;

  /**
   * The feature id for the '<em><b>Facets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIF__FACETS = STATEMENT__FACETS;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIF__BLOCK = STATEMENT__BLOCK;

  /**
   * The feature id for the '<em><b>Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIF__ELSE = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>SIf</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIF_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.S_TryImpl <em>STry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.S_TryImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Try()
   * @generated
   */
  int STRY = 16;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRY__KEY = STATEMENT__KEY;

  /**
   * The feature id for the '<em><b>First Facet</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRY__FIRST_FACET = STATEMENT__FIRST_FACET;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRY__EXPR = STATEMENT__EXPR;

  /**
   * The feature id for the '<em><b>Facets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRY__FACETS = STATEMENT__FACETS;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRY__BLOCK = STATEMENT__BLOCK;

  /**
   * The feature id for the '<em><b>Catch</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRY__CATCH = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>STry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRY_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.S_OtherImpl <em>SOther</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.S_OtherImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Other()
   * @generated
   */
  int SOTHER = 17;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOTHER__KEY = STATEMENT__KEY;

  /**
   * The feature id for the '<em><b>First Facet</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOTHER__FIRST_FACET = STATEMENT__FIRST_FACET;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOTHER__EXPR = STATEMENT__EXPR;

  /**
   * The feature id for the '<em><b>Facets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOTHER__FACETS = STATEMENT__FACETS;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOTHER__BLOCK = STATEMENT__BLOCK;

  /**
   * The number of structural features of the '<em>SOther</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOTHER_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.S_ReturnImpl <em>SReturn</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.S_ReturnImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Return()
   * @generated
   */
  int SRETURN = 18;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SRETURN__KEY = STATEMENT__KEY;

  /**
   * The feature id for the '<em><b>First Facet</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SRETURN__FIRST_FACET = STATEMENT__FIRST_FACET;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SRETURN__EXPR = STATEMENT__EXPR;

  /**
   * The feature id for the '<em><b>Facets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SRETURN__FACETS = STATEMENT__FACETS;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SRETURN__BLOCK = STATEMENT__BLOCK;

  /**
   * The number of structural features of the '<em>SReturn</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SRETURN_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.S_ReflexImpl <em>SReflex</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.S_ReflexImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Reflex()
   * @generated
   */
  int SREFLEX = 20;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SREFLEX__KEY = SDECLARATION__KEY;

  /**
   * The feature id for the '<em><b>First Facet</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SREFLEX__FIRST_FACET = SDECLARATION__FIRST_FACET;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SREFLEX__EXPR = SDECLARATION__EXPR;

  /**
   * The feature id for the '<em><b>Facets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SREFLEX__FACETS = SDECLARATION__FACETS;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SREFLEX__BLOCK = SDECLARATION__BLOCK;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SREFLEX__NAME = SDECLARATION__NAME;

  /**
   * The number of structural features of the '<em>SReflex</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SREFLEX_FEATURE_COUNT = SDECLARATION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.S_DefinitionImpl <em>SDefinition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.S_DefinitionImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Definition()
   * @generated
   */
  int SDEFINITION = 21;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDEFINITION__KEY = SDECLARATION__KEY;

  /**
   * The feature id for the '<em><b>First Facet</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDEFINITION__FIRST_FACET = SDECLARATION__FIRST_FACET;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDEFINITION__EXPR = SDECLARATION__EXPR;

  /**
   * The feature id for the '<em><b>Facets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDEFINITION__FACETS = SDECLARATION__FACETS;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDEFINITION__BLOCK = SDECLARATION__BLOCK;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDEFINITION__NAME = SDECLARATION__NAME;

  /**
   * The feature id for the '<em><b>Tkey</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDEFINITION__TKEY = SDECLARATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDEFINITION__ARGS = SDECLARATION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>SDefinition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDEFINITION_FEATURE_COUNT = SDECLARATION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.S_AssignmentImpl <em>SAssignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.S_AssignmentImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Assignment()
   * @generated
   */
  int SASSIGNMENT = 22;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SASSIGNMENT__KEY = STATEMENT__KEY;

  /**
   * The feature id for the '<em><b>First Facet</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SASSIGNMENT__FIRST_FACET = STATEMENT__FIRST_FACET;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SASSIGNMENT__EXPR = STATEMENT__EXPR;

  /**
   * The feature id for the '<em><b>Facets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SASSIGNMENT__FACETS = STATEMENT__FACETS;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SASSIGNMENT__BLOCK = STATEMENT__BLOCK;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SASSIGNMENT__VALUE = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>SAssignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SASSIGNMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.S_DirectAssignmentImpl <em>SDirect Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.S_DirectAssignmentImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_DirectAssignment()
   * @generated
   */
  int SDIRECT_ASSIGNMENT = 23;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDIRECT_ASSIGNMENT__KEY = SASSIGNMENT__KEY;

  /**
   * The feature id for the '<em><b>First Facet</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDIRECT_ASSIGNMENT__FIRST_FACET = SASSIGNMENT__FIRST_FACET;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDIRECT_ASSIGNMENT__EXPR = SASSIGNMENT__EXPR;

  /**
   * The feature id for the '<em><b>Facets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDIRECT_ASSIGNMENT__FACETS = SASSIGNMENT__FACETS;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDIRECT_ASSIGNMENT__BLOCK = SASSIGNMENT__BLOCK;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDIRECT_ASSIGNMENT__VALUE = SASSIGNMENT__VALUE;

  /**
   * The number of structural features of the '<em>SDirect Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDIRECT_ASSIGNMENT_FEATURE_COUNT = SASSIGNMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.S_SetImpl <em>SSet</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.S_SetImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Set()
   * @generated
   */
  int SSET = 24;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SSET__KEY = SASSIGNMENT__KEY;

  /**
   * The feature id for the '<em><b>First Facet</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SSET__FIRST_FACET = SASSIGNMENT__FIRST_FACET;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SSET__EXPR = SASSIGNMENT__EXPR;

  /**
   * The feature id for the '<em><b>Facets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SSET__FACETS = SASSIGNMENT__FACETS;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SSET__BLOCK = SASSIGNMENT__BLOCK;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SSET__VALUE = SASSIGNMENT__VALUE;

  /**
   * The number of structural features of the '<em>SSet</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SSET_FEATURE_COUNT = SASSIGNMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.S_EquationsImpl <em>SEquations</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.S_EquationsImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Equations()
   * @generated
   */
  int SEQUATIONS = 25;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUATIONS__KEY = STATEMENT__KEY;

  /**
   * The feature id for the '<em><b>First Facet</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUATIONS__FIRST_FACET = STATEMENT__FIRST_FACET;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUATIONS__EXPR = STATEMENT__EXPR;

  /**
   * The feature id for the '<em><b>Facets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUATIONS__FACETS = STATEMENT__FACETS;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUATIONS__BLOCK = STATEMENT__BLOCK;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUATIONS__NAME = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Equations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUATIONS__EQUATIONS = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>SEquations</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUATIONS_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.S_SolveImpl <em>SSolve</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.S_SolveImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Solve()
   * @generated
   */
  int SSOLVE = 26;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SSOLVE__KEY = STATEMENT__KEY;

  /**
   * The feature id for the '<em><b>First Facet</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SSOLVE__FIRST_FACET = STATEMENT__FIRST_FACET;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SSOLVE__EXPR = STATEMENT__EXPR;

  /**
   * The feature id for the '<em><b>Facets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SSOLVE__FACETS = STATEMENT__FACETS;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SSOLVE__BLOCK = STATEMENT__BLOCK;

  /**
   * The number of structural features of the '<em>SSolve</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SSOLVE_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.S_DisplayImpl <em>SDisplay</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.S_DisplayImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Display()
   * @generated
   */
  int SDISPLAY = 27;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDISPLAY__KEY = STATEMENT__KEY;

  /**
   * The feature id for the '<em><b>First Facet</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDISPLAY__FIRST_FACET = STATEMENT__FIRST_FACET;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDISPLAY__EXPR = STATEMENT__EXPR;

  /**
   * The feature id for the '<em><b>Facets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDISPLAY__FACETS = STATEMENT__FACETS;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDISPLAY__BLOCK = STATEMENT__BLOCK;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDISPLAY__NAME = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>SDisplay</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SDISPLAY_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.speciesOrGridDisplayStatementImpl <em>species Or Grid Display Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.speciesOrGridDisplayStatementImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getspeciesOrGridDisplayStatement()
   * @generated
   */
  int SPECIES_OR_GRID_DISPLAY_STATEMENT = 28;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIES_OR_GRID_DISPLAY_STATEMENT__KEY = STATEMENT__KEY;

  /**
   * The feature id for the '<em><b>First Facet</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIES_OR_GRID_DISPLAY_STATEMENT__FIRST_FACET = STATEMENT__FIRST_FACET;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIES_OR_GRID_DISPLAY_STATEMENT__EXPR = STATEMENT__EXPR;

  /**
   * The feature id for the '<em><b>Facets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIES_OR_GRID_DISPLAY_STATEMENT__FACETS = STATEMENT__FACETS;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIES_OR_GRID_DISPLAY_STATEMENT__BLOCK = STATEMENT__BLOCK;

  /**
   * The number of structural features of the '<em>species Or Grid Display Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIES_OR_GRID_DISPLAY_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.imageDisplayStatementImpl <em>image Display Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.imageDisplayStatementImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getimageDisplayStatement()
   * @generated
   */
  int IMAGE_DISPLAY_STATEMENT = 29;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMAGE_DISPLAY_STATEMENT__KEY = STATEMENT__KEY;

  /**
   * The feature id for the '<em><b>First Facet</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMAGE_DISPLAY_STATEMENT__FIRST_FACET = STATEMENT__FIRST_FACET;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMAGE_DISPLAY_STATEMENT__EXPR = STATEMENT__EXPR;

  /**
   * The feature id for the '<em><b>Facets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMAGE_DISPLAY_STATEMENT__FACETS = STATEMENT__FACETS;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMAGE_DISPLAY_STATEMENT__BLOCK = STATEMENT__BLOCK;

  /**
   * The number of structural features of the '<em>image Display Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMAGE_DISPLAY_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.ActionArgumentsImpl <em>Action Arguments</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.ActionArgumentsImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getActionArguments()
   * @generated
   */
  int ACTION_ARGUMENTS = 30;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_ARGUMENTS__ARGS = 0;

  /**
   * The number of structural features of the '<em>Action Arguments</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_ARGUMENTS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.ArgumentDefinitionImpl <em>Argument Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.ArgumentDefinitionImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getArgumentDefinition()
   * @generated
   */
  int ARGUMENT_DEFINITION = 31;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_DEFINITION__NAME = VAR_DEFINITION__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_DEFINITION__TYPE = VAR_DEFINITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Default</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_DEFINITION__DEFAULT = VAR_DEFINITION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Argument Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_DEFINITION_FEATURE_COUNT = VAR_DEFINITION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.FacetImpl <em>Facet</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.FacetImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getFacet()
   * @generated
   */
  int FACET = 32;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACET__NAME = VAR_DEFINITION__NAME;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACET__KEY = VAR_DEFINITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACET__EXPR = VAR_DEFINITION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACET__BLOCK = VAR_DEFINITION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Facet</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACET_FEATURE_COUNT = VAR_DEFINITION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.ExpressionImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 33;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.ArgumentPairImpl <em>Argument Pair</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.ArgumentPairImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getArgumentPair()
   * @generated
   */
  int ARGUMENT_PAIR = 34;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_PAIR__OP = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_PAIR__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Argument Pair</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_PAIR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.ExpressionListImpl <em>Expression List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.ExpressionListImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getExpressionList()
   * @generated
   */
  int EXPRESSION_LIST = 35;

  /**
   * The feature id for the '<em><b>Exprs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_LIST__EXPRS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Expression List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_LIST_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.VariableRefImpl <em>Variable Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.VariableRefImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getVariableRef()
   * @generated
   */
  int VARIABLE_REF = 36;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_REF__REF = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Variable Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_REF_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.TypeInfoImpl <em>Type Info</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.TypeInfoImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getTypeInfo()
   * @generated
   */
  int TYPE_INFO = 37;

  /**
   * The feature id for the '<em><b>First</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_INFO__FIRST = 0;

  /**
   * The feature id for the '<em><b>Second</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_INFO__SECOND = 1;

  /**
   * The number of structural features of the '<em>Type Info</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_INFO_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.EquationDefinitionImpl <em>Equation Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.EquationDefinitionImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getEquationDefinition()
   * @generated
   */
  int EQUATION_DEFINITION = 39;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUATION_DEFINITION__NAME = GAML_DEFINITION__NAME;

  /**
   * The number of structural features of the '<em>Equation Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUATION_DEFINITION_FEATURE_COUNT = GAML_DEFINITION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.TypeDefinitionImpl <em>Type Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.TypeDefinitionImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getTypeDefinition()
   * @generated
   */
  int TYPE_DEFINITION = 40;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DEFINITION__NAME = GAML_DEFINITION__NAME;

  /**
   * The number of structural features of the '<em>Type Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DEFINITION_FEATURE_COUNT = GAML_DEFINITION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.ActionDefinitionImpl <em>Action Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.ActionDefinitionImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getActionDefinition()
   * @generated
   */
  int ACTION_DEFINITION = 42;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_DEFINITION__NAME = GAML_DEFINITION__NAME;

  /**
   * The number of structural features of the '<em>Action Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_DEFINITION_FEATURE_COUNT = GAML_DEFINITION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.UnitFakeDefinitionImpl <em>Unit Fake Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.UnitFakeDefinitionImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getUnitFakeDefinition()
   * @generated
   */
  int UNIT_FAKE_DEFINITION = 43;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_FAKE_DEFINITION__NAME = GAML_DEFINITION__NAME;

  /**
   * The number of structural features of the '<em>Unit Fake Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_FAKE_DEFINITION_FEATURE_COUNT = GAML_DEFINITION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.TypeFakeDefinitionImpl <em>Type Fake Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.TypeFakeDefinitionImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getTypeFakeDefinition()
   * @generated
   */
  int TYPE_FAKE_DEFINITION = 44;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FAKE_DEFINITION__NAME = TYPE_DEFINITION__NAME;

  /**
   * The number of structural features of the '<em>Type Fake Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FAKE_DEFINITION_FEATURE_COUNT = TYPE_DEFINITION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.ActionFakeDefinitionImpl <em>Action Fake Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.ActionFakeDefinitionImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getActionFakeDefinition()
   * @generated
   */
  int ACTION_FAKE_DEFINITION = 45;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_FAKE_DEFINITION__NAME = ACTION_DEFINITION__NAME;

  /**
   * The number of structural features of the '<em>Action Fake Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_FAKE_DEFINITION_FEATURE_COUNT = ACTION_DEFINITION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.SkillFakeDefinitionImpl <em>Skill Fake Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.SkillFakeDefinitionImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getSkillFakeDefinition()
   * @generated
   */
  int SKILL_FAKE_DEFINITION = 46;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SKILL_FAKE_DEFINITION__NAME = GAML_DEFINITION__NAME;

  /**
   * The number of structural features of the '<em>Skill Fake Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SKILL_FAKE_DEFINITION_FEATURE_COUNT = GAML_DEFINITION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.VarFakeDefinitionImpl <em>Var Fake Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.VarFakeDefinitionImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getVarFakeDefinition()
   * @generated
   */
  int VAR_FAKE_DEFINITION = 47;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_FAKE_DEFINITION__NAME = VAR_DEFINITION__NAME;

  /**
   * The number of structural features of the '<em>Var Fake Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_FAKE_DEFINITION_FEATURE_COUNT = VAR_DEFINITION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.EquationFakeDefinitionImpl <em>Equation Fake Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.EquationFakeDefinitionImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getEquationFakeDefinition()
   * @generated
   */
  int EQUATION_FAKE_DEFINITION = 48;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUATION_FAKE_DEFINITION__NAME = EQUATION_DEFINITION__NAME;

  /**
   * The number of structural features of the '<em>Equation Fake Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUATION_FAKE_DEFINITION_FEATURE_COUNT = EQUATION_DEFINITION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.TerminalExpressionImpl <em>Terminal Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.TerminalExpressionImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getTerminalExpression()
   * @generated
   */
  int TERMINAL_EXPRESSION = 49;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERMINAL_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Terminal Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERMINAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.StringLiteralImpl <em>String Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.StringLiteralImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getStringLiteral()
   * @generated
   */
  int STRING_LITERAL = 50;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL__OP = TERMINAL_EXPRESSION__OP;

  /**
   * The number of structural features of the '<em>String Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL_FEATURE_COUNT = TERMINAL_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.S_ActionImpl <em>SAction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.S_ActionImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Action()
   * @generated
   */
  int SACTION = 51;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SACTION__KEY = SDEFINITION__KEY;

  /**
   * The feature id for the '<em><b>First Facet</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SACTION__FIRST_FACET = SDEFINITION__FIRST_FACET;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SACTION__EXPR = SDEFINITION__EXPR;

  /**
   * The feature id for the '<em><b>Facets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SACTION__FACETS = SDEFINITION__FACETS;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SACTION__BLOCK = SDEFINITION__BLOCK;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SACTION__NAME = SDEFINITION__NAME;

  /**
   * The feature id for the '<em><b>Tkey</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SACTION__TKEY = SDEFINITION__TKEY;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SACTION__ARGS = SDEFINITION__ARGS;

  /**
   * The number of structural features of the '<em>SAction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SACTION_FEATURE_COUNT = SDEFINITION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.S_VarImpl <em>SVar</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.S_VarImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Var()
   * @generated
   */
  int SVAR = 52;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR__KEY = SDEFINITION__KEY;

  /**
   * The feature id for the '<em><b>First Facet</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR__FIRST_FACET = SDEFINITION__FIRST_FACET;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR__EXPR = SDEFINITION__EXPR;

  /**
   * The feature id for the '<em><b>Facets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR__FACETS = SDEFINITION__FACETS;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR__BLOCK = SDEFINITION__BLOCK;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR__NAME = SDEFINITION__NAME;

  /**
   * The feature id for the '<em><b>Tkey</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR__TKEY = SDEFINITION__TKEY;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR__ARGS = SDEFINITION__ARGS;

  /**
   * The number of structural features of the '<em>SVar</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_FEATURE_COUNT = SDEFINITION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.BinaryOperatorImpl <em>Binary Operator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.BinaryOperatorImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getBinaryOperator()
   * @generated
   */
  int BINARY_OPERATOR = 53;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_OPERATOR__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_OPERATOR__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_OPERATOR__RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Binary Operator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_OPERATOR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.IfImpl <em>If</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.IfImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getIf()
   * @generated
   */
  int IF = 54;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF__RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>If False</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF__IF_FALSE = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>If</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.UnitImpl <em>Unit</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.UnitImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getUnit()
   * @generated
   */
  int UNIT = 55;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT__RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Unit</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.UnaryImpl <em>Unary</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.UnaryImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getUnary()
   * @generated
   */
  int UNARY = 56;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY__OP = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Unary</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.AccessImpl <em>Access</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.AccessImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getAccess()
   * @generated
   */
  int ACCESS = 57;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACCESS__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACCESS__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACCESS__RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Access</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACCESS_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.ArrayImpl <em>Array</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.ArrayImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getArray()
   * @generated
   */
  int ARRAY = 58;

  /**
   * The feature id for the '<em><b>Exprs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY__EXPRS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Array</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.PointImpl <em>Point</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.PointImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getPoint()
   * @generated
   */
  int POINT = 59;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POINT__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POINT__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POINT__RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Z</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POINT__Z = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Point</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POINT_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.FunctionImpl <em>Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.FunctionImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getFunction()
   * @generated
   */
  int FUNCTION = 60;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__TYPE = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.ParameterImpl <em>Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.ParameterImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getParameter()
   * @generated
   */
  int PARAMETER = 61;

  /**
   * The feature id for the '<em><b>Built In Facet Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__BUILT_IN_FACET_KEY = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__LEFT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.UnitNameImpl <em>Unit Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.UnitNameImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getUnitName()
   * @generated
   */
  int UNIT_NAME = 62;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_NAME__REF = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Unit Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_NAME_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.TypeRefImpl <em>Type Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.TypeRefImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getTypeRef()
   * @generated
   */
  int TYPE_REF = 63;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_REF__REF = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_REF__PARAMETER = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Type Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_REF_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.SkillRefImpl <em>Skill Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.SkillRefImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getSkillRef()
   * @generated
   */
  int SKILL_REF = 64;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SKILL_REF__REF = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Skill Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SKILL_REF_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.ActionRefImpl <em>Action Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.ActionRefImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getActionRef()
   * @generated
   */
  int ACTION_REF = 65;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_REF__REF = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Action Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_REF_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.EquationRefImpl <em>Equation Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.EquationRefImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getEquationRef()
   * @generated
   */
  int EQUATION_REF = 66;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUATION_REF__REF = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Equation Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUATION_REF_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.IntLiteralImpl <em>Int Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.IntLiteralImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getIntLiteral()
   * @generated
   */
  int INT_LITERAL = 67;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_LITERAL__OP = TERMINAL_EXPRESSION__OP;

  /**
   * The number of structural features of the '<em>Int Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_LITERAL_FEATURE_COUNT = TERMINAL_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.DoubleLiteralImpl <em>Double Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.DoubleLiteralImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getDoubleLiteral()
   * @generated
   */
  int DOUBLE_LITERAL = 68;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_LITERAL__OP = TERMINAL_EXPRESSION__OP;

  /**
   * The number of structural features of the '<em>Double Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_LITERAL_FEATURE_COUNT = TERMINAL_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.BooleanLiteralImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getBooleanLiteral()
   * @generated
   */
  int BOOLEAN_LITERAL = 69;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL__OP = TERMINAL_EXPRESSION__OP;

  /**
   * The number of structural features of the '<em>Boolean Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL_FEATURE_COUNT = TERMINAL_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gaml.compiler.gaml.impl.ReservedLiteralImpl <em>Reserved Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gaml.compiler.gaml.impl.ReservedLiteralImpl
   * @see gaml.compiler.gaml.impl.GamlPackageImpl#getReservedLiteral()
   * @generated
   */
  int RESERVED_LITERAL = 70;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESERVED_LITERAL__OP = TERMINAL_EXPRESSION__OP;

  /**
   * The number of structural features of the '<em>Reserved Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESERVED_LITERAL_FEATURE_COUNT = TERMINAL_EXPRESSION_FEATURE_COUNT + 0;


  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.Entry <em>Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entry</em>'.
   * @see gaml.compiler.gaml.Entry
   * @generated
   */
  EClass getEntry();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.StandaloneBlock <em>Standalone Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Standalone Block</em>'.
   * @see gaml.compiler.gaml.StandaloneBlock
   * @generated
   */
  EClass getStandaloneBlock();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.StandaloneBlock#getBlock <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Block</em>'.
   * @see gaml.compiler.gaml.StandaloneBlock#getBlock()
   * @see #getStandaloneBlock()
   * @generated
   */
  EReference getStandaloneBlock_Block();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.StringEvaluator <em>String Evaluator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Evaluator</em>'.
   * @see gaml.compiler.gaml.StringEvaluator
   * @generated
   */
  EClass getStringEvaluator();

  /**
   * Returns the meta object for the attribute '{@link gaml.compiler.gaml.StringEvaluator#getToto <em>Toto</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Toto</em>'.
   * @see gaml.compiler.gaml.StringEvaluator#getToto()
   * @see #getStringEvaluator()
   * @generated
   */
  EAttribute getStringEvaluator_Toto();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.StringEvaluator#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see gaml.compiler.gaml.StringEvaluator#getExpr()
   * @see #getStringEvaluator()
   * @generated
   */
  EReference getStringEvaluator_Expr();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see gaml.compiler.gaml.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link gaml.compiler.gaml.Model#getPragmas <em>Pragmas</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Pragmas</em>'.
   * @see gaml.compiler.gaml.Model#getPragmas()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Pragmas();

  /**
   * Returns the meta object for the containment reference list '{@link gaml.compiler.gaml.Model#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see gaml.compiler.gaml.Model#getImports()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Imports();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.Model#getBlock <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Block</em>'.
   * @see gaml.compiler.gaml.Model#getBlock()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Block();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.Block <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Block</em>'.
   * @see gaml.compiler.gaml.Block
   * @generated
   */
  EClass getBlock();

  /**
   * Returns the meta object for the containment reference list '{@link gaml.compiler.gaml.Block#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see gaml.compiler.gaml.Block#getStatements()
   * @see #getBlock()
   * @generated
   */
  EReference getBlock_Statements();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see gaml.compiler.gaml.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link gaml.compiler.gaml.Import#getImportURI <em>Import URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Import URI</em>'.
   * @see gaml.compiler.gaml.Import#getImportURI()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImportURI();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.Pragma <em>Pragma</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pragma</em>'.
   * @see gaml.compiler.gaml.Pragma
   * @generated
   */
  EClass getPragma();

  /**
   * Returns the meta object for the attribute '{@link gaml.compiler.gaml.Pragma#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see gaml.compiler.gaml.Pragma#getName()
   * @see #getPragma()
   * @generated
   */
  EAttribute getPragma_Name();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.Pragma#getPlugins <em>Plugins</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Plugins</em>'.
   * @see gaml.compiler.gaml.Pragma#getPlugins()
   * @see #getPragma()
   * @generated
   */
  EReference getPragma_Plugins();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.ExperimentFileStructure <em>Experiment File Structure</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Experiment File Structure</em>'.
   * @see gaml.compiler.gaml.ExperimentFileStructure
   * @generated
   */
  EClass getExperimentFileStructure();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.ExperimentFileStructure#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp</em>'.
   * @see gaml.compiler.gaml.ExperimentFileStructure#getExp()
   * @see #getExperimentFileStructure()
   * @generated
   */
  EReference getExperimentFileStructure_Exp();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.HeadlessExperiment <em>Headless Experiment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Headless Experiment</em>'.
   * @see gaml.compiler.gaml.HeadlessExperiment
   * @generated
   */
  EClass getHeadlessExperiment();

  /**
   * Returns the meta object for the attribute '{@link gaml.compiler.gaml.HeadlessExperiment#getKey <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Key</em>'.
   * @see gaml.compiler.gaml.HeadlessExperiment#getKey()
   * @see #getHeadlessExperiment()
   * @generated
   */
  EAttribute getHeadlessExperiment_Key();

  /**
   * Returns the meta object for the attribute '{@link gaml.compiler.gaml.HeadlessExperiment#getFirstFacet <em>First Facet</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>First Facet</em>'.
   * @see gaml.compiler.gaml.HeadlessExperiment#getFirstFacet()
   * @see #getHeadlessExperiment()
   * @generated
   */
  EAttribute getHeadlessExperiment_FirstFacet();

  /**
   * Returns the meta object for the attribute '{@link gaml.compiler.gaml.HeadlessExperiment#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see gaml.compiler.gaml.HeadlessExperiment#getName()
   * @see #getHeadlessExperiment()
   * @generated
   */
  EAttribute getHeadlessExperiment_Name();

  /**
   * Returns the meta object for the attribute '{@link gaml.compiler.gaml.HeadlessExperiment#getImportURI <em>Import URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Import URI</em>'.
   * @see gaml.compiler.gaml.HeadlessExperiment#getImportURI()
   * @see #getHeadlessExperiment()
   * @generated
   */
  EAttribute getHeadlessExperiment_ImportURI();

  /**
   * Returns the meta object for the containment reference list '{@link gaml.compiler.gaml.HeadlessExperiment#getFacets <em>Facets</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Facets</em>'.
   * @see gaml.compiler.gaml.HeadlessExperiment#getFacets()
   * @see #getHeadlessExperiment()
   * @generated
   */
  EReference getHeadlessExperiment_Facets();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.HeadlessExperiment#getBlock <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Block</em>'.
   * @see gaml.compiler.gaml.HeadlessExperiment#getBlock()
   * @see #getHeadlessExperiment()
   * @generated
   */
  EReference getHeadlessExperiment_Block();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement</em>'.
   * @see gaml.compiler.gaml.Statement
   * @generated
   */
  EClass getStatement();

  /**
   * Returns the meta object for the attribute '{@link gaml.compiler.gaml.Statement#getKey <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Key</em>'.
   * @see gaml.compiler.gaml.Statement#getKey()
   * @see #getStatement()
   * @generated
   */
  EAttribute getStatement_Key();

  /**
   * Returns the meta object for the attribute '{@link gaml.compiler.gaml.Statement#getFirstFacet <em>First Facet</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>First Facet</em>'.
   * @see gaml.compiler.gaml.Statement#getFirstFacet()
   * @see #getStatement()
   * @generated
   */
  EAttribute getStatement_FirstFacet();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.Statement#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see gaml.compiler.gaml.Statement#getExpr()
   * @see #getStatement()
   * @generated
   */
  EReference getStatement_Expr();

  /**
   * Returns the meta object for the containment reference list '{@link gaml.compiler.gaml.Statement#getFacets <em>Facets</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Facets</em>'.
   * @see gaml.compiler.gaml.Statement#getFacets()
   * @see #getStatement()
   * @generated
   */
  EReference getStatement_Facets();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.Statement#getBlock <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Block</em>'.
   * @see gaml.compiler.gaml.Statement#getBlock()
   * @see #getStatement()
   * @generated
   */
  EReference getStatement_Block();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.S_Global <em>SGlobal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SGlobal</em>'.
   * @see gaml.compiler.gaml.S_Global
   * @generated
   */
  EClass getS_Global();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.S_Species <em>SSpecies</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SSpecies</em>'.
   * @see gaml.compiler.gaml.S_Species
   * @generated
   */
  EClass getS_Species();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.S_Experiment <em>SExperiment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SExperiment</em>'.
   * @see gaml.compiler.gaml.S_Experiment
   * @generated
   */
  EClass getS_Experiment();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.S_Do <em>SDo</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SDo</em>'.
   * @see gaml.compiler.gaml.S_Do
   * @generated
   */
  EClass getS_Do();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.S_Loop <em>SLoop</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SLoop</em>'.
   * @see gaml.compiler.gaml.S_Loop
   * @generated
   */
  EClass getS_Loop();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.S_If <em>SIf</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SIf</em>'.
   * @see gaml.compiler.gaml.S_If
   * @generated
   */
  EClass getS_If();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.S_If#getElse <em>Else</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else</em>'.
   * @see gaml.compiler.gaml.S_If#getElse()
   * @see #getS_If()
   * @generated
   */
  EReference getS_If_Else();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.S_Try <em>STry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>STry</em>'.
   * @see gaml.compiler.gaml.S_Try
   * @generated
   */
  EClass getS_Try();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.S_Try#getCatch <em>Catch</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Catch</em>'.
   * @see gaml.compiler.gaml.S_Try#getCatch()
   * @see #getS_Try()
   * @generated
   */
  EReference getS_Try_Catch();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.S_Other <em>SOther</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SOther</em>'.
   * @see gaml.compiler.gaml.S_Other
   * @generated
   */
  EClass getS_Other();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.S_Return <em>SReturn</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SReturn</em>'.
   * @see gaml.compiler.gaml.S_Return
   * @generated
   */
  EClass getS_Return();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.S_Declaration <em>SDeclaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SDeclaration</em>'.
   * @see gaml.compiler.gaml.S_Declaration
   * @generated
   */
  EClass getS_Declaration();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.S_Reflex <em>SReflex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SReflex</em>'.
   * @see gaml.compiler.gaml.S_Reflex
   * @generated
   */
  EClass getS_Reflex();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.S_Definition <em>SDefinition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SDefinition</em>'.
   * @see gaml.compiler.gaml.S_Definition
   * @generated
   */
  EClass getS_Definition();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.S_Definition#getTkey <em>Tkey</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Tkey</em>'.
   * @see gaml.compiler.gaml.S_Definition#getTkey()
   * @see #getS_Definition()
   * @generated
   */
  EReference getS_Definition_Tkey();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.S_Definition#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Args</em>'.
   * @see gaml.compiler.gaml.S_Definition#getArgs()
   * @see #getS_Definition()
   * @generated
   */
  EReference getS_Definition_Args();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.S_Assignment <em>SAssignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SAssignment</em>'.
   * @see gaml.compiler.gaml.S_Assignment
   * @generated
   */
  EClass getS_Assignment();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.S_Assignment#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see gaml.compiler.gaml.S_Assignment#getValue()
   * @see #getS_Assignment()
   * @generated
   */
  EReference getS_Assignment_Value();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.S_DirectAssignment <em>SDirect Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SDirect Assignment</em>'.
   * @see gaml.compiler.gaml.S_DirectAssignment
   * @generated
   */
  EClass getS_DirectAssignment();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.S_Set <em>SSet</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SSet</em>'.
   * @see gaml.compiler.gaml.S_Set
   * @generated
   */
  EClass getS_Set();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.S_Equations <em>SEquations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SEquations</em>'.
   * @see gaml.compiler.gaml.S_Equations
   * @generated
   */
  EClass getS_Equations();

  /**
   * Returns the meta object for the containment reference list '{@link gaml.compiler.gaml.S_Equations#getEquations <em>Equations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Equations</em>'.
   * @see gaml.compiler.gaml.S_Equations#getEquations()
   * @see #getS_Equations()
   * @generated
   */
  EReference getS_Equations_Equations();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.S_Solve <em>SSolve</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SSolve</em>'.
   * @see gaml.compiler.gaml.S_Solve
   * @generated
   */
  EClass getS_Solve();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.S_Display <em>SDisplay</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SDisplay</em>'.
   * @see gaml.compiler.gaml.S_Display
   * @generated
   */
  EClass getS_Display();

  /**
   * Returns the meta object for the attribute '{@link gaml.compiler.gaml.S_Display#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see gaml.compiler.gaml.S_Display#getName()
   * @see #getS_Display()
   * @generated
   */
  EAttribute getS_Display_Name();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.speciesOrGridDisplayStatement <em>species Or Grid Display Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>species Or Grid Display Statement</em>'.
   * @see gaml.compiler.gaml.speciesOrGridDisplayStatement
   * @generated
   */
  EClass getspeciesOrGridDisplayStatement();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.imageDisplayStatement <em>image Display Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>image Display Statement</em>'.
   * @see gaml.compiler.gaml.imageDisplayStatement
   * @generated
   */
  EClass getimageDisplayStatement();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.ActionArguments <em>Action Arguments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Action Arguments</em>'.
   * @see gaml.compiler.gaml.ActionArguments
   * @generated
   */
  EClass getActionArguments();

  /**
   * Returns the meta object for the containment reference list '{@link gaml.compiler.gaml.ActionArguments#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see gaml.compiler.gaml.ActionArguments#getArgs()
   * @see #getActionArguments()
   * @generated
   */
  EReference getActionArguments_Args();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.ArgumentDefinition <em>Argument Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Argument Definition</em>'.
   * @see gaml.compiler.gaml.ArgumentDefinition
   * @generated
   */
  EClass getArgumentDefinition();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.ArgumentDefinition#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see gaml.compiler.gaml.ArgumentDefinition#getType()
   * @see #getArgumentDefinition()
   * @generated
   */
  EReference getArgumentDefinition_Type();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.ArgumentDefinition#getDefault <em>Default</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Default</em>'.
   * @see gaml.compiler.gaml.ArgumentDefinition#getDefault()
   * @see #getArgumentDefinition()
   * @generated
   */
  EReference getArgumentDefinition_Default();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.Facet <em>Facet</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Facet</em>'.
   * @see gaml.compiler.gaml.Facet
   * @generated
   */
  EClass getFacet();

  /**
   * Returns the meta object for the attribute '{@link gaml.compiler.gaml.Facet#getKey <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Key</em>'.
   * @see gaml.compiler.gaml.Facet#getKey()
   * @see #getFacet()
   * @generated
   */
  EAttribute getFacet_Key();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.Facet#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see gaml.compiler.gaml.Facet#getExpr()
   * @see #getFacet()
   * @generated
   */
  EReference getFacet_Expr();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.Facet#getBlock <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Block</em>'.
   * @see gaml.compiler.gaml.Facet#getBlock()
   * @see #getFacet()
   * @generated
   */
  EReference getFacet_Block();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see gaml.compiler.gaml.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.ArgumentPair <em>Argument Pair</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Argument Pair</em>'.
   * @see gaml.compiler.gaml.ArgumentPair
   * @generated
   */
  EClass getArgumentPair();

  /**
   * Returns the meta object for the attribute '{@link gaml.compiler.gaml.ArgumentPair#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see gaml.compiler.gaml.ArgumentPair#getOp()
   * @see #getArgumentPair()
   * @generated
   */
  EAttribute getArgumentPair_Op();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.ArgumentPair#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see gaml.compiler.gaml.ArgumentPair#getRight()
   * @see #getArgumentPair()
   * @generated
   */
  EReference getArgumentPair_Right();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.ExpressionList <em>Expression List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression List</em>'.
   * @see gaml.compiler.gaml.ExpressionList
   * @generated
   */
  EClass getExpressionList();

  /**
   * Returns the meta object for the containment reference list '{@link gaml.compiler.gaml.ExpressionList#getExprs <em>Exprs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exprs</em>'.
   * @see gaml.compiler.gaml.ExpressionList#getExprs()
   * @see #getExpressionList()
   * @generated
   */
  EReference getExpressionList_Exprs();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.VariableRef <em>Variable Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Ref</em>'.
   * @see gaml.compiler.gaml.VariableRef
   * @generated
   */
  EClass getVariableRef();

  /**
   * Returns the meta object for the reference '{@link gaml.compiler.gaml.VariableRef#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see gaml.compiler.gaml.VariableRef#getRef()
   * @see #getVariableRef()
   * @generated
   */
  EReference getVariableRef_Ref();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.TypeInfo <em>Type Info</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Info</em>'.
   * @see gaml.compiler.gaml.TypeInfo
   * @generated
   */
  EClass getTypeInfo();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.TypeInfo#getFirst <em>First</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>First</em>'.
   * @see gaml.compiler.gaml.TypeInfo#getFirst()
   * @see #getTypeInfo()
   * @generated
   */
  EReference getTypeInfo_First();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.TypeInfo#getSecond <em>Second</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Second</em>'.
   * @see gaml.compiler.gaml.TypeInfo#getSecond()
   * @see #getTypeInfo()
   * @generated
   */
  EReference getTypeInfo_Second();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.GamlDefinition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Definition</em>'.
   * @see gaml.compiler.gaml.GamlDefinition
   * @generated
   */
  EClass getGamlDefinition();

  /**
   * Returns the meta object for the attribute '{@link gaml.compiler.gaml.GamlDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see gaml.compiler.gaml.GamlDefinition#getName()
   * @see #getGamlDefinition()
   * @generated
   */
  EAttribute getGamlDefinition_Name();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.EquationDefinition <em>Equation Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equation Definition</em>'.
   * @see gaml.compiler.gaml.EquationDefinition
   * @generated
   */
  EClass getEquationDefinition();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.TypeDefinition <em>Type Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Definition</em>'.
   * @see gaml.compiler.gaml.TypeDefinition
   * @generated
   */
  EClass getTypeDefinition();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.VarDefinition <em>Var Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var Definition</em>'.
   * @see gaml.compiler.gaml.VarDefinition
   * @generated
   */
  EClass getVarDefinition();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.ActionDefinition <em>Action Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Action Definition</em>'.
   * @see gaml.compiler.gaml.ActionDefinition
   * @generated
   */
  EClass getActionDefinition();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.UnitFakeDefinition <em>Unit Fake Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unit Fake Definition</em>'.
   * @see gaml.compiler.gaml.UnitFakeDefinition
   * @generated
   */
  EClass getUnitFakeDefinition();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.TypeFakeDefinition <em>Type Fake Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Fake Definition</em>'.
   * @see gaml.compiler.gaml.TypeFakeDefinition
   * @generated
   */
  EClass getTypeFakeDefinition();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.ActionFakeDefinition <em>Action Fake Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Action Fake Definition</em>'.
   * @see gaml.compiler.gaml.ActionFakeDefinition
   * @generated
   */
  EClass getActionFakeDefinition();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.SkillFakeDefinition <em>Skill Fake Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Skill Fake Definition</em>'.
   * @see gaml.compiler.gaml.SkillFakeDefinition
   * @generated
   */
  EClass getSkillFakeDefinition();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.VarFakeDefinition <em>Var Fake Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var Fake Definition</em>'.
   * @see gaml.compiler.gaml.VarFakeDefinition
   * @generated
   */
  EClass getVarFakeDefinition();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.EquationFakeDefinition <em>Equation Fake Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equation Fake Definition</em>'.
   * @see gaml.compiler.gaml.EquationFakeDefinition
   * @generated
   */
  EClass getEquationFakeDefinition();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.TerminalExpression <em>Terminal Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Terminal Expression</em>'.
   * @see gaml.compiler.gaml.TerminalExpression
   * @generated
   */
  EClass getTerminalExpression();

  /**
   * Returns the meta object for the attribute '{@link gaml.compiler.gaml.TerminalExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see gaml.compiler.gaml.TerminalExpression#getOp()
   * @see #getTerminalExpression()
   * @generated
   */
  EAttribute getTerminalExpression_Op();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.StringLiteral <em>String Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Literal</em>'.
   * @see gaml.compiler.gaml.StringLiteral
   * @generated
   */
  EClass getStringLiteral();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.S_Action <em>SAction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SAction</em>'.
   * @see gaml.compiler.gaml.S_Action
   * @generated
   */
  EClass getS_Action();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.S_Var <em>SVar</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SVar</em>'.
   * @see gaml.compiler.gaml.S_Var
   * @generated
   */
  EClass getS_Var();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.BinaryOperator <em>Binary Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Binary Operator</em>'.
   * @see gaml.compiler.gaml.BinaryOperator
   * @generated
   */
  EClass getBinaryOperator();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.BinaryOperator#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see gaml.compiler.gaml.BinaryOperator#getLeft()
   * @see #getBinaryOperator()
   * @generated
   */
  EReference getBinaryOperator_Left();

  /**
   * Returns the meta object for the attribute '{@link gaml.compiler.gaml.BinaryOperator#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see gaml.compiler.gaml.BinaryOperator#getOp()
   * @see #getBinaryOperator()
   * @generated
   */
  EAttribute getBinaryOperator_Op();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.BinaryOperator#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see gaml.compiler.gaml.BinaryOperator#getRight()
   * @see #getBinaryOperator()
   * @generated
   */
  EReference getBinaryOperator_Right();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.If <em>If</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If</em>'.
   * @see gaml.compiler.gaml.If
   * @generated
   */
  EClass getIf();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.If#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see gaml.compiler.gaml.If#getLeft()
   * @see #getIf()
   * @generated
   */
  EReference getIf_Left();

  /**
   * Returns the meta object for the attribute '{@link gaml.compiler.gaml.If#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see gaml.compiler.gaml.If#getOp()
   * @see #getIf()
   * @generated
   */
  EAttribute getIf_Op();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.If#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see gaml.compiler.gaml.If#getRight()
   * @see #getIf()
   * @generated
   */
  EReference getIf_Right();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.If#getIfFalse <em>If False</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>If False</em>'.
   * @see gaml.compiler.gaml.If#getIfFalse()
   * @see #getIf()
   * @generated
   */
  EReference getIf_IfFalse();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.Unit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unit</em>'.
   * @see gaml.compiler.gaml.Unit
   * @generated
   */
  EClass getUnit();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.Unit#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see gaml.compiler.gaml.Unit#getLeft()
   * @see #getUnit()
   * @generated
   */
  EReference getUnit_Left();

  /**
   * Returns the meta object for the attribute '{@link gaml.compiler.gaml.Unit#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see gaml.compiler.gaml.Unit#getOp()
   * @see #getUnit()
   * @generated
   */
  EAttribute getUnit_Op();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.Unit#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see gaml.compiler.gaml.Unit#getRight()
   * @see #getUnit()
   * @generated
   */
  EReference getUnit_Right();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.Unary <em>Unary</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary</em>'.
   * @see gaml.compiler.gaml.Unary
   * @generated
   */
  EClass getUnary();

  /**
   * Returns the meta object for the attribute '{@link gaml.compiler.gaml.Unary#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see gaml.compiler.gaml.Unary#getOp()
   * @see #getUnary()
   * @generated
   */
  EAttribute getUnary_Op();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.Unary#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see gaml.compiler.gaml.Unary#getRight()
   * @see #getUnary()
   * @generated
   */
  EReference getUnary_Right();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.Access <em>Access</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Access</em>'.
   * @see gaml.compiler.gaml.Access
   * @generated
   */
  EClass getAccess();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.Access#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see gaml.compiler.gaml.Access#getLeft()
   * @see #getAccess()
   * @generated
   */
  EReference getAccess_Left();

  /**
   * Returns the meta object for the attribute '{@link gaml.compiler.gaml.Access#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see gaml.compiler.gaml.Access#getOp()
   * @see #getAccess()
   * @generated
   */
  EAttribute getAccess_Op();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.Access#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see gaml.compiler.gaml.Access#getRight()
   * @see #getAccess()
   * @generated
   */
  EReference getAccess_Right();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.Array <em>Array</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array</em>'.
   * @see gaml.compiler.gaml.Array
   * @generated
   */
  EClass getArray();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.Array#getExprs <em>Exprs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exprs</em>'.
   * @see gaml.compiler.gaml.Array#getExprs()
   * @see #getArray()
   * @generated
   */
  EReference getArray_Exprs();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.Point <em>Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Point</em>'.
   * @see gaml.compiler.gaml.Point
   * @generated
   */
  EClass getPoint();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.Point#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see gaml.compiler.gaml.Point#getLeft()
   * @see #getPoint()
   * @generated
   */
  EReference getPoint_Left();

  /**
   * Returns the meta object for the attribute '{@link gaml.compiler.gaml.Point#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see gaml.compiler.gaml.Point#getOp()
   * @see #getPoint()
   * @generated
   */
  EAttribute getPoint_Op();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.Point#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see gaml.compiler.gaml.Point#getRight()
   * @see #getPoint()
   * @generated
   */
  EReference getPoint_Right();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.Point#getZ <em>Z</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Z</em>'.
   * @see gaml.compiler.gaml.Point#getZ()
   * @see #getPoint()
   * @generated
   */
  EReference getPoint_Z();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.Function <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function</em>'.
   * @see gaml.compiler.gaml.Function
   * @generated
   */
  EClass getFunction();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.Function#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see gaml.compiler.gaml.Function#getLeft()
   * @see #getFunction()
   * @generated
   */
  EReference getFunction_Left();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.Function#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see gaml.compiler.gaml.Function#getType()
   * @see #getFunction()
   * @generated
   */
  EReference getFunction_Type();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.Function#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see gaml.compiler.gaml.Function#getRight()
   * @see #getFunction()
   * @generated
   */
  EReference getFunction_Right();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter</em>'.
   * @see gaml.compiler.gaml.Parameter
   * @generated
   */
  EClass getParameter();

  /**
   * Returns the meta object for the attribute '{@link gaml.compiler.gaml.Parameter#getBuiltInFacetKey <em>Built In Facet Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Built In Facet Key</em>'.
   * @see gaml.compiler.gaml.Parameter#getBuiltInFacetKey()
   * @see #getParameter()
   * @generated
   */
  EAttribute getParameter_BuiltInFacetKey();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.Parameter#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see gaml.compiler.gaml.Parameter#getLeft()
   * @see #getParameter()
   * @generated
   */
  EReference getParameter_Left();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.Parameter#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see gaml.compiler.gaml.Parameter#getRight()
   * @see #getParameter()
   * @generated
   */
  EReference getParameter_Right();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.UnitName <em>Unit Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unit Name</em>'.
   * @see gaml.compiler.gaml.UnitName
   * @generated
   */
  EClass getUnitName();

  /**
   * Returns the meta object for the reference '{@link gaml.compiler.gaml.UnitName#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see gaml.compiler.gaml.UnitName#getRef()
   * @see #getUnitName()
   * @generated
   */
  EReference getUnitName_Ref();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.TypeRef <em>Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Ref</em>'.
   * @see gaml.compiler.gaml.TypeRef
   * @generated
   */
  EClass getTypeRef();

  /**
   * Returns the meta object for the reference '{@link gaml.compiler.gaml.TypeRef#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see gaml.compiler.gaml.TypeRef#getRef()
   * @see #getTypeRef()
   * @generated
   */
  EReference getTypeRef_Ref();

  /**
   * Returns the meta object for the containment reference '{@link gaml.compiler.gaml.TypeRef#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Parameter</em>'.
   * @see gaml.compiler.gaml.TypeRef#getParameter()
   * @see #getTypeRef()
   * @generated
   */
  EReference getTypeRef_Parameter();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.SkillRef <em>Skill Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Skill Ref</em>'.
   * @see gaml.compiler.gaml.SkillRef
   * @generated
   */
  EClass getSkillRef();

  /**
   * Returns the meta object for the reference '{@link gaml.compiler.gaml.SkillRef#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see gaml.compiler.gaml.SkillRef#getRef()
   * @see #getSkillRef()
   * @generated
   */
  EReference getSkillRef_Ref();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.ActionRef <em>Action Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Action Ref</em>'.
   * @see gaml.compiler.gaml.ActionRef
   * @generated
   */
  EClass getActionRef();

  /**
   * Returns the meta object for the reference '{@link gaml.compiler.gaml.ActionRef#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see gaml.compiler.gaml.ActionRef#getRef()
   * @see #getActionRef()
   * @generated
   */
  EReference getActionRef_Ref();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.EquationRef <em>Equation Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equation Ref</em>'.
   * @see gaml.compiler.gaml.EquationRef
   * @generated
   */
  EClass getEquationRef();

  /**
   * Returns the meta object for the reference '{@link gaml.compiler.gaml.EquationRef#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see gaml.compiler.gaml.EquationRef#getRef()
   * @see #getEquationRef()
   * @generated
   */
  EReference getEquationRef_Ref();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.IntLiteral <em>Int Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Int Literal</em>'.
   * @see gaml.compiler.gaml.IntLiteral
   * @generated
   */
  EClass getIntLiteral();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.DoubleLiteral <em>Double Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Double Literal</em>'.
   * @see gaml.compiler.gaml.DoubleLiteral
   * @generated
   */
  EClass getDoubleLiteral();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.BooleanLiteral <em>Boolean Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Literal</em>'.
   * @see gaml.compiler.gaml.BooleanLiteral
   * @generated
   */
  EClass getBooleanLiteral();

  /**
   * Returns the meta object for class '{@link gaml.compiler.gaml.ReservedLiteral <em>Reserved Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reserved Literal</em>'.
   * @see gaml.compiler.gaml.ReservedLiteral
   * @generated
   */
  EClass getReservedLiteral();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  GamlFactory getGamlFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.EntryImpl <em>Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.EntryImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getEntry()
     * @generated
     */
    EClass ENTRY = eINSTANCE.getEntry();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.StandaloneBlockImpl <em>Standalone Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.StandaloneBlockImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getStandaloneBlock()
     * @generated
     */
    EClass STANDALONE_BLOCK = eINSTANCE.getStandaloneBlock();

    /**
     * The meta object literal for the '<em><b>Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STANDALONE_BLOCK__BLOCK = eINSTANCE.getStandaloneBlock_Block();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.StringEvaluatorImpl <em>String Evaluator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.StringEvaluatorImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getStringEvaluator()
     * @generated
     */
    EClass STRING_EVALUATOR = eINSTANCE.getStringEvaluator();

    /**
     * The meta object literal for the '<em><b>Toto</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_EVALUATOR__TOTO = eINSTANCE.getStringEvaluator_Toto();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRING_EVALUATOR__EXPR = eINSTANCE.getStringEvaluator_Expr();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.ModelImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Pragmas</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__PRAGMAS = eINSTANCE.getModel_Pragmas();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__IMPORTS = eINSTANCE.getModel_Imports();

    /**
     * The meta object literal for the '<em><b>Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__BLOCK = eINSTANCE.getModel_Block();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.BlockImpl <em>Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.BlockImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getBlock()
     * @generated
     */
    EClass BLOCK = eINSTANCE.getBlock();

    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BLOCK__STATEMENTS = eINSTANCE.getBlock_Statements();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.ImportImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getImport()
     * @generated
     */
    EClass IMPORT = eINSTANCE.getImport();

    /**
     * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT__IMPORT_URI = eINSTANCE.getImport_ImportURI();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.PragmaImpl <em>Pragma</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.PragmaImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getPragma()
     * @generated
     */
    EClass PRAGMA = eINSTANCE.getPragma();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRAGMA__NAME = eINSTANCE.getPragma_Name();

    /**
     * The meta object literal for the '<em><b>Plugins</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRAGMA__PLUGINS = eINSTANCE.getPragma_Plugins();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.ExperimentFileStructureImpl <em>Experiment File Structure</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.ExperimentFileStructureImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getExperimentFileStructure()
     * @generated
     */
    EClass EXPERIMENT_FILE_STRUCTURE = eINSTANCE.getExperimentFileStructure();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPERIMENT_FILE_STRUCTURE__EXP = eINSTANCE.getExperimentFileStructure_Exp();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.HeadlessExperimentImpl <em>Headless Experiment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.HeadlessExperimentImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getHeadlessExperiment()
     * @generated
     */
    EClass HEADLESS_EXPERIMENT = eINSTANCE.getHeadlessExperiment();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HEADLESS_EXPERIMENT__KEY = eINSTANCE.getHeadlessExperiment_Key();

    /**
     * The meta object literal for the '<em><b>First Facet</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HEADLESS_EXPERIMENT__FIRST_FACET = eINSTANCE.getHeadlessExperiment_FirstFacet();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HEADLESS_EXPERIMENT__NAME = eINSTANCE.getHeadlessExperiment_Name();

    /**
     * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HEADLESS_EXPERIMENT__IMPORT_URI = eINSTANCE.getHeadlessExperiment_ImportURI();

    /**
     * The meta object literal for the '<em><b>Facets</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HEADLESS_EXPERIMENT__FACETS = eINSTANCE.getHeadlessExperiment_Facets();

    /**
     * The meta object literal for the '<em><b>Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HEADLESS_EXPERIMENT__BLOCK = eINSTANCE.getHeadlessExperiment_Block();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.StatementImpl <em>Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.StatementImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getStatement()
     * @generated
     */
    EClass STATEMENT = eINSTANCE.getStatement();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATEMENT__KEY = eINSTANCE.getStatement_Key();

    /**
     * The meta object literal for the '<em><b>First Facet</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATEMENT__FIRST_FACET = eINSTANCE.getStatement_FirstFacet();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__EXPR = eINSTANCE.getStatement_Expr();

    /**
     * The meta object literal for the '<em><b>Facets</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__FACETS = eINSTANCE.getStatement_Facets();

    /**
     * The meta object literal for the '<em><b>Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__BLOCK = eINSTANCE.getStatement_Block();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.S_GlobalImpl <em>SGlobal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.S_GlobalImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Global()
     * @generated
     */
    EClass SGLOBAL = eINSTANCE.getS_Global();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.S_SpeciesImpl <em>SSpecies</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.S_SpeciesImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Species()
     * @generated
     */
    EClass SSPECIES = eINSTANCE.getS_Species();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.S_ExperimentImpl <em>SExperiment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.S_ExperimentImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Experiment()
     * @generated
     */
    EClass SEXPERIMENT = eINSTANCE.getS_Experiment();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.S_DoImpl <em>SDo</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.S_DoImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Do()
     * @generated
     */
    EClass SDO = eINSTANCE.getS_Do();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.S_LoopImpl <em>SLoop</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.S_LoopImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Loop()
     * @generated
     */
    EClass SLOOP = eINSTANCE.getS_Loop();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.S_IfImpl <em>SIf</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.S_IfImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_If()
     * @generated
     */
    EClass SIF = eINSTANCE.getS_If();

    /**
     * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIF__ELSE = eINSTANCE.getS_If_Else();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.S_TryImpl <em>STry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.S_TryImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Try()
     * @generated
     */
    EClass STRY = eINSTANCE.getS_Try();

    /**
     * The meta object literal for the '<em><b>Catch</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRY__CATCH = eINSTANCE.getS_Try_Catch();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.S_OtherImpl <em>SOther</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.S_OtherImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Other()
     * @generated
     */
    EClass SOTHER = eINSTANCE.getS_Other();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.S_ReturnImpl <em>SReturn</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.S_ReturnImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Return()
     * @generated
     */
    EClass SRETURN = eINSTANCE.getS_Return();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.S_DeclarationImpl <em>SDeclaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.S_DeclarationImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Declaration()
     * @generated
     */
    EClass SDECLARATION = eINSTANCE.getS_Declaration();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.S_ReflexImpl <em>SReflex</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.S_ReflexImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Reflex()
     * @generated
     */
    EClass SREFLEX = eINSTANCE.getS_Reflex();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.S_DefinitionImpl <em>SDefinition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.S_DefinitionImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Definition()
     * @generated
     */
    EClass SDEFINITION = eINSTANCE.getS_Definition();

    /**
     * The meta object literal for the '<em><b>Tkey</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SDEFINITION__TKEY = eINSTANCE.getS_Definition_Tkey();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SDEFINITION__ARGS = eINSTANCE.getS_Definition_Args();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.S_AssignmentImpl <em>SAssignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.S_AssignmentImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Assignment()
     * @generated
     */
    EClass SASSIGNMENT = eINSTANCE.getS_Assignment();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SASSIGNMENT__VALUE = eINSTANCE.getS_Assignment_Value();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.S_DirectAssignmentImpl <em>SDirect Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.S_DirectAssignmentImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_DirectAssignment()
     * @generated
     */
    EClass SDIRECT_ASSIGNMENT = eINSTANCE.getS_DirectAssignment();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.S_SetImpl <em>SSet</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.S_SetImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Set()
     * @generated
     */
    EClass SSET = eINSTANCE.getS_Set();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.S_EquationsImpl <em>SEquations</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.S_EquationsImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Equations()
     * @generated
     */
    EClass SEQUATIONS = eINSTANCE.getS_Equations();

    /**
     * The meta object literal for the '<em><b>Equations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEQUATIONS__EQUATIONS = eINSTANCE.getS_Equations_Equations();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.S_SolveImpl <em>SSolve</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.S_SolveImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Solve()
     * @generated
     */
    EClass SSOLVE = eINSTANCE.getS_Solve();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.S_DisplayImpl <em>SDisplay</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.S_DisplayImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Display()
     * @generated
     */
    EClass SDISPLAY = eINSTANCE.getS_Display();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SDISPLAY__NAME = eINSTANCE.getS_Display_Name();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.speciesOrGridDisplayStatementImpl <em>species Or Grid Display Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.speciesOrGridDisplayStatementImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getspeciesOrGridDisplayStatement()
     * @generated
     */
    EClass SPECIES_OR_GRID_DISPLAY_STATEMENT = eINSTANCE.getspeciesOrGridDisplayStatement();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.imageDisplayStatementImpl <em>image Display Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.imageDisplayStatementImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getimageDisplayStatement()
     * @generated
     */
    EClass IMAGE_DISPLAY_STATEMENT = eINSTANCE.getimageDisplayStatement();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.ActionArgumentsImpl <em>Action Arguments</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.ActionArgumentsImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getActionArguments()
     * @generated
     */
    EClass ACTION_ARGUMENTS = eINSTANCE.getActionArguments();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTION_ARGUMENTS__ARGS = eINSTANCE.getActionArguments_Args();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.ArgumentDefinitionImpl <em>Argument Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.ArgumentDefinitionImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getArgumentDefinition()
     * @generated
     */
    EClass ARGUMENT_DEFINITION = eINSTANCE.getArgumentDefinition();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARGUMENT_DEFINITION__TYPE = eINSTANCE.getArgumentDefinition_Type();

    /**
     * The meta object literal for the '<em><b>Default</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARGUMENT_DEFINITION__DEFAULT = eINSTANCE.getArgumentDefinition_Default();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.FacetImpl <em>Facet</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.FacetImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getFacet()
     * @generated
     */
    EClass FACET = eINSTANCE.getFacet();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FACET__KEY = eINSTANCE.getFacet_Key();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACET__EXPR = eINSTANCE.getFacet_Expr();

    /**
     * The meta object literal for the '<em><b>Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACET__BLOCK = eINSTANCE.getFacet_Block();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.ExpressionImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.ArgumentPairImpl <em>Argument Pair</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.ArgumentPairImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getArgumentPair()
     * @generated
     */
    EClass ARGUMENT_PAIR = eINSTANCE.getArgumentPair();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARGUMENT_PAIR__OP = eINSTANCE.getArgumentPair_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARGUMENT_PAIR__RIGHT = eINSTANCE.getArgumentPair_Right();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.ExpressionListImpl <em>Expression List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.ExpressionListImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getExpressionList()
     * @generated
     */
    EClass EXPRESSION_LIST = eINSTANCE.getExpressionList();

    /**
     * The meta object literal for the '<em><b>Exprs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_LIST__EXPRS = eINSTANCE.getExpressionList_Exprs();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.VariableRefImpl <em>Variable Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.VariableRefImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getVariableRef()
     * @generated
     */
    EClass VARIABLE_REF = eINSTANCE.getVariableRef();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_REF__REF = eINSTANCE.getVariableRef_Ref();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.TypeInfoImpl <em>Type Info</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.TypeInfoImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getTypeInfo()
     * @generated
     */
    EClass TYPE_INFO = eINSTANCE.getTypeInfo();

    /**
     * The meta object literal for the '<em><b>First</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_INFO__FIRST = eINSTANCE.getTypeInfo_First();

    /**
     * The meta object literal for the '<em><b>Second</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_INFO__SECOND = eINSTANCE.getTypeInfo_Second();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.GamlDefinitionImpl <em>Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.GamlDefinitionImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getGamlDefinition()
     * @generated
     */
    EClass GAML_DEFINITION = eINSTANCE.getGamlDefinition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GAML_DEFINITION__NAME = eINSTANCE.getGamlDefinition_Name();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.EquationDefinitionImpl <em>Equation Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.EquationDefinitionImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getEquationDefinition()
     * @generated
     */
    EClass EQUATION_DEFINITION = eINSTANCE.getEquationDefinition();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.TypeDefinitionImpl <em>Type Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.TypeDefinitionImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getTypeDefinition()
     * @generated
     */
    EClass TYPE_DEFINITION = eINSTANCE.getTypeDefinition();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.VarDefinitionImpl <em>Var Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.VarDefinitionImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getVarDefinition()
     * @generated
     */
    EClass VAR_DEFINITION = eINSTANCE.getVarDefinition();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.ActionDefinitionImpl <em>Action Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.ActionDefinitionImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getActionDefinition()
     * @generated
     */
    EClass ACTION_DEFINITION = eINSTANCE.getActionDefinition();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.UnitFakeDefinitionImpl <em>Unit Fake Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.UnitFakeDefinitionImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getUnitFakeDefinition()
     * @generated
     */
    EClass UNIT_FAKE_DEFINITION = eINSTANCE.getUnitFakeDefinition();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.TypeFakeDefinitionImpl <em>Type Fake Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.TypeFakeDefinitionImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getTypeFakeDefinition()
     * @generated
     */
    EClass TYPE_FAKE_DEFINITION = eINSTANCE.getTypeFakeDefinition();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.ActionFakeDefinitionImpl <em>Action Fake Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.ActionFakeDefinitionImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getActionFakeDefinition()
     * @generated
     */
    EClass ACTION_FAKE_DEFINITION = eINSTANCE.getActionFakeDefinition();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.SkillFakeDefinitionImpl <em>Skill Fake Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.SkillFakeDefinitionImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getSkillFakeDefinition()
     * @generated
     */
    EClass SKILL_FAKE_DEFINITION = eINSTANCE.getSkillFakeDefinition();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.VarFakeDefinitionImpl <em>Var Fake Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.VarFakeDefinitionImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getVarFakeDefinition()
     * @generated
     */
    EClass VAR_FAKE_DEFINITION = eINSTANCE.getVarFakeDefinition();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.EquationFakeDefinitionImpl <em>Equation Fake Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.EquationFakeDefinitionImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getEquationFakeDefinition()
     * @generated
     */
    EClass EQUATION_FAKE_DEFINITION = eINSTANCE.getEquationFakeDefinition();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.TerminalExpressionImpl <em>Terminal Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.TerminalExpressionImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getTerminalExpression()
     * @generated
     */
    EClass TERMINAL_EXPRESSION = eINSTANCE.getTerminalExpression();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TERMINAL_EXPRESSION__OP = eINSTANCE.getTerminalExpression_Op();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.StringLiteralImpl <em>String Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.StringLiteralImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getStringLiteral()
     * @generated
     */
    EClass STRING_LITERAL = eINSTANCE.getStringLiteral();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.S_ActionImpl <em>SAction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.S_ActionImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Action()
     * @generated
     */
    EClass SACTION = eINSTANCE.getS_Action();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.S_VarImpl <em>SVar</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.S_VarImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getS_Var()
     * @generated
     */
    EClass SVAR = eINSTANCE.getS_Var();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.BinaryOperatorImpl <em>Binary Operator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.BinaryOperatorImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getBinaryOperator()
     * @generated
     */
    EClass BINARY_OPERATOR = eINSTANCE.getBinaryOperator();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINARY_OPERATOR__LEFT = eINSTANCE.getBinaryOperator_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BINARY_OPERATOR__OP = eINSTANCE.getBinaryOperator_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINARY_OPERATOR__RIGHT = eINSTANCE.getBinaryOperator_Right();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.IfImpl <em>If</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.IfImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getIf()
     * @generated
     */
    EClass IF = eINSTANCE.getIf();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF__LEFT = eINSTANCE.getIf_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IF__OP = eINSTANCE.getIf_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF__RIGHT = eINSTANCE.getIf_Right();

    /**
     * The meta object literal for the '<em><b>If False</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF__IF_FALSE = eINSTANCE.getIf_IfFalse();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.UnitImpl <em>Unit</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.UnitImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getUnit()
     * @generated
     */
    EClass UNIT = eINSTANCE.getUnit();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNIT__LEFT = eINSTANCE.getUnit_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNIT__OP = eINSTANCE.getUnit_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNIT__RIGHT = eINSTANCE.getUnit_Right();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.UnaryImpl <em>Unary</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.UnaryImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getUnary()
     * @generated
     */
    EClass UNARY = eINSTANCE.getUnary();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNARY__OP = eINSTANCE.getUnary_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY__RIGHT = eINSTANCE.getUnary_Right();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.AccessImpl <em>Access</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.AccessImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getAccess()
     * @generated
     */
    EClass ACCESS = eINSTANCE.getAccess();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACCESS__LEFT = eINSTANCE.getAccess_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACCESS__OP = eINSTANCE.getAccess_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACCESS__RIGHT = eINSTANCE.getAccess_Right();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.ArrayImpl <em>Array</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.ArrayImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getArray()
     * @generated
     */
    EClass ARRAY = eINSTANCE.getArray();

    /**
     * The meta object literal for the '<em><b>Exprs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY__EXPRS = eINSTANCE.getArray_Exprs();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.PointImpl <em>Point</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.PointImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getPoint()
     * @generated
     */
    EClass POINT = eINSTANCE.getPoint();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POINT__LEFT = eINSTANCE.getPoint_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute POINT__OP = eINSTANCE.getPoint_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POINT__RIGHT = eINSTANCE.getPoint_Right();

    /**
     * The meta object literal for the '<em><b>Z</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POINT__Z = eINSTANCE.getPoint_Z();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.FunctionImpl <em>Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.FunctionImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getFunction()
     * @generated
     */
    EClass FUNCTION = eINSTANCE.getFunction();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION__LEFT = eINSTANCE.getFunction_Left();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION__TYPE = eINSTANCE.getFunction_Type();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION__RIGHT = eINSTANCE.getFunction_Right();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.ParameterImpl <em>Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.ParameterImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getParameter()
     * @generated
     */
    EClass PARAMETER = eINSTANCE.getParameter();

    /**
     * The meta object literal for the '<em><b>Built In Facet Key</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETER__BUILT_IN_FACET_KEY = eINSTANCE.getParameter_BuiltInFacetKey();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER__LEFT = eINSTANCE.getParameter_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER__RIGHT = eINSTANCE.getParameter_Right();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.UnitNameImpl <em>Unit Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.UnitNameImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getUnitName()
     * @generated
     */
    EClass UNIT_NAME = eINSTANCE.getUnitName();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNIT_NAME__REF = eINSTANCE.getUnitName_Ref();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.TypeRefImpl <em>Type Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.TypeRefImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getTypeRef()
     * @generated
     */
    EClass TYPE_REF = eINSTANCE.getTypeRef();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_REF__REF = eINSTANCE.getTypeRef_Ref();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_REF__PARAMETER = eINSTANCE.getTypeRef_Parameter();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.SkillRefImpl <em>Skill Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.SkillRefImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getSkillRef()
     * @generated
     */
    EClass SKILL_REF = eINSTANCE.getSkillRef();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SKILL_REF__REF = eINSTANCE.getSkillRef_Ref();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.ActionRefImpl <em>Action Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.ActionRefImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getActionRef()
     * @generated
     */
    EClass ACTION_REF = eINSTANCE.getActionRef();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTION_REF__REF = eINSTANCE.getActionRef_Ref();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.EquationRefImpl <em>Equation Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.EquationRefImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getEquationRef()
     * @generated
     */
    EClass EQUATION_REF = eINSTANCE.getEquationRef();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUATION_REF__REF = eINSTANCE.getEquationRef_Ref();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.IntLiteralImpl <em>Int Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.IntLiteralImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getIntLiteral()
     * @generated
     */
    EClass INT_LITERAL = eINSTANCE.getIntLiteral();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.DoubleLiteralImpl <em>Double Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.DoubleLiteralImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getDoubleLiteral()
     * @generated
     */
    EClass DOUBLE_LITERAL = eINSTANCE.getDoubleLiteral();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.BooleanLiteralImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getBooleanLiteral()
     * @generated
     */
    EClass BOOLEAN_LITERAL = eINSTANCE.getBooleanLiteral();

    /**
     * The meta object literal for the '{@link gaml.compiler.gaml.impl.ReservedLiteralImpl <em>Reserved Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gaml.compiler.gaml.impl.ReservedLiteralImpl
     * @see gaml.compiler.gaml.impl.GamlPackageImpl#getReservedLiteral()
     * @generated
     */
    EClass RESERVED_LITERAL = eINSTANCE.getReservedLiteral();

  }

} //GamlPackage
