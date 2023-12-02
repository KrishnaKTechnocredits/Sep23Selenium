/*Assignment18: 25 Nov Verify number of unique office locations in the table.
1. Navigate to https://datatables.net/
2. Find unique offices in the data table.
3. Verify number of unique offices.*/
package shrutika;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment18 {
	WebDriver driver;

	@BeforeMethod
	void setup() {
		System.out.println("Step : Launch Chrome Browser and  Navigate to  https://datatables.net/");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Step : Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Step : Open given URL");
		driver.get("https://datatables.net/");
	}

	@Test
	void findUniqueOfficeLocation() {

		List<WebElement> listOfLocations = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
		Set<String> setOfLocaions = new LinkedHashSet<String>();

		for (WebElement location : listOfLocations) {
			setOfLocaions.add(location.getText());
		}
		System.out.println("number of unique offices -> " + setOfLocaions.size());
		System.out.println("List of unique office location " + setOfLocaions);
	}

	@AfterMethod
	void closeBrowser() {
		System.out.println("Step : Close the browser");
		driver.close();
	}
}
