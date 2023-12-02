package technocredits.standaloneScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import technocredits.actionsDemo.LaunchChromeBrowser;

public class TC1 {

	@Test
	public void verifyLogin() {
		WebDriver driver = LaunchChromeBrowser.launchBrowser("https://rahulshettyacademy.com/client/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("harshhpatel07@gmail.com");
		System.out.println("STEP: Entered Email address");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Hhv@123456");
		System.out.println("STEP: Entered Password");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		System.out.println("STEP: Clicked on Login Button");

		if (driver.findElement(By.xpath("//div[@aria-label='Login Successfully']")).isDisplayed()) {
			System.out.println("VERIFY: Login Successfully message displayed");
			System.out.println("Passed");
		} else {
			System.out.println("VERIFY: Login Successfully message not displayed");
			System.out.println("Failed");
		}
	}
}
