package denishsantoki.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperationTest {
	
	public static Object[][] getAllRows(String filePath, String sheetName) throws IOException {
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		
		Workbook wb = new XSSFWorkbook(inputStream);
		
		Sheet dataSheet = wb.getSheet(sheetName);
		int totalRows = dataSheet.getLastRowNum(); //3
		int totalCols = dataSheet.getRow(0).getLastCellNum();
		
		System.out.println(totalRows); // 3
		System.out.println(totalCols); // 3
		Object[][] data = new Object[totalRows][totalCols];
		
		for(int rowIndex=0;rowIndex<totalRows;rowIndex++) {
			for(int colIndex=0;colIndex<totalCols;colIndex++) {	
				Cell cell = dataSheet.getRow(rowIndex+1).getCell(colIndex);
				if(cell.getCellType() == CellType.STRING)
					data[rowIndex][colIndex] = cell.getStringCellValue();
				else if(cell.getCellType() == CellType.NUMERIC) {
					String temp = String.valueOf(cell.getNumericCellValue());
					data[rowIndex][colIndex] = temp.substring(0,temp.length()-2);
				}else if(cell.getCellType() == CellType.BOOLEAN)
					data[rowIndex][colIndex] = cell.getBooleanCellValue();
				
				System.out.print(data[rowIndex][colIndex] + "-->");
			}
			System.out.println();
		}
		wb.close();
		return data;
	}
}
