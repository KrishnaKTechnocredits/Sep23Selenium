/*Verify list of employees whose age is greater than 50.
1. Navigate to https://datatables.net/
2. Find employees whose age is greater than 50.
3. Verify list of employees.
Note: 
Create expected list and compare with actual list.
Covered in session. */
package shrutika;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment21 {

	WebDriver driver;

	@BeforeMethod
	void setup() {
		System.out.println("STEP : Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("STEP : Open given URL");
		driver.get("https://datatables.net/");
	}

	@Test
	void verifyEmpAge() {

		ArrayList<String> expectedList = new ArrayList<String>();
		expectedList.add("Ashton Cox");
		expectedList.add("Brielle Williamson");

		System.out.println("STEP : Find Employees List");
		ArrayList<String> actualEmpList = new ArrayList<String>();
		int totalRows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[4]")).size();
		for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
			WebElement ageElement = driver
					.findElement(By.xpath("//table[@id='example']/tbody/tr[" + rowIndex + "]/td[4]"));
			int age = Integer.parseInt(ageElement.getText());
			if (age > 50) {
				String emp = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + rowIndex + "]/td[1]"))
						.getText();
				actualEmpList.add(emp);
			}
		}

		System.out.println("STEP : Employees with age greater than 50 are: ");
		for (String str : actualEmpList) {
			System.out.println(str);
		}

		System.out.println("STEP : List of employees whose age is greater than 50");
		if (expectedList.equals(actualEmpList)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}
	}

	@AfterMethod
	void closeBrowser() {
		System.out.println("STEP : Close browser ");
		driver.close();
	}
}
