/*******************************************************************************************************
 *
 * DXFXLine.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.dxf;


/**
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 *
 */
public class DXFXLine extends DXFRay {
    public Bounds getBounds() {
        //the xline is a infinite straight line
        //so we omit the bounds
        Bounds bounds = new Bounds();
        bounds.setValid(false);

        return bounds;
    }

    public String getType() {
        return DXFConstants.ENTITY_TYPE_XLINE;
    }
}
