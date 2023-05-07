/*******************************************************************************************************
 *
 * ICsvFileModelListener.java, in gama.ui.viewers, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.viewers.csv.model;

/**
 *
 * @author fhenri
 *
 */
public interface ICsvFileModelListener {

    /**
     * Entry changed.
     *
     * @param row the row
     * @param rowIndex the row index
     */
    void entryChanged(CSVRow row, int rowIndex);

}
