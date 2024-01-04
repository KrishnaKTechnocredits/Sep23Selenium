package gaurangvirani.standalonrScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC2 {

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
		
		int catagories = driver.findElements(By.xpath("//section//h6[text()='Categories']/parent::div//div[@class='form-group ng-star-inserted']")).size();
		int subCatagories = driver.findElements(By.xpath("//section//h6[text()='Sub Categories']/parent::div//div[@class='form-group ng-star-inserted']")).size();
		int searchFor = driver.findElements(By.xpath("//section//h6[text()='Search For']/parent::div//div[@class='form-group ng-star-inserted']")).size();
		
		if(catagories>0 && subCatagories>0 && searchFor>0) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		
		driver.close();
	}
}
