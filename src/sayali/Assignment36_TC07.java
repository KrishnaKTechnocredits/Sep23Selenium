/* 1. navigate to https://rahulshettyacademy.com/client/
2. user enters the username
3. user enters the password
4. user click on the login button
5. user select any product & clicked on add to cart button
6. user click on cart tab
7. user click on the checkout button
8. user enter the ""4542 9931 9292 2293"" credit number
9. user enter name as "Sayali"
10. user does not select country
11. user click on ""Place Order""
12. user getting toast message ""Please Enter Full Shipping Information"" on checkout page" */

package sayali;

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

public class Assignment36_TC07 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	void setup() {
		System.out.println("STEP: Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Navigate to given URL");
		driver.get("https://rahulshettyacademy.com/client/");
	}

	public void scrollFunction(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
	}

	@Test
	public void verifyLogin() {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("sayali.honrao@gmail.com");
		System.out.println("STEP: Entered Email address");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Sayali@1441");
		System.out.println("STEP: Entered Password");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		System.out.println("STEP: Clicked on Login Button");

		String productSelection = "zara coat 3";

		String locatorForAddToCart = String.format("//section[2]//button[2][contains(text(),' Add To Cart')]",
				productSelection);

		System.out.println("STEP: Product added to cart");
		waitForElementTobeVisible(By.xpath(locatorForAddToCart)).click();
		waitUntilLoaderDisappers();

		System.out.println("STEP: clicked on cart button");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")));

		System.out.println("STEP: Clicked on checkout button");
		waitForElementTobeVisible(By.xpath("//button[text()='Checkout']")).click();

		waitUntilLoaderDisappers();

		String attValue = driver
				.findElement(By.xpath("//div[contains(text(),'Credit Card Number')]/following-sibling::input"))
				.getAttribute("value");
		if (attValue.length() > 1) {
			System.out.println("STEP: User entered credit card number");
			driver.findElement(By.xpath("//div[contains(text(),'Credit Card Number')]/following-sibling::input"))
					.clear();
			driver.findElement(By.xpath("//div[contains(text(),'Credit Card Number')]/following-sibling::input"))
					.sendKeys("4542 9846 7822 2293");
		}

		waitForElementTobeVisible(By.xpath("//span[@class='numberCircle']/parent::div/following-sibling::input"))
				.sendKeys("896");
		waitUntilLoaderDisappers();

		System.out.println("STEP: User entered name as \"Sayali\"");
		waitForElementTobeVisible(By.xpath("//div[@class = 'field']/input[@class='input txt']")).sendKeys("Sayali");

		System.out.println("STEP: User does not select country");

		System.out.println("STEP: Clicked on Place Order button");
		driver.findElement(By.xpath("//a[contains(text(), 'Place Order')]")).click();

		System.out.println(
				"VERIFY : Toast message as \"Please Enter Full Shipping Information\" displayed on checkout page");
		WebElement toastMessage = waitForElementTobeVisible(
				By.xpath("//div[@aria-label='Please Enter Full Shipping Information']"));
		Assert.assertTrue(toastMessage.isDisplayed(), "Toast message not displayed");
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
	void tearDown() {
		driver.close();
	}
}
