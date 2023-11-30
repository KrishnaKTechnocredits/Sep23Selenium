/* Verify number of employees working at each office location.
1. Navigate to https://datatables.net/
2. Find employees working at each office location.
3. Verify number of employees. */

package sayali;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment19 {

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
	void empLocations() {
		List<WebElement> listOfEmplByOfficeLocation = driver
				.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
		Map<String, Integer> deptMap = new LinkedHashMap<String, Integer>();
		for (WebElement name : listOfEmplByOfficeLocation) {
			String dept = name.getText();
			if (deptMap.containsKey(dept)) {
				int count = deptMap.get(dept);
				deptMap.put(dept, count + 1);
			} else {
				deptMap.put(dept, 1);
			}
		}
		System.out.println("Number Of employees working at each office location : " + deptMap);
	}

	@AfterClass
	void closeBrowser() {
		System.out.println("Close browser");
		driver.close();
	}
}