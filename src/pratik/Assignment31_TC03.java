/*
 * TC03 - validate that user filter the eletronics & only those values displayed on UI
 * https://rahulshettyacademy.com/client/
 */

package pratik;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Assignment31_TC03 {
	@Test
	public void verifyLogin() throws Exception {
		WebDriver driver = LaunchChromeBrowser.launchBrowser("https://rahulshettyacademy.com/client/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("pratikkabra0391@gmail.com");
		System.out.println("STEP:Entered email");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test@123");
		System.out.println("STEP:Entered password");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		System.out.println("STEP:Clicked on login");
			
		int resultCountBefore = driver.findElements(By.xpath("//img[@class='card-img-top']")).size();
		System.out.println("STEP:Result count before filter");
		System.out.println(resultCountBefore+" results displayed");
		
		driver.findElement(By.xpath("//section//label[text()='electronics']/parent::div/input")).click();
		
		
		Thread.sleep(2000);
		int resultCountAfter = driver.findElements(By.xpath("//img[@class='card-img-top']")).size();
		System.out.println("STEP:Result count after filter");
		System.out.println(resultCountAfter+" result displayed");
		
		if(resultCountBefore != resultCountAfter) {
			System.out.println("Results are displayed");
		} else
			System.out.println("Results are not displayed");
		
		driver.close();
    }
}