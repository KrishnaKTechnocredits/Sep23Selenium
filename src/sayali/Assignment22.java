/* Verify list of employees whose age is less than 50 and works in London office.
1. Navigate to https://datatables.net/
2. Find employees whose age is less than 50 and works in London office. */

package sayali;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment22 {

	WebDriver driver;

	@BeforeMethod
	void setup() {
		System.out.println("Launch Chrome Browser and  Navigate to  https://datatables.net/");
		System.setProperty("webdriver.chrome.driver",
				"D:\\Testing_Class Sayali\\JavaProject\\Sep23Selenium\\src\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get("https://datatables.net/");
	}

	@Test
	void verifyEmployeeAgeLocation() {

		Select s1 = new Select(driver.findElement(By.xpath("//select[@name='example_length']")));
		s1.selectByValue("100");

		System.out.println("List of employees having age less than 50 and works in London office: ");
		List<WebElement> row = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));

		for (int index = 1; index <= row.size(); index++) {
			int age = Integer.parseInt(
					driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[4]")).getText());
			String location = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[3]"))
					.getText();
			if (location.equals("London") && age < 50) {
				System.out.println(
						(driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[1]"))).getText()
								+ " - >" + age);
			}
		}
	}

	@AfterMethod
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}
}