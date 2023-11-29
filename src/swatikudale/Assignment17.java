/*Assignment17: 25 Nov Verify number of unique employee positions in the table.
1. Navigate to https://datatables.net/ 
2. Find unique employee positions in the data table. 
3. Verify number of unique positions*/
package swatikudale;

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

public class Assignment17 {

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

	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	void findUniquePosition() {

		List<WebElement> listOPositions = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
		// Need unique hence will use set
		Set<String> setOfPositions = new LinkedHashSet<>();

		for (WebElement e : listOPositions) {
			setOfPositions.add(e.getText());
		}
		System.out.println("Unique employee positions " + setOfPositions);
		System.out.println("Number of unique positions are ->" + setOfPositions.size());
	}

	@AfterMethod
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}
}
