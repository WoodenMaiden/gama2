/*******************************************************************************************************
 *
 * ImportImpl.java, in gaml.compiler, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.compiler.gaml.impl;

import gaml.compiler.gaml.GamlPackage;
import gaml.compiler.gaml.Import;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gaml.compiler.gaml.impl.ImportImpl#getImportURI <em>Import URI</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImportImpl extends VarDefinitionImpl implements Import
{
  /**
   * The default value of the '{@link #getImportURI() <em>Import URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImportURI()
   * @generated
   * @ordered
   */
  protected static final String IMPORT_URI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getImportURI() <em>Import URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImportURI()
   * @generated
   * @ordered
   */
  protected String importURI = IMPORT_URI_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ImportImpl()
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
    return GamlPackage.Literals.IMPORT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getImportURI()
  {
    return importURI;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setImportURI(String newImportURI)
  {
    String oldImportURI = importURI;
    importURI = newImportURI;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GamlPackage.IMPORT__IMPORT_URI, oldImportURI, importURI));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case GamlPackage.IMPORT__IMPORT_URI:
        return getImportURI();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case GamlPackage.IMPORT__IMPORT_URI:
        setImportURI((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case GamlPackage.IMPORT__IMPORT_URI:
        setImportURI(IMPORT_URI_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case GamlPackage.IMPORT__IMPORT_URI:
        return IMPORT_URI_EDEFAULT == null ? importURI != null : !IMPORT_URI_EDEFAULT.equals(importURI);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (importURI: ");
    result.append(importURI);
    result.append(')');
    return result.toString();
  }

} //ImportImpl
