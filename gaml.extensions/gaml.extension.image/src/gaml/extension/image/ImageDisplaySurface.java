/*******************************************************************************************************
 *
 * ImageDisplaySurface.java, in gaml.extension.image, is part of the source code of the GAMA modeling and simulation
 * platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 *
 ********************************************************************************************************/
package gaml.extension.image;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Collection;
import java.util.Collections;

import org.locationtech.jts.geom.Envelope;

import gama.annotations.common.interfaces.IKeyword;
import gama.annotations.precompiler.GamlAnnotations.display;
import gama.annotations.precompiler.GamlAnnotations.doc;
import gama.core.common.interfaces.IDisplaySurface;
import gama.core.common.interfaces.IGraphics;
import gama.core.common.interfaces.ILayer;
import gama.core.common.interfaces.ILayerManager;
import gama.core.common.preferences.GamaPreferences;
import gama.core.metamodel.agent.IAgent;
import gama.core.metamodel.shape.GamaPoint;
import gama.core.metamodel.shape.IShape;
import gama.core.outputs.LayeredDisplayData;
import gama.core.outputs.LayeredDisplayData.Changes;
import gama.core.outputs.LayeredDisplayOutput;
import gama.core.outputs.display.AWTDisplayGraphics;
import gama.core.outputs.display.LayerManager;
import gama.core.outputs.layers.IEventLayerListener;
import gama.core.runtime.GAMA;
import gama.core.runtime.IScope.IGraphicsScope;
import gama.core.util.GamaListFactory;
import gama.core.util.IList;
import gama.dev.DEBUG;

/**
 * The Class ImageDisplaySurface.
 */

/**
 * The Class ImageDisplaySurface.
 */
@display (
		value = IKeyword.IMAGE)
@doc ("A display used to save the graphical representations of agents into image files")
public class ImageDisplaySurface implements IDisplaySurface {

	/** The null point. */
	static GamaPoint NULL_POINT = new GamaPoint.Immutable();

	/** The output. */
	private final LayeredDisplayOutput output;

	/** The buff image. */
	private GamaImage bufferImage = null;

	/** The height. */
	private int width = 500, height = 500;

	/** The display graphics. */
	private IGraphics displayGraphics;

	/** The manager. */
	ILayerManager manager;

	/** The scope. */
	protected IGraphicsScope scope;

	/** The data. */
	private final LayeredDisplayData data;

	/**
	 * Instantiates a new image display surface.
	 *
	 * @param args
	 *            the args
	 */
	public ImageDisplaySurface(final Object... args) {
		output = (LayeredDisplayOutput) args[0];
		DEBUG.LOG("Image Display Surface created for simulation " + output.getScope().getSimulation());
		data = output.getData();
		resizeImage(width, height, true);

	}

	@Override
	public void outputReloaded() {
		this.scope = output.getScope().copyForGraphics("in image surface of " + output.getName());
		if (!GamaPreferences.Runtime.ERRORS_IN_DISPLAYS.getValue()) { scope.disableErrorReporting(); }
		if (manager == null) {
			manager = new LayerManager(this, output);
		} else {
			manager.outputChanged();
		}

	}

	/**
	 * Gets the scope.
	 *
	 * @return the scope
	 */
	@Override
	public IGraphicsScope getScope() { return scope; }

	/**
	 * Gets the manager.
	 *
	 * @return the manager
	 */
	@Override
	public ILayerManager getManager() { return manager; }

	/**
	 * Resize image.
	 *
	 * @param newWidth
	 *            the new width
	 * @param newHeight
	 *            the new height
	 * @param force
	 *            the force
	 * @return true, if successful
	 */
	public boolean resizeImage(final int newWidth, final int newHeight, final boolean force) {
		if (!force && width == newWidth && height == newHeight) return false;
		this.width = newWidth;
		this.height = newHeight;
		final Image copy = bufferImage;
		bufferImage = GamaImage.ofDimensions(width, height);
		final var g2 = bufferImage.createGraphics();
		if (displayGraphics != null) { displayGraphics.dispose(); }
		displayGraphics = new AWTDisplayGraphics(g2);
		((AWTDisplayGraphics) displayGraphics).setUntranslatedGraphics2D(bufferImage.createGraphics());
		displayGraphics.setDisplaySurface(this);
		if (getScope() != null && getScope().isPaused()) {
			updateDisplay(true);
		} else if (copy != null) { g2.drawImage(copy, 0, 0, newWidth, newHeight, null); }
		if (copy != null) { copy.flush(); }
		return true;
	}

	/**
	 * Update display.
	 *
	 * @param force
	 *            the force
	 */
	@Override
	public void updateDisplay(final boolean force) {
		drawAllDisplays();
	}

	/**
	 * Draw all displays.
	 */
	private void drawAllDisplays() {
		if (displayGraphics == null) return;
		displayGraphics.fillBackground(data.getBackgroundColor());
		manager.drawLayersOn(displayGraphics);
	}

	/**
	 * Dispose.
	 */
	@Override
	public void dispose() {
		if (displayGraphics != null) { displayGraphics.dispose(); }
		if (bufferImage != null) { bufferImage.flush(); }
		if (manager != null) { manager.dispose(); }
		GAMA.releaseScope(scope);
	}

	/**
	 * Gets the image.
	 *
	 * @param w
	 *            the w
	 * @param h
	 *            the h
	 * @return the image
	 */
	@Override
	public GamaImage getImage(final int w, final int h) {
		DEBUG.LOG("Asking to snapshot step " + scope.getClock().getCycle() + "  from " + Thread.currentThread()
				+ " in simulation " + scope.getSimulation().getIndex());
		setSize(w, h);
		drawAllDisplays();
		return bufferImage;
	}

	/**
	 * Zoom in.
	 */

	@Override
	public void zoomIn() {

	}

	/**
	 * Zoom out.
	 */

	@Override
	public void zoomOut() {

	}

	/**
	 * Zoom fit.
	 */

	@Override
	public void zoomFit() {

	}

	/**
	 * Toggle lock.
	 */
	@Override
	public void toggleLock() {}

	/**
	 * Focus on.
	 *
	 * @param geometry
	 *            the geometry
	 */
	@Override
	public void focusOn(final IShape geometry) {

	}

	/**
	 * @see gama.common.interfaces.IDisplaySurface#getWidth()
	 */
	@Override
	public int getWidth() { return width; }

	/**
	 * @see gama.common.interfaces.IDisplaySurface#getHeight()
	 */
	@Override
	public int getHeight() { return height; }

	/**
	 * Adds the listener.
	 *
	 * @param e 
	 *            the e
	 */
	@Override
	public void addListener(final IEventLayerListener e) {}

	/**
	 * Gets the env width.
	 *
	 * @return the env width
	 */
	@Override
	public double getEnvWidth() { return data.getEnvWidth(); }

	/**
	 * Gets the env height.
	 *
	 * @return the env height
	 */
	@Override
	public double getEnvHeight() { return data.getEnvHeight(); }

	/**
	 * Gets the display width.
	 *
	 * @return the display width
	 */
	@Override
	public double getDisplayWidth() { return this.getWidth(); }

	/**
	 * Gets the display height.
	 *
	 * @return the display height
	 */
	@Override
	public double getDisplayHeight() { return this.getHeight(); }

	/**
	 * Method getModelCoordinates()
	 *
	 * @see gama.common.interfaces.IDisplaySurface#getModelCoordinates()
	 */
	@Override
	public GamaPoint getModelCoordinates() { return null; }

	/**
	 * Method getZoomLevel()
	 *
	 * @see gama.common.interfaces.IDisplaySurface#getZoomLevel()
	 */
	@Override
	public double getZoomLevel() { return 1.0; }

	/**
	 * Method setSize()
	 *
	 * @see gama.common.interfaces.IDisplaySurface#setSize(int, int)
	 */
	@Override
	public void setSize(final int x, final int y) {
		resizeImage(x, y, false);
	}

	/**
	 * Method removeMouseListener()
	 *
	 * @see gama.common.interfaces.IDisplaySurface#removeMouseListener(java.awt.event.MouseListener)
	 */
	@Override
	public void removeListener(final IEventLayerListener e) {}

	/**
	 * Gets the layer listeners.
	 *
	 * @return the layer listeners
	 */
	@Override
	public Collection<IEventLayerListener> getLayerListeners() { return Collections.EMPTY_LIST; }

