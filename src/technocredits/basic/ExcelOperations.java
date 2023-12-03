package technocredits.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {
	
	public static void main(String[] args) throws IOException {
		File file = new File(".//testdata/LoginData.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		
		Workbook wb = new XSSFWorkbook(inputStream);
		
		Sheet dataSheet = wb.getSheet("Data");
		int totalRows = dataSheet.getLastRowNum();
		
		System.out.println(totalRows);
	}
}
