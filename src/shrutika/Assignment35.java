/*Test case 5 */
package shrutika;

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

public class Assignment35 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	void setup() {
		System.out.println("STEP: Launch Chrome Browser and  Navigate to https://rahulshettyacademy.com/client/");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");

		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");
	}

	@Test
	void verifCheckoutProcess() {

		System.out.println("STEP: Input the Login credentials");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("shrutikad905@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Shrutika@123");
		driver.findElement(By.xpath("//input[@id='login']")).click();

		wait = new WebDriverWait(driver, 5);

		String selectProduct = "adidas original";
		String productPath = "//b[text()='" + selectProduct
				+ "']/parent::h5/following-sibling::button[text()=' Add To Cart']";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(productPath)));
		driver.findElement(By.xpath(productPath)).click();

		System.out.println("STEP: verify Product into cart ");
		String verifyproduct = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Product Added To Cart ']")))
				.getText();
		Assert.assertEquals(verifyproduct, "Product Added To Cart");

		waitUntilLoaderDisappers();

		System.out.println("STEP: Click on cart button");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")));

		System.out.println("STEP: Click on checkout button");
		waitForElementTobeVisible(By.xpath("//button[text()='Checkout']")).click();

		waitUntilLoaderDisappers();

		System.out.println("STEP: User enter credit card number");
		String attributeValue = driver
				.findElement(By.xpath("//div[contains(text(),'Credit Card Number')]/following-sibling::input"))
				.getAttribute("value");
		if (attributeValue.length() > 1) {
			driver.findElement(By.xpath("//div[contains(text(),'Credit Card Number')]/following-sibling::input"))
					.clear();
			driver.findElement(By.xpath("//div[contains(text(),'Credit Card Number')]/following-sibling::input"))
					.sendKeys("4542 9846 7822 2293");
		}

		System.out.println("STEP: Enter CVV Code");
		driver.findElement(By.xpath("//span[@class='numberCircle']/parent::div/following-sibling::input"))
				.sendKeys("786");

		System.out.println("STEP: Enter user name");
		waitForElementTobeVisible(By.xpath("//div[@class = 'field']/input[@class='input txt']")).sendKeys("Shrutika");

		System.out.println("STEP: Select Country");
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");

		List<WebElement> listOfWebElements = waitForAllElementTobeVisible(
				By.xpath("//section[@class='ta-results list-group ng-star-inserted']//button"));
		for (WebElement singleELement : listOfWebElements) {
			if (singleELement.getText().equalsIgnoreCase("india")) {
				singleELement.click();
			}
		}

		System.out.println("STEP: Click On Place Order Button");
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", driver
				.findElement(By.xpath("//div[@class = 'actions']/a[@class ='btnn action__submit ng-star-inserted']")));

		System.out.println("STEP: Verify Order Placed Successfully Toast Message displayed");
		driver.findElement(By.xpath("//div[@class='toast-bottom-right toast-container']"));

		System.out.println("VERIFY : Validate THANKYOU FOR THE ORDER Title Displayed");
		Assert.assertTrue(waitForElementTobeVisible(By.xpath("//h1[@class='hero-primary']")).isDisplayed(),
				"Title is not displayed");
	}

	public void waitUntilLoaderDisappers() {
		wait = new WebDriverWait(driver, 5);
		try {
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(
					"//div[contains(@class,'la-ball-scale-multiple')]//div[contains(@class,'ng-star-inserted')]"))));
		} catch (Exception e) {

		}
	}

	public WebElement waitForElementTobeVisible(By by) {
		wait = new WebDriverWait(driver, 5);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public List<WebElement> waitForAllElementTobeVisible(By by) {
		wait = new WebDriverWait(driver, 5);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}

	@AfterMethod
	void closeBrowser() {
		System.out.println("STEP: Close browser ");
		driver.close();
	}
}
