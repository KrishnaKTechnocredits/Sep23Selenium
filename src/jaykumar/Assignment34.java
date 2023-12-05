/*Assignment34:

1. complete the TC4 from below sheet
https://docs.google.com/spreadsheets/d/1XAsOC5KFoI_AOnB9Zwn4AvSSU0pHXyGgoCexc8Pt-HE/edit#gid=0
*/

package jaykumar;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment34 {
	WebDriver driver;
	
	@BeforeMethod
	void setUp(){
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
		String addToCartLocator = String.format("//b[text()='%s']/parent::h5/following-sibling::button[contains(text(), 'Add To Cart')]", productSelection);
		driver.findElement(By.xpath(addToCartLocator)).click();
		
		System.out.println("VERIFY - Successful Add to cart toast message");
		WebElement toastMessage = driver.findElement(By.xpath("//div[@aria-label='Product Added To Cart']"));
		Assert.assertTrue(toastMessage.isDisplayed(), "Toast message not displayed");
		
		System.out.println("STEP - Go to cart");
		driver.findElement(By.xpath("//li/button[contains(text(), 'Cart')]")).click();
		
		System.out.println("VERIFY - Product "+productSelection+" is added to cart");
		String itemInCart = String.format("//div[@class='cartSection']/h3[text()='iphone 13 pro']",productSelection);
		WebElement itemInCartElement = driver.findElement(By.xpath(itemInCart));
		Assert.assertTrue(itemInCartElement.isDisplayed(), "Added product "+productSelection+" not displayed in cart");
	}
	
	@AfterMethod
	void tearDown() {
		driver.close();
	}
}
