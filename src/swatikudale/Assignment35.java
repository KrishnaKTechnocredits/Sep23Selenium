/*Assignment : 30th Nov 23

1. complete the TC5 from below sheet
https://docs.google.com/spreadsheets/d/1XAsOC5KFoI_AOnB9Zwn4AvSSU0pHXyGgoCexc8Pt-HE/edit#gid=0
*/
package swatikudale;

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
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Maximize browser window");
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Open given URL");
		driver.get("https://rahulshettyacademy.com/client/");
	}

	@Test
	void verifyFilter() {

		System.out.println("Input the Login credentials");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("swatikudale92@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Swati@1592");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		System.out.println("Logged in ");

		wait = new WebDriverWait(driver, 5);

		String selectProduct = "zara coat 3";
		String productPath = "//b[text()='" + selectProduct
				+ "']/parent::h5/following-sibling::button[text()=' Add To Cart']";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(productPath)));
		driver.findElement(By.xpath(productPath)).click();

		System.out.println("verify Product into cart ");
		String verifyproduct = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Product Added To Cart ']")))
				.getText();
		Assert.assertEquals(verifyproduct, "Product Added To Cart");

		waitUntilLoaderDisappers();

		System.out.println("click on cart button");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")));

		System.out.println("click on checkout button");
		waitForElementTobeVisible(By.xpath("//button[text()='Checkout']")).click();

		waitUntilLoaderDisappers();

		System.out.println("User enter credit card number");
		String attributeValue = driver
				.findElement(By.xpath("//div[contains(text(),'Credit Card Number')]/following-sibling::input"))
				.getAttribute("value");
		if (attributeValue.length() > 1) {
			driver.findElement(By.xpath("//div[contains(text(),'Credit Card Number')]/following-sibling::input"))
					.clear();
			driver.findElement(By.xpath("//div[contains(text(),'Credit Card Number')]/following-sibling::input"))
					.sendKeys("4542 9846 7822 2293");
		}

		System.out.println("Enter CVV Code");
		driver.findElement(By.xpath("//span[@class='numberCircle']/parent::div/following-sibling::input"))
				.sendKeys("786");

		System.out.println("Enter user name");
		waitForElementTobeVisible(By.xpath("//div[@class = 'field']/input[@class='input txt']")).sendKeys("Swati");

		System.out.println("Select Country");
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");

		List<WebElement> listOfWebElements = waitForAllElementTobeVisible(
				By.xpath("//section[@class='ta-results list-group ng-star-inserted']//button"));
		for (WebElement singleELement : listOfWebElements) {
			if (singleELement.getText().equalsIgnoreCase("india")) {
				singleELement.click();
			}
		}

		System.out.println("Click On Place Order Button");
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", driver
				.findElement(By.xpath("//div[@class = 'actions']/a[@class ='btnn action__submit ng-star-inserted']")));

		System.out.println("Verify Order Placed Successfully Toast Message displayed");
		driver.findElement(By.xpath("//div[@class='toast-bottom-right toast-container']"));

		System.out.println("Validate THANKYOU FOR THE ORDER Title Displayed");
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
	public void tearDown() {
		driver.close();
	}
}
