/*******************************************************************************************************
 *
 * EntryImpl.java, in gaml.compiler, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.compiler.gaml.impl;

import gaml.compiler.gaml.Entry;
import gaml.compiler.gaml.GamlPackage;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class EntryImpl extends MinimalEObjectImpl.Container implements Entry
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EntryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return GamlPackage.Literals.ENTRY;
  }

} //EntryImpl
