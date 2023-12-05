package denishsantoki;

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

import denishsantoki.Utility.ExcelOperationTest;

public class Assignment33_RegistrationTest {
	
	WebDriver driver;

	@BeforeMethod
	void setup() {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Maximize browser window");
		driver.manage().window().maximize();
		System.out.println("Open given URL");
		driver.get("http://automationbykrishna.com");
	}
	
	public void sleep(int ms) {
		try {
			Thread.sleep(250);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
	@Test(dataProvider = "loginDataProvider")
	void verifyLogin(String username, String password, String expectedAlertText) {
		System.out.println("-> Test Data <-");
		System.out.println(username);
		System.out.println(password);
		System.out.println(expectedAlertText);
		System.out.println("===========================");

		System.out.println("STEP : Click on Registration link");
		WebElement registrationLinkElement = driver.findElement(By.xpath("//a[@id='registration2']"));
		registrationLinkElement.click();
		sleep(250);

		System.out.println("STEP : Enter username");
		WebElement usernameElement = driver.findElement(By.xpath("//input[@id='unameSignin']"));
		usernameElement.sendKeys(username);
		
		System.out.println("STEP : Enter password");
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id='pwdSignin']"));
		passwordElement.sendKeys(password);
		

		WebElement loginBtn = driver.findElement(By.xpath("//button[@id='btnsubmitdetails']"));
		loginBtn.click();
		sleep(250);
		System.out.println("VERIFY - Alter message");
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("AlertText is " + alertText);

		Assert.assertEquals(alertText, expectedAlertText);
		alert.accept();
	}

	@DataProvider
	public Object[][] loginDataProvider() throws IOException {
		Object[][] data = ExcelOperationTest.getAllRows(".//testdata/LoginData.xlsx", "Data");
		return data;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
