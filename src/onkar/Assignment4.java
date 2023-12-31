/*- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- Click 'Alert' and verify if alert message contains TechnoCredits*/

package onkar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment4 {
	
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
	
	@AfterClass
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}
	
	@Test
	void verifyAlert() {
		System.out.println("Navigate Basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		sleep(3000);
		
		System.out.println("Click 'Alert' and verify if alert message contains TechnoCredits");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		Alert javascriptAlert = driver.switchTo().alert();
		String actualMessage = javascriptAlert.getText();
		if(actualMessage.contains("TechnoCredits"))
			System.out.println("Test is passed");
		else
			System.out.println("Test failed");
		javascriptAlert.accept();
	}
}
