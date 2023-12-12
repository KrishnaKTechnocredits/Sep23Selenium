/*
 * TC08 - validate price of product on every page
 * https://docs.google.com/spreadsheets/d/1XAsOC5KFoI_AOnB9Zwn4AvSSU0pHXyGgoCexc8Pt-HE/edit#gid=0
1. navigate to https://rahulshettyacademy.com/client/
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
13. user validates the price on order page
 
 */

package roshnikolhe;

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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assignment36_TC08 {
	WebDriver driver;
	WebDriverWait wait;

	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", ".//chromeDriver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 10);
	}

	public WebElement waitForElement(String locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}

	public void scrollFunction(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
	}

	public void jsClickAction(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click(true)", e);
	}

	@Test(dataProvider = "loginDetails")
	public void productPriceValidation(String url, String uName, String uPasswrd) {
		launchBrowser();
		driver.get(url);
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(uName);
		driver.findElement(By.id("userPassword")).sendKeys(uPasswrd);
		driver.findElement(By.id("login")).click();
		System.out.println("STEP: Login Successfully!");

		String product = "iphone 13 pro";
		WebElement productPriceElement = waitForElement(
				"//h5/b[text()='" + product + "']/parent::h5/following-sibling::div/div");
		String actualProductPrice = productPriceElement.getText();
		String productLocator = String
				.format("//h5//b[text()='%s']/parent::h5/following-sibling::button[text()=' Add To Cart']", product);

		System.out.println("STEP: Product Added in the Cart!");
		WebElement addToCart = waitForElement(productLocator);
		addToCart.click();

		WebElement toastMsg = waitForElement("//div[@aria-label='Product Added To Cart']");
		System.out.println("VERIFY: Success Toast message is displayed!");
		Assert.assertTrue(toastMsg.isDisplayed(), toastMsg + " not displayed!");

		System.out.println("STEP: User Navigates to the Cart!");
		driver.findElement(By.xpath("//li//button[contains(text(),'Cart')]")).click();

		System.out.println("VERIFY: Product Added in the cart");
		WebElement addedProduct = waitForElement("//h3[text()='" + product + "']");
		Assert.assertTrue(addedProduct.isDisplayed(), "Added product '" + product + "'not displayed!");

		System.out.println("VERIFY: Product Price verification on the CART PAGE!");
		String productPriceCartLocator = String.format("//h3[text()='%s']/parent::div/following-sibling::div/p",
				product);
		String productPriceCartPage = driver.findElement(By.xpath(productPriceCartLocator)).getText();
		Assert.assertEquals(productPriceCartPage, actualProductPrice, "Product price is different in Cart");

		System.out.println("VERIFY: User clicks on Checkout button");
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();

		driver.findElement(By.xpath("//div[text()='Credit Card Number ']/following-sibling::input")).clear();
		driver.findElement(By.xpath("//div[text()='Credit Card Number ']/following-sibling::input"))
				.sendKeys("4542 9931 9292 2293");

		driver.findElement(By.xpath("//div[text()='Name on Card ']/following-sibling::input")).sendKeys("Mahesh");

		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("India");

		List<WebElement> listOfCountries = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//section[@class='ta-results list-group ng-star-inserted']/button")));

		for (WebElement country : listOfCountries) {
			String countryToSelect = country.getText();
			if (countryToSelect.equalsIgnoreCase("india"))
				country.click();
		}

		System.out.println("VERIFY: Product Price verification on the PAYMENT PAGE!");
		String productPricePaymentPage = driver.findElement(By.xpath("//div[@class='item__price']")).getText();
		Assert.assertEquals(productPricePaymentPage, actualProductPrice, "Product price is different in Cart");

		System.out.println("STEP: User clicks on Place Order button!");
		WebElement placeOrder = waitForElement("//a[@class='btnn action__submit ng-star-inserted']");
		// scrollFunction(placeOrder);
		jsClickAction(placeOrder);

		System.out.println("VERIFY: System displays success message on placing order!");
		WebElement toastOrder = waitForElement("//div[@aria-label='Order Placed Successfully']");
		Assert.assertEquals(toastOrder.getText(), "Order Placed Successfully");

		System.out.println("VERIFY: System displays 'THANKYOU FOR THE ORDER' message on the screen!");
		WebElement thanksMsg = waitForElement("//h1[text()=' Thankyou for the order. ']");
		Assert.assertEquals(thanksMsg.getText(), "THANKYOU FOR THE ORDER.");

		System.out.println("VERIFY: Product Price verification on the PLACE ORDER PAGE!");
		String productPricePlaceOrderPage = driver
				.findElement(By.xpath("//td[@class='line-item product-info-column']/div[@class='title']")).getText();
		Assert.assertEquals(productPricePlaceOrderPage, actualProductPrice,
				"Product price is different in Place order page");

		System.out.println("STEP: User clicks on Orders tab!");
		WebElement orderTab = waitForElement("//button[@routerlink='/dashboard/myorders']");
		// scrollFunction(orderTab);
		jsClickAction(orderTab);

		System.out.println("VERIFY: User validates that the added product is displayed on the Orders page!");
		String orderedProduct = String.format("//table/tbody/tr/td[text()='%s']", product);
		WebElement bookedProduct = waitForElement(orderedProduct);
		Assert.assertEquals(bookedProduct.getText(), product);

		System.out.println("VERIFY: Product Price verification on the ORDER PAGE!");
		String productPriceOrderPage = null;
		List<WebElement> listofDetails = driver.findElements(By.xpath("//tr[@class='ng-star-inserted']/td"));
		for (WebElement entity : listofDetails) {
			if (entity.getText().contains("$"))
				productPriceOrderPage = entity.getText();
		}
		Assert.assertEquals(productPriceOrderPage, actualProductPrice,
				"Product price is different in Place order page");
	}

	@DataProvider
	public Object[][] loginDetails() {
		Object[][] data = new Object[1][3];
		data[0][0] = "https://rahulshettyacademy.com/client/";
		data[0][1] = "roshnikolhe1@gmail.com";
		data[0][2] = "Practice@123";

		return data;
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}