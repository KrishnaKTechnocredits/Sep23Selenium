/* Print Last row data, Demo tables >> EMPLOYEE BASIC INFORMATION table
Note: Get row size - 4 */

package sayali;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment13 {

	WebDriver driver;

	@BeforeMethod
	void launchChrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Testing_Class Sayali\\JavaProject\\Sep23Selenium\\src\\chromeDriver\\chromedriver.exe");
		System.out.println("Launch Chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
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
	void printData() throws InterruptedException {
		System.out.println("Navigate to Demo Table");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		sleep(3000);

		List<WebElement> listOfRows = driver.findElements(By.xpath("//table[@id='table1']/thead//th"));
		System.out.println("Last Row Size : " + listOfRows.size());
		System.out.println("Last Row Data: ");
		int lastRowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody//tr")).size();

		for (int index = 1; index <= listOfRows.size(); index++) {
			String text = driver
					.findElement(By.xpath("//table[@id='table1']/tbody//tr[" + lastRowCount + "]/td[" + index + "]"))
					.getText();
			System.out.print(text + " ");
		}
	}

	@AfterMethod
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}
}