package utilities;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import constants.Constants;

public class DataProviders {

	/*
	 * this is the utility method which extracts data from excel and provides to
	 * test cases
	 */

	@DataProvider(name = "testData")
	public Object[][] getData(Method method) throws IOException {
		// get class name dynamically (each class = one sheet)
		String className = method.getDeclaringClass().getSimpleName();

		// determine which Excel file (module) to use based on class name
		String filePath = getExcelPathForClass(className);
		String sheetName = getSheetNameForClass(className);

		// Use ExcelUtility to read data
		ExcelUtil excelUtil = new ExcelUtil(filePath);

		int totalRows = excelUtil.getRowCount(sheetName);
		int totalCols = excelUtil.getCellCount(sheetName, 0);

		// get header (column names)
		List<String> headers = new ArrayList<>();
		for (int c = 0; c < totalCols; c++) {
			headers.add(excelUtil.getCellData(sheetName, 0, c));
		}

		List<Map<String, String>> allRows = new ArrayList<>();

		// Loop through rows (skip header)
		for (int i = 1; i <= totalRows; i++) {
			Map<String, String> rowData = new HashMap<>();
			boolean rowHasData = false;

			for (int j = 0; j < totalCols; j++) {
				String cellValue = excelUtil.getCellData(sheetName, i, j);
				if (!cellValue.trim().isEmpty()) {
					rowHasData = true;
				}
				rowData.put(headers.get(j), cellValue);
			}

			// Skip empty rows
			if (rowHasData) {
				allRows.add(rowData);
			}
		}

		// Convert List<Map> → Object[][]
		Object[][] data = new Object[allRows.size()][1];
		for (int i = 0; i < allRows.size(); i++) {
			data[i][0] = allRows.get(i);
		}

		return data;
	}

	// helper method : determines excel path based on class name
	private String getExcelPathForClass(String className) {
		switch (className) {
		case "TC_01":
		case "TC_05":
			return Constants.REGISTER_USER;
		case "TC_02":
		case "TC_03":
		case "TC_04":
			return Constants.LOGIN_USER;
		case "TC_06":
		case "TC_07":
			return Constants.CONTACT_US;
		case "TC_09":
		case "TC_10":
		case "TC_11":
		case "TC_20":
		case "TC_21":
		case "TC_23":
		case "TC_24":
			return Constants.PRODUCTS;
		case "TC_14":
		case "TC_15":
		case "TC_16":
			return Constants.BUY_PRODUCT;
		default:
			throw new RuntimeException("No Excel file defined for : " + className);
		}

	}

	// helper method : determines sheet name based on class name
	private String getSheetNameForClass(String className) {
		switch (className) {
		case "TC_01":
			return Constants.TC_01;
		case "TC_02":
			return Constants.TC_02;
		case "TC_03":
			return Constants.TC_03;
		case "TC_04":
			return Constants.TC_02;
		case "TC_05":
			return Constants.TC_05;
		case "TC_06":
			return Constants.TC_06;
		case "TC_07":
			return Constants.TC_07;
		case "TC_09":
			return Constants.TC_09;
		case "TC_10":
		case "TC_11":
			return Constants.TC_10;
		case "TC_14":
		case "TC_15":
			return Constants.TC_14;
		case "TC_16":
			return Constants.TC_16;
		case "TC_20":
			return Constants.TC_20;
		case "TC_21":
			return Constants.TC_21;
		case "TC_23":
			return Constants.TC_23;
		case "TC_24":
			return Constants.TC_24;
		default:
			throw new RuntimeException("No sheet defined for : " + className);
		}
	}

}
