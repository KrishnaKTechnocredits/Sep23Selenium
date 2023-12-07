package onkar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment34 {
	
	@Test
	void verifyCart() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 5);

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");

		System.out.println("Input the Login credentials");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("patilonkar18@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Ishani@1");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		System.out.println("Login is done");
		
		String selectProduct = "zara coat 3";
		String productXPath = "//b[text()='"+selectProduct+"']/parent::h5/following-sibling::button[text()=' Add To Cart']";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(productXPath)));
		driver.findElement(By.xpath(productXPath)).click();
		Thread.sleep(1500);
		String successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Product Added To Cart ']"))).getText();
		Assert.assertEquals(successMessage, "Product Added To Cart");
		System.out.println("Addition of product into cart is verified");
		
		driver.findElement(By.xpath("//li/button[contains(text(),'Cart')]")).click();
		System.out.println("Clicked on Cart");
		
		String expectedString = driver.findElement(By.xpath("//div[@class='cartSection']/h3")).getText();
		
		System.out.println("Added product in the cart is : "+expectedString);
		Assert.assertEquals(expectedString.compareToIgnoreCase(expectedString), 0);
		
		driver.close();
	}
}
