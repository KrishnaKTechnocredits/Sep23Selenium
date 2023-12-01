package shamligadekar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment12 {

WebDriver driver;
	
	void launchBrowser(String url) {
		System.out.println("STEP-Launch Browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println("STEP-Maximize Window");
		driver.manage().window().maximize();;
		
		System.out.println("STEP-Navigate to : "+url);
		driver.get(url);
	}
	
	void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void countTableRowsAndColumns() {
		
		System.out.println("STEP - Print count of columns");
		List<WebElement> listofcolumns= driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		int coloumnscount=listofcolumns.size();
		System.out.println("Total columns are : "+coloumnscount);
		if(coloumnscount==4) {
			System.out.println("Verify column count test pass");
		}else {
			System.out.println("Verify column count test fail");
		}
		
		System.out.println("STEP - Print count of rows");
		List<WebElement> listofrows= driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		int rowscount=listofrows.size();
		System.out.println("Total Rows are : "+rowscount);
		if(rowscount==5) {
			System.out.println("Verify rows count test pass");
		}else {
			System.out.println("Verify rows count test fail");
		}
		
		
		
		
		
	}
	
	void testCases() {
		launchBrowser("http://automationbykrishna.com/");
		System.out.println("STEP-Click Demo Table");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		wait(3000);
		
		countTableRowsAndColumns();
		
		
		
		System.out.println("STEP-Browser Close");
		driver.close();
	}
	
	public static void main(String[] args) {
		Assignment12 assignment12 = new Assignment12();
		assignment12.testCases();
	}
}
