/*Assignment19: 25 Nov
Verify number of employees working at each office location.
1. Navigate to https://datatables.net/
2. Find employees working at each office location.
3. Verify number of employees.*/
package denishsantoki;

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
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get("https://datatables.net/");
	}

	@Test
	void empPositions() {
		List<WebElement> listOfOffice = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
		Map<String, Integer> deptMap = new LinkedHashMap<String, Integer>();
		for (WebElement name : listOfOffice) {
			String dept = name.getText();
			if (deptMap.containsKey(dept)) {
				int count = deptMap.get(dept);
				deptMap.put(dept, count + 1);
			} else {
				deptMap.put(dept, 1);
			}
		}
		System.out.println("Number Of Employees Working At Each Office location : " + deptMap);
	}

	@AfterClass
	void tearDown() {
		driver.close();
	}
}
