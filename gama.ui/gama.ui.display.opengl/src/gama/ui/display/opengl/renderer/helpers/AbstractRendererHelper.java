/*******************************************************************************************************
 *
 * AbstractRendererHelper.java, in gama.ui.display.opengl, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.display.opengl.renderer.helpers;

import com.jogamp.opengl.GL2;

import gama.ui.display.opengl.OpenGL;
import gama.ui.display.opengl.renderer.IOpenGLRenderer;
import gama.ui.display.opengl.view.GamaGLCanvas;
import gama.ui.display.opengl.view.SWTOpenGLDisplaySurface;
import gama.core.outputs.LayeredDisplayData;

/**
 * The Class AbstractRendererHelper.
 */
public abstract class AbstractRendererHelper {

	/**
	 * The Interface Pass.
	 */
	public interface Pass extends AutoCloseable {

		/**
		 * Close.
		 */
		@Override
		void close();

	}

	/** The renderer. */
	protected final IOpenGLRenderer renderer;

	/** The data. */
	protected final LayeredDisplayData data;

	/**
	 * Instantiates a new abstract renderer helper.
	 *
	 * @param renderer
	 *            the renderer
	 */
	public AbstractRendererHelper(final IOpenGLRenderer renderer) {
		this.renderer = renderer;
		this.data = renderer.getData();
	}

	/**
	 * Gets the renderer.
	 *
	 * @return the renderer
	 */
	public IOpenGLRenderer getRenderer() { return renderer; }

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	protected LayeredDisplayData getData() { return data; }

	/**
	 * Gets the gl.
	 *
	 * @return the gl
	 */
	protected GL2 getGL() { return renderer.getOpenGLHelper().getGL(); }

	/**
	 * Gets the open GL.
	 *
	 * @return the open GL
	 */
	protected OpenGL getOpenGL() { return renderer.getOpenGLHelper(); }

	/**
	 * Gets the canvas.
	 *
	 * @return the canvas
	 */
	protected GamaGLCanvas getCanvas() { return renderer.getCanvas(); }

	/**
	 * Gets the surface.
	 *
	 * @return the surface
	 */
	protected SWTOpenGLDisplaySurface getSurface() { return renderer.getSurface(); }

	/**
	 * Gets the max env dim.
	 *
	 * @return the max env dim
	 */
	public double getMaxEnvDim() { return renderer.getMaxEnvDim(); }

	/**
	 * Gets the z near.
	 *
	 * @return the z near
	 */
	public double getZNear() { return data.getzNear(); }

	/**
	 * Gets the z far.
	 *
	 * @return the z far
	 */
	public double getZFar() { return data.getzFar(); }

	/**
	 * Initialize.
	 */
	public abstract void initialize();

}
