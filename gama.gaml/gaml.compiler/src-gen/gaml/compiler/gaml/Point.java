/*******************************************************************************************************
 *
 * Point.java, in gaml.compiler, is part of the source code of the
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
 * A representation of the model object '<em><b>Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gaml.compiler.gaml.Point#getLeft <em>Left</em>}</li>
 *   <li>{@link gaml.compiler.gaml.Point#getOp <em>Op</em>}</li>
 *   <li>{@link gaml.compiler.gaml.Point#getRight <em>Right</em>}</li>
 *   <li>{@link gaml.compiler.gaml.Point#getZ <em>Z</em>}</li>
 * </ul>
 *
 * @see gaml.compiler.gaml.GamlPackage#getPoint()
 * @model
 * @generated
 */
public interface Point extends Expression
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(Expression)
   * @see gaml.compiler.gaml.GamlPackage#getPoint_Left()
   * @model containment="true"
   * @generated
   */
  Expression getLeft();

  /**
   * Sets the value of the '{@link gaml.compiler.gaml.Point#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Expression value);

  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see #setOp(String)
   * @see gaml.compiler.gaml.GamlPackage#getPoint_Op()
   * @model
   * @generated
   */
  String getOp();

  /**
   * Sets the value of the '{@link gaml.compiler.gaml.Point#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see #getOp()
   * @generated
   */
  void setOp(String value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(Expression)
   * @see gaml.compiler.gaml.GamlPackage#getPoint_Right()
   * @model containment="true"
   * @generated
   */
  Expression getRight();

  /**
   * Sets the value of the '{@link gaml.compiler.gaml.Point#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(Expression value);

  /**
   * Returns the value of the '<em><b>Z</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Z</em>' containment reference.
   * @see #setZ(Expression)
   * @see gaml.compiler.gaml.GamlPackage#getPoint_Z()
   * @model containment="true"
   * @generated
   */
  Expression getZ();

  /**
   * Sets the value of the '{@link gaml.compiler.gaml.Point#getZ <em>Z</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Z</em>' containment reference.
   * @see #getZ()
   * @generated
   */
  void setZ(Expression value);

} // Point
