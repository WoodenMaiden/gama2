/*******************************************************************************************************
 *
 * DXFHeaderSectionHandler.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.parser;

import gama.dependencies.kabeja.dxf.DXFDocument;
import gama.dependencies.kabeja.dxf.DXFHeader;
import gama.dependencies.kabeja.dxf.DXFVariable;


/**
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 *
 */
public class DXFHeaderSectionHandler implements DXFSectionHandler {
    public final static int VARIABLE_CODE = 9;
    private final String sectionKey = "HEADER";
    private DXFDocument doc;
    private DXFVariable variable = null;
    private String mode;

    /* (non-Javadoc)
     * @see org.dxf2svg.parser.SectionHandler#getSectionKey()
     */
    public String getSectionKey() {
        return sectionKey;
    }

    /* (non-Javadoc)
     * @see org.dxf2svg.parser.SectionHandler#setDXFDocument(org.dxf2svg.xml.DXFDocument)
     */
    public void setDXFDocument(DXFDocument doc) {
        this.doc = doc;
    }

    /* (non-Javadoc)
     * @see org.dxf2svg.parser.SectionHandler#parseGroup(int, java.lang.String)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        if (groupCode == VARIABLE_CODE) {
            variable = new DXFVariable(value.getValue());
            doc.getDXFHeader().setVariable(variable);
        } else {
            //handle the current mode
            parse(groupCode, value);
        }
    }

    private void parse(int code, DXFValue value) {
        variable.setValue("" + code, value.getValue());
    }

    /* (non-Javadoc)
     * @see org.dxf2svg.parser.SectionHandler#endParsing()
     */
    public void endSection() {
    }

    /* (non-Javadoc)
     * @see org.dxf2svg.parser.SectionHandler#startParsing()
     */
    public void startSection() {
        doc.setDXFHeader(new DXFHeader());
    }

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.parser.Handler#releaseDXFDocument()
     */
    public void releaseDXFDocument() {
        this.doc = null;
    }
}
