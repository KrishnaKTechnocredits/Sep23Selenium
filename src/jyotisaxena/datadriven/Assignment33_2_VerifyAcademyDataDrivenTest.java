package jyotisaxena.datadriven;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
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

public class Assignment33_2_VerifyAcademyDataDrivenTest {
	WebDriver driver;

	@BeforeMethod
	void setUp() {
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();// Launch Chrome Browser

		System.out.println("STEP - Maximize browser");
		driver.manage().window().maximize();

		System.out.println("STEP - Launch Automationbykrishna.com");
		driver.get("http://rahulshettyacademy.com/client/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void waitABit(int ms) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	@Test(dataProvider = "loginDataProvider")
	void verifyLogin(String username, String password, String expectedResult) {
		System.out.println("#### TEST DATA ####");
		System.out.println(username);
		System.out.println(password);
		System.out.println(expectedResult);
		System.out.println("##################");

		System.out.println("STEP - Enter username");
		WebElement usernameElement = driver.findElement(By.xpath("//input[@id='userEmail']"));
		usernameElement.clear();
		usernameElement.sendKeys(username);
		System.out.println("STEP - Enter password");
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id='userPassword']"));
		passwordElement.clear();
		passwordElement.sendKeys(password);

		WebElement loginBtn = driver.findElement(By.xpath("//input[@id='login']"));
		loginBtn.click();
		String url = driver.getCurrentUrl();
		if (expectedResult.equals("Login Successfully")) {
			Assert.assertTrue(url.endsWith("/dashboard/dash"));
		} else {
			Assert.assertTrue(url.endsWith("/auth/login"));
		}
	}

	@DataProvider
	public Object[][] loginDataProvider() throws IOException {
		Object[][] data = ExcelOperationsTest.getAllRows(".//testdata/TestDataDriven.xlsx", "AcademyLogin");
		return data;
	}

	@AfterMethod
	void tearDown() {
		driver.close();
	}

}
