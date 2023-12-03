package technocredits.basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationDataDrivenTest {
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
	
	@Test(dataProvider = "loginDataProvider")
	void verifyLogin(String username, String password, String expectedAlertText) {
		System.out.println("#### TEST DATA ####");
		System.out.println(username);
		System.out.println(password);
		System.out.println(expectedAlertText);
		System.out.println("##################");
		
		System.out.println("STEP - Click on Registration link");
		WebElement registrationLinkElement = driver.findElement(By.id("registration2"));
		registrationLinkElement.click();

		System.out.println("STEP - Enter username");
		WebElement usernameElement = driver.findElement(By.id("unameSignin"));
		usernameElement.sendKeys(username);

		System.out.println("STEP - Enter password");
		WebElement passwordElement = driver.findElement(By.id("pwdSignin"));
		passwordElement.sendKeys(password);

		WebElement loginBtn = driver.findElement(By.id("btnsubmitdetails"));
		loginBtn.click();

		System.out.println("VERIFY - Alter message");
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("AlertText is " + alertText);
		
		Assert.assertEquals(alertText, expectedAlertText);
		alert.accept();
	}
	
	@DataProvider
	public Object[][] loginDataProvider() {
		Object[][] data = new Object[2][3];
		data[0][0] = "Mkanani";
		data[0][1] = "mkanani@1308";
		data[0][2] = "Success!";
		
		data[1][0] = "Techno";
		data[1][1] = "Tech@121";
		data[1][2] = "Failed! please enter strong password";
		return data;
	}
	
	@AfterMethod
	void tearDown() {
		driver.close();
	}
	
}
