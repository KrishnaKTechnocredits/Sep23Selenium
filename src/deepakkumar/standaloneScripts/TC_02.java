/*
 * Validate that Categories, Sub Categories, Search For options are non-empty
 * https://rahulshettyacademy.com/client/
 */

package deepakkumar.standaloneScripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_02 {
	WebDriver driver;

	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", ".//chromeDriver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void verifySideFilters() {
		launchBrowser();
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("userEmail")).sendKeys("dgkankhar@gmail.com");
		System.out.println("STEP: User enters email!");
		driver.findElement(By.id("userPassword")).sendKeys("Deepak@21");
		System.out.println("STEP: User enters password!");
		driver.findElement(By.id("login")).click();

		System.out.println("VERIFICATION: Side Panel Filter Options: EMPTY CHECK!");
		List<WebElement> categories = driver
				.findElements(By.xpath("//section//h6[text()='Categories']//parent::div//input[@type='checkbox']"));
		int size = categories.size();
		if (size > 0)
			System.out.println("Categories Filter is not empty");
		else
			System.out.println("Categories Filter is empty");

		List<WebElement> subCategories = driver
				.findElements(By.xpath("//section//h6[text()='Sub Categories']//parent::div//input[@type='checkbox']"));
		size = subCategories.size();
		if (size > 0)
			System.out.println("Sub Categories Filter is not empty");
		else
			System.out.println("Sub Categories Filter is empty");

		List<WebElement> searchFor = driver
				.findElements(By.xpath("//section//h6[text()='Search For']//parent::div//input[@type='checkbox']"));
		size = searchFor.size();
		if (size > 0)
			System.out.println("Search For Filter is not empty");
		else
			System.out.println("Search For Filter is empty");
		driver.close();
	}

}
