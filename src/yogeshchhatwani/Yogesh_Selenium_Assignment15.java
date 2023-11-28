//Assignment15 Nov22
//Print all the data for Demo tables >> EMPLOYEE BASIC INFORMATION table
//Hint: 2 Loops, out loop - Row, inner loop - Column
package yogeshchhatwani;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Yogesh_Selenium_Assignment15 {
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
		
		for(int j=1;j<rowsCount;j++) {
			for(int i=1;i<=colCount;i++) {
				System.out.print(driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[" + j + "]/td[" + i+ "]"+" ")).getText());
				System.out.println(" ");
		}
		}
	}
}
