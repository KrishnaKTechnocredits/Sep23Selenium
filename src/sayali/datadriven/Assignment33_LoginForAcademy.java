package sayali.datadriven;

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

import sayali.datadriven.ExcelOperations.ExcelOperations;

public class Assignment33_LoginForAcademy {

	WebDriver driver;

	@BeforeMethod
	void setUp() {
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();// Launch Chrome Browser

		System.out.println("STEP - Maximize browser");
		driver.manage().window().maximize();

		System.out.println("STEP - Launch site");
		driver.get("http://rahulshettyacademy.com/client/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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

		System.out.println("VERIFY - Expected Result");
		String url = driver.getCurrentUrl();

		Assert.assertFalse(url.endsWith("/dashboard/dash"));
	}

	@DataProvider
	public Object[][] loginDataProvider() throws IOException {
		Object[][] loginData = ExcelOperations.getAllRows(".//testdata/LoginData.xlsx", "Login");
		return loginData;
	}

	@AfterMethod
	void tearDown() {
		driver.close();
	}
}