/*******************************************************************************************************
 *
 * ViewFilter.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.processing;

import java.util.Iterator;
import java.util.Map;

import gama.dependencies.kabeja.dxf.Bounds;
import gama.dependencies.kabeja.dxf.DXFDocument;
import gama.dependencies.kabeja.dxf.DXFEntity;
import gama.dependencies.kabeja.dxf.DXFLayer;
import gama.dependencies.kabeja.dxf.DXFView;


/**
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 */
public class ViewFilter extends AbstractPostProcessor {
    public static final String CONTEXT_OPTION_VIEW_NAME = "view.name";

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.tools.PostProcessor#process(de.miethxml.kabeja.dxf.DXFDocument)
     */
    public void process(DXFDocument doc, Map context) throws ProcessorException {
        // get the active viewport
        DXFView view = null;
        Iterator i = doc.getDXFViewIterator();

        if (context.containsKey(CONTEXT_OPTION_VIEW_NAME)) {
            String name = (String) context.get(CONTEXT_OPTION_VIEW_NAME);

            boolean found = false;

            while (i.hasNext() && !found) {
                DXFView v = (DXFView) i.next();

                if (v.getName().trim().equals(name.trim())) {
                    view = v;
                    found = true;
                }
            }
        } else if (i.hasNext()) {
            // get the first view
            view = (DXFView) i.next();
        }

        if (view != null) {
            double w = view.getWidth() / 2;
            double h = view.getHeight() / 2;
            Bounds b = new Bounds();

            // the upper right corner
            b.addToBounds(view.getCenterPoint().getX() + w,
                view.getCenterPoint().getY() + h, view.getCenterPoint().getZ());

            // the lower left corner
            b.addToBounds(view.getCenterPoint().getX() - w,
                view.getCenterPoint().getY() - h, view.getCenterPoint().getZ());
            filterEntities(b, doc);
        }
    }

    protected void filterEntities(Bounds b, DXFDocument doc) {
        Iterator i = doc.getDXFLayerIterator();

        while (i.hasNext()) {
            DXFLayer l = (DXFLayer) i.next();
            Iterator ti = l.getDXFEntityTypeIterator();

            while (ti.hasNext()) {
                String type = (String) ti.next();
                Iterator ei = l.getDXFEntities(type).iterator();

                while (ei.hasNext()) {
                    DXFEntity entity = (DXFEntity) ei.next();
                    Bounds currentBounds = entity.getBounds();

                    if (!b.contains(currentBounds)) {
                        ei.remove();
                    }
                }
            }
        }
    }

    /* (non-Javadoc)
         * @see org.kabeja.tools.PostProcessor#setProperties(java.util.Map)
         */
    public void setProperties(Map properties) {
        
    }
}
