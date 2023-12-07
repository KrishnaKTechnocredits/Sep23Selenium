/*Assignment23: 25 Nov
Verify sort functionality works on list of office locations from the table [consider all  pages].
1. Navigate to https://datatables.net/
2. Find list of office locations from all pages of table.
3. Sort the list of office locations.
4. Verify sort on list of office locations.*/
package denishsantoki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment23 {
	
	WebDriver driver;

	@BeforeClass
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
	void verifyTableData() {
		Select se = new Select(driver.findElement(By.xpath("//select[@name='example_length']")));
		se.selectByValue("100");

		List<WebElement> list1 = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
		ArrayList<String> expectedList = new ArrayList<String>();
		for (WebElement name : list1) {
			expectedList.add(name.getText());
		}
		
		Collections.sort(expectedList);
		System.out.println("Expected List" + expectedList);
		
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[3]")).click();
		List<WebElement> list2 = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
		ArrayList<String> actualList = new ArrayList<String>();
		for (WebElement name : list2) {
			actualList.add(name.getText());
		}
		System.out.println("Sorted List : " + actualList);
		Assert.assertEquals(actualList, expectedList);
	}
	
	@AfterClass
	void tearDown() {
		driver.close();
	}
}
