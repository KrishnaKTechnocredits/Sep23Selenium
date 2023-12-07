/*
 * Asignment33 3Dec23
WAP using datadriven approach where you need to automate login flow for websites automationByKrishna & rahulshetty.
	- https://rahulshettyacademy.com/client/
	- http://automationbykrishna.com/#
 */

package deepakkumar;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import deepakkumar.utility.ExcelOperations;

public class Assignment33 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./chromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 5);
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "loginCredentials1")
	public void loginFlowSite1(String uName, String uPasswrd, String msg) {
		driver.get("https://rahulshettyacademy.com/client/");
		String beforeURL = driver.getCurrentUrl();
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(uName);
		driver.findElement(By.id("userPassword")).sendKeys(uPasswrd);
		driver.findElement(By.id("login")).click();
		WebElement toastBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class, 'toast-title')] | //div[contains(@class, 'toast-message')]")));
		String toastMsg = toastBox.getText();
		String afterURL = driver.getCurrentUrl();

		if (beforeURL.equals(afterURL)) {
			Assert.assertEquals(toastMsg, msg);
		} else if (!beforeURL.equals(afterURL)) {
			Assert.assertEquals(toastMsg, msg);
			driver.findElement(By.xpath("//button[text() = ' Sign Out ']")).click();
		}
	}

	@Test(dataProvider = "loginCredentials2")
	public void loginFlowSite2(String uName, String uPasswrd, String msg) {
		driver.get("http://automationbykrishna.com/index.html#");
		driver.findElement(By.id("registration2")).click();
		WebElement loginBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unameSignin")));
		loginBox.sendKeys("maulik");
		driver.findElement(By.id("pwdSignin")).sendKeys("M2");
		driver.findElement(By.id("btnsubmitdetails")).click();

		Alert alert = driver.switchTo().alert();
		String popMsg = alert.getText();
		alert.accept();

		if (popMsg.equals(msg))
			Assert.assertEquals(popMsg, msg);
		else if (popMsg.equals(msg)) {
			Assert.assertEquals(popMsg, msg);
		}
	}

	@DataProvider
	public Object[][] loginCredentials1() throws IOException {
		Object[][] data = ExcelOperations.readExcel("./testdata/LoginData.xlsx", "Login");
		return data;
	}

	@DataProvider
	public Object[][] loginCredentials2() throws IOException {
		Object[][] data = ExcelOperations.readExcel("./testdata/LoginData.xlsx", "Data");
		return data;
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
