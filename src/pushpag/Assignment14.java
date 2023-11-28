//Assignment14 Nov22
//WAP, print all data for last row
//Hint:
//Get rows size = 5
//Get column size = 4
//Note: Assignment should have dynamic data.


package pushpag;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment14 {

	WebDriver driver;

	@BeforeClass
	void setup() {
		System.out.println("Launch chrome browser");
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
	void printLastRow() {
		System.out.println("Navigate to Demo Tables");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		sleep(3000);

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		int rowCount = rows.size();
		System.out.println("Row Count : " + rowCount);

		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")); 
		int columnCount = columns.size();
		System.out.println("Column Size : " + columnCount);

		System.out.print("Last row of the given table is : ");
		for(int index=1; index<=columnCount; index++) {
			System.out.print(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowCount+"]/td["+index+"]")).getText());
			System.out.print(" ");
		}
	}

	@AfterClass
	void close() {
		driver.close();
	}
}