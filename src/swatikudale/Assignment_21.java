/*Assignment21: 25 Nov Verify list of employees whose age is greater than 50.
1. Navigate to https://datatables.net/ 
2. Find employees whose age is greater than 50.
3. Verify list of employees.
Note: Create expected list and compare with actual list. Covered in session.*/
package swatikudale;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment_21 {

	WebDriver driver;

	@BeforeMethod
	void setup() {
		System.out.println("Launch Chrome Browser and  Navigate to  https://datatables.net/");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get("https://datatables.net/");
	}

	@Test
	void verifyEmpWithAge() {
		// this is action is to select how many rows should displayed on page
		Select se = new Select(driver.findElement(By.xpath("//select[@name='example_length']")));
		se.selectByValue("100");

		// taking 100 row s elements into list
		List<WebElement> listOfAge = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		for (int index = 1; index <= listOfAge.size(); index++) {
			int age = Integer.parseInt(
					driver.findElement(By.xpath("//table[@id = 'example']/tbody/tr[" + index + "]/td[4]")).getText());
			if (age > 50) {
				System.out.println(age + " -> "
						+ (driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[1]")))
								.getText());
			}
		}
	}

	@AfterMethod
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}
}
