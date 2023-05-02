/*******************************************************************************************************
 *
 * CSVModel.java, in gama.ui.viewers, is part of the source code of the GAMA modeling and simulation platform (v.1.9.2).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.viewers.csv.model;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;

import gama.core.runtime.GAMA;
import gama.core.util.file.GamaCSVFile.CSVInfo;
import gama.core.util.file.IGamaFileMetaData;
import gama.core.util.file.csv.AbstractCSVManipulator;
import gama.core.util.file.csv.CsvReader;
import gama.core.util.file.csv.CsvWriter;
import gama.dev.DEBUG;
import gama.ui.shared.interfaces.IRefreshHandler;
import gama.ui.shared.utils.WorkbenchHelper;

/**
 *
 * @author fhenri
 *
 */
public class CSVModel implements IRowChangesListener {

	/** The display first line. */
	private final boolean displayFirstLine;

	/** The rows. */
	private final ArrayList<CSVRow> rows;

	/** The listeners. */
	private final ArrayList<ICsvFileModelListener> listeners;

	/** The file. */
	private final IFile file;

	/** The current info. */
	private CSVInfo currentInfo;

	/**
	 * Default constructor
	 */
	public CSVModel(final IFile file) {
		this.file = file;
		displayFirstLine = true;
		rows = new ArrayList<>();
		listeners = new ArrayList<>();
	}

	/**
	 * Check if first line in the file will be considered as the file header
	 *
	 * @return true if the first line in the file represents the header
	 */
	public boolean isFirstLineHeader() { return getInfo().header; }

	/**
	 * Sets the first line header.
	 *
	 * @param header
	 *            the new first line header
	 */
	public void setFirstLineHeader(final boolean header) {
		final CSVInfo info = getInfo();
		if (info.header != header) {
			info.header = header;
			saveMetaData();
		}
		// ResourceRefreshHandler.discardMetaData(file);
	}

	/**
	 * Get custom delimiter to use as a separator
	 *
	 * @return the delimiter
	 */
	public char getCustomDelimiter() { return getInfo().delimiter; }

	/**
	 * Sets the custom delimiter.
	 *
	 * @param c
	 *            the new custom delimiter
	 */
	public void setCustomDelimiter(final char c) {
		final CSVInfo info = getInfo();
		if (c == info.delimiter) return;
		info.delimiter = c;
		saveMetaData();
	}

	/**
	 * Gets the text qualifier.
	 *
	 * @return the text qualifier
	 */
	public Character getTextQualifier() { return AbstractCSVManipulator.getDefaultQualifier(); }

	/**
	 * @param text
	 */
	public void setInput(final String text) {
		readLines(text);
	}

	/**
	 * @param reader
	 * @return
	 */
	protected CsvReader initializeReader(final Reader reader) {
		final CsvReader csvReader = new CsvReader(reader);
		final char customDelimiter = getCustomDelimiter();
		csvReader.setDelimiter(customDelimiter);
		return csvReader;
	}

	/**
	 * Read lines.
	 *
	 * @param fileText
	 *            the file text
	 */
	protected void readLines(final String fileText) {
		readLines(new StringReader(fileText));
	}

	/**
	 * @param fileText
	 */
	protected void readLines(final Reader reader) {
		rows.clear();
		final CSVInfo info = getInfo();
		info.cols = 0;

		try (final CsvReader csvReader = initializeReader(reader)) {
			// case when the first line is the encoding
			if (!displayFirstLine) { csvReader.skipLine(); }

			boolean setHeader = false;
			while (csvReader.readRecord()) {
				final String[] rowValues = csvReader.getValues();
				if (rowValues.length > info.cols) { info.cols = rowValues.length; }
				final CSVRow csvRow = new CSVRow(rowValues, this);

				if (info.header && !setHeader) {
					setHeader = true;
					csvRow.setHeader(true);
					getInfo().headers = new String[getInfo().cols];
					for (int i = 0; i < getInfo().cols; i++) { getInfo().headers[i] = rowValues[i]; }
				}

				rows.add(csvRow);
			}
			if (!info.header) {
				getInfo().headers = new String[getInfo().cols];
				for (int i = 0; i < getInfo().cols; i++) { getInfo().headers[i] = "Column" + (i + 1); }
			}

			csvReader.close();
		} catch (final Exception e) {
			DEBUG.ERR("exception in readLines " + e);
			e.printStackTrace();
		}
		saveMetaData();
	}

	/**
	 * @return
	 */
	public List<String> getHeader() { return Arrays.asList(getInfo().headers); }

	/**
	 * @return
	 */
	public String[] getArrayHeader() { return getInfo().headers; }

	// ----------------------------------
	// Helper method on rows management
	// ----------------------------------

	/**
	 *
	 */
	public void addRow() {
		final CSVRow row = CSVRow.createEmptyLine(getInfo().cols, this);
		addRow(row);
	}

	/**
	 * @param row
	 */
	public void addRow(final CSVRow row) {
		rows.add(row);
		final CSVInfo info = getInfo();
		info.rows++;
		saveMetaData();

	}

