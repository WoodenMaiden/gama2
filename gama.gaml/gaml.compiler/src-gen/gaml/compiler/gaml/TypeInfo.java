/*******************************************************************************************************
 *
 * TypeInfo.java, in gaml.compiler, is part of the source code of the
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
 * A representation of the model object '<em><b>Type Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gaml.compiler.gaml.TypeInfo#getFirst <em>First</em>}</li>
 *   <li>{@link gaml.compiler.gaml.TypeInfo#getSecond <em>Second</em>}</li>
 * </ul>
 *
 * @see gaml.compiler.gaml.GamlPackage#getTypeInfo()
 * @model
 * @generated
 */
public interface TypeInfo extends EObject
{
  /**
   * Returns the value of the '<em><b>First</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>First</em>' containment reference.
   * @see #setFirst(Expression)
   * @see gaml.compiler.gaml.GamlPackage#getTypeInfo_First()
   * @model containment="true"
   * @generated
   */
  Expression getFirst();

  /**
   * Sets the value of the '{@link gaml.compiler.gaml.TypeInfo#getFirst <em>First</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>First</em>' containment reference.
   * @see #getFirst()
   * @generated
   */
  void setFirst(Expression value);

  /**
   * Returns the value of the '<em><b>Second</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Second</em>' containment reference.
   * @see #setSecond(Expression)
   * @see gaml.compiler.gaml.GamlPackage#getTypeInfo_Second()
   * @model containment="true"
   * @generated
   */
  Expression getSecond();

  /**
   * Sets the value of the '{@link gaml.compiler.gaml.TypeInfo#getSecond <em>Second</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Second</em>' containment reference.
   * @see #getSecond()
   * @generated
   */
  void setSecond(Expression value);

} // TypeInfo
