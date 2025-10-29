package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	private String path;

	// constructor for ExcelUtil

	public ExcelUtil(String path) {
		this.path = path;
	}

	// method to get row count from an excel sheet

	public int getRowCount(String sheetName) throws IOException {
		try (FileInputStream fi = new FileInputStream(path); XSSFWorkbook workbook = new XSSFWorkbook(fi)) {
			XSSFSheet sheet = workbook.getSheet(sheetName);
			return (sheet != null) ? sheet.getLastRowNum() : 0;
		}

	}

	// method to get cell count from a row

	public int getCellCount(String sheetName, int rownum) throws IOException {
		try (FileInputStream fi = new FileInputStream(path); XSSFWorkbook workbook = new XSSFWorkbook(fi)) {
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row = (sheet != null) ? sheet.getRow(rownum) : null;
			return (row != null) ? row.getLastCellNum() : 0;
		}
	}

	// method to get cell data from a particular row and column

	public String getCellData(String sheetName, int rownum, int colnum) throws IOException {
		try (FileInputStream fi = new FileInputStream(path); XSSFWorkbook workbook = new XSSFWorkbook(fi)) {

			XSSFSheet sheet = workbook.getSheet(sheetName);
			if (sheet == null)
				return "";

			XSSFRow row = sheet.getRow(rownum);
			if (row == null)
				return "";

			XSSFCell cell = row.getCell(colnum);
			if (cell == null)
				return "";

			DataFormatter formatter = new DataFormatter();
			return formatter.formatCellValue(cell);
		}
	}

	// method to write data into a cell of a workbook

	public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException {
		File file = new File(path);
		XSSFWorkbook workbook;

		// Open or create workbook
		if (file.exists()) {
			try (FileInputStream fi = new FileInputStream(file)) {
				workbook = new XSSFWorkbook(fi);
			}
		} else {
			workbook = new XSSFWorkbook();
		}

		// Create or get sheet
		XSSFSheet sheet = workbook.getSheet(sheetName);
		if (sheet == null)
			sheet = workbook.createSheet(sheetName);

		// Create or get row
		XSSFRow row = sheet.getRow(rownum);
		if (row == null)
			row = sheet.createRow(rownum);

		// Create cell and set value
		XSSFCell cell = row.createCell(colnum);
		cell.setCellValue(data);

		// Write changes to file
		try (FileOutputStream fo = new FileOutputStream(file)) {
			workbook.write(fo);
		}

		workbook.close();

	}

	// method to fill green color into a cell

	public void fillGreenColor(String sheetName, int rowNum, int colNum) throws IOException {
		fillCellColor(sheetName, rowNum, colNum, IndexedColors.GREEN);
	}
	// method to fill red color into a cell

	public void fillRedColor(String sheetName, int rowNum, int colNum) throws IOException {
		fillCellColor(sheetName, rowNum, colNum, IndexedColors.RED);
	}

	// Private helper to fill cell color
	private void fillCellColor(String sheetName, int rowNum, int colNum, IndexedColors color) throws IOException {
		try (FileInputStream fi = new FileInputStream(path);
				XSSFWorkbook workbook = new XSSFWorkbook(fi);
				FileOutputStream fo = new FileOutputStream(path)) {

			XSSFSheet sheet = workbook.getSheet(sheetName);
			if (sheet == null)
				return;

			XSSFRow row = sheet.getRow(rowNum);
			if (row == null)
				return;

			XSSFCell cell = row.getCell(colNum);
			if (cell == null)
				return;

			CellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(color.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell.setCellStyle(style);

			workbook.write(fo);
		}
	}
}
