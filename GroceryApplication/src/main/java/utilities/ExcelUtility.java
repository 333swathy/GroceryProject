package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;

public class ExcelUtility {
	static FileInputStream file;//belong to the class and do not require object creation.
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public static String readStringDataFromExcel(int rowIndex, int cellIndex, String sheetName) throws IOException {
		file = new FileInputStream(Constants.TEST_DATE_FILE);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(rowIndex);
		XSSFCell cell = row.getCell(cellIndex);
		return cell.getStringCellValue();

	}

	public static String readIntegerDataFromExcel(int rowIndex, int cellIndex, String sheetName) throws IOException {
		file = new FileInputStream(Constants.TEST_DATE_FILE);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(rowIndex);
		XSSFCell cell = row.getCell(cellIndex);
		int value = (int) cell.getNumericCellValue();
		return String.valueOf(value);
	}

}
