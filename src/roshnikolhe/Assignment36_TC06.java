/*
 * TC06 - validate that booked product displayed in the orders tab
 * https://docs.google.com/spreadsheets/d/1XAsOC5KFoI_AOnB9Zwn4AvSSU0pHXyGgoCexc8Pt-HE/edit#gid=0
1. navigate to https://rahulshettyacademy.com/client/
2. user enters the username
3. user enters the password
4. user click on the login button
5. user select any product & clicked on add to cart button
6. user click on cart tab
7. user click on the checkout button
8. user enter the "4542 9931 9292 2293" credit number
9. user enter name as "Mahesh"
10. user select country as "India"
11. user click on the "Place Order" button
12. user naviagate to Orders tab
13. user validates that order product displayed in orders tab
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

public class Assignment36_TC06 {
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
	public void ordersCheck(String url, String uName, String uPasswrd) {
		launchBrowser();
		driver.get(url);
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(uName);
		driver.findElement(By.id("userPassword")).sendKeys(uPasswrd);
		driver.findElement(By.id("login")).click();
		System.out.println("STEP: Login Successfully!");
		String product = "iphone 13 pro";

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

		System.out.println("STEP: User clicks on Place Order button!");
		WebElement placeOrder = waitForElement("//a[@class='btnn action__submit ng-star-inserted']");
		//scrollFunction(placeOrder);
		jsClickAction(placeOrder);

		System.out.println("VERIFY: System displays success message on placing order!");
		WebElement toastOrder = waitForElement("//div[@aria-label='Order Placed Successfully']");
		Assert.assertEquals(toastOrder.getText(), "Order Placed Successfully");

		System.out.println("VERIFY: System displays 'THANKYOU FOR THE ORDER' message on the screen!");
		WebElement thanksMsg = waitForElement("//h1[text()=' Thankyou for the order. ']");
		Assert.assertEquals(thanksMsg.getText(), "THANKYOU FOR THE ORDER.");

		System.out.println("STEP: User clicks on Orders tab!");
		WebElement orderTab = waitForElement("//button[@routerlink='/dashboard/myorders']");
		//scrollFunction(orderTab);
		jsClickAction(orderTab);

		System.out.println("VERIFY: User validates that the added product is displayed on the Orders page!");
		String orderedProduct = String.format("//table/tbody/tr/td[text()='%s']", product);
		WebElement bookedProduct = waitForElement(orderedProduct);
		Assert.assertEquals(bookedProduct.getText(), product);
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