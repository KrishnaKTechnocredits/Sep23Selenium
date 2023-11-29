/*Assignment17: 25 Nov
Verify number of unique employee positions in the table.
1. Navigate to https://datatables.net/
2. Find unique employee positions in the data table.
3. Verify number of unique positions.*/
package denishsantoki;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment17 {

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
		List<WebElement> listOfPosition = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
		Set<String> setOfPosition = new LinkedHashSet<String>();
		for (WebElement name : listOfPosition) {
			setOfPosition.add(name.getText());
		}
		System.out.println("Number Of Unique employee Position: " + setOfPosition.size());
		System.out.println("Unique Positions" + setOfPosition);
	}

	@AfterClass
	void tearDown() {
		driver.close();
	}
}
