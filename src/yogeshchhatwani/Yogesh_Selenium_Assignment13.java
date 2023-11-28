//Assignment13 Nov22
//Print Last row data, Demo tables >> EMPLOYEE BASIC INFORMATION table
//Note: Get row size - 4

package yogeshchhatwani;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Yogesh_Selenium_Assignment13 {
	WebDriver driver;

	@BeforeClass
	void openChrome() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("Launch Chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@BeforeMethod
	void navigateUrl() {
		String url = "http://automationbykrishna.com/index.html";
		driver.navigate().to(url);
	}

	void waitaBit(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void demotables() {
		System.out.println("Click on demo tables");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		waitaBit(3000);
		System.out.println("Print last row");
		List<WebElement> listOfCols = driver.findElements(By.xpath("//table[@class='table']/tbody/tr[1]/td"));
		int lastRowCount = driver.findElements(By.xpath("//table[@class='table']/tbody/tr")).size();

		for (int index = 1; index <= listOfCols.size(); index++) {
			// String locator =
			// "//table[@class='table']/tbody/tr["+lastRowCount+"]/td["+index+"]";
			String text = driver
					.findElement(By.xpath("//table[@class='table']/tbody/tr[" + lastRowCount + "]/td[" + index + "]"))
					.getText();
			System.out.print(text + " ");
		}
	}

	@AfterMethod
	void close() {
		driver.close();
	}
}
