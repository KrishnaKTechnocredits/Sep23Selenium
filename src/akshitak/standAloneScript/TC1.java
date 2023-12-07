package akshitak.standAloneScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import technocredits.actionsDemo.LaunchChromeBrowser;

public class TC1 {

	WebDriver driver;

	@Test
	void verifyLogin() {
		System.out.println("Navigate to URL");
		driver = LaunchChromeBrowser.launchBrowser("https://rahulshettyacademy.com/client/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Enter User name");
		driver.findElement(By.id("userEmail")).sendKeys("ak@demo.com");
		System.out.println("Enter the Password");
		driver.findElement(By.id("userPassword")).sendKeys("Reset@1234");
		System.out.println("Click Login button");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		System.out.println("validate that \"Login Successfully\" toast message displayed");
		if (driver.findElement(By.xpath("//div[@aria-label='Login Successfully']")).isDisplayed()) 
			System.out.println("Sucess Message is displayed");
		else
			System.out.println("Sucess message is not displayed");
		//driver.close();
	}
}
