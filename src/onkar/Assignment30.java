/*1. complete the TC1 & TC2 from below sheet
https://docs.google.com/spreadsheets/d/1XAsOC5KFoI_AOnB9Zwn4AvSSU0pHXyGgoCexc8Pt-HE/edit#gid=0
*/

package onkar;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Assignment30 {
	
	@Test
	void validateLoginMessage(){
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/client/");
		
		System.out.println("Input the Login credentials");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("patilonkar18@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Ishani@1");
		System.out.println("Click on Login");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		String loginMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Login Successfully']"))).getText();
		System.out.println(loginMessage);
		if(loginMessage.equals("Login Successfully"))
			System.out.println("Login message is shown correctly");
		else
			System.out.println("TC is failed");
		
		driver.close();
	}
	
	@Test
	void validateCategories() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/client/");
		
		System.out.println("Input the Login credentials");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("patilonkar18@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Ishani@1");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		
		List<WebElement> categoryList = driver.findElements(By.xpath("//section//h6[text()='Categories']/parent::div/div[@class='form-group ng-star-inserted']"));
		int count1 = categoryList.size();
		
		List<WebElement> subCategoryList = driver.findElements(By.xpath("//section//h6[text()='Sub Categories']/parent::div/div[@class='form-group ng-star-inserted']"));
		int count2 = subCategoryList.size();
		
		List<WebElement> searchForList = driver.findElements(By.xpath("//section//h6[text()='Search For']/parent::div/div[@class='form-group ng-star-inserted']"));
		int count3 = searchForList.size();
		
		if(count1>0 && count2>0 && count3>0)
			System.out.println("Sections are containing some values");
		else
			System.out.println("Sections are empty");
		
		driver.close();
	}
}
