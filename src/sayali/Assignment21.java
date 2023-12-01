/* Verify list of employees whose age is greater than 50.
1. Navigate to https://datatables.net/
2. Find employees whose age is greater than 50.
3. Verify list of employees. */

package sayali;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment21 {

	WebDriver driver;

	@BeforeClass
	void setup() {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver",
				"D:\\Testing_Class Sayali\\JavaProject\\Sep23Selenium\\src\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get("https://datatables.net/");
	}

	@Test
	void employee() {
		List<WebElement> listOfEmployees = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		int rowsCount = listOfEmployees.size();
		System.out.println("\nList of employees having age > 50: ");
		for (int index = 1; index <= rowsCount; index++) {
			int age = Integer.parseInt(
					driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[4]")).getText());
			if (age >= 50) {
				System.out.println(
						(driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[1]"))).getText()
								+ " : " + age);
			}
		}
	}

	@AfterClass
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}
}