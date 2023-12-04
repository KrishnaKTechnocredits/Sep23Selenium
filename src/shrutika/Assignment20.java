/*Assignment20: 25 Nov Verify number of employees working at each position. 
1. Navigate to https://datatables.net/ 
2.Find employees working at each position. 
3. Verify number of employees. 
Note: please refer to link for expected employee, position map.*/
package shrutika;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment20 {

	WebDriver driver;

	@BeforeMethod
	void setup() {
		System.out.println("STEP : Launch Chrome Browser and  Navigate to  https://datatables.net/");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("STEP : Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("STEP : Open given URL");
		driver.get("https://datatables.net/");
	}

	@Test
	void verifyNumberOfEmployees() {
		System.out.println("STEP : 100 Rows should displayed on page.");
		Select se = new Select(driver.findElement(By.xpath("//select[@name='example_length']")));
		se.selectByValue("100");

		System.out.println("STEP : 100 Rows elements into List.");
		List<WebElement> listOfpositions = driver.findElements(By.xpath("//table[@id = 'example']/tbody/tr/td[2]"));

		Map<String, Integer> employeePositionMap = new LinkedHashMap<String, Integer>();
		for (WebElement position : listOfpositions) {
			String emposition = position.getText();
			if (employeePositionMap.containsKey(emposition)) {
				int count = employeePositionMap.get(emposition);
				employeePositionMap.put(emposition, count + 1);
			} else
				employeePositionMap.put(emposition, 1);
		}
		System.out.println("STEP : Employees working at each position are - > " + employeePositionMap);
	}

	@AfterMethod
	void closeBrowser() {
		System.out.println("STEP : Close browser window");
		driver.close();
	}

}
