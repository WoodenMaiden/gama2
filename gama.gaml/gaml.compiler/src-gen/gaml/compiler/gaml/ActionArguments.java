/*******************************************************************************************************
 *
 * ActionArguments.java, in gaml.compiler, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.compiler.gaml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Arguments</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gaml.compiler.gaml.ActionArguments#getArgs <em>Args</em>}</li>
 * </ul>
 *
 * @see gaml.compiler.gaml.GamlPackage#getActionArguments()
 * @model
 * @generated
 */
public interface ActionArguments extends EObject
{
  /**
   * Returns the value of the '<em><b>Args</b></em>' containment reference list.
   * The list contents are of type {@link gaml.compiler.gaml.ArgumentDefinition}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Args</em>' containment reference list.
   * @see gaml.compiler.gaml.GamlPackage#getActionArguments_Args()
   * @model containment="true"
   * @generated
   */
  EList<ArgumentDefinition> getArgs();

} // ActionArguments
