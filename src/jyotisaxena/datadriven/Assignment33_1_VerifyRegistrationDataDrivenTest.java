package jyotisaxena.datadriven;

import java.io.IOException;

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

import jyotisaxena.datadriven.ExcelOperationsTest;
//import jyoti.utility.ExcelOperationsTest;

public class Assignment33_1_VerifyRegistrationDataDrivenTest {
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

	public void waitABit(int ms) {
		try {
			Thread.sleep(250);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	@Test(dataProvider = "loginDataProvider")
	void verifyLogin(String username, String password, String expectedAlertText) {
		System.out.println("#### TEST DATA ####");
		System.out.println(username);
		System.out.println(password);
		System.out.println(expectedAlertText);
		System.out.println("##################");

		System.out.println("STEP - Click on Registration link");
		WebElement registrationLinkElement = driver.findElement(By.xpath("//a[@id='registration2']"));
		registrationLinkElement.click();
		waitABit(250);

		System.out.println("STEP - Enter username");
		WebElement usernameElement = driver.findElement(By.xpath("//input[@id='unameSignin']"));
		usernameElement.sendKeys(username);
		waitABit(250);
		System.out.println("STEP - Enter password");
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id='pwdSignin']"));
		passwordElement.sendKeys(password);
		waitABit(250);

		WebElement loginBtn = driver.findElement(By.xpath("//button[@id='btnsubmitdetails']"));
		loginBtn.click();
		waitABit(250);
		System.out.println("VERIFY - Alter message");
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("AlertText is " + alertText);

		Assert.assertEquals(alertText, expectedAlertText);
		alert.accept();
	}

	@DataProvider
	public Object[][] loginDataProvider() throws IOException {
		Object[][] data = ExcelOperationsTest.getAllRows(".//testdata/TestDataDriven.xlsx", "DataSet");
		return data;
	}

	@AfterMethod
	void tearDown() {
		driver.close();
	}

}
