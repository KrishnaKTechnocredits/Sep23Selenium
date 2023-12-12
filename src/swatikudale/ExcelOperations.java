package swatikudale;

import java.io.File;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {

	public static Object[][] readExcel(String filePath, String sheetName) throws IOException {
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(inputStream);
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowCount][columnCount];
		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
				Cell cell = sheet.getRow(rowIndex + 1).getCell(columnIndex);
				if (cell.getCellType() == CellType.STRING)
					data[rowIndex][columnIndex] = cell.getStringCellValue();
				else if(cell.getCellType() == CellType.NUMERIC) {
					String temp = String.valueOf(cell.getNumericCellValue());
					data[rowIndex][columnIndex] = temp.substring(0,temp.length()-2);
				}
			}
		}
		wb.close();
		return data;
	}
}
