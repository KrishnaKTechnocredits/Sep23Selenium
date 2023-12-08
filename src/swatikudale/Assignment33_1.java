/*Asignment33 3Dec23
WAP using datadriven approach where you need to automate login flow for websites automationByKrishna & rahulshetty.
	- https://rahulshettyacademy.com/client/
	- http://automationbykrishna.com/#
 */

package swatikudale;

import java.io.IOException;

import org.openqa.selenium.Alert;
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

public class Assignment33_1 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./chromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 5);
		driver.manage().window().maximize();
		System.out.println("Launch Automationbykrishna.com");
		driver.get("http://automationbykrishna.com/");
	}

	@Test(dataProvider = "loginCredentials1")
	public void automationByKrishna(String userName, String PassWord, String message) {
		System.out.println("******TEST DATA ****");
		System.out.println(userName);
		System.out.println(PassWord);
		System.out.println(message);
		System.out.println("********************");

		System.out.println("Click on Registration link");

		driver.findElement(By.id("registration2")).click();
		WebElement loginBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unameSignin")));
		loginBox.sendKeys(userName);
		driver.findElement(By.id("pwdSignin")).sendKeys(PassWord);
		driver.findElement(By.id("btnsubmitdetails")).click();

		// verify Alert
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		System.out.println("AlertText is " + alertMessage);

		if (alertMessage.equals(message))
			Assert.assertEquals(alertMessage, message);
		else if (alertMessage.equals(message)) {
			Assert.assertEquals(alertMessage, message);
		}
		alert.accept();
	}

	@DataProvider
	public Object[][] loginCredentials1() throws IOException {

		Object[][] data = ExcelOperations.readExcel(".//testdata/LoginData.xlsx", "Data");
		return data;
	}

	@AfterMethod
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}
}