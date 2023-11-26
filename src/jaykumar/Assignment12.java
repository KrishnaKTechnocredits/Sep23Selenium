/*Assignment12 Nov22
Verify how many columns and rows are present in Demo tables >> EMPLOYEE MANAGER table
Expected: 
Column count - 5
Row count - 9*/

package jaykumar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment12 {
	WebDriver driver;
	
	void setUp(String url){
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("STEP - Launch: "+url);
		driver.get(url);
	}
	
	void waitABit(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void webTableTestCases(){
		setUp("http://automationbykrishna.com");
		System.out.println("STEP - Click on Demo Tables link");
		driver.findElement(By.id("demotable")).click();
		waitABit(3000);
		
		System.out.println("STEP - Verify count of columns");
		List<WebElement> listOfColumns = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		int columnsCount = listOfColumns.size();
		System.out.println("Total columns found: "+columnsCount);
		if(columnsCount == 4) {
			System.out.println("Verify columns count test passed");
		}else {
			System.out.println("Verify columns count test failed");
		}
		
		System.out.println("STEP - Verify count of rows");
		List<WebElement> listOfRows =  driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		int rowsCount = listOfRows.size();
		System.out.println("Total rows found: "+rowsCount);
		if(rowsCount == 5) {
			System.out.println("Verify columns count test passed");
		}else {
			System.out.println("Verify columns count test failed");
		}
		
		System.out.println("STEP - Close browser");
		driver.close();
	}
	
	public static void main(String[] args) {
		new Assignment12().webTableTestCases();
	}
}
