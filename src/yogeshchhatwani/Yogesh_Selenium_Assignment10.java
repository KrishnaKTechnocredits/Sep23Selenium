//Assignment10 Nov19 (Multiselect dropdown)
//- Navigate to http://automationbykrishna.com/index.html
//- Navigate Basic elements
//- Checkboxes and radios - Select multiple checkboxes
package yogeshchhatwani;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Yogesh_Selenium_Assignment10 {
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

	@Test
	void checkboxAndRadios() {
		System.out.println("Step-->Click on Basic elements Link");
		WebElement elementOpen = driver.findElement(By.id("basicelements"));
		elementOpen.click();

		System.out.println("Select multiple checkbox and radio Button");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement e = driver.findElement(By.xpath("(//div[@class='col-lg-10']//input[@type='checkbox'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
		e.click();

		driver.findElement(By.xpath("(//div[@class='col-lg-10']//input[@type='checkbox'])[2]")).click();
		driver.findElement(By.xpath("//input[@id='optionsRadios1']")).click();

	}

	@AfterMethod
	void close() {
		driver.close();
	}

}
