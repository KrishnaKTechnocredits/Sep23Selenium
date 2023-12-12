package denishsantoki;

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

import denishsantoki.Utility.ExcelOperationTest;

public class Assignment33_RahulShettyAcademyTest {

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
		driver.get("http://rahulshettyacademy.com/client/");
	}
	
	public void sleep(int ms) {
		try {
			Thread.sleep(250);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	@Test(dataProvider = "loginDataProvider")
	void verifyLogin(String userName, String password, String expectedResult) {
		System.out.println("-> Test Data <-");
		System.out.println(userName);
		System.out.println(password);
		System.out.println(expectedResult);
		System.out.println("==========================");

		System.out.println("STEP : Enter Username");
		WebElement userNameInput = driver.findElement(By.xpath("//input[@id='userEmail']"));
		userNameInput.clear();
		userNameInput.sendKeys(userName);
		sleep(250);
		
		System.out.println("STEP : Enter PAssword");
		WebElement passwordInput = driver.findElement(By.xpath("//input[@id='userPassword']"));
		passwordInput.clear();
		passwordInput.sendKeys(password);
		sleep(250);
		
		
		System.out.println("STEP : Click On Login");
		WebElement login = driver.findElement(By.xpath("//input[@id='login']"));
		login.click();

		String url = driver.getCurrentUrl();
		if (expectedResult.equals("Login Successfully")) {
			Assert.assertTrue(url.endsWith("/dashboard/dash"));
		} else {
			Assert.assertTrue(url.endsWith("/auth/login"));
		}
	}

	@DataProvider
	public Object[][] loginDataProvider() throws IOException {
		Object[][] data = ExcelOperationTest.getAllRows(".//testdata/LoginData.xlsx", "Login");
		return data;
	}

	@AfterMethod
	void tearDown() {
		driver.close();
	}
}
