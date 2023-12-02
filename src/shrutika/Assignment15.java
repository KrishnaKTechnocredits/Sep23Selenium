/* Assignment15 Nov22 Print all the data for 
 * Demo tables >> EMPLOYEE BASIC INFORMATION table
 *  Hint: 2 Loops, out loop - Row, inner loop - Column*/
package shrutika;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment15 {

	WebDriver driver;

	@BeforeClass
	void launchChrome() {
		System.out.println("Step 1 : Launch Chrome Browser ");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("Launch Chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@BeforeMethod
	void setUp() {
		System.out.println("Step 2 : Navigate URL");
		String url = "http://automationbykrishna.com/index.html";
		driver.navigate().to(url);
	}

	@Test
	void printAllDataOfEmployeeBasicInfo() {

		System.out.println("Navigate to Demo Table");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

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
	void close() {
		System.out.println("\n Step: browser close");
		driver.close();
	}
}
