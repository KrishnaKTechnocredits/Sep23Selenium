/*Assignment34:

1. complete the TC5 from below sheet
https://docs.google.com/spreadsheets/d/1XAsOC5KFoI_AOnB9Zwn4AvSSU0pHXyGgoCexc8Pt-HE/edit#gid=0
*/

package jaykumar;

import java.util.List;

import org.openqa.selenium.By;
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

	@BeforeMethod
	void setUp() {
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	void addToCartTestCase() throws InterruptedException {
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
		waitForElementTobeVisible(By.xpath("//li/button[contains(text(), 'Cart')]")).click();

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

		System.out.println("VERIFY - Successful order placed toast message");
		WebElement toastMessage = waitForElementTobeVisible(By.xpath("//div[@aria-label='Order Placed Successfully']"));
		Assert.assertTrue(toastMessage.isDisplayed(), "Toast message not displayed");

		System.out.println("VERIFY - THANK YOU FOR THE ORDER Message");
		WebElement feedbackMessage = driver.findElement(By.xpath("//h1[contains(text(), 'Thankyou')]"));
		Assert.assertTrue(feedbackMessage.isDisplayed(), "Toast message not displayed");
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
