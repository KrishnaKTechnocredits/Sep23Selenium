/*Assignment19: 25 Nov
Verify number of employees working at each office location.
1. Navigate to https://datatables.net/
2. Find employees working at each office location.
3. Verify number of employees.

Note: please refer to link for expected employee, office map.
*/
package yogeshchhatwani;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Yogesh_Assignment19 {
	WebDriver driver;

	@BeforeClass
	void openChrome() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("Open chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = "https://datatables.net/";
		driver.navigate().to(url);
	}

	@BeforeMethod
	void selectPageSize() {
		Select se = new Select(driver.findElement(By.xpath("//select[@name='example_length']")));
		se.selectByValue("100");
	}

	@Test
	void uniqueOffices() {
		List<WebElement> empRows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
		Map<String, Integer> officeEmployeeCount = new LinkedHashMap<String, Integer>();
	
		for (WebElement row : empRows) {
			String office = row.getText();

			if (officeEmployeeCount.containsKey(office)) {
				int count = officeEmployeeCount.get(office);
				officeEmployeeCount.put(office, count + 1);
			} else {
				officeEmployeeCount.put(office, 1);
			}
		}
		//System.out.println(officeEmployeeCount);
	}

	@AfterClass
	void close() {
		driver.quit();
	}
}
