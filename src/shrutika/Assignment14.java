/*Assignment14 Nov22 WAP, print all data for last row Hint: Get rows size = 5
Get column size = 4
Note: Assignment should have dynamic data.*/
package shrutika;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment14 {
	WebDriver driver;

	@BeforeClass
	void launchChrome() {
		System.out.println("Step : Launch Chrome Browser ");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("Launch Chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@BeforeMethod
	void setUp() {
		System.out.println("Step : Navigate URL");
		String url = "http://automationbykrishna.com/index.html";
		driver.navigate().to(url);
	}

	@Test
	void printAllDataOfLastRow() {
	
		System.out.println("Step :Navigate to Demo Table");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		int rowCount = rows.size();

		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		int columnCount = columns.size();

		System.out.print("Step : Last row data is : ");
		for (int index = 1; index <= columnCount; index++) {
			System.out.print(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowCount + "]/td[" + index + "]"))
							.getText());
			System.out.print(" ");
		}

		System.out.println("\nStep : Close the browser");
		driver.close();
	}
}
