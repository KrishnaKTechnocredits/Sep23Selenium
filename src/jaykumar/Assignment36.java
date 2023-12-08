/*Assignment36:
1. complete the TC6, TC7, TC8 from below sheet
https://docs.google.com/spreadsheets/d/1XAsOC5KFoI_AOnB9Zwn4AvSSU0pHXyGgoCexc8Pt-HE/edit#gid=0
*/

package jaykumar;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment36 {
	WebDriver driver;

	@BeforeMethod
	void setUp() {
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	void testCase06() throws InterruptedException {
		System.out.println("STEP - Navigate to rahulshettyacademy.com");
		driver.get("https://rahulshettyacademy.com/client/");

		System.out.println("STEP - Enter user details and Login");
		driver.findElement(By.id("userEmail")).sendKeys("bankarjaykumar@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Jay@131197");
		driver.findElement(By.id("login")).click();

		System.out.println("STEP - Select product and Add to cart");
		String productSelection = "iphone 13 pro";
		String addToCartLocator = String.format(
				"//b[text()='%s']/parent::h5/following-sibling::button[contains(text(), 'Add To Cart')]",
				productSelection);
		waitForElementTobeVisible(By.xpath(addToCartLocator)).click();

		waitUntilLoaderDisappers();
		System.out.println("STEP - Go to cart");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")));
		
		System.out.println("STEP - Click on checkout");
		waitForElementTobeVisible(By.xpath("//button[text()='Checkout']")).click();

		waitUntilLoaderDisappers();
		
		System.out.println("STEP - Enter Credit card number if blank");
		WebElement cardnumberElement = waitForElementTobeVisible(By.xpath("//div[contains(text(),'Credit Card Number')]/following-sibling::input"));
		if (cardnumberElement.getAttribute("value").length() == 0) {
			cardnumberElement.sendKeys("4542 9931 9292 2293");
		} else {
			System.out.println("Card number is already there");
		}

		System.out.println("STEP - Enter CVV");
		WebElement cvvElement = driver
				.findElement(By.xpath("//div[text()='CVV Code ']/following-sibling::input[@class='input txt']"));
		cvvElement.sendKeys("123");

		System.out.println("STEP - Enter name");
		WebElement nameElement = driver.findElement(By.xpath("//div[@class='field']/input[@class='input txt']"));
		nameElement.sendKeys("mahesh");

		System.out.println("STEP - Select country");
		WebElement countryElement = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
		countryElement.sendKeys("india");

		List<WebElement> listOfWebElements = waitForAllElementTobeVisible(
				By.xpath("//section[@class='ta-results list-group ng-star-inserted']//button"));
		for (WebElement singleELement : listOfWebElements) {
			if (singleELement.getText().equalsIgnoreCase("india")) {
				singleELement.click();
			}
		}

		System.out.println("STEP - Click on place order");
		driver.findElement(By.xpath("//a[contains(text(), 'Place Order')]")).click();
		
		System.out.println("STEP - Click on Orders button");
		waitForElementTobeVisible(By.xpath("//button[contains(text(), 'ORDERS')]")).click();
		
		System.out.println("VERIFY - Ordered product is in orders tab");
		String orderLocator = String.format("//td[text()='%s']", productSelection);
		Assert.assertTrue(waitForElementTobeVisible(By.xpath(orderLocator)).isDisplayed(),
				"Ordered product not displayed in orders tab");
	}

	@Test
	void testCase07() throws InterruptedException {
		System.out.println("STEP - Navigate to rahulshettyacademy.com");
		driver.get("https://rahulshettyacademy.com/client/");

		System.out.println("STEP - Enter user details and Login");
		driver.findElement(By.id("userEmail")).sendKeys("bankarjaykumar@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Jay@131197");
		driver.findElement(By.id("login")).click();

		System.out.println("STEP - Select product and Add to cart");
		String productSelection = "iphone 13 pro";
		String addToCartLocator = String.format(
				"//b[text()='%s']/parent::h5/following-sibling::button[contains(text(), 'Add To Cart')]",
				productSelection);
		waitForElementTobeVisible(By.xpath(addToCartLocator)).click();

		waitUntilLoaderDisappers();
		System.out.println("STEP - Go to cart");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")));
		
		System.out.println("STEP - Click on checkout");
		waitForElementTobeVisible(By.xpath("//button[text()='Checkout']")).click();

		System.out.println("STEP - Enter Credit card number if blank");
		WebElement cardnumberElement = waitForElementTobeVisible(By.xpath("//div[contains(text(),'Credit Card Number')]/following-sibling::input"));
		if (cardnumberElement.getAttribute("value").length() == 0) {
			cardnumberElement.sendKeys("4542 9931 9292 2293");
		} else {
			System.out.println("Card number is already there");
		}

		System.out.println("STEP - Enter CVV");
		WebElement cvvElement = driver
				.findElement(By.xpath("//div[text()='CVV Code ']/following-sibling::input[@class='input txt']"));
		cvvElement.sendKeys("123");

		System.out.println("STEP - Enter name");
		WebElement nameElement = driver.findElement(By.xpath("//div[@class='field']/input[@class='input txt']"));
		nameElement.sendKeys("mahesh");

		System.out.println("STEP - Click on place order");
		driver.findElement(By.xpath("//a[contains(text(), 'Place Order')]")).click();

		System.out.println("VERIFY - 'Please Enter Full Shipping Information' toast message");
		WebElement toastMessage = waitForElementTobeVisible(By.xpath("//div[@aria-label='Please Enter Full Shipping Information']"));
		Assert.assertTrue(toastMessage.isDisplayed(), "Toast message not displayed");
	}
	
	@Test
	void testCase08() throws InterruptedException {
		System.out.println("STEP - Navigate to rahulshettyacademy.com");
		driver.get("https://rahulshettyacademy.com/client/");

		System.out.println("STEP - Enter user details and Login");
		driver.findElement(By.id("userEmail")).sendKeys("bankarjaykumar@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Jay@131197");
		driver.findElement(By.id("login")).click();
		
		String productSelection = "iphone 13 pro";
		
		System.out.println("STEP - Capture product price on product page");
		String productPagePriceLocator = String.format("//div[@class='card-body']//b[text()='%s']/parent::h5/following-sibling::div/div", productSelection);
		String productPagePrice = waitForElementTobeVisible(By.xpath(productPagePriceLocator)).getText();

		System.out.println("STEP - Select product and Add to cart");
		String addToCartLocator = String.format(
				"//b[text()='%s']/parent::h5/following-sibling::button[contains(text(), 'Add To Cart')]",
				productSelection);
		waitForElementTobeVisible(By.xpath(addToCartLocator)).click();

		waitUntilLoaderDisappers();
		System.out.println("STEP - Go to cart");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")));
		
		System.out.println("STEP - Capture product price on cart page");
		String cartPriceLocator = String.format(
				"//h3[text()='%s']/parent::div/following-sibling::div[@class='prodTotal cartSection']/p",
				productSelection);
		String cartPagePrice = waitForElementTobeVisible(By.xpath(cartPriceLocator)).getText();
		
		System.out.println("STEP - Click on checkout");
		waitForElementTobeVisible(By.xpath("//button[text()='Checkout']")).click();
		
		waitUntilLoaderDisappers();

		System.out.println("STEP - Capture product price on payment page");
		String paymentPriceLocator = String.format(
				"//div[contains(text(), '%s')]/following-sibling::div[@class='item__price']",
				productSelection);
		String paymentPagePrice = waitForElementTobeVisible(By.xpath(paymentPriceLocator)).getText();
		
		System.out.println("STEP - Enter Credit card number if blank");
		WebElement cardnumberElement = waitForElementTobeVisible(By.xpath("//div[contains(text(),'Credit Card Number')]/following-sibling::input"));
		if (cardnumberElement.getAttribute("value").length() == 0) {
			cardnumberElement.sendKeys("4542 9931 9292 2293");
		} else {
			System.out.println("Card number is already there");
		}

		System.out.println("STEP - Enter CVV");
		WebElement cvvElement = driver.findElement(By.xpath("//div[text()='CVV Code ']/following-sibling::input[@class='input txt']"));
		cvvElement.sendKeys("123");

		System.out.println("STEP - Enter name");
		WebElement nameElement = driver.findElement(By.xpath("//div[@class='field']/input[@class='input txt']"));
		nameElement.sendKeys("mahesh");

		System.out.println("STEP - Select country");
		WebElement countryElement = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
		countryElement.sendKeys("india");

		List<WebElement> listOfCountryWebElements = waitForAllElementTobeVisible(By.xpath("//section[@class='ta-results list-group ng-star-inserted']//button"));
		for (WebElement singleCountryELement : listOfCountryWebElements) {
			if (singleCountryELement.getText().equalsIgnoreCase("india")) {
				singleCountryELement.click();
			}
		}

		System.out.println("STEP - Click on place order");
		driver.findElement(By.xpath("//a[contains(text(), 'Place Order')]")).click();
		
		System.out.println("STEP - Capture product price on order info page");
		String shippingPageLocator = String
				.format("//div[text()='%s']/parent::td/following-sibling::td/div[@class='title']", productSelection);
		String shippingPagePrice = waitForElementTobeVisible(By.xpath(shippingPageLocator)).getText().trim();
		
		System.out.println("STEP - Click on Orders button");
		waitForElementTobeVisible(By.xpath("//button[@routerlink='/dashboard/myorders']")).click();
		
		List<WebElement> listOfHeaders = waitForAllElementTobeVisible(By.xpath("//table/thead//th"));
		List<String> listOfHeaderText = new ArrayList<String>();
		for (WebElement header : listOfHeaders)
			listOfHeaderText.add(header.getText());
		int priceIndex = listOfHeaderText.indexOf("Price");
		String orderPageLocator = String.format("//td[text()='%s']/parent::tr/td[" + priceIndex + "]", productSelection);
		String orderPagePrice = waitForElementTobeVisible(By.xpath(orderPageLocator)).getText();

		System.out.println("VERIFY - Product price of all pages");
		Assert.assertEquals(productPagePrice, cartPagePrice);
		Assert.assertEquals(productPagePrice, paymentPagePrice);
		Assert.assertEquals(productPagePrice, shippingPagePrice);
		Assert.assertEquals(productPagePrice, orderPagePrice);
	}

	void waitUntilLoaderDisappers() {
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

	@AfterMethod
	void tearDown() {
		driver.close();
	}
}
