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

public class TC8 {
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

		String productPagePriceLocator = String.format(
				"//div[@class='card-body']//b[text()='%s']/parent::h5/following-sibling::div/div", productSelection);
		String productPagePrice = waitForElementTobeVisible(By.xpath(productPagePriceLocator)).getText();

		waitForElementTobeVisible(By.xpath(locatorForAddToCart)).click();
		System.out.println("STEP: product added to cart");

		waitUntilLoaderDisappers();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")));
		System.out.println("STEP: click on cart button");

		String cartPriceLocator = String.format(
				"//h3[text()='%s']/parent::div/following-sibling::div[@class='prodTotal cartSection']/p",
				productSelection);
		String cartPagePrice = waitForElementTobeVisible(By.xpath(cartPriceLocator)).getText();

		waitForElementTobeVisible(By.xpath("//button[text()='Checkout']")).click();
		System.out.println("STEP: Clicked on checkout button");

		waitUntilLoaderDisappers();

		String attValue = driver
				.findElement(By.xpath("//div[contains(text(),'Credit Card Number')]/following-sibling::input"))
				.getAttribute("value");
		if (attValue.length() == 0) {
			driver.findElement(By.xpath("//div[contains(text(),'Credit Card Number')]/following-sibling::input"))
					.sendKeys("4542 9846 7822 2293");
			System.out.println("STEP: User enter credit card number");
		}

		driver.findElement(By.xpath("//span[@class='numberCircle']/parent::div/following-sibling::input"))
				.sendKeys("896");

		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");

		List<WebElement> listOfWebElements = waitForAllElementTobeVisible(
				By.xpath("//section[@class='ta-results list-group ng-star-inserted']//button"));
		for (WebElement singleELement : listOfWebElements) {
			if (singleELement.getText().equalsIgnoreCase("india")) {
				singleELement.click();
			}
		}

		driver.findElement(By.xpath("//div[contains(text(),'Name on Card')]/following-sibling::input"))
				.sendKeys("Mahesh");

		driver.findElement(By.xpath("//*[contains(text(),'Place Order')]")).click();

		String shippingPageLocator = String
				.format("//div[text()='%s']/parent::td/following-sibling::td/div[@class='title']", productSelection);
		String shippingPagePrice = waitForElementTobeVisible(By.xpath(shippingPageLocator)).getText().trim();

		waitUntilLoaderDisappers();

		waitForElementTobeVisible(By.xpath("//button[@routerlink='/dashboard/myorders']")).click();

		List<WebElement> listOfHeaders = waitForAllElementTobeVisible(By.xpath("//table/thead//th"));
		List<String> listOfHeaderText = new ArrayList<String>();

		for (WebElement header : listOfHeaders)
			listOfHeaderText.add(header.getText());

		int priceIndex = listOfHeaderText.indexOf("Price");

		String orderPageLocator = String.format("//td[text()='%s']/parent::tr/td[" + priceIndex + "]", productSelection);
		String orderPagePrice = waitForElementTobeVisible(By.xpath(orderPageLocator)).getText();

		Assert.assertEquals(productPagePrice, cartPagePrice);
		Assert.assertEquals(productPagePrice, orderPagePrice);
		Assert.assertEquals(productPagePrice, shippingPagePrice);

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
