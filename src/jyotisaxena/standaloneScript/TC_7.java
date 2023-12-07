/*1. navigate to https://rahulshettyacademy.com/client/
2. user enters the username
3. user enters the password
4. user click on the login button
5. user select any product & clicked on add to cart button
6. user click on cart tab
7. user click on the checkout button
8. user enter the "4542 9931 9292 2293" credit number
9. user enter name as "Mahesh"
10. user does not select country
11. user click on "Place Order"
12. user getting toast messgae "Please Enter Full Shipping Information" on checkout page*/
package jyotisaxena.standaloneScript;

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

public class TC_7 {

	WebDriver driver;
	String uname = "jyotisaxena2006@gmail.com";
	String pwd = "Welcome@1234";
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
		driver.findElement(By.id("userEmail")).sendKeys(uname);
		System.out.println("STEP : Enter PAssword");
		driver.findElement(By.id("userPassword")).sendKeys(pwd);
		System.out.println("STEP : Click On Login");
		driver.findElement(By.id("login")).click();

		String selectProduct = "iphone 13 pro";
		String productPath = "//b[text()='" + selectProduct
				+ "']/parent::h5/following-sibling::button[text()=' Add To Cart']";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(productPath)));
		driver.findElement(By.xpath(productPath)).click();

		System.out.println("STEP : Product into cart is verify");
		String successFullyMessage = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Product Added To Cart ']")))
				.getText();
		Assert.assertEquals(successFullyMessage, "Product Added To Cart");

		waitUntilLoaderDisappers();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")));
		System.out.println("STEP: click on cart button");

		waitForElementTobeVisible(By.xpath("//button[text()='Checkout']")).click();
		System.out.println("STEP: Clicked on checkout button");

		waitUntilLoaderDisappers();

		String attValue = driver
				.findElement(By.xpath("//div[contains(text(),'Credit Card Number')]/following-sibling::input"))
				.getAttribute("value");
		if (attValue.length() > 1) {
			driver.findElement(By.xpath("//div[contains(text(),'Credit Card Number')]/following-sibling::input"))
					.clear();
			driver.findElement(By.xpath("//div[contains(text(),'Credit Card Number')]/following-sibling::input"))
					.sendKeys("4542 9846 7822 2293");
			System.out.println("STEP : User enter credit card number");
		}

		System.out.println("STEP : User Enter CVV Code");
		driver.findElement(By.xpath("//span[@class='numberCircle']/parent::div/following-sibling::input"))
				.sendKeys("786");

		System.out.println("STEP : User entered name as Jyoti");
		waitForElementTobeVisible(By.xpath("//div[@class = 'field']/input[@class='input txt']")).sendKeys("Jyoti");

		System.out.println("STEP : User Click On Place Order Button");
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", driver
				.findElement(By.xpath("//div[@class = 'actions']/a[@class ='btnn action__submit ng-star-inserted']")));

		waitUntilLoaderDisappers();

		System.out.println("VERIFY : Please Enter Full Shipping Information Toast Meassage is verify");
		String failMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")))
				.getText();
		Assert.assertEquals(failMessage, "Please Enter Full Shipping Information");
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
