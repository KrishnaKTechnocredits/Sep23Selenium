package technocredits.basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationAssertTest {
	WebDriver driver;
	
	@BeforeMethod
	void setUp() {
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();// Launch Chrome Browser

		System.out.println("STEP - Maximize browser");
		driver.manage().window().maximize();

		System.out.println("STEP - Launch Automationbykrishna.com");
		driver.get("http://automationbykrishna.com/");
	}
	
	@Test
	void verifyLogin() {
		System.out.println("STEP - Click on Registration link");
		WebElement registrationLinkElement = driver.findElement(By.id("registration2"));
		registrationLinkElement.click();

		System.out.println("STEP - Enter username");
		WebElement usernameElement = driver.findElement(By.id("unameSignin"));
		usernameElement.sendKeys("MKANAni");

		System.out.println("STEP - Enter password");
		WebElement passwordElement = driver.findElement(By.id("pwdSignin"));
		passwordElement.sendKeys("mk34");

		WebElement loginBtn = driver.findElement(By.id("btnsubmitdetails"));
		loginBtn.click();

		System.out.println("VERIFY - Alter message should be \"Success!\"");
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("AlertText is " + alertText);
		
		Assert.assertEquals(alertText, "Failed! please enter strong password");
		alert.accept();

		//
		usernameElement.clear();
		passwordElement.clear();
	}
	
	@AfterMethod
	void tearDown() {
		driver.close();
	}
	
}
