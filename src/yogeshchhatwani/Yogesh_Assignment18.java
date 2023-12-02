/*Assignment18: 25 Nov
Verify number of unique office locations in the table.
1. Navigate to https://datatables.net/
2. Find unique offices in the data table.
3. Verify number of unique offices.
*/
package yogeshchhatwani;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Yogesh_Assignment18 {

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

	@Test
	void uniqueOffices() {
		List<WebElement> offices = driver.findElements(By.xpath("//table[@id='example']//tbody/tr/td[3]"));
		Set<String> uniqueOffices = new HashSet<>();
		for (WebElement office : offices) {
			System.out.println(office.getText());
			uniqueOffices.add(office.getText());
		}
		System.out.println("Number of unique positions are:--" + uniqueOffices.size());

		Set<String> expectedOffices = new HashSet<>(
				Arrays.asList("Tokyo", "London", "San Francisco", "New York", "Edinburgh"));

		if (uniqueOffices.equals(expectedOffices)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}
	}

	@AfterClass
	void close() {
		driver.quit();
	}

}
