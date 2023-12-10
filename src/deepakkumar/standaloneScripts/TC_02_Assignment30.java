/*
 *TC02 - Validate that Categories, Sub Categories, Search For options are non-empty
 * https://rahulshettyacademy.com/client/
1. navigate to https://rahulshettyacademy.com/client/
2. user enters the username
3. user enters the password
4. user click on the login button
5. validate that Categories, Sub Categories, Search For filter have some values in form of checkbox, they are not empty

 */

package deepakkumar.standaloneScripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_02_Assignment30 {
	WebDriver driver;
	WebDriverWait wait;

	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", ".//chromeDriver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 5);
	}
	
	public List<WebElement> waitForElements(String locator) {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
	}

	@Test
	public void verifySideFilters() {
		launchBrowser();
		driver.get("https://rahulshettyacademy.com/client/");
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("userEmail")).sendKeys("dgkankhar@gmail.com");
		System.out.println("STEP: User enters email!");
		driver.findElement(By.id("userPassword")).sendKeys("Deepak@21");
		System.out.println("STEP: User enters password!");
		driver.findElement(By.id("login")).click();
		
		System.out.println("VERIFICATION: Side Panel Filter Options: EMPTY CHECK!");
		List<WebElement> categories = waitForElements("//section//h6[text()='Categories']//parent::div//input[@type='checkbox']");
		int size = categories.size();
		Assert.assertNotEquals(size, 0, "Categories Filter is empty");
		System.out.println("***Categories Filter option is not empty***");
//		if (size > 0)
//			System.out.println("Categories Filter is not empty");
//		else
//			System.out.println("Categories Filter is empty");

		List<WebElement> subCategories = driver
				.findElements(By.xpath("//section//h6[text()='Sub Categories']//parent::div//input[@type='checkbox']"));
		size = subCategories.size();
		Assert.assertNotEquals(size, 0, "Sub-Categories Filter is empty");
		System.out.println("***Sub-Categories Filter option is not empty***");
//		if (size > 0)
//			System.out.println("Sub Categories Filter is not empty");
//		else
//			System.out.println("Sub Categories Filter is empty");

		List<WebElement> searchFor = driver
				.findElements(By.xpath("//section//h6[text()='Search For']//parent::div//input[@type='checkbox']"));
		size = searchFor.size();

		Assert.assertNotEquals(size, 0, "Search For filters is empty");
		System.out.println("***Search For filter options is not empty***");
//		if (size > 0)
//			System.out.println("Search For Filter is not empty");
//		else
//			System.out.println("Search For Filter is empty");

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
