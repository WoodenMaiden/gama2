/*******************************************************************************************************
 *
 * ExperimentFileStructure.java, in gaml.compiler, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.compiler.gaml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Experiment File Structure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gaml.compiler.gaml.ExperimentFileStructure#getExp <em>Exp</em>}</li>
 * </ul>
 *
 * @see gaml.compiler.gaml.GamlPackage#getExperimentFileStructure()
 * @model
 * @generated
 */
public interface ExperimentFileStructure extends Entry
{
  /**
   * Returns the value of the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exp</em>' containment reference.
   * @see #setExp(HeadlessExperiment)
   * @see gaml.compiler.gaml.GamlPackage#getExperimentFileStructure_Exp()
   * @model containment="true"
   * @generated
   */
  HeadlessExperiment getExp();

  /**
   * Sets the value of the '{@link gaml.compiler.gaml.ExperimentFileStructure#getExp <em>Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exp</em>' containment reference.
   * @see #getExp()
   * @generated
   */
  void setExp(HeadlessExperiment value);

} // ExperimentFileStructure