	/**
	 * @param row
	 */
	public void addRowAfterElement(final CSVRow row) {
		final CSVInfo info = getInfo();
		final CSVRow newRow = CSVRow.createEmptyLine(info.cols, this);
		final int indexRow = findRow(row);

		if (indexRow != -1) {
			rows.add(indexRow, newRow);
			info.rows++;
		} else {
			addRow(newRow);
		}
		saveMetaData();
	}

	/**
	 * @param row
	 * @return
	 */
	public int findRow(final CSVRow findRow) {
		for (int i = 0; i <= getArrayRows(true).length; i++) {
			final CSVRow row = getRowAt(i);
			if (row.equals(findRow)) return i;
		}
		return -1;
	}

	/**
	 * @return
	 */
	public List<CSVRow> getRows() { return rows; }

	/**
	 * @return
	 */
	public Object[] getArrayRows(final boolean includeCommentLine) {
		// filter header and comment rows
		final ArrayList<CSVRow> myrows = new ArrayList<>();
		for (final CSVRow row : rows) {
			// should we return the comment line
			if (!row.isHeader()) { myrows.add(row); }
		}
		return myrows.toArray();
	}

	/**
	 * @param index
	 * @return
	 */
	public CSVRow getRowAt(final int index) {
		return rows.get(index);
	}

	/**
	 * @see org.fhsolution.eclipse.plugins.csvedit.model.IRowChangesListener#rowChanged(org.fhsolution.eclipse.plugins.csvedit.model.CSVRow,
	 *      int)
	 */
	@Override
	public void rowChanged(final CSVRow row, final int rowIndex) {
		for (final ICsvFileModelListener l : listeners) { l.entryChanged(row, rowIndex); }
	}

	/**
	 *
	 */
	public void removeRow(final CSVRow row) {
		if (!rows.remove(row)) return;
		// TODO return error message
		final CSVInfo info = getInfo();
		info.rows--;
		saveMetaData();
	}

	// ----------------------------------
	// Helper method on column management
	// ----------------------------------

	/**
	 * @param colName
	 */
	public void addColumn(final String colName) {
		final CSVInfo info = getInfo();
		info.cols++;
		info.headers = Arrays.copyOf(info.headers, info.headers.length + 1);
		info.headers[info.headers.length - 1] = colName;
		for (final CSVRow row : rows) { row.addElement(""); }
		saveMetaData();

	}

	/**
	 * @return
	 */
	public int getColumnCount() { return getInfo().cols; }

	/**
	 * Remove the column represented by the index
	 *
	 * @param colIndex
	 */
	public void removeColumn(final int colIndex) {
		final CSVInfo info = getInfo();
		if (info.header) {
			final ArrayList<String> cols = new ArrayList<>(Arrays.asList(info.headers));
			cols.remove(colIndex);
			info.headers = cols.toArray(new String[cols.size()]);
		}
		info.cols--;
		for (final CSVRow row : rows) { row.removeElementAt(colIndex); }
		saveMetaData();
	}

	/**
	 * Remove the column represented by its name
	 *
	 * @param colIndex
	 */
	public void removeColumn(final String columnName) {
		if (columnName == null) return;
		final List<String> cols = Arrays.asList(getInfo().headers);
		final int colIndex = cols.indexOf(columnName);
		removeColumn(colIndex);
	}

	/**
	 * @param csvFileListener
	 */
	public void removeModelListener(final ICsvFileModelListener csvFileListener) {
		listeners.remove(csvFileListener);
	}

	/**
	 * @param csvFileListener
	 */
	public void addModelListener(final ICsvFileModelListener csvFileListener) {
		if (!listeners.contains(csvFileListener)) { listeners.add(csvFileListener); }
	}

	/**
	 * Initialize the CsvWriter
	 *
	 * @param writer
	 * @return
	 */
	protected CsvWriter initializeWriter(final Writer writer) {
		final char delimiter = getCustomDelimiter();
		final CsvWriter csvWriter = new CsvWriter(writer, delimiter);
		csvWriter.setTextQualifier(getTextQualifier());
		return csvWriter;
	}

	/**
	 * @return
	 */
	public String getTextRepresentation() {

		try (final StringWriter sw = new StringWriter(); final CsvWriter clw = initializeWriter(sw);) {

			for (final CSVRow row : rows) { clw.writeRecord(row.getEntriesAsArray()); }
			return sw.toString();
		} catch (final Exception e) {
			DEBUG.ERR("cannot write csv file");
			return "";
		}

	}

	/**
	 *
	 */
	public void saveMetaData() {
		final IRefreshHandler refresh = WorkbenchHelper.getService(IRefreshHandler.class);
		if (refresh != null) { refresh.refreshResource(file); }
	}

	/**
	 * @return the info
	 */
	public CSVInfo getInfo() {
		if (currentInfo == null) {
			final IGamaFileMetaData metaData = GAMA.getGui().getMetaDataProvider().getMetaData(file, false, true);
			if (metaData instanceof CSVInfo) {
				currentInfo = (CSVInfo) metaData;
			} else {
				GAMA.getGui().getMetaDataProvider().storeMetaData(file, null, true);
				currentInfo = (CSVInfo) GAMA.getGui().getMetaDataProvider().getMetaData(file, false, true);
			}
		}
		return currentInfo;
	}
}
