package technocredits.standaloneScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import technocredits.actionsDemo.LaunchChromeBrowser;

public class TC4 {

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

		String productSelection = "iphone 13 pro";

		String locatorForAddToCart = String.format(
				"//h5//b[text()='%s']/parent::h5/following-sibling::button[contains(text(),'Add To Cart')]",
				productSelection);

		driver.findElement(By.xpath(locatorForAddToCart)).click();
		System.out.println("STEP: product added to cart");

		Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Product Added To Cart']")).isDisplayed(),
				"Tosat message not displayed");
		System.out.println("VERIFY: Toast messsage displayed");

		driver.findElement(By.xpath("//li//button[contains(text(),'Cart')]")).click();
		System.out.println("STEP: click on cart button");

		String addToCartLocator = String.format("//div[@class='cartSection']//h3[text()='%s']", productSelection);

		Assert.assertTrue(driver.findElement(By.xpath(addToCartLocator)).isDisplayed(),
				"Added product " + productSelection + " not displayed");
		System.out.println("VERIFY: added product " + productSelection + " displayed on cart page");

		driver.quit();
	}

}
