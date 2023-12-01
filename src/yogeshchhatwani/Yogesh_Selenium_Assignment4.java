//Assignment4 Nov19

//- Navigate to http://automationbykrishna.com/index.html
//- Navigate Basic elements
//- Click 'Alert' and verify if alert message contains TechnoCredits
package yogeshchhatwani;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Yogesh_Selenium_Assignment4 {
	WebDriver driver;

	@BeforeClass
	void launchChrome() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("Step-->Launch Chrome Browser");
		driver = new ChromeDriver();// launch chrome browser
		// Mazimize current window
		driver.manage().window().maximize();
	}

	@BeforeMethod
	void navigateToUrl() {
		String url = "http://automationbykrishna.com";
		driver.navigate().to(url);

	}

	@Test
	void basicElements() {
		System.out.println("Step-->Click on Basic elements Link");
		WebElement elementOpen = driver.findElement(By.id("basicelements"));
		elementOpen.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement e = driver.findElement(By.xpath("//button[@id='javascriptAlert']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
		e.click();

		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert is " + alertText);
		if (alertText.contains("TechnoCredits")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}
		alert.accept();
	}

	@AfterMethod
	void close() {
		driver.close();
	}
}
