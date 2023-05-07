/*******************************************************************************************************
 *
 * S_Equations.java, in gaml.compiler, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.compiler.gaml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SEquations</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gaml.compiler.gaml.S_Equations#getEquations <em>Equations</em>}</li>
 * </ul>
 *
 * @see gaml.compiler.gaml.GamlPackage#getS_Equations()
 * @model
 * @generated
 */
public interface S_Equations extends Statement, EquationDefinition
{
  /**
   * Returns the value of the '<em><b>Equations</b></em>' containment reference list.
   * The list contents are of type {@link gaml.compiler.gaml.S_Assignment}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Equations</em>' containment reference list.
   * @see gaml.compiler.gaml.GamlPackage#getS_Equations_Equations()
   * @model containment="true"
   * @generated
   */
  EList<S_Assignment> getEquations();

} // S_Equations
