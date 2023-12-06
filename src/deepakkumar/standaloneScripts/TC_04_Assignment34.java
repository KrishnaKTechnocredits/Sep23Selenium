/*
 * TC04 - validate that add to cart product displayed in cart
 * https://docs.google.com/spreadsheets/d/1XAsOC5KFoI_AOnB9Zwn4AvSSU0pHXyGgoCexc8Pt-HE/edit#gid=0
 */

package deepakkumar.standaloneScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_04_Assignment34 {
	WebDriver driver;
	WebDriverWait wait;

	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", ".//chromeDriver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 10);
	}

	@Test(dataProvider = "loginDetails")
	public void addingInCart(String url, String uName, String uPasswrd) {
		launchBrowser();
		driver.get(url);
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(uName);
		driver.findElement(By.id("userPassword")).sendKeys(uPasswrd);
		driver.findElement(By.id("login")).click();
		System.out.println("STEP: Login Successfully!");
		String product = "adidas original";

		String productLocator = String
				.format("//h5//b[text()='%s']/parent::h5/following-sibling::button[text()=' Add To Cart']", product);

		System.out.println("STEP: Product Added in the Cart!");
		WebElement addToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(productLocator)));
		addToCart.click();

		WebElement toastMsg = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Product Added To Cart']")));
		System.out.println("VERIFY: Success Toast message is displayed!");
		Assert.assertTrue(toastMsg.isDisplayed(), toastMsg + " not displayed!");

		System.out.println("STEP: User Navigates to the Cart!");
		driver.findElement(By.xpath("//li//button[contains(text(),'Cart')]")).click();

		System.out.println("VERIFY: Product Added in the cart");
		WebElement addedProduct = driver.findElement(By.xpath("//h3[text()='" + product + "']"));
		Assert.assertTrue(addedProduct.isDisplayed(), "Added product '" + product + "'not displayed!");
	}

	@DataProvider
	public Object[][] loginDetails() {
		Object[][] data = new Object[1][3];
		data[0][0] = "https://rahulshettyacademy.com/client/";
		data[0][1] = "dgkankhar@gmail.com";
		data[0][2] = "Deepak@21";

		return data;
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
