/*Assignment18: 25 Nov
Verify number of unique office locations in the table.
1. Navigate to https://datatables.net/
2. Find unique offices in the data table.
3. Verify number of unique offices.*/
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

public class Assignment18 {

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
		Set<String> setOfOffice = new LinkedHashSet<String>();
		for (WebElement name : listOfOffice) {
			setOfOffice.add(name.getText());
		}
		System.out.println("Number Of Unique employee Position: " + setOfOffice.size());
		System.out.println("Unique Positions" + setOfOffice);

	}

	@AfterClass
	void tearDown() {
		driver.close();
	}
}
