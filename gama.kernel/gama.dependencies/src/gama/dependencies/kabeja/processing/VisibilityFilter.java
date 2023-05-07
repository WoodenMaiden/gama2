/*******************************************************************************************************
 *
 * VisibilityFilter.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.processing;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gama.dependencies.kabeja.dxf.DXFDocument;
import gama.dependencies.kabeja.dxf.DXFEntity;
import gama.dependencies.kabeja.dxf.DXFLayer;


/**
 * This postprocessor remove all invisible entities and layers.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 */
public class VisibilityFilter extends AbstractPostProcessor {
    /* (non-Javadoc)
     * @see org.kabeja.tools.PostProcessor#process(org.kabeja.dxf.DXFDocument)
     */
    public void process(DXFDocument doc, Map context) throws ProcessorException {
        Iterator i = doc.getDXFLayerIterator();

        while (i.hasNext()) {
            DXFLayer l = (DXFLayer) i.next();

            if (l.isVisible()) {
                Iterator inner = l.getDXFEntityTypeIterator();

                while (inner.hasNext()) {
                    String type = (String) inner.next();
                    List entities = l.getDXFEntities(type);
                    Iterator ei = entities.iterator();

                    while (ei.hasNext()) {
                        DXFEntity entity = (DXFEntity) ei.next();

                        if (!entity.isVisibile()) {
                            ei.remove();
                        }
                    }
                }
            } else {
                i.remove();
            }
        }
    }

    /* (non-Javadoc)
     * @see org.kabeja.tools.PostProcessor#setProperties(java.util.Map)
     */
    public void setProperties(Map properties) {
        
    }
}
