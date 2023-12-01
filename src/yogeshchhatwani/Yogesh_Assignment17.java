/*Verify number of unique employee positions in the table.
1. Navigate to https://datatables.net/
2. Find unique employee positions in the data table.
3. Verify number of unique positions.*/

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

public class Yogesh_Assignment17 {

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
	void uniqueEmployee() {
		List<WebElement> positions = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
		Set<String> uniquePositions = new HashSet<>();
		for (WebElement position : positions) {
			System.out.println(position.getText());
			uniquePositions.add(position.getText());
		}
		System.out.println("Number of unique positions are:--" + uniquePositions.size());

		Set<String> expectedPositions = new HashSet<>(Arrays.asList("Accountant", "Chief Executive Officer (CEO)",
				"Junior Technical Author", "Software Engineer", "Integration Specialist",
				"Pre-Sales Support", "Sales Assistant", "Senior Javascript Developer"));

		if (uniquePositions.equals(expectedPositions)) {
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
