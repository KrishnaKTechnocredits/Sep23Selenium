/*1. Complete the TC 3 from the sheet
2.  practice the [parent, css basic, following-sibling, preceing-sibling, parent, Index based css] on automation by krishna*/

package onkar;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment31 {
	
	@Test
	void validateFilter() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/client/");

		System.out.println("Input the Login credentials");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("patilonkar18@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Ishani@1");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		
		int intitialResults = driver.findElements(By.xpath("//div[@class='card']")).size();
		driver.findElement(By.xpath("//section//h6[text()='Categories']/parent::div//label[text()='electronics']/preceding-sibling::input")).click();
		Thread.sleep(2000);
		int finalResult = driver.findElements(By.xpath("//div[@class='card']")).size();
		
		if(intitialResults != finalResult)
			System.out.println("Filter is applied correctly");
		else
			System.out.println("TC Failed");
		
		driver.close();
	}
}
