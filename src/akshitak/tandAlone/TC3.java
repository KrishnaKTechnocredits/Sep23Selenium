package akshitak.tandAlone;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import technocredits.actionsDemo.LaunchChromeBrowser;

public class TC3 {

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
		
		int beforeFilter = driver.findElements(By.xpath("//img[@class='card-img-top']")).size();
		
		
		driver.findElement(By.xpath(
				"//section//div/h6[text()='Categories']/parent::div/div[@class='form-group ng-star-inserted']/label[text()='electronics']/preceding-sibling::input")).click();
		
		int afterFilter = driver.findElements(By.xpath("//div[@class='card']")).size();
		
		
		if (beforeFilter != afterFilter) {
			System.out.println("VERIFY: Filter applied");
			System.out.println("Passed!");
		} else {
			System.out.println("failed!");
		}

	}
}