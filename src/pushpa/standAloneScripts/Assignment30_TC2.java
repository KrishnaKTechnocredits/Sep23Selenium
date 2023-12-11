//1. navigate to https://rahulshettyacademy.com/client/
//2. user enters the username
//3. user enters the password
//4. user click on the login button
//5. validate that Categories, Sub Categories, Search For filter have some values in form of checkbox, they are not empty

package pushpa.standAloneScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment30_TC2 {
	WebDriver driver;

	@BeforeClass
	public void setBrowser() {
		System.out.println("Step 1 - launch browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// 1. navigate to https://rahulshettyacademy.com/client/
		System.out.println("Step 2 -  navigate to https://rahulshettyacademy.com/client/");
		driver.navigate().to("https://rahulshettyacademy.com/client/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void loginTest() {
		WebElement userEmailElement = driver.findElement(By.xpath("//input[@id = 'userEmail']"));
		userEmailElement.sendKeys("pushpa.gite1209@gmail.com");
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id = 'userPassword']"));
		passwordElement.sendKeys("Pa$$w0rd");
		WebElement loginElement = driver.findElement(By.xpath("//input[@id = 'login']"));
		loginElement.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		int categoriesElement = driver
				.findElements(By.xpath("//section//h6[text() = 'Categories']/parent::div//input[@type = 'checkbox']"))
				.size();
		
		int subCategoriesElement = driver.findElements(By.xpath(
				"//section//h6[text() = 'Sub Categories']/parent::div//div[@class = 'form-group ng-star-inserted']//input[@type = 'checkbox']"))
				.size();

		int searchForElement = driver.findElements(By.xpath(
				"//section//h6[text() = 'Search For']/parent::div//div[@class= 'form-group ng-star-inserted']//input[@type = 'checkbox']"))
				.size();

		if (categoriesElement > 0 && subCategoriesElement > 0 && searchForElement > 0)
			System.out.println("Test Case Passed...");
		else
			System.out.println("Test Case Failed");

	}

	@AfterClass
	public void closeDriver() {
		driver.close();
	}
}
