package technocredits.standaloneScripts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import technocredits.actionsDemo.LaunchChromeBrowser;

public class TC9 {
	WebDriver driver;

	@Test
	public void verifyLogin() throws InterruptedException {
		driver = LaunchChromeBrowser.launchBrowser("https://rahulshettyacademy.com/client/");

		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("harshhpatel07@gmail.com");

		System.out.println("STEP: Entered Email address");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Hhv@123456");

		System.out.println("STEP: Entered Password");
		driver.findElement(By.xpath("//input[@id='login']")).click();

		System.out.println("STEP: Clicked on Login Button");

		String productSelection = "zara coat 3";

		String locatorForAddToCart = String.format(
				"//h5//b[text()='%s']/parent::h5/following-sibling::button[contains(text(),'Add To Cart')]/i",
				productSelection);
		
		waitForElementTobeVisible(By.xpath(locatorForAddToCart)).click();
		System.out.println("STEP: product added to cart");

		waitUntilLoaderDisappers();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")));
		System.out.println("STEP: click on cart button");

		List<WebElement> listOfDeleteButtons = waitForAllElementTobeVisible(By.xpath("//button[@class='btn btn-danger']"));
		for(WebElement button : listOfDeleteButtons) {
			button.click();
		}
		
		Assert.assertTrue(waitForElementTobeVisible(By.xpath("//h1[text()='No Products in Your Cart !']")).isDisplayed(), "No Product Cart message not displayed");
		
		Thread.sleep(5000);
		driver.quit();
	}

	public void waitUntilLoaderDisappers() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		try {
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(
					"//div[contains(@class,'la-ball-scale-multiple')]//div[contains(@class,'ng-star-inserted')]"))));
		} catch (Exception e) {

		}
	}

	public WebElement waitForElementTobeVisible(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public List<WebElement> waitForAllElementTobeVisible(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}

}