	/**
	 * Gets the model coordinates from.
	 *
	 * @param xOnScreen
	 *            the x on screen
	 * @param yOnScreen
	 *            the y on screen
	 * @param sizeInPixels
	 *            the size in pixels
	 * @param positionInPixels
	 *            the position in pixels
	 * @return the model coordinates from
	 */
	@Override
	public GamaPoint getModelCoordinatesFrom(final int xOnScreen, final int yOnScreen, final Point sizeInPixels,
			final Point positionInPixels) {
		return ImageDisplaySurface.NULL_POINT;
	}

	/**
	 * Select agent.
	 *
	 * @param xc
	 *            the xc
	 * @param yc
	 *            the yc
	 * @return the i list
	 */
	@Override
	public IList<IAgent> selectAgent(final int xc, final int yc) {
		return GamaListFactory.EMPTY_LIST;
	}

	/**
	 * Method getOutput()
	 *
	 * @see gama.common.interfaces.IDisplaySurface#getOutput()
	 */
	@Override
	public LayeredDisplayOutput getOutput() { return output; }

	/**
	 * Method waitForUpdateAndRun()
	 *
	 * @see gama.common.interfaces.IDisplaySurface#waitForUpdateAndRun(java.lang.Runnable)
	 */
	@Override
	public void runAndUpdate(final Runnable r) {
		r.run();
	}

	/**
	 * Method getData()
	 *
	 * @see gama.common.interfaces.IDisplaySurface#getData()
	 */
	@Override
	public LayeredDisplayData getData() { return data; }

	/**
	 * Method layersChanged()
	 *
	 * @see gama.common.interfaces.IDisplaySurface#layersChanged()
	 */
	@Override
	public void layersChanged() {}

	@Override
	public void changed(final Changes property, final Object value) {}

	@Override
	public Envelope getVisibleRegionForLayer(final ILayer currentLayer) {
		return null;
	}

	/**
	 * Method getFPS()
	 *
	 * @see gama.common.interfaces.IDisplaySurface#getFPS()
	 */
	@Override
	public int getFPS() { return 0; }

	/**
	 * Checks if is disposed.
	 *
	 * @return true, if is disposed
	 */
	@Override
	public boolean isDisposed() { return false; }

	/**
	 * Gets the model coordinates info.
	 *
	 * @param sb
	 *            the sb
	 * @return the model coordinates info
	 */
	@Override
	public void getModelCoordinatesInfo(final StringBuilder sb) {}

	/**
	 * Dispatch key event.
	 *
	 * @param character
	 *            the character
	 */
	@Override
	public void dispatchKeyEvent(final char character) {}

	/**
	 * Dispatch special key event.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void dispatchSpecialKeyEvent(final int e) {}

	/**
	 * Dispatch mouse event.
	 *
	 * @param swtEventType
	 *            the swt event type
	 */
	@Override
	public void dispatchMouseEvent(final int swtEventType, final int x, final int y) {}

	/**
	 * Sets the mouse position.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	@Override
	public void setMousePosition(final int x, final int y) {}

	/**
	 * Dragged to.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	@Override
	public void draggedTo(final int x, final int y) {}

	/**
	 * Select agents around mouse.
	 */
	@Override
	public void selectAgentsAroundMouse() {}

	/**
	 * Sets the menu manager.
	 *
	 * @param displaySurfaceMenu
	 *            the new menu manager
	 */
	@Override
	public void setMenuManager(final Object displaySurfaceMenu) {}

	/**
	 * Checks if is visible.
	 *
	 * @return true, if is visible
	 */
	@Override
	public boolean isVisible() { return true; }

	/**
	 * Gets the i graphics.
	 *
	 * @return the i graphics
	 */
	@Override
	public IGraphics getIGraphics() { return displayGraphics; }

	/**
	 * Gets the bounds for robot snapshot.
	 *
	 * @return the bounds for robot snapshot
	 */
	@Override
	public Rectangle getBoundsForRobotSnapshot() { return new Rectangle(0, 0, width, height); }

	/**
	 * Should wait to become rendered.
	 *
	 * @return true, if successful
	 */
	@Override
	public boolean shouldWaitToBecomeRendered() {
		return false;
	}

}
