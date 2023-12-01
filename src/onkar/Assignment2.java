/*1. Launch Chrome Browser
2. Navigate to automationbykrishna.com
3. Click on Registration link
4. Enter username
5. Enter password having length > 8 characters
6. Click on Login button
7. Verify alter message should be "Success!"
8. clear username and password
9. Enter username
10.Enter password having length < 8 characters
11. Click on Login button
12. Verify alter message should be "Failed! please enter strong password"*/

package onkar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment2 {
	
	WebDriver driver;
	
	@BeforeMethod
	void setup() {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println("Maximize browser window");
		driver.manage().window().maximize();
		
		System.out.println("Open given URL");
		driver.get("http://automationbykrishna.com");
	}
	
	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}
	
	@Test
	void verifyLogin() {		
		System.out.println("click on Registration link");
		driver.findElement(By.id("registration2")).click();
		
		sleep(3000);
		System.out.println("Enter Username");
		driver.findElement(By.id("unameSignin")).sendKeys("Patilonkar18");
		
		System.out.println("Enter password having length > 8 characters");
		driver.findElement(By.id("pwdSignin")).sendKeys("123456789");
		
		System.out.println("Click on Login button");
		driver.findElement(By.id("btnsubmitdetails")).click();
		System.out.println("Verify alert message should be \"Success!\"");
		Alert javascriptAlert = driver.switchTo().alert();
		String alertText = javascriptAlert.getText();
		if (alertText.equals("Success!"))
			System.out.println("Login test with correct password is passed");
		else
			System.out.println("Login test is failed");
		javascriptAlert.accept();
		
		System.out.println("clear username and password");
		driver.findElement(By.id("unameSignin")).clear();
		driver.findElement(By.id("pwdSignin")).clear();
		
		System.out.println("Enter Username");
		driver.findElement(By.id("unameSignin")).sendKeys("Patilonkar18");
		
		System.out.println("Enter password having length < 8 characters");
		driver.findElement(By.id("pwdSignin")).sendKeys("123");
		
		System.out.println("Click on Login button");
		driver.findElement(By.id("btnsubmitdetails")).click();
		System.out.println("Verify alert message should be \"Failed! please enter strong password\"");
		javascriptAlert = driver.switchTo().alert();
		alertText = javascriptAlert.getText();
		if (alertText.equals("Failed! please enter strong password"))
			System.out.println("Login test with incorrect password is passed");
		else
			System.out.println("Login test is failed");
		javascriptAlert.accept();
	}
}
