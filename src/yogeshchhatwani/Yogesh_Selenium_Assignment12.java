//Assignment12 Nov22
//Verify how many columns and rows are present in Demo tables >> EMPLOYEE MANAGER table
//Expected: 
//Column count - 5
//Row count - 9

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

public class Yogesh_Selenium_Assignment12 {
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
		List<WebElement> columns = driver.findElements(By.xpath("//div[@id='empmanager']//thead/tr/th"));
		int columnCount = columns.size();
		System.out.println("Number of columns available in given table are : " + columnCount);
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr"));
		int rowCount = rows.size();
		System.out.println("Number of rows available in given table are : " + rowCount);
	}
	@AfterMethod
	void close() {
		driver.close();
}
}
