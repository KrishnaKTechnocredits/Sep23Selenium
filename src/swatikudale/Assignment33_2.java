/*Asignment33 3Dec23

WAP using datadriven approach where you need to automate login flow for websites automationByKrishna & rahulshetty.
	- https://rahulshettyacademy.com/client/
	- http://automationbykrishna.com/#
 */

package swatikudale;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assignment33_2 {
	WebDriver driver;
	String urlBeforeLogin;

	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./chromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Launch rahulshettyacademy.com");
		driver.get("https://rahulshettyacademy.com/client/");
		urlBeforeLogin = driver.getCurrentUrl();

	}

	@Test(dataProvider = "loginCredentials2")
	public void rahulShettyAcademyLogin(String userName, String PassWord, String expectedResult) {
		System.out.println("******TEST DATA ****");
		System.out.println(userName);
		System.out.println(PassWord);
		System.out.println(expectedResult);
		System.out.println("********************");

		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys(PassWord);
		driver.findElement(By.xpath("//input[@id='login']")).click();

		String actualURL = driver.getCurrentUrl();

		if (urlBeforeLogin.equals(actualURL)) {
			Assert.assertTrue(actualURL.endsWith("/auth/login"));
		} else if (!urlBeforeLogin.equals(actualURL)) {
			Assert.assertTrue(actualURL.endsWith("/dashboard/dash"));
		}
	}

	@DataProvider
	public Object[][] loginCredentials2() throws IOException {

		Object[][] data = ExcelOperations.readExcel(".//testdata/LoginData.xlsx", "Login");
		return data;
	}

	@AfterMethod
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}
}