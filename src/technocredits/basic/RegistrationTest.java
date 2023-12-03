package technocredits.basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationTest {
	WebDriver driver;
	
	void setUp() {
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();// Launch Chrome Browser

		System.out.println("STEP - Maximize browser");
		driver.manage().window().maximize();

		System.out.println("STEP - Launch Automationbykrishna.com");
		driver.get("http://automationbykrishna.com/");
	}
	
	void verifyLogin() {
		setUp();
		System.out.println("STEP - Click on Registration link");
		WebElement registrationLinkElement = driver.findElement(By.id("registration2"));
		registrationLinkElement.click();

		System.out.println("STEP - Enter username");
		WebElement usernameElement = driver.findElement(By.id("unameSignin"));
		usernameElement.sendKeys("MKANAni");

		System.out.println("STEP - Enter password");
		WebElement passwordElement = driver.findElement(By.id("pwdSignin"));
		passwordElement.sendKeys("mk345");

		WebElement loginBtn = driver.findElement(By.id("btnsubmitdetails"));
		loginBtn.click();

		System.out.println("VERIFY - Alter message should be \"Success!\"");
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("AlertText is " + alertText);
		if (alertText.equals("Failed! please enter strong password")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test fail");
		}
		alert.accept();

		usernameElement.clear();
		passwordElement.clear();
		tearDown();
	}
	
	void tearDown() {
		driver.close();
	}
	
	public static void main(String[] args) {
		new RegistrationTest().verifyLogin();
	}
}
