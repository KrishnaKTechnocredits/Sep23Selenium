package swatikudale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment34 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	void setup() {
		System.out.println("Launch Chrome Browser and  Navigate to https://rahulshettyacademy.com/client/");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");

		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");
	}

	@Test
	void verifyCart() throws InterruptedException {

		System.out.println("Input the Login credentials");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("swatikudale92@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Swati@1592");
		driver.findElement(By.xpath("//input[@id='login']")).click();

		// select product for add to cart
		String selectProduct = "zara coat 3";
		String productXPath = "//b[text()='" + selectProduct
				+ "']/parent::h5/following-sibling::button[text()=' Add To Cart']";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(productXPath)));
		driver.findElement(By.xpath(productXPath)).click();
		

		String successMessage = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Product Added To Cart ']")))
				.getText();

		System.out.println("Verify if "+selectProduct+"is added to cart");
		Assert.assertEquals(successMessage, "Product Added To Cart");

		System.out.println("Click on Cart");
		driver.findElement(By.xpath("//li/button[contains(text(),'Cart')]")).click();
		Thread.sleep(2000);

		String expectedString = driver.findElement(By.xpath("//div[@class='cartSection']/h3")).getText();
		System.out.println("Added product in the cart is : " + expectedString);
		Assert.assertEquals(expectedString.compareToIgnoreCase(expectedString), 0);
	}

	@AfterMethod
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}
}
