package akshitak.standAloneScript;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Document;

import org.apache.commons.io.input.WindowsLineEndingInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import technocredits.actionsDemo.LaunchChromeBrowser;

public class TC7 {

	WebDriver driver;

	@Test
	void verifyLogin() throws InterruptedException {
		System.out.println("STEP: Navigate to URL");
		driver = LaunchChromeBrowser.launchBrowser("https://rahulshettyacademy.com/client/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("STEP:Enter User name");
		driver.findElement(By.id("userEmail")).sendKeys("ak@demo.com");
		System.out.println("STEP:Enter the Password");
		driver.findElement(By.id("userPassword")).sendKeys("Reset@1234");
		System.out.println("STEP:Click Login button");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		System.out.println("STEP : Click add to card button");
		driver.findElement(
				By.xpath("//h5/b[text()='zara coat 3']/parent::h5/following-sibling::button[text()=' Add To Cart']"))
				.click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Product Added To Cart']")).isDisplayed(),
				"Toast message is not Displayed");
		System.out.println("STEP : Click cart tab");
		driver.findElement(By.xpath("//li/button[contains(text(),'Cart')]")).click();
		System.out.println("STEP :Click on Checkout Button");
		Thread.sleep(10);
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		System.out.println("STEP : user enter the 4542 9931 9292 2293 credit number");
		driver.findElement(By.xpath("//input[@value='4542 9931 9292 2293']")).sendKeys("4542 9931 9292 2293");
		System.out.println("STEP : user enter name as Mahesh");
		driver.findElement(By.xpath("//div[text()='Name on Card ']/following-sibling::input")).sendKeys("Mahesh");

		System.out.println("STEP: click button Place Order");

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[text()='Place Order ']")));

		System.out.println("STEP : validate that Please Enter Full Shipping Information title dispalyed");
		Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Please Enter Full Shipping Information']")).isDisplayed()," Please Enter Full Shipping Information ");
	}
}