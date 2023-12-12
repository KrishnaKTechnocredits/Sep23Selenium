/*Verify number of employees working at each position.
1. Navigate to https://datatables.net/
2. Find employees working at each position.
3. Verify number of employees.

Note: please refer to link for expected employee, position map.
*/

package onkar;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment20 {

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
	void verifyEmployeesPositions() {
		List<WebElement> listOfPositions = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
		Map<String, Integer> actualList = new LinkedHashMap<String, Integer>();
		
		for (WebElement e : listOfPositions) {
			String key = e.getText();
			if(actualList.containsKey(key)) {
				int count = actualList.get(key);
				actualList.put(key, ++count);
			}else
				actualList.put(key, 1);
		}
		
		Map<String, Integer> expectedList = new LinkedHashMap<String, Integer>();
		expectedList.put("Accountant", 1);
		expectedList.put("Chief Executive Officer (CEO)", 1);
		expectedList.put("Junior Technical Author", 1);
		expectedList.put("Software Engineer", 3);
		expectedList.put("Integration Specialist", 1);
		expectedList.put("Pre-Sales Support", 1);
		expectedList.put("Sales Assistant", 1);
		expectedList.put("Senior Javascript Developer", 1);
		
		Assert.assertEquals(actualList, expectedList);
 	}
}
