package hetalvirani.standAloneScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC1 {

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
	public void verifylogin() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("step : Enter email");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("hetalusadadiya@gmail.com");

		System.out.println("step : Enter password");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Heta@0643");

		System.out.println("step : click loginbutton");
		driver.findElement(By.xpath("//input[@id='login']")).click();

		WebElement loginSuccess = driver.findElement(By.xpath("//div[@aria-label='Login Successfully']"));
		String expectedLoginText = "Login Successfully";
		String actualLoginText = loginSuccess.getText();

		if (loginSuccess.isDisplayed()) {
			System.out.println("Login Successful!");
		} else
			System.out.println("Login Unsuccessful!");

		if (actualLoginText.equals(expectedLoginText)) {
			System.out.println("Login Test Message is Displayed!");
		} else {
			System.out.println("Login Test Message is Not Deiplayed!");
		}
	}

	@AfterClass
	void tearDown() {
		driver.close();
	}

}
