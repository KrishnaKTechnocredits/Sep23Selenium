/*1. navigate to https://rahulshettyacademy.com/client/
2. user enters the username
3. user enters the password
4. user click on the login button
5. user add product to cart
6. user click on cart
7. user delete the all product from the cart page
8. user should not see product on cart page
9. user validate "No Products in Your Cart !" messgae displayed on cart page*/
package denishsantoki.standAloneScripts;

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

public class TC_09 {

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

		System.out.println("STEP: product added to cart");
		waitForElementTobeVisible(By.xpath(locatorForAddToCart)).click();

		waitUntilLoaderDisappers();

		System.out.println("STEP: click on cart button");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")));
		
		System.out.println("STEP : Click On Delete Button");
		List<WebElement> listOfbutton = driver.findElements(By.xpath("//button[@class='btn btn-danger']"));
		for (WebElement button : listOfbutton) {
			button.click();
		}
		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='No Products in Your Cart !']")).isDisplayed(),
				"No Product In Your Cart Message is Not Displayed");
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
