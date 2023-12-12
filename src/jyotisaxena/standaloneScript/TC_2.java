/*1. navigate to https://rahulshettyacademy.com/client/
2. user enters the username
3. user enters the password
4. user click on the login button
5. validate that Categories, Sub Categories, Search For filter have some values in form of checkbox, they are not empty*/
package jyotisaxena.standaloneScript;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_2 {

	WebDriver driver;
	String uemail = "jyotisaxena2006@gmail.com";
	String pwd = "Welcome@1234";

	@BeforeClass
	void setup() {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get("https://rahulshettyacademy.com/client/");
	}

	@Test
	void verifyCategories() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("userEmail")).sendKeys(uemail);
		System.out.println("STEP : Enter Email");
		driver.findElement(By.id("userPassword")).sendKeys(pwd);
		System.out.println("STEP : Enter PAssword");
		driver.findElement(By.id("login")).click();
		System.out.println("STEP : Click On Login");

		System.out.println("STEP : Verify All Filters Options");
		List<WebElement> categoriesList = driver
				.findElements(By.xpath("//section//h6[text()='Categories']//parent::div//input[@type='checkbox']"));
		int categoriesSize = categoriesList.size();

		List<WebElement> subCategoriesList = driver
				.findElements(By.xpath("//section//h6[text()='Sub Categories']//parent::div//input[@type='checkbox']"));
		int subCategoriesSize = subCategoriesList.size();

		List<WebElement> searchForList = driver
				.findElements(By.xpath("//section//h6[text()='Search For']//parent::div//input[@type='checkbox']"));
		int searchForSize = searchForList.size();

		if (categoriesSize > 0 && subCategoriesSize > 0 && searchForSize > 0) {
			System.out.println("Categories Filter is not empty");
		} else if (categoriesSize == 0) {
			System.out.println("Categories Filter is empty");
		} else if (subCategoriesSize == 0) {
			System.out.println("Categories Filter is empty");
		} else if (searchForSize == 0) {
			System.out.println("Categories Filter is empty");
		}
	}

	@AfterClass
	void tearDown() {
		driver.close();
	}
}
