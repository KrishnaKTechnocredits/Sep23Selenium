/*Assignment20: 25 Nov Verify number of employees working at each position. 
1. Navigate to https://datatables.net/ 
2.Find employees working at each position. 
3. Verify number of employees. 
Note: please refer to link for expected employee, position map.*/

package swatikudale;

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
		System.out.println("Launch Chrome Browser and  Navigate to  https://datatables.net/");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get("https://datatables.net/");
	}

	@Test
	void verifyNumberOfEmployees() {

		// this is action is to select how many rows should displayed on page.
		Select se = new Select(driver.findElement(By.xpath("//select[@name='example_length']")));
		se.selectByValue("100");

		// taking 100 rows elements into list
		List<WebElement> listOfpositions = driver.findElements(By.xpath("//table[@id = 'example']/tbody/tr/td[2]"));

		// Finding position and its count in 100 rows and calculation emp at each
		// position
		Map<String, Integer> employeePositionMap = new LinkedHashMap<String, Integer>();

		for (WebElement position : listOfpositions) {
			String emposition = position.getText();
			if (employeePositionMap.containsKey(emposition)) {
				int count = employeePositionMap.get(emposition);
				employeePositionMap.put(emposition, count + 1);
			} else
				employeePositionMap.put(emposition, 1);
		}
		System.out.println("Employees working at each position are - > " + employeePositionMap);
	}

	@AfterMethod
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}
}