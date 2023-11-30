//Assignment18: 25 Nov
//Verify number of unique office locations in the table.
//1. Navigate to https://datatables.net/
//2. Find unique offices in the data table.
//3. Verify number of unique offices.

package pushpag;

import java.util.HashSet;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Assignment18 {
	WebDriver driver;

	@BeforeMethod
	public void setBrowser() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to https://datatables.net/
		System.out.println("Step 1 - https://datatables.net/");
		driver.navigate().to("https://datatables.net/");
		wait(3000);
	}
	
	@org.testng.annotations.Test
	public void findUniqueOffices() throws InterruptedException {
		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id = 'example']//tbody//tr"));
		System.out.println(tableRows.size());
		wait(3000);

		HashSet<String> uniqueOffices = new HashSet<>();
		for (int index = 1; index <= tableRows.size(); index++) {
			String locator = "//table[@id = 'example']//tbody//tr[" + index + "]//td[3]";
			String office = driver.findElement(By.xpath(locator)).getText();
			uniqueOffices.add(office);
		}

		System.out.println("unique Offices :" + uniqueOffices);
		System.out.println("No of unique offices :" + uniqueOffices.size());
	}
	
	public void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	@AfterMethod
	public void closeDriver() {
		driver.close();
	}
}