/*Assignment13 Nov22 Print Last row data, 
Demo tables >> EMPLOYEE BASIC INFORMATION table 
Note: Get row size - 4*/
package swatikudale;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment_13 {
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
	void printLastRowData() {

		System.out.println("Navigate to Demo Table");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		sleep(3000);

		List<WebElement> column = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		int columnCount = column.size();

		// Dynamic Xpath
		System.out.print("Last row data : ");
		for (int index = 1; index <= columnCount; index++) {
			System.out.print(
					driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[5]/td[" + index + "]")).getText());
			System.out.print(" ");
		}
	}

	@AfterMethod
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}
}
