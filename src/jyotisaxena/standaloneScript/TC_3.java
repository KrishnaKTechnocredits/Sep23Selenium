/*1. navigate to https://rahulshettyacademy.com/client/
2. user enters the username
3. user enters the password
4. user click on the login button
5. user select the "eletronics" check box under "Categories" & validated that result are displayed

Note: as per the application behavious what you can do is before selection store the total results & after filter take total visible options & both are not same, count must be different*/
package jyotisaxena.standaloneScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class TC_3 {

	WebDriver driver;
	WebDriverWait wait;
	String uemail = "jyotisaxena2006@gmail.com";
	String pwd = "Welcome@1234";

	@BeforeClass
	void setup() {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get("https://rahulshettyacademy.com/client/");
	}

	@Test
	void verifyFilter() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("STEP : Enter Email");
		driver.findElement(By.id("userEmail")).sendKeys(uemail);
		System.out.println("STEP : Enter PAssword");
		driver.findElement(By.id("userPassword")).sendKeys(pwd);
		System.out.println("STEP : Click On Login");
		driver.findElement(By.id("login")).click();

		System.out.println("STEP : Result Count Validate Before Filter Applied");
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='card-body']"), 1));
		int resultCountBefore = driver.findElements(By.xpath("//div[@class='card-body']")).size();
		Assert.assertTrue(resultCountBefore > 1);

		System.out.println("Count Of Top Product : " + resultCountBefore);

		driver.findElement(By.xpath(
				"//section//h6[text()='Categories']/parent::div//label[text()='electronics']/preceding-sibling::input"))
				.click();
		wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//div[@class='card-body']"), 3));
		int resultCountElectronics = driver.findElements(By.xpath("//div[@class='card-body']")).size();
		System.out.println("Count Of Electronics : " + resultCountElectronics);
		Assert.assertTrue(resultCountElectronics == 1);
	}

	@AfterClass
	void tearDown() {
		driver.close();
	}
}
