/*1. navigate to https://rahulshettyacademy.com/client/
2. user enters the username
3. user enters the password
4. user click on the login button
5. user capture price of product
6. user select product & clicked on add to cart button
7. user validate price on cart page
8. user click on checkout page
9. user validate price on payment page
10. user enter valid infor & place order
11. user vaidate price on order page
12. user navigate to orders tab
13. user validates the price on order page*/
package denishsantoki.standAloneScripts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_08 {
	
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	void setup() {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	@Test
	void verifyFilter() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("STEP : Enter Email");
		driver.findElement(By.id("userEmail")).sendKeys("denishsantoki74@gmail.com");
		System.out.println("STEP : Enter PAssword");
		driver.findElement(By.id("userPassword")).sendKeys("D@d10033517#");
		System.out.println("STEP : Click On Login");
		driver.findElement(By.id("login")).click();
		
		String selectProduct = "adidas original";
		String locatorForAddToCart = String.format(
				"//h5//b[text()='%s']/parent::h5/following-sibling::button[contains(text(),'Add To Cart')]/i",
				selectProduct);

		String productPagePriceLocator = String.format(
				"//div[@class='card-body']//b[text()='%s']/parent::h5/following-sibling::div/div", selectProduct);
		String productPagePrice = waitForElementTobeVisible(By.xpath(productPagePriceLocator)).getText();

		System.out.println("STEP: product added to cart");
		waitForElementTobeVisible(By.xpath(locatorForAddToCart)).click();

		waitUntilLoaderDisappers();

		System.out.println("STEP: click on cart button");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")));

		String cartPriceLocator = String.format(
				"//h3[text()='%s']/parent::div/following-sibling::div[@class='prodTotal cartSection']/p",
				selectProduct);
		String cartPagePrice = waitForElementTobeVisible(By.xpath(cartPriceLocator)).getText();

		System.out.println("STEP: Clicked on checkout button");
		waitForElementTobeVisible(By.xpath("//button[text()='Checkout']")).click();
		
		waitUntilLoaderDisappers();

		String attValue = driver
				.findElement(By.xpath("//div[contains(text(),'Credit Card Number')]/following-sibling::input"))
				.getAttribute("value");
		if (attValue.length() > 1) {
			driver.findElement(By.xpath("//div[contains(text(),'Credit Card Number')]/following-sibling::input")).clear();
			driver.findElement(By.xpath("//div[contains(text(),'Credit Card Number')]/following-sibling::input"))
					.sendKeys("4542 9846 7822 2293");
			System.out.println("STEP: User enter credit card number");
		}
		
		System.out.println("STEP : Enter CVV Code");
		driver.findElement(By.xpath("//span[@class='numberCircle']/parent::div/following-sibling::input"))
				.sendKeys("896");
		
		System.out.println("STEP : Enter user name as Denish");
		driver.findElement(By.xpath("//div[contains(text(),'Name on Card')]/following-sibling::input"))
		.sendKeys("Denish");

		System.out.println("STEP : Select Your Country");
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");

		List<WebElement> listOfWebElements = waitForAllElementTobeVisible(
				By.xpath("//section[@class='ta-results list-group ng-star-inserted']//button"));
		for (WebElement singleELement : listOfWebElements) {
			if (singleELement.getText().equalsIgnoreCase("india")) {
				singleELement.click();
			}
		}
		
		System.out.println("STEP : Click On Place Order");
		 js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()",
					driver.findElement(By.xpath("//div[@class = 'actions']/a[@class ='btnn action__submit ng-star-inserted']")));
			

		String shippingPageLocator = String
				.format("//div[text()='%s']/parent::td/following-sibling::td/div[@class='title']", selectProduct);
		String shippingPagePrice = waitForElementTobeVisible(By.xpath(shippingPageLocator)).getText().trim();

		waitUntilLoaderDisappers();
		
		System.out.println("STEP : Click On Cart Tab");
		waitForElementTobeVisible(By.xpath("//button[@routerlink='/dashboard/myorders']")).click();

		List<WebElement> listOfHeaders = waitForAllElementTobeVisible(By.xpath("//table/thead//th"));
		List<String> listOfHeaderText = new ArrayList<String>();

		for (WebElement header : listOfHeaders)
			listOfHeaderText.add(header.getText());

		int priceIndex = listOfHeaderText.indexOf("Price");

		String orderPageLocator = String.format("//td[text()='%s']/parent::tr/td[" + priceIndex + "]", selectProduct);
		String orderPagePrice = waitForElementTobeVisible(By.xpath(orderPageLocator)).getText();

		Assert.assertEquals(productPagePrice, cartPagePrice);
		Assert.assertEquals(productPagePrice, orderPagePrice);
		Assert.assertEquals(productPagePrice, shippingPagePrice);
		System.out.println("VERIFY : Validate All Page Prince Is Same");

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
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
