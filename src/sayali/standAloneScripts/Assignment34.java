/* 1. navigate to https://rahulshettyacademy.com/client/
2. user enters the username
3. user enters the password
4. user click on the login button
5. user select any product & clicked on add to cart button
6. validate that add to cart toast message ""Product Added To Cart"" displayed
7. user click on cart tab
8. user validated that added product displayed" */

package sayali.standAloneScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment34 {

	WebDriver driver;

	@BeforeClass
	void setup() {
		System.out.println("STEP: Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Navigate to given URL");
		driver.get("https://rahulshettyacademy.com/client/");
	}

	@Test
	public void verifyLogin() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
		driver.findElement(By.xpath(locatorForAddToCart)).click();

		System.out.println("VERIFY: Toast messsage displayed");
		Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Product Added To Cart']")).isDisplayed(),
				"Toaat message not displayed");

		System.out.println("STEP: Click on cart button");
		driver.findElement(By.xpath("//li//button[contains(text(),'Cart')]")).click();

		String addToCartLocator = String.format("//div[@class='cartSection']//h3[text()='%s']", productSelection);

		System.out.println("VERIFY: Added product " + productSelection + " displayed on cart page");
		Assert.assertTrue(driver.findElement(By.xpath(addToCartLocator)).isDisplayed(),
				"Added product " + productSelection + " not displayed");
	}

	@AfterClass
	void tearDown() {
		driver.close();
	}
}