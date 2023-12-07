/*
 * TC1 - Validate the login sccessful with the credentials
 * https://rahulshettyacademy.com/client/
 */

package deepakkumar.standaloneScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01_Assignment30 {
	WebDriver driver;

	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", ".//chromeDriver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void loginTC(String email, String password, String expectedResult) throws InterruptedException {
		launchBrowser();
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("userEmail")).sendKeys(email);
		System.out.println("STEP: User enters email!");
		driver.findElement(By.id("userPassword")).sendKeys(password);
		System.out.println("STEP: User enters password!");
		driver.findElement(By.id("login")).click();
		System.out.println("STEP: User clicks on Login button.");
		
		String url = driver.getCurrentUrl();
		String toastMessage = driver.findElement(By.xpath("//div[contains(@class,'toast-message')] | //div[contains(@class,'toast-title')]")).getText(); 
		if(expectedResult.equals("Login Successfully")) {
			Assert.assertEquals(toastMessage, "Login Successfully");
			Assert.assertTrue(url.endsWith("dashboard/dash"));
		}else {
			Assert.assertEquals(toastMessage, "Incorrect email or password.");
			Assert.assertTrue(url.endsWith("auth/login"));
		}
		driver.close();
	}
}
