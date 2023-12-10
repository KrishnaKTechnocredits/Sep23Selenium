package akshitak.tandAlone;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import technocredits.actionsDemo.LaunchChromeBrowser;

public class TC4 {

	WebDriver driver;

	@Test
	void verifyLogin() {
		System.out.println("STEP: Navigate to URL");
		driver = LaunchChromeBrowser.launchBrowser("https://rahulshettyacademy.com/client/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("STEP:Enter User name");
		driver.findElement(By.id("userEmail")).sendKeys("ak@demo.com");
		System.out.println("STEP:Enter the Password");
		driver.findElement(By.id("userPassword")).sendKeys("Reset@1234");
		System.out.println("STEP:Click Login button");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		System.out.println("STEP : Click add to card button");
		driver.findElement(By.xpath("//h5/b[text()='zara coat 3']/parent::h5/following-sibling::button[text()=' Add To Cart']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Product Added To Cart']")).isDisplayed(),"Toast message is not Displayed");
		System.out.println("Click cart tab");
		driver.findElement(By.xpath("//li/button[contains(text(),'Cart')]")).click();
		System.out.println("validated that added product displayed");
		Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='zara coat 3']")).isDisplayed(), "Product not added in card");
		}
	}

