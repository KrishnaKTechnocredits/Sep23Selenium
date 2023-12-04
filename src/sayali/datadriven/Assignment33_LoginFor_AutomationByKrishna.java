package sayali.datadriven;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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

import sayali.datadriven.ExcelOperations.ExcelOperations;

public class Assignment33_LoginFor_AutomationByKrishna {

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
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
		
		System.out.println("VERIFY - Alert message");
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("AlertText is " + alertText);
		
		Assert.assertEquals(alertText, expectedAlertText);
		alert.accept();
	}
	
	@DataProvider
	public Object[][] loginDataProvider() throws IOException {
		
		Object[][] data = ExcelOperations.getAllRows(".//testdata/LoginData.xlsx", "Data");
		return data;
	}
	
	@AfterMethod
	void tearDown() {
		driver.close();
	}
}