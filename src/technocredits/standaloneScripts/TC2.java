package technocredits.standaloneScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import technocredits.actionsDemo.LaunchChromeBrowser;

public class TC2 {

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

		int categoriesFilter = driver
				.findElements(By.xpath(
						"//section//h6[text()='Categories']/parent::div//div[@class='form-group ng-star-inserted']"))
				.size();
		System.out.println("STEP: Collected all the categories");
		int subCategoriesFilter = driver.findElements(By
				.xpath("//section//h6[text()='Sub Categories']/parent::div//div[@class='form-group ng-star-inserted']"))
				.size();
		System.out.println("STEP: Collected all the Sub Categories");
		int searchForFilter = driver
				.findElements(By.xpath(
						"//section//h6[text()='Search For']/parent::div//div[@class='form-group ng-star-inserted']"))
				.size();
		System.out.println("STEP: Collected all the Search For");

		if (categoriesFilter > 0 && subCategoriesFilter > 0 && searchForFilter > 0) {
			System.out.println("Passed");
		} else {
			System.out.println("failed");
		}

	}
}
