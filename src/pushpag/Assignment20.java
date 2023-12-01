//Assignment19: 25 Nov
//Verify number of employees working at each office location.
//1. Navigate to https://datatables.net/
//2. Find employees working at each office location.
//3. Verify number of employees.

package pushpag;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Assignment20 {
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
	public void findTotalEmployessEachPosition() throws InterruptedException {
		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id = 'example']//tbody//tr"));
		wait(3000);

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int index = 1; index <= tableRows.size(); index++) {
			String locator = "//table[@id = 'example']//tbody//tr[" + index + "]//td[2]";
			String position = driver.findElement(By.xpath(locator)).getText();
			if (map.containsKey(position)) {
				int count = map.get(position);
				map.put(position, count + 1);
			} else {
				map.put(position, 1);
			}
		}
		System.out.println("No of Employees Working at each position : ");
		System.out.println(map);
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