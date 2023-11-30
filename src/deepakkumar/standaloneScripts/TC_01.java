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
import org.testng.annotations.Test;

public class TC_01 {
	WebDriver driver;

	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", ".//chromeDriver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void loginTC() throws InterruptedException {
		launchBrowser();
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("userEmail")).sendKeys("dgkankhar@gmail.com");
		System.out.println("STEP: User enters email!");
		driver.findElement(By.id("userPassword")).sendKeys("Deepak@21");
		System.out.println("STEP: User enters password!");
		driver.findElement(By.id("login")).click();
		System.out.println("STEP: User clicks on Login button.");

		WebElement loginSuccess = driver.findElement(By.xpath("//div[@aria-label='Login Successfully']"));
		String expectedLoginText = "Login Successfully";

		if (loginSuccess.isDisplayed()) {
			System.out.println("Login Successful!");
		} else
			System.out.println("Login Unsuccessful!");

		String actualLoginText = loginSuccess.getText();

		if (actualLoginText.equals(expectedLoginText)) {
			System.out.println("VERIFICATION: Login pop-up text is as expected!");
		} else
			System.out.println("VERIFICATION: Login pop-up text is not as expected!");
		driver.close();
	}
}
