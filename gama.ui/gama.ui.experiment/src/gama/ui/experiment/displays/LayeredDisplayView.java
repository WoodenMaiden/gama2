/*******************************************************************************************************
 *
 * LayeredDisplayView.java, in gama.ui.experiment, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.experiment.displays;

import java.awt.Color;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;

import gama.annotations.common.interfaces.IDisposable;
import gama.core.common.interfaces.IDisplaySurface;
import gama.core.common.interfaces.IGamaView;
import gama.core.common.interfaces.ILayerManager;
import gama.core.common.preferences.GamaPreferences;
import gama.core.kernel.experiment.ITopLevelAgent;
import gama.core.metamodel.shape.GamaPoint;
import gama.core.outputs.IDisplayOutput;
import gama.core.outputs.LayeredDisplayOutput;
import gama.core.runtime.GAMA;
import gama.core.runtime.IScope;
import gama.dev.DEBUG;
import gama.ui.shared.resources.GamaColors;
import gama.ui.shared.resources.GamaIcon;
import gama.ui.shared.utils.ViewsHelper;
import gama.ui.shared.utils.WorkbenchHelper;
import gama.ui.shared.views.GamaViewPart;
import gama.ui.shared.views.toolbar.GamaToolbar2;
import gama.ui.shared.views.toolbar.IToolbarDecoratedView;

/**
 * The Class LayeredDisplayView.
 */
