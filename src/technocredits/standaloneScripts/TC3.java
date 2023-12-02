package technocredits.standaloneScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import technocredits.actionsDemo.LaunchChromeBrowser;

public class TC3 {

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

		int beforeFilter = driver.findElements(By.xpath("//img[@class='card-img-top']")).size();
		System.out.println("STEP: Collected before filter count");

		driver.findElement(By.xpath(
				"//section//h6[text()='Categories']/parent::div//div[@class='form-group ng-star-inserted']/label[text()='electronics']/preceding-sibling::input"))
				.click();
		System.out.println("STEP: Selected eletronics under categories");

		int afterFilter = driver.findElements(By.xpath("//div[@class='card']")).size();
		System.out.println("STEP: Collected after filter count");

		if (beforeFilter != afterFilter) {
			System.out.println("VERIFY: Filter applied");
			System.out.println("Passed!");
		} else {
			System.out.println("failed!");
		}

	}
}
