/*Assignment21: 25 Nov
Verify list of employees whose age is greater than 50.
1. Navigate to https://datatables.net/
2. Find employees whose age is greater than 50.
3. Verify list of employees.
Note: 
Create expected list and compare with actual list.
Covered in session*/

package yogeshchhatwani;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Yogesh_Assignment21 {
	WebDriver driver;

	@BeforeClass
	void openChrome() {
		// System.setProperty("webdriver.chrome.driver",
		// ".\\chromeDriver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", ".\\src\\yogeshchhatwani\\chromedriver.exe");

		System.out.println("Open chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = "https://datatables.net/";
		System.out.println("Navigate to url");
		driver.navigate().to(url);
	}

	@Test
	void empAge() {

		List<String> old = new ArrayList<String>();
		int row = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();

		for (int i = 1; i <= row; i++) {
			int age = Integer.parseInt(
					driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + i + "]/td[4]")).getText());

			if (age >= 50) {
				old.add(driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + i + "]/td[1]")).getText());
			}
		}
			List<String> expectedList = new ArrayList<String>();
			expectedList.add("Ashton Cox");
			expectedList.add("Brielle Williamson");

			Assert.assertEquals(old, expectedList,"fail");

		
	}

	@AfterMethod
	void close() {
		driver.quit();
	}
}
