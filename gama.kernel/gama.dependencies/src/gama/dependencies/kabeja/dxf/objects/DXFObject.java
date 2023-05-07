/*******************************************************************************************************
 *
 * DXFObject.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.dxf.objects;

import gama.dependencies.kabeja.dxf.DXFDocument;


/**
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 *
 */
public abstract class DXFObject {
    protected DXFDocument doc;
    protected String softID;
    protected String hardID;
    protected String handleID;

    public String getSoftPointerID() {
        return softID;
    }

    public void setSoftPointerID(String id) {
        this.softID = id;
    }

    public String getHardOwnerID() {
        return hardID;
    }

    public void setHardOwnerID(String id) {
        this.hardID = id;
    }

    public void setDXFDocument(DXFDocument doc) {
        this.doc = doc;
    }

    public abstract String getObjectType();

    /**
     * @return Returns the handleID.
     */
    public String getID() {
        return handleID;
    }

    /**
     * @param handleID The handleID to set.
     */
    public void setID(String handleID) {
        this.handleID = handleID;
    }
}
