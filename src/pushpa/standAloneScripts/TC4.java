//1. navigate to https://rahulshettyacademy.com/client/
//2. user enters the username
//3. user enters the password
//4. user click on the login button
//5. user select any product & clicked on add to cart button
//6. validate that add to cart toast message "Product Added To Cart" displayed
//7. user click on cart tab
//8. user validated that added product displayed

package pushpa.standAloneScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC4 {
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
		WebElement addToCartElement = driver.findElement(By.xpath("//h5//b[text()='" + productToSelect
				+ "']/parent::h5/following-sibling::button[text() = ' Add To Cart']"));
		addToCartElement.click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Product Added To Cart']")).isDisplayed(),
				"Add to Cart Toaster is not displayed");
		System.out.println("VERIFY: Toast messsage displayed");

		WebElement cartBtnElement = driver.findElement(By.xpath("//li//button[contains(text(), 'Cart')]"));
		cartBtnElement.click();

		WebElement cartElement = driver
				.findElement(By.xpath("//div[@class='cartSection']//h3[text() = '" + productToSelect + "']"));
		Assert.assertTrue(cartElement.isDisplayed(), "Element is not present in the cart");
		System.out.println("Verify Cart element");
	}

	@AfterClass
	public void closeDriver() {
		driver.close();
	}
}
