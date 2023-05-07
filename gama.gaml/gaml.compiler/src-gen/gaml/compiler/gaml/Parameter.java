/*******************************************************************************************************
 *
 * Parameter.java, in gaml.compiler, is part of the source code of the
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
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gaml.compiler.gaml.Parameter#getBuiltInFacetKey <em>Built In Facet Key</em>}</li>
 *   <li>{@link gaml.compiler.gaml.Parameter#getLeft <em>Left</em>}</li>
 *   <li>{@link gaml.compiler.gaml.Parameter#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see gaml.compiler.gaml.GamlPackage#getParameter()
 * @model
 * @generated
 */
public interface Parameter extends Expression
{
  /**
   * Returns the value of the '<em><b>Built In Facet Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Built In Facet Key</em>' attribute.
   * @see #setBuiltInFacetKey(String)
   * @see gaml.compiler.gaml.GamlPackage#getParameter_BuiltInFacetKey()
   * @model
   * @generated
   */
  String getBuiltInFacetKey();

  /**
   * Sets the value of the '{@link gaml.compiler.gaml.Parameter#getBuiltInFacetKey <em>Built In Facet Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Built In Facet Key</em>' attribute.
   * @see #getBuiltInFacetKey()
   * @generated
   */
  void setBuiltInFacetKey(String value);

  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(VariableRef)
   * @see gaml.compiler.gaml.GamlPackage#getParameter_Left()
   * @model containment="true"
   * @generated
   */
  VariableRef getLeft();

  /**
   * Sets the value of the '{@link gaml.compiler.gaml.Parameter#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(VariableRef value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(Expression)
   * @see gaml.compiler.gaml.GamlPackage#getParameter_Right()
   * @model containment="true"
   * @generated
   */
  Expression getRight();

  /**
   * Sets the value of the '{@link gaml.compiler.gaml.Parameter#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(Expression value);

} // Parameter
