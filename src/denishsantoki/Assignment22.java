/*Verify list of employees whose age is less than 50 and works in London office.
1. Navigate to https://datatables.net/
2. Find employees whose age is less than 50 and works in London office.
3. Verify list of employees.*/
package denishsantoki;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment22 {
	
	WebDriver driver;

	@BeforeClass
	void setup() {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get("https://datatables.net/");
	}
	
	@Test
	void employee() {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		int rowsCount = rows.size();
		System.out.println("List Of Employee Less Then 50 Age And Work In London Office");
		for (int index = 1; index <= rowsCount; index++) {
			int age = Integer.parseInt(driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[4]")).getText());
			String country = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+ index +"]/td[3]")).getText();
			if (age <= 50 && country.equals("London")) {
				System.out.println(age + " -> " + (driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[1]"))).getText());
			}
		}
	}
	
	@AfterClass
	void tearDdown() {
		driver.close();
	}
}
