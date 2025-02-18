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
	static FileInputStream file;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public static String readUsernameFromExcel(int rowIndex, int cellIndex, String sheetName) throws IOException {
		file = new FileInputStream(Constants.TEST_DATE_FILE);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(rowIndex);
		XSSFCell cell = row.getCell(cellIndex);
		return cell.getStringCellValue();
		
	}

	public static String readPasswordFromExcel(int rowIndex, int cellIndex, String sheetName) throws IOException {
		file = new FileInputStream(Constants.TEST_DATE_FILE);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(rowIndex);
		XSSFCell cell = row.getCell(cellIndex);
		return cell.getStringCellValue();
	}

}
