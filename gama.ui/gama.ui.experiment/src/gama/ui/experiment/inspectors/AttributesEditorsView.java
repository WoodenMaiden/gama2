/*******************************************************************************************************
 *
 * AttributesEditorsView.java, in gama.ui.experiment, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.experiment.inspectors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.widgets.Composite;

import gama.ui.experiment.parameters.EditorsList;
import gama.ui.shared.interfaces.IParameterEditor;
import gama.ui.shared.parameters.AbstractEditor;
import gama.ui.shared.parameters.EditorsGroup;
import gama.ui.shared.views.ExpandableItemsView;

/**
 * The Class AttributesEditorsView.
 *
 * @param <T>
 *            the generic type
 */
public abstract class AttributesEditorsView<T> extends ExpandableItemsView<T> {

	/** The editors. */
	protected EditorsList<T> editors;

	/**
	 * Gets the item display name.
	 *
	 * @param obj
	 *            the obj
	 * @param previousName
	 *            the previous name
	 * @return the item display name
	 */
	@Override
	public String getItemDisplayName(final T obj, final String previousName) {
		if (editors == null) return "";
		return editors.getItemDisplayName(obj, previousName);
	}

	/**
	 * Creates the item contents for.
	 *
	 * @param data
	 *            the data
	 * @return the composite
	 */
	@SuppressWarnings ({ "rawtypes", "unchecked" })
	@Override
	protected Composite createItemContentsFor(final T data) {
		final EditorsGroup compo = new EditorsGroup(getViewer());
		if (editors != null) {
			final Map<String, IParameterEditor<?>> parameters = editors.getSections().get(data);
			if (parameters != null) {
				final List<AbstractEditor> list = new ArrayList(parameters.values());
				Collections.sort(list);
				for (final AbstractEditor<?> gpParam : list) {
					gpParam.createControls(compo);
					if (!editors.isEnabled(gpParam)) { gpParam.setActive(false); }
				}
			}
		}
		return compo;
	}

	/**
	 * Reset.
	 */
	@Override
	public void reset() {
		super.reset();
		editors = null;
	}

	/**
	 * Removes the item.
	 *
	 * @param obj
	 *            the obj
	 */
	@Override
	public void removeItem(final T obj) {
		if (editors == null) return;
		editors.removeItem(obj);
	}

	/**
	 * Pause item.
	 *
	 * @param obj
	 *            the obj
	 */
	@Override
	public void pauseItem(final T obj) {
		if (editors == null) return;
		editors.pauseItem(obj);
	}

	/**
	 * Resume item.
	 *
	 * @param obj
	 *            the obj
	 */
	@Override
	public void resumeItem(final T obj) {
		if (editors == null) return;
		editors.resumeItem(obj);
	}

	/**
	 * Focus item.
	 *
	 * @param obj
	 *            the obj
	 */
	@Override
	public void focusItem(final T obj) {
		if (editors == null) return;
		editors.focusItem(obj);
	}

	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	@Override
	public List<T> getItems() {
		if (editors == null) return Collections.EMPTY_LIST;
		return editors.getItems();
	}

	/**
	 * Update item values.
	 *
	 * @param synchronously
	 *            the synchronously
	 */
	@Override
	public void updateItemValues(final boolean synchronously) {
		if (editors != null) { editors.updateItemValues(synchronously); }
	}

}
