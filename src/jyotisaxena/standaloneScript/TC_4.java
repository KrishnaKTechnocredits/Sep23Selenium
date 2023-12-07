/*1. navigate to https://rahulshettyacademy.com/client/
2. user enters the username
3. user enters the password
4. user click on the login button
5. user select any product & clicked on add to cart button
6. validate that add to cart toast message "Product Added To Cart" displayed
7. user click on cart tab
8. user validated that added product displayed
*/
package jyotisaxena.standaloneScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_4 {

	WebDriver driver;
	String uname = "jyotisaxena2006@gmail.com";
	String pwd = "Welcome@1234";
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
		driver.findElement(By.id("userEmail")).sendKeys(uname);
		System.out.println("STEP : Enter PAssword");
		driver.findElement(By.id("userPassword")).sendKeys(pwd);
		System.out.println("STEP : Click On Login");
		driver.findElement(By.id("login")).click();

		String selectProduct = "iphone 13 pro";
		String productPath = "//b[text()='" + selectProduct
				+ "']/parent::h5/following-sibling::button[text()=' Add To Cart']";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(productPath)));
		driver.findElement(By.xpath(productPath)).click();

		System.out.println("STEP : Product into cart is verify");
		String successFullyMessage = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Product Added To Cart ']")))
				.getText();
		Assert.assertEquals(successFullyMessage, "Product Added To Cart");

		System.out.println("STEP : Click On Cart Button");
		driver.findElement(By.xpath("//li/button[contains(text(),'Cart')]")).click();

		String expectedProduct = driver.findElement(By.xpath("//div[@class='cartSection']/h3")).getText();
		System.out.println("Product Added into cart is : " + expectedProduct);

		Assert.assertEquals(expectedProduct.compareToIgnoreCase(expectedProduct), 0);
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}