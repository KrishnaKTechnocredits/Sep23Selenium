/*Verify number of unique office locations in the table.
1. Navigate to https://datatables.net/
2. Find unique offices in the data table.
3. Verify number of unique offices.*/

package onkar;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment18 {

	WebDriver driver;

	@BeforeMethod
	void setup() {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get("https://datatables.net/");
	}

	@AfterMethod
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}

	@Test
	void verifyUniqueOffices() {
		List<WebElement> listOfOffices = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
		Set<String> uniqueOffices = new LinkedHashSet<String>();

		for (WebElement e : listOfOffices) {
			uniqueOffices.add(e.getText());
		}

		System.out.println(uniqueOffices);
		Assert.assertEquals(uniqueOffices.size(), 5);
	}
}
