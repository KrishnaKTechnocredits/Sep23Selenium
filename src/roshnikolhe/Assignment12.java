/*Assignment12 Nov22
Verify how many columns and rows are present in Demo tables >> EMPLOYEE MANAGER table
Expected: 
Column count - 5
Row count - 9*/

package roshnikolhe;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment12 {
	WebDriver driver;

	void setUp(String url){
		System.out.println("Step1. Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("Step1.1 - Launch: "+url);
		driver.get(url);
	}

	void waitABit(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void verifyWebTable(){
		setUp("http://automationbykrishna.com");
		System.out.println("Step2. Click on Demo Tables link");
		driver.findElement(By.id("demotable")).click();
		waitABit(3000);

		System.out.println("Step3. Verify column count");
		List<WebElement> listOfColumns = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		int columnsCount = listOfColumns.size();
		System.out.println("Total no. of columns are: "+columnsCount);
		if(columnsCount == 4) {
			System.out.println("Test Passed");
		}else {
			System.out.println("Test Failed");
		}

		System.out.println("Step4. Verify row count");
		List<WebElement> listOfRows =  driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		int rowsCount = listOfRows.size();
		System.out.println("Total no. of rows are: "+rowsCount);
		if(rowsCount == 5) {
			System.out.println("Test Passed");
		}else {
			System.out.println("Test Failed");
		}

		System.out.println("Step5. Browser closed.");
		driver.close();
	}

	public static void main(String[] args) {
		new Assignment12().verifyWebTable();
	}
}