/* Print all the data for Demo tables >> EMPLOYEE BASIC INFORMATION table
Hint: 2 Loops, out loop - Row, inner loop - Column */

package sayali;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment15 {

	WebDriver driver;

	@BeforeMethod
	void setup() {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", "D:\\Testing_Class Sayali\\JavaProject\\Sep23Selenium\\src\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get("http://automationbykrishna.com");
	}

	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	void printAllData() {
		System.out.println("Navigate to Demo Tables");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		sleep(3000);

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		int rowCount = rows.size();

		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		int columnCount = columns.size();

		System.out.println("\n All data of the table is as below : ");
		for (int index = 1; index <= rowCount; index++) {
			for (int i = 1; i <= columnCount; i++) {
				System.out.print(
						driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[" + i + "]"))
								.getText());
				System.out.print(" ");
			}
			System.out.println("");
		}
	}

	@AfterMethod
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}
}