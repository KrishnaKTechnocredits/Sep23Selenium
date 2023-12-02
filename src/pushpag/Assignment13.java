//Assignment13 Nov22
//Print Last row data, Demo tables >> EMPLOYEE BASIC INFORMATION table
//Note: Get row size - 4

package pushpag;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment13 {
	WebDriver driver;

	@BeforeClass
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

		// Print Last row data, Demo tables >> EMPLOYEE BASIC INFORMATION table
		System.out.println("Step 3 - Print Last row data, Demo tables");
		List<WebElement> listOfCols = driver.findElements(By.xpath("//table[@id = 'table1']/tbody/tr[5]/td"));
		int lastRowCount = driver.findElements(By.xpath("//table[@id = 'table1']/tbody/tr")).size();

		for(int index=1;index<=listOfCols.size();index++){
			String locator = "//table[@id = 'table1']/tbody/tr["+lastRowCount+"]/td["+index+"]"; 
			String text = driver.findElement(By.xpath("//table[@class='table']/tbody/tr["+lastRowCount+"]/td["+index+"]")).getText();
			System.out.println(text);
		}
	}

	public void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	@AfterClass
	public void closeDriver() {
		driver.close();
	}
}