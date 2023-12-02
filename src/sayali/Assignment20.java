/*Assignment20: 25 Nov
Verify number of employees working at each position.
1. Navigate to https://datatables.net/
2. Find employees working at each position.
3. Verify number of employees.
*/
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

public class Assignment20 {

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
	void empPositions() {
		List<WebElement> listOfEmpPosition = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
		Map<String, Integer> positionMap = new LinkedHashMap<String, Integer>();
		for (WebElement name : listOfEmpPosition) {
			String position = name.getText();
			if (positionMap.containsKey(position)) {
				int count = positionMap.get(position);
				positionMap.put(position, count + 1);
			} else {
				positionMap.put(position, 1);
			}
		}
		System.out.println("Number of employees working at each position : " + positionMap);
	}

	@AfterClass
	void closeBrowser() {
		System.out.println("Close browser");
		driver.close();
	}
}