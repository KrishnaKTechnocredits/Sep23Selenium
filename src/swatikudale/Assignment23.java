/*Assignment23: 25 Nov Verify sort functionality works on list of office locations from the
table [consider all  pages].
1. Navigate to https://datatables.net/ 
2.Find list of office locations from all pages of table. 
3. Sort the list of office locations. 
4. Verify sort on list of office locations.
Note: Expected list - You can find list of offices as it is,
then use sort() method of Collections. 
Then you can sort the list from UI and take it as actual list.*/
package swatikudale;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment23 {
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

	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	void verifyEmpWithAgeAndLocation() {
		// this is action is to select how many rows should displayed on page
		Select se = new Select(driver.findElement(By.xpath("//select[@name='example_length']")));
		se.selectByValue("100");

		List<WebElement> list1 = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
		ArrayList<String> expectedList = new ArrayList<String>();
		for (WebElement name : list1) {
			expectedList.add(name.getText());
		}

		Collections.sort(expectedList);
		System.out.println("Expected List" + expectedList);
		sleep(3000);
		// finding expected list to match with actual list
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[3]")).click();
		List<WebElement> list2 = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
		ArrayList<String> actualList = new ArrayList<String>();
		for (WebElement name : list2) {
			actualList.add(name.getText());
		}
		System.out.println("Sorted List : " + actualList);
		// comparing actual and expected list
		if (expectedList.equals(actualList)) {
			System.out.println("Sorting Successfully : Test Pass");
		} else
			System.out.println("Sorting Unsuccessfull : Test Fail");
	}

	@AfterMethod
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}
}
