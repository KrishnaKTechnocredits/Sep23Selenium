package gaurangvirani.standalonrScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC1 {
	
	@Test
	void verifyLogin() throws InterruptedException {
		System.out.println("STEP : Launch Browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		System.out.println("STEP : Details");
		driver.findElement(By.id("userEmail")).sendKeys("gaurangvirani97244@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Ab@1Ab@1");
		driver.findElement(By.id("login")).click();
		
		if (driver.findElement(By.xpath("//div[@aria-label='Login Successfully']")).isDisplayed()) 
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
	}
}
