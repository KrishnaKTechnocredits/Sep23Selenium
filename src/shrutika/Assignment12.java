/*Assignment12 Nov22 Verify how many columns and rows are present in 
Demo tables >> EMPLOYEE MANAGER table Expected: Column count - 5 Row count - 9*/
package shrutika;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment12 {
	
	WebDriver driver;
	
	@BeforeClass
	void setUpBrowser() {
		System.out.println("Step 1 : Launch Chrome");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println("Maximize the window");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	void setupURL() {
		driver.get("http://automationbykrishna.com");
	}

	@Test
	void verifyDemoTableRownNColumns() {
		
		System.out.println("Step 2 :Navigate to Demo Tables");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		
		List<WebElement> columns = driver.findElements(By.xpath("//div[@id='empmanager']//thead/tr/th"));
		int columnCount = columns.size();
		System.out.println("Step3 : "+columnCount + " columns present in demo table");

		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr"));
		int rowCount = rows.size();
		System.out.println("Step3 : "+rowCount + " rows present in demo table");

		System.out.println("Browser close");
		driver.close();
	}
}
