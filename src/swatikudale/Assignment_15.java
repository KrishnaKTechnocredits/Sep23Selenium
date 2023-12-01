/* Assignment15 Nov22 Print all the data for 
 * Demo tables >> EMPLOYEE BASIC INFORMATION table
 *  Hint: 2 Loops, out loop - Row, inner loop - Column*/
package swatikudale;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment_15 {
	WebDriver driver;

	@BeforeMethod
	void setup() {

		System.out.println("Launch Chrome Browser and  Navigate to http://automationbykrishna.com");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
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
	void printAllDataOfEmployeeBasicInfo() {

		System.out.println("Navigate to Demo Table");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		sleep(3000);

		// RowCount
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		int rowCount = rows.size();

		// ColoumnCount
		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		int columnCount = columns.size();

		System.out.println("All the data of EMPLOYEE BASIC INFORMATIOM table is as below ");
		for (int index = 1; index <= rowCount; index++) {
			for (int innerindex = 1; innerindex <= columnCount; innerindex++) {
				System.out.print(driver
						.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[" + innerindex + "]"))
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