package akshitak.standAloneScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import technocredits.actionsDemo.LaunchChromeBrowser;

public class TC2 {
	WebDriver driver;

	@Test
	void verifyLogin() {
		System.out.println("STEP: Navigate to URL");
		driver = LaunchChromeBrowser.launchBrowser("https://rahulshettyacademy.com/client/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("STEP:Enter User name");
		driver.findElement(By.id("userEmail")).sendKeys("ak@demo.com");
		System.out.println("STEP:Enter the Password");
		driver.findElement(By.id("userPassword")).sendKeys("Reset@1234");
		System.out.println("STEP:Click Login button");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		System.out.println("STEP:Validate catagories have value");
      	int catagoryCount=	driver.findElements(By.xpath("//section//div/h6[text()='Categories']/parent::div/div[@class='form-group ng-star-inserted']")).size();
      	System.out.println("STEP:Validate Sub catagories have value");
		int subCatagory = driver.findElements(By.xpath("//section//div/h6[text()='Sub Categories']/parent::div/div[@class='form-group ng-star-inserted']")).size();
		System.out.println("STEP:Validate Search for have value");
		int search = driver.findElements(By.xpath("//section//div/h6[text()='Sub Categories']/parent::div/div[@class='form-group ng-star-inserted']//section//div/h6[text()='Search For']/parent::div/div[@class='form-group ng-star-inserted']")).size();
		System.out.println("STEP:Verify Filter have some values in form of checkbox");
		if(catagoryCount !=0 && subCatagory !=0 && search !=0 )
			System.out.println("Filter have some values in form of checkbox");
		else
			System.out.println(" filter dont have values in form of checkbox");
	}
}
