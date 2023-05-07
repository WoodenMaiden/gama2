/*******************************************************************************************************
 *
 * DXFEntityHandler.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.parser.entities;

import gama.dependencies.kabeja.dxf.DXFDocument;
import gama.dependencies.kabeja.dxf.DXFEntity;
import gama.dependencies.kabeja.parser.DXFValue;
import gama.dependencies.kabeja.parser.Handler;


/**
 *
 * This interface descripe an Entity jandler, which should
 * handle (parse) an DXF entity.
 *
 * <h3>Lifecycle</h3>
 * <ol>
 * <li>setDXFDocument</li>
 * <li>startDXFEntity</li>
 * <li>parseGroup (multiple)</li>
 * <li>isFollowSequence (need for polylines, where multiple vertices follow)</li>
 * <li>endDXFEntity</li>
 * <li>getDXFEntity</li>
 * </lo>
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public interface DXFEntityHandler extends Handler {
    /**
     *
     * @return the DXFEntity name (LINE,POLYLINE,TEXT,...)
     */
    public abstract String getDXFEntityName();

    public void setDXFDocument(DXFDocument doc);

    /**
     * Will called if the entity block starts.
     *
     */
    public abstract void startDXFEntity();

    public abstract void parseGroup(int groupCode, DXFValue value);

    /**
     * Called after endDXFEntity.
     * @return the parsed Entity
     */
    public abstract DXFEntity getDXFEntity();

    /**
     * Will called if the entity block ends.
     *
     */
    public abstract void endDXFEntity();

    /**
     *
     * @return true if the this DXFEntityHandler have to parse the following entities (like POLYLINE),
     *  otherwise false (like TEXT,LINE).
     */
    public abstract boolean isFollowSequence();
}
