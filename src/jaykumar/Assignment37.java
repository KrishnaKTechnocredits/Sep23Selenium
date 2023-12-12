/*Assignment37:

1. complete the TC9 from below sheet
https://docs.google.com/spreadsheets/d/1XAsOC5KFoI_AOnB9Zwn4AvSSU0pHXyGgoCexc8Pt-HE/edit#gid=0
*/

package jaykumar;

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

public class Assignment37 {
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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")));
		
		System.out.println("STEP - Remove products from cart");
		List<WebElement> listOfRemoveWebElements = waitForAllElementTobeVisible(By.xpath("//button[@class='btn btn-danger']"));
		for (WebElement singleRemoveELement : listOfRemoveWebElements) {
			singleRemoveELement.click();
		}

		System.out.println("VERIFY - 'No produect in your cart' toast message");
		WebElement toastMessage = waitForElementTobeVisible(By.xpath("//div[@id='toast-container']//div[contains(text(), 'No Product in Your Cart')]"));
		Assert.assertTrue(toastMessage.isDisplayed(), "Toast message not displayed");

		System.out.println("VERIFY - 'No Products in Your Cart'");
		WebElement feedbackMessage = driver.findElement(By.xpath("//h1[contains(text(), 'No Products in Your Cart')]"));
		Assert.assertTrue(feedbackMessage.isDisplayed(), "Feedback message not displayed");
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
