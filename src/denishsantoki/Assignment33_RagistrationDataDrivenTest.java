package denishsantoki;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import denishsantoki.utility.ExcelOperationTest;

public class Assignment33_RagistrationDataDrivenTest {
	
	WebDriver driver;

	@BeforeClass
	void setup() {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
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
	void verifyLogin(String userName, String password, String expectedMessage) {
		System.out.println("-> Test Data <-");
		System.out.println(userName);
		System.out.println(password);
		System.out.println(expectedMessage);
		System.out.println("==========================");
		
		System.out.println("STEP : Click on Registration link");
		WebElement registrationElement = driver.findElement(By.xpath("//a[@id='registration2']"));
		registrationElement.click();
		sleep(250);
		
		System.out.println("STEP : Enter Username");
		WebElement userNameInput = driver.findElement(By.xpath("//input[@id='unameSignin']"));
		userNameInput.sendKeys(userName);
		sleep(250);

		System.out.println("STEP : Enter PAssword");
		WebElement passwordInput = driver.findElement(By.xpath("//input[@id='pwdSignin']"));
		passwordInput.sendKeys(password);
		sleep(250);
		
		System.out.println("STEP : Click On Submit");
		WebElement submit = driver.findElement(By.xpath("//button[@id='btnsubmitdetails']"));
		submit.click();
		

		System.out.println("Verify Alert Message");
		Alert alert = driver.switchTo().alert();
		String AlertMessage = alert.getText();
		System.out.println("Alert Message is : " + AlertMessage);
		
		Assert.assertEquals(AlertMessage, expectedMessage);
		alert.accept();
	}
	
	@DataProvider
	public Object[][] loginDataProvider() throws IOException {
		Object[][] data = ExcelOperationTest.getAllRows(".//testdata/LoginData.xlsx", "Data");
		return data;
	}
	
	@AfterClass
	void tearDown() {
		driver.close();
	}
}
