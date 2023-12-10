/*
 * TC1 - Validate the login successful with the credentials
 * https://rahulshettyacademy.com/client/
 */

package deepakkumar.standaloneScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_01_Assignment30 {
	WebDriver driver;
	WebDriverWait wait;

	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", ".//chromeDriver//chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
	}
	
	public WebElement waitForElement(String locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}

	@Test(dataProvider = "loginCredentials")
	public void loginTC(String uName, String uPassword, String successText) throws InterruptedException {
		launchBrowser();
		driver.get("https://rahulshettyacademy.com/client/");
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("userEmail")).sendKeys("dgkankhar@gmail.com");
		System.out.println("STEP: User enters email!");
		driver.findElement(By.id("userPassword")).sendKeys("Deepak@21");
		System.out.println("STEP: User enters password!");
		driver.findElement(By.id("login")).click();
		System.out.println("STEP: User clicks on Login button.");

		String expectedLoginText = successText;
		WebElement loginSuccess = waitForElement("//div[@aria-label='Login Successfully']");
		System.out.println("VERIFY: Login Toast pop-up displayed!");
		Assert.assertTrue(loginSuccess.isDisplayed(), "Login Successfull!");

		String actualLoginText = loginSuccess.getText();
		System.out.println("VERIFY: Text on Toast pop-up text displayed is as expected!");
		Assert.assertEquals(expectedLoginText, actualLoginText);
	}
	
	@DataProvider
	public Object[][] loginCredentials() {
		Object[][] data = new Object[1][3];
		data[0][0] = "dgkankhar@gmail.com";
		data[0][1] = "Deepak@21";
		data[0][2] = "Login Successfully";
		
		return data;
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
