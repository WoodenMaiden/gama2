/*******************************************************************************************************
 *
 * Pragma.java, in gaml.compiler, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.compiler.gaml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pragma</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gaml.compiler.gaml.Pragma#getName <em>Name</em>}</li>
 *   <li>{@link gaml.compiler.gaml.Pragma#getPlugins <em>Plugins</em>}</li>
 * </ul>
 *
 * @see gaml.compiler.gaml.GamlPackage#getPragma()
 * @model
 * @generated
 */
public interface Pragma extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see gaml.compiler.gaml.GamlPackage#getPragma_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link gaml.compiler.gaml.Pragma#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Plugins</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Plugins</em>' containment reference.
   * @see #setPlugins(ExpressionList)
   * @see gaml.compiler.gaml.GamlPackage#getPragma_Plugins()
   * @model containment="true"
   * @generated
   */
  ExpressionList getPlugins();

  /**
   * Sets the value of the '{@link gaml.compiler.gaml.Pragma#getPlugins <em>Plugins</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Plugins</em>' containment reference.
   * @see #getPlugins()
   * @generated
   */
  void setPlugins(ExpressionList value);

} // Pragma
