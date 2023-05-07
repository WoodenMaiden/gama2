/*******************************************************************************************************
 *
 * DXFShape.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.dxf;

import java.util.Map;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import gama.dependencies.kabeja.dxf.helpers.Point;
import gama.dependencies.kabeja.math.TransformContext;


/**
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 *
 */
public class DXFShape extends DXFEntity {
    protected Point insertPoint = new Point();
    protected double rotation = 0.0;
    protected double height = 0.0;
    protected double scaleFactor = 1.0;
    protected double obliqueAngle = 0.0;
    protected String name = "";

    /* (non-Javadoc)
     * @see org.kabeja.dxf.DXFEntity#toSAX(org.xml.sax.ContentHandler, java.util.Map)
     */
    public void toSAX(ContentHandler handler, Map svgContext, DXFEntity entity,
        TransformContext transformContext) throws SAXException {
    }

    /* (non-Javadoc)
     * @see org.kabeja.dxf.DXFEntity#getBounds()
     */
    public Bounds getBounds() {
        Bounds bounds = new Bounds();
        bounds.setValid(false);

        return bounds;
    }

    /* (non-Javadoc)
     * @see org.kabeja.dxf.DXFEntity#getType()
     */
    public String getType() {
        return DXFConstants.ENTITY_TYPE_SHAPE;
    }

    /**
     * @return Returns the height.
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height The height to set.
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return Returns the insertPoint.
     */
    public Point getInsertPoint() {
        return insertPoint;
    }

    /**
     * @param insertPoint The insertPoint to set.
     */
    public void setInsertPoint(Point insertPoint) {
        this.insertPoint = insertPoint;
    }

    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Returns the obliqueAngle.
     */
    public double getObliqueAngle() {
        return obliqueAngle;
    }

    /**
     * @param obliqueAngle The obliqueAngle to set.
     */
    public void setObliqueAngle(double obliqueAngle) {
        this.obliqueAngle = obliqueAngle;
    }

    /**
     * @return Returns the rotation.
     */
    public double getRotation() {
        return rotation;
    }

    /**
     * @param rotation The rotation to set.
     */
    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    /**
     * @return Returns the scaleFactor.
     */
    public double getScaleFactor() {
        return scaleFactor;
    }

    /**
     * @param scaleFactor The scaleFactor to set.
     */
    public void setScaleFactor(double scaleFactor) {
        this.scaleFactor = scaleFactor;
    }

    public double getLength() {
        return 0;
    }
}
