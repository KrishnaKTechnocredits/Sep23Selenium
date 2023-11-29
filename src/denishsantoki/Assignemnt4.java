/*Assignment4 Nov19
- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- Click 'Alert' and verify if alert message contains TechnoCredits*/
package denishsantoki;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignemnt4 {

	WebDriver driver;

	@BeforeClass
	void launchChrome() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("Step-->Launch Chrome Browser");
		driver = new ChromeDriver();// launch chrome browser
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com");
	}
	
	void sleep(int time) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void verify() {
		System.out.println("Navigate Basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		sleep(3000);
		
		System.out.println("Click 'Alert' and verify if alert message contains TechnoCredits");
		WebElement e = driver.findElement(By.xpath("//button[@id='javascriptAlert']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
		e.click();
		Alert javascriptAlert = driver.switchTo().alert();
		String actualMessage = javascriptAlert.getText();
		if(actualMessage.contains("TechnoCredits"))
			System.out.println("Test is passed");
		else
			System.out.println("Test failed");
		javascriptAlert.accept();
	}
	
	@AfterClass
	void tearDown() {
		driver.close();
	}
}
