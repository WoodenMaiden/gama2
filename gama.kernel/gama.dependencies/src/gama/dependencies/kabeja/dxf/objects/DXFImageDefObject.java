/*******************************************************************************************************
 *
 * DXFImageDefObject.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.dxf.objects;

import gama.dependencies.kabeja.dxf.DXFConstants;


/**
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 *
 */
public class DXFImageDefObject extends DXFObject {
    protected String filename;

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.dxf.objects.DXFObject#getObjectType()
     */
    public String getObjectType() {
        return DXFConstants.OBJECT_TYPE_IMAGEDEF;
    }

    /**
     * @return Returns the filename.
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename The filename to set.
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }
}
