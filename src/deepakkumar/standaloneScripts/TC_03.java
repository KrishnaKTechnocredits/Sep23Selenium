/*
 * TC03 - validate that user filter the eletronics & only those values displayed on UI
 * https://rahulshettyacademy.com/client/
 */

package deepakkumar.standaloneScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_03 {
	WebDriver driver;

	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", ".//chromeDriver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void verifySideFilters() throws Exception {
		launchBrowser();
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("userEmail")).sendKeys("dgkankhar@gmail.com");
		System.out.println("STEP: User enters email!");
		driver.findElement(By.id("userPassword")).sendKeys("Deepak@21");
		System.out.println("STEP: User enters password!");
		driver.findElement(By.id("login")).click();
		System.out.println("STEP: User clicks on Login button!");

		int resultCountBefore = driver.findElements(By.xpath("//div[@class = 'card-body']")).size();
		System.out.println("STEP: Result Count fetch before filter applied");

		System.out.println("Showing " + resultCountBefore + " results");
		driver.findElement(By.xpath("//section//label[text()='electronics']/parent::div/input")).click();
		Thread.sleep(2000);
		int resultCountAfter = driver.findElements(By.xpath("//div[@class = 'card-body']")).size();

		System.out.println("STEP: Result Count fetch after filter applied");
		System.out.println("Showing " + resultCountAfter + " results");

		if (resultCountBefore != resultCountAfter)
			System.out.println("Results are displayed!");
		else
			System.out.println("Results are not displayed!");

		driver.close();
	}
}
