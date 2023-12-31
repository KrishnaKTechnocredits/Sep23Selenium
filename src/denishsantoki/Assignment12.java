/*Assignment12 Nov22
Verify how many columns and rows are present in Demo tables >> EMPLOYEE MANAGER table
Expected: 
Column count - 5
Row count - 9*/
package denishsantoki;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment12 {
	WebDriver driver;
	
	@BeforeClass
	void launchChrome() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("Launch Chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com");
	}

	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void verify() throws InterruptedException{
		System.out.println("Navigate to Demo Table");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		sleep(3000);
		
		System.out.println("Find Number Of Coloum");
		List<WebElement> listOfCols = driver.findElements(By.xpath("//table[@class = 'table table-striped']/thead/tr/th"));
		System.out.println("Number Of Coloum is : " + listOfCols.size());
		
		System.out.println("Find Number Of Rows");
		List<WebElement> listOfRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
		System.out.println("Number Of Rows : " + listOfRows.size());
	}
	
	@AfterClass
	void tearDown() {
		driver.close();
	}
}
