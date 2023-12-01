//Assignment14 Nov22
//WAP, print all data for last row
//Hint:
//Get rows size = 5
//Get column size = 4
//Note: Assignment should have dynamic data.

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

public class Yogesh_Selenium_Assignment14 {

	WebDriver driver;

	@BeforeClass
	void openChrome() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("Open chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@BeforeMethod
	void navigateurl() {
		String url = "http://automationbykrishna.com/index.html#";
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
	void demotable() {
		System.out.println("Click on demo tables");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		waitaBit(3000);

		List<WebElement> listOfRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		int rowsCount = listOfRow.size();
		System.out.println(rowsCount);

		List<WebElement> listOfCol = driver.findElements(By.xpath("//table[@id='table1']//thead/tr/th"));
		int colCount = listOfCol.size();
		System.out.println(colCount);

		for (int i = 1; i <= colCount; i++) {
			System.out.print(
					driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[" + rowsCount + "]/td[" + i + "]"))
							.getText());
			System.out.print(" ");
		}
	}

	@AfterMethod
	void close() {
		driver.close();
	}

}
