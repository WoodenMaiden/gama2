/*******************************************************************************************************
 *
 * DXFMLineStyleElementDistanceComparator.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.dxf.helpers;

import java.util.Comparator;

import gama.dependencies.kabeja.dxf.objects.DXFMLineStyleElement;


public class DXFMLineStyleElementDistanceComparator implements Comparator {
    public int compare(Object arg0, Object arg1) {
        DXFMLineStyleElement el1 = (DXFMLineStyleElement) arg0;
        DXFMLineStyleElement el2 = (DXFMLineStyleElement) arg1;

        if (el1.getOffset() > el2.getOffset()) {
            return 1;
        } else if (el1.getOffset() < el2.getOffset()) {
            return -1;
        }

        return 0;
    }
}