public abstract class LayeredDisplayView extends GamaViewPart
		implements IToolbarDecoratedView.Pausable, IToolbarDecoratedView.Zoomable, IGamaView.Display {

	static {
		DEBUG.OFF();
	}

	/** The is hi DPI. */
	volatile boolean isHiDPI;

	/** The shell listener. */
	ControlListener shellListener;

	/** The real index. */
	protected int realIndex = -1;

	/** The surface composite. */
	public Composite surfaceComposite;

	/** The decorator. */
	public LayeredDisplayDecorator decorator;

	/** The disposed. */
	public volatile boolean disposed = false;

	/** The closing. */
	private volatile boolean closing = false;

	/** The central panel. */
	protected CentralPanel centralPanel;

	@Override
	public void setIndex(final int index) { realIndex = index; }

	@Override
	public int getIndex() { return realIndex; }

	/**
	 * Instantiates a new layered display view.
	 */
	public LayeredDisplayView() {

	}

	/**
	 * Gets the sash.
	 *
	 * @return the sash
	 */
	public Composite getCentralPanel() { return centralPanel; }

	@Override
	public boolean containsPoint(final int x, final int y) {
		if (super.containsPoint(x, y)) return true;
		final Point o = getSurfaceComposite().toDisplay(0, 0);
		final Point s = getSurfaceComposite().getSize();
		Rectangle r = new Rectangle(o.x, o.y, s.x, s.y);
		// DEBUG.OUT("Looking in surfaceComposite rectangle " + r);

		return r.contains(x, y);
	}

	/**
	 * Inits the.
	 *
	 * @param site
	 *            the site
	 * @throws PartInitException
	 *             the part init exception
	 */
	@Override
	public void init(final IViewSite site) throws PartInitException {
		super.init(site);
		decorator = new LayeredDisplayDecorator(this);
		if (getOutput() != null) {
			getOutput().getData().addListener(decorator);
			setPartName(getOutput().getName());
		}
		shellListener = new ControlListener() {

			@Override
			public void controlResized(final ControlEvent e) {
				computeHiDPI();
			}

			@Override
			public void controlMoved(final ControlEvent e) {
				computeHiDPI();
			}
		};
		site.getShell().addControlListener(shellListener);
	}

	/**
	 * Adds the output.
	 *
	 * @param out
	 *            the out
	 */
	@Override
	public void addOutput(final IDisplayOutput out) {

		if (out == getOutput()) return; // Check if it is ok in terms of relaunch
		// DEBUG.OUT("Adding Output " + out.getName());
		super.addOutput(out);
		if (out instanceof LayeredDisplayOutput) {
			final IScope scope = out.getScope();
			if (scope != null && scope.getSimulation() != null) {
				final ITopLevelAgent root = scope.getRoot();
				final Color color = root.getColor();
				this.setTitleImage(GamaIcon.ofColor(GamaColors.get(color), true).image());
			}
		}

	}

	/**
	 * Checks if is open GL.
	 *
	 * @return true, if is open GL
	 */
	public boolean isOpenGL() { return false; }

	/**
	 * Gets the display manager.
	 *
	 * @return the display manager
	 */
	public ILayerManager getDisplayManager() { return getDisplaySurface().getManager(); }

	/**
	 * Gets the surface composite.
	 *
	 * @return the surface composite
	 */
	public Composite getSurfaceComposite() { return surfaceComposite; }

	/**
	 * The Class CentralPanel.
	 */

	public class CentralPanel extends Composite implements InnerComponent {

		/**
		 * Instantiates a new central panel.
		 *
		 * @param parent
		 *            the parent
		 * @param style
		 *            the style
		 */
		public CentralPanel(final Composite c) {
			super(c, GamaPreferences.Displays.CORE_DISPLAY_BORDER.getValue() ? SWT.BORDER : SWT.NONE);
			setLayout(emptyLayout());
			setLayoutData(fullData());
			setParentComposite(this);
		}

		/**
		 * Gets the view.
		 *
		 * @return the view
		 */
		@Override
		public LayeredDisplayView getView() { return LayeredDisplayView.this; }

	}

	/**
	 * Own create part control.
	 *
	 * @param c
	 *            the c
	 */
	@Override
	public void ownCreatePartControl(final Composite c) {
		if (getOutput() == null) return;
		c.setLayout(emptyLayout());
		centralPanel = new CentralPanel(c);
		createSurfaceComposite(centralPanel);
		surfaceComposite.setLayoutData(fullData());
		decorator.createDecorations();
		c.requestLayout();
	}

	/**
	 * Gets the multi listener.
	 *
	 * @return the multi listener
	 */
	public IDisposable getMultiListener() {
		return new SWTLayeredDisplayMultiListener(decorator, getDisplaySurface());
	}

	/**
	 * Empty layout.
	 *
	 * @return the grid layout
	 */
	Layout emptyLayout() {
		// return new FillLayout(SWT.VERTICAL);
		final GridLayout gl = new GridLayout(1, true);
		gl.horizontalSpacing = 0;
		gl.marginHeight = 0;
		gl.marginWidth = 0;
		gl.verticalSpacing = 0;
		return gl;
	}

	/**
	 * Full data.
	 *
	 * @return the grid data
	 */
	GridData fullData() {
		return new GridData(SWT.FILL, SWT.FILL, true, true);
	}

	/**
	 * Creates the surface composite.
	 *
	 * @param parent
	 *            the parent
	 * @return the composite
	 */
	protected abstract Composite createSurfaceComposite(Composite parent);

	@Override
	public LayeredDisplayOutput getOutput() { return (LayeredDisplayOutput) super.getOutput(); }

	@Override
	public IDisplaySurface getDisplaySurface() {
		final LayeredDisplayOutput out = getOutput();
		if (out != null) return out.getSurface();
		return null;
	}

	/**
	 * Widget disposed.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void widgetDisposed(final DisposeEvent e) {
		if (disposed) return;
		final LayeredDisplayOutput output = getOutput();
		if (output != null) {
			output.getData().listeners.clear();
			final IDisplaySurface s = output.getSurface();
			if (isOpenGL() && s != null) {
				s.dispose();
				output.setSurface(null);
			}
			output.releaseView();
			output.setSurface(null);
		}

		disposed = true;
		if (surfaceComposite != null) {
			try {
				surfaceComposite.dispose();
			} catch (final RuntimeException ex) {

			}
		}
		if (decorator != null) { decorator.dispose(); }
		super.widgetDisposed(e);
	}

	/**
	 * Pause changed.
	 */
	@Override
	public void pauseChanged() {
		decorator.updateOverlay();
	}

	/**
	 * Force overlay visibility.
	 *
	 * @return true, if successful
	 */
	public boolean forceOverlayVisibility() {
		return false;
	}

	/**
	 * Zoom in.
	 */
	@Override
	public void zoomIn() {
		if (getDisplaySurface() != null) { getDisplaySurface().zoomIn(); }
	}

	/**
	 * Zoom out.
	 */
	@Override
	public void zoomOut() {
		if (getDisplaySurface() != null) { getDisplaySurface().zoomOut(); }
	}

	/**
	 * Zoom fit.
	 */
	@Override
	public void zoomFit() {
		if (getDisplaySurface() != null) { getDisplaySurface().zoomFit(); }
	}

	/**
	 * Gets the zoomable controls.
	 *
	 * @return the zoomable controls
	 */
	@Override
	public Control[] getZoomableControls() { return new Control[] { getParentComposite() }; }

	/**
	 * Creates the update job.
	 *
	 * @return the job
	 */
	@Override
	protected Job createUpdateJob() {
		return new Job(getTitle()) {

			@Override
			protected IStatus run(final IProgressMonitor monitor) {
				final IDisplaySurface surface = getDisplaySurface();
				if (surface != null && !disposed && !surface.isDisposed()) {
					try {
						surface.updateDisplay(false);
					} catch (Exception e) {
						DEBUG.OUT("Error when updating " + getTitle() + ": " + e.getMessage());
					}
				}
				return Status.OK_STATUS;
			}
		};
	}

	/**
	 * Update.
	 *
	 * @param output
	 *            the output
	 */
	@Override
	public void update(final IDisplayOutput output) {
		super.update(output);
		updateSnapshot();
	}

	/**
	 * Update snapshot.
	 */
	private void updateSnapshot() {
		if (disposed) return;
		final IDisplaySurface surface = getDisplaySurface();
		if (surface == null || surface.isDisposed()) return;
		if (surface.getScope().getClock().getCycle() > 0 && surface.getData().isAutosave()) {
			WorkbenchHelper.run(() -> takeSnapshot(surface.getData().getImageDimension()));
		}
	}

	/**
	 * Zoom when scrolling.
	 *
	 * @return true, if successful
	 */
	@Override
	public boolean zoomWhenScrolling() {
		return true;
	}

	/**
	 * Removes the output.
	 *
	 * @param output
	 *            the output
	 */
	@Override
	public void removeOutput(final IDisplayOutput output) {
		if (output == null) return;
		if (output == getOutput() && isFullScreen()) { WorkbenchHelper.run(decorator::toggleFullScreen); }
		output.dispose();
		outputs.remove(output);
		if (outputs.isEmpty()) { close(GAMA.getRuntimeScope()); }
	}

	@Override
	public boolean isFullScreen() { return decorator.isFullScreen(); }

	@Override
	public void toggleOverlay() {
		decorator.toggleOverlay();
	}

	@Override
	public void toggleFullScreen() {
		decorator.toggleFullScreen();
	}

	/**
	 * Creates the tool items.
	 *
	 * @param tb
	 *            the tb
	 */
	@Override
	public void createToolItems(final GamaToolbar2 tb) {
		super.createToolItems(tb);
		decorator.createToolItems(tb);
	}

	@Override
	public void showOverlay(final boolean show) {
		decorator.overlay.setVisible(show);
	}

	@Override
	public void takeSnapshot(final GamaPoint customDimensions) {
		GAMA.getSnapshotMaker().takeAndSaveSnapshot(getDisplaySurface(), customDimensions);
	}

	/**
	 * Gets the interaction control.
	 *
	 * @return the interaction control
	 */
	public Control getInteractionControl() { return getZoomableControls()[0]; }

	/**
	 * Close.
	 *
	 * @param scope
	 *            the scope
	 */
	@Override
	public void close(final IScope scope) {
		if (closing) return;
		closing = true;
		WorkbenchHelper.asyncRun(() -> {
			try {
				IDisplaySurface surface = getDisplaySurface();
				if (surface != null) { surface.dispose(); }
				ViewsHelper.hideView(this);
			} catch (final Exception e) {}
		});

	}

	/**
	 * Dispose.
	 */
	@Override
	public void dispose() {
		WorkbenchHelper.run(() -> {
			if (getSite() != null) { getSite().getShell().removeControlListener(shellListener); }
			super.dispose();
		});

	}

	/**
	 * Checks if is visible.
	 *
	 * @return true, if is visible
	 */
	@Override
	public boolean isVisible() {
		IDisplaySurface surface = getDisplaySurface();
		return surface != null && surface.isVisible() || isFullScreen();
	}

	/**
	 * Checks if is esc refefined.
	 *
	 * @return true, if is esc refefined
	 */
	@Override
	public boolean isEscRedefined() {
		IDisplaySurface surface = getDisplaySurface();
		return surface != null && surface.isEscRedefined();
	}

	/**
	 * Toggle lock.
	 */
	@Override
	public void toggleLock() {
		if (getDisplaySurface() != null) { getDisplaySurface().toggleLock(); }
	}

	/**
	 * Compute hi DPI.
	 *
	 * @return true, if successful
	 */
	public void computeHiDPI() {
		Monitor monitor = ViewsHelper.getMonitorOf(this);
		isHiDPI = monitor == null ? false : monitor.getZoom() > 100;
	}

	@Override
	public boolean isHiDPI() { return isHiDPI; }

}
