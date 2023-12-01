/*1. navigate to https://rahulshettyacademy.com/client/
2. user enters the username
3. user enters the password
4. user click on the login button
5. validate that "Login Successfully" toast message displayed*/
package denishsantoki.standAloneScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_01 {

	WebDriver driver;

	@BeforeClass
	void setup() {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get("https://rahulshettyacademy.com/client/");
	}

	@Test
	void loginTest() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("userEmail")).sendKeys("denishsantoki74@gmail.com");
		System.out.println("STEP : Enter Email");
		driver.findElement(By.id("userPassword")).sendKeys("D@d10033517#");
		System.out.println("STEP : Enter PAssword");
		driver.findElement(By.id("login")).click();
		System.out.println("STEP : Click On Login");

		WebElement loginSuccess = driver.findElement(By.xpath("//div[@aria-label='Login Successfully']"));
		String expectedLoginText = "Login Successfully";
		String actualLoginText = loginSuccess.getText();

		if (loginSuccess.isDisplayed()) {
			System.out.println("Login Successful!");
		} else
			System.out.println("Login Unsuccessful!");

		if (actualLoginText.equals(expectedLoginText)) {
			System.out.println("Login Toast Message is Displayed!");
		} else {
			System.out.println("Login Toast Message is Not Deiplayed!");
		}
	}

	@AfterClass
	void tearDown() {
		driver.close();
	}
}
