/*Verify number of employees working at each office location.
1. Navigate to https://datatables.net/
2. Find employees working at each office location.
3. Verify number of employees.
Note: please refer to link for expected employee, office map.*/

package roshnikolhe;

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

public class Assignment19 {

	WebDriver driver;

	@BeforeMethod
	void setup() {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver",".\\chromeDriver\\chromedriver.exe");
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
	void verifyEmployeesLocation() {
		List<WebElement> listOfOffices = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
		Map<String, Integer> actualMap = new LinkedHashMap<String, Integer>();

		for (WebElement e : listOfOffices) {
			String key = e.getText();
			if(actualMap.containsKey(key)) {
				int count = actualMap.get(key);
				actualMap.put(key, count+1);
			}else {
				actualMap.put(key, 1);
			}
		}

		Map<String, Integer> expectedMap = new LinkedHashMap<String, Integer>();
		expectedMap.put("Tokyo", 1);
		expectedMap.put("London", 3);
		expectedMap.put("San Francisco", 2);
		expectedMap.put("New York", 3);
		expectedMap.put("Edinburgh", 1);

		Assert.assertEquals(actualMap, expectedMap);
	}
}