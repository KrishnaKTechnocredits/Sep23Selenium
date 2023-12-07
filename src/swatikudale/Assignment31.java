/*1. Complete the TC 3 from the sheet
2.  practice the [parent, css basic, following-sibling, preceing-sibling, parent, Index based css] on automation by krishna*/

package swatikudale;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Assignment31 {
	WebDriver driver;

	@Test
	void checkFilter() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/client/");

		System.out.println("Login credentials");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("swatikudale92@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Swati@1592");
		driver.findElement(By.xpath("//input[@id='login']")).click();

		int resultsBeforeFilter = driver.findElements(By.xpath("//div[@class='card']")).size();
		driver.findElement(By.xpath(
				"//section//h6[text()='Categories']/parent::div//label[text()='electronics']/preceding-sibling::input"))
				.click();
		Thread.sleep(2000);
		int resultAfterFilter = driver.findElements(By.xpath("//div[@class='card']")).size();

		Assert.assertNotEquals(resultsBeforeFilter, resultAfterFilter);
	}

	@AfterMethod
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}
}
