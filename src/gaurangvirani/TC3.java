package gaurangvirani;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC3 {

	@Test
	void verifyLogin() throws InterruptedException {
		System.out.println("STEP : Launch Browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("STEP : Details");
		driver.findElement(By.id("userEmail")).sendKeys("gaurangvirani97244@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Ab@1Ab@1");
		driver.findElement(By.id("login")).click();
		
		System.out.println("");
		int products = driver.findElements(By.xpath("//img[@class='card-img-top']")).size();
		driver.findElement(By.xpath("//section//h6[text()='Categories']/parent::div//div[@class='form-group ng-star-inserted']/label[text()='electronics']/preceding-sibling::input")).click();
		System.out.println("afterclick");
		int afterClick = driver.findElements(By.xpath("//div[@class='card']")).size();
		if(afterClick != products) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		driver.close();
	}
}
