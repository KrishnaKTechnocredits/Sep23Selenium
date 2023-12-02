//Assignment12 Nov22
//Verify how many columns and rows are present in Demo tables >> EMPLOYEE MANAGER table
//Expected: 
//Column count - 5
//Row count - 9

package pushpag;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment12 {
	WebDriver driver;

	@BeforeMethod
	public void setBrowser() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to http://automationbykrishna.com/index.html
		System.out.println("Step 1 - http://automationbykrishna.com/index.html");
		driver.navigate().to("http://automationbykrishna.com/index.html");
		wait(3000);
	}

	@Test
	public void verifyRowAndCols() throws InterruptedException {
		// - Navigate Demo tables
		System.out.println("Step 2 - Navigate Demo tables");
		WebElement basicElement = driver.findElement(By.id("demotable"));
		basicElement.click();
		wait(3000);

		// Find no of columns in the table
		System.out.println("Step 3 - Find no of cols");
		List<WebElement> listOfCols = driver
				.findElements(By.xpath("//table[@class = 'table table-striped']/thead/tr/th"));
		System.out.println("No of cols :" + listOfCols.size());

		// Find no of columns in the table
		System.out.println("Step 4 - Find no of rows");
		List<WebElement> listOfRows = driver.findElements(By.xpath("//table[@class = 'table table-striped']/tbody/tr"));
		System.out.println("No of rows :" + listOfRows.size());

	}

	public void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	@AfterMethod
	public void closeDriver() {
		driver.close();
	}
}