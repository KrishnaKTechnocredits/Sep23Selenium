//1. navigate to https://rahulshettyacademy.com/client/
//2. user enters the username
//3. user enters the password
//4. user click on the login button
//5. user select any product & clicked on add to cart button
//6. user click on cart tab
//7. user click on the checkout button
//8. user enter the "4542 9931 9292 2293" credit number
//9. user enter name as "Mahesh"
//10. user select country as "India"
//11.  user click on "Place Order" button
//11. user can see "Order Placed Successfully" toast message displayed
//12. user validate that "THANKYOU FOR THE ORDER." title dispalyed

package pushpa.standAloneScripts;

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

public class TC5 {
	WebDriver driver;

	@BeforeClass
	public void setBrowser() {
		System.out.println("Step 1 - launch browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// 1. navigate to https://rahulshettyacademy.com/client/
		System.out.println("Step 2 -  navigate to https://rahulshettyacademy.com/client/");
		driver.navigate().to("https://rahulshettyacademy.com/client/");
	}

	@Test
	public void verifyCart() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement userEmailElement = driver.findElement(By.xpath("//input[@id = 'userEmail']"));
		userEmailElement.sendKeys("pushpa.gite1209@gmail.com");
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id = 'userPassword']"));
		passwordElement.sendKeys("Pa$$w0rd");
		WebElement loginElement = driver.findElement(By.xpath("//input[@id = 'login']"));
		loginElement.click();

		String productToSelect = "adidas original";
		String locatorForAddToCart = String.format(
				"//h5//b[text()='%s']/parent::h5/following-sibling::button[contains(text(),'Add To Cart')]/i",
				productToSelect);

		waitForElementTobeVisible(By.xpath(locatorForAddToCart)).click();
		System.out.println("STEP: product added to cart");

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
		if (attValue.length() == 0) {
			driver.findElement(By.xpath("//div[contains(text(),'Credit Card Number')]/following-sibling::input"))
					.sendKeys("4542 9846 7822 2293");
			System.out.println("STEP: User enter credit card number");
		}

		driver.findElement(By.xpath("//span[@class='numberCircle']/parent::div/following-sibling::input"))
				.sendKeys("896");

		driver.findElement(By.xpath("//div[contains(text(), 'Name on Card')]/following-sibling::input"))
				.sendKeys("Mahesh");

		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");

		List<WebElement> listOfWebElements = waitForAllElementTobeVisible(
				By.xpath("//section[@class='ta-results list-group ng-star-inserted']//button"));
		for (WebElement singleELement : listOfWebElements) {
			if (singleELement.getText().equalsIgnoreCase("india")) {
				singleELement.click();
			}
		}

		System.out.println("STEP: click button Place Order");

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[text()='Place Order ']")));

		System.out.println("STEP: Verify THANKYOU FOR THE ORDER. is displayed");
		Assert.assertTrue(driver.findElement(By.xpath("//tr//td//h1")).isDisplayed(),
				"THANKYOU FOR THE ORDER message is not displayed");

	}

	@AfterClass
	public void closeDriver() {
		driver.close();
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
