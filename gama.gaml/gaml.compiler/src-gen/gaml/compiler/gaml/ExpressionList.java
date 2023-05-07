/*******************************************************************************************************
 *
 * ExpressionList.java, in gaml.compiler, is part of the source code of the
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
 * A representation of the model object '<em><b>Expression List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gaml.compiler.gaml.ExpressionList#getExprs <em>Exprs</em>}</li>
 * </ul>
 *
 * @see gaml.compiler.gaml.GamlPackage#getExpressionList()
 * @model
 * @generated
 */
public interface ExpressionList extends Expression
{
  /**
   * Returns the value of the '<em><b>Exprs</b></em>' containment reference list.
   * The list contents are of type {@link gaml.compiler.gaml.Expression}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exprs</em>' containment reference list.
   * @see gaml.compiler.gaml.GamlPackage#getExpressionList_Exprs()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getExprs();

} // ExpressionList
