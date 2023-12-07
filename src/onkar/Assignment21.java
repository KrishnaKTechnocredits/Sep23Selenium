/*Verify list of employees whose age is greater than 50.
1. Navigate to https://datatables.net/
2. Find employees whose age is greater than 50.
3. Verify list of employees.
Note: 
Create expected list and compare with actual list.
Covered in session. */

package onkar;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment21 {

	WebDriver driver;

	@BeforeMethod
	void setup() {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get("https://datatables.net/");
	}

	@AfterMethod
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}
	
	@Test
	void verifyOlderEmployees(){
		List<String> olderEmployees = new ArrayList<String>();
		int rowsCount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();

		for (int index=1; index<=rowsCount; index++) {
			int age = Integer.parseInt(driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+index+"]/td[4]")).getText());
			if(age>50) {
				olderEmployees.add(driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+index+"]/td[1]")).getText());
			}
		}
		
		List<String> expectedList = new ArrayList<String>();
		expectedList.add("Ashton Cox");
		expectedList.add("Brielle Williamson");
		
		Assert.assertEquals(olderEmployees, expectedList);
	}
}
