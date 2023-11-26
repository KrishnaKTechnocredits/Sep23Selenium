/*
 Assignment - 2 : 18th Nov'2023 [30 mins]

1. Launch Chrome Browser
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
12. Verify alter message should be "Failed! please enter strong password"
 */

package roshnikolhe;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

public class Assignment2 {
	
	public static void main(String[] args) {
		System.out.println("Step1. Launch Chrome Browser");
		//String SetProperty = System.setProperty("webdriver.chrome.driver", "D:\\\\Technocredits\\\\Projects\\\\IDE\\\\Sep23Selenium\\\\ChromeDriver\\\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",".\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();//Launch Chrome Browser
		
		System.out.println("Step2. Maximize Browser");
		driver.manage().window().maximize();
		
		System.out.println("Step3. Navigate to automationbykrishna.com");
		driver.get("http://automationbykrishna.com\\");
		
		System.out.println("Step4. Click on Registration link");
		WebElement registrationLinkElement = driver.findElement(By.id("registration2"));
		registrationLinkElement.click();
		
		System.out.println("Step5.Enter username");
		WebElement usernameElement = driver.findElement(By.id("unameSignin"));
		usernameElement.sendKeys("mkanani");
		
		System.out.println("Step6. Enter password having length > 8 characters");
		WebElement passwordElement = driver.findElement(By.id("pwdSignin"));
		passwordElement.sendKeys("Kanani@12");
		
		System.out.println("Step7. Click on Login button");
		WebElement loginButtonElement = driver.findElement(By.id("btnsubmitdetails"));
		loginButtonElement.click();
		
		System.out.println("Step8. Verify alert message should be \"Success!\"");
		Alert javaScriptAlert = driver.switchTo().alert();
		String alertText = javaScriptAlert.getText();
		System.out.println("AlertText is " + javaScriptAlert);
		if(alertText.equals("Success!")) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		javaScriptAlert.accept();
		
		System.out.println("Step9. Clear username and password");
		usernameElement.clear();
		passwordElement.clear();
		
		System.out.println("Step10.Enter username");
		WebElement usernameElement1 = driver.findElement(By.id("unameSignin"));
		usernameElement1.sendKeys("mkanani");
		
		System.out.println("Step11. Enter password having length < 8 characters");
		WebElement passwordElement1 = driver.findElement(By.id("pwdSignin"));
		passwordElement1.sendKeys("Kanani");
		
		System.out.println("Step12. Click on Login button");
		WebElement loginButtonElement1 = driver.findElement(By.id("btnsubmitdetails"));
		loginButtonElement1.click();
		
		System.out.println("Step13. Verify alert message should be \"Failed! please enter strong password/");
		Alert javaScriptAlert1 = driver.switchTo().alert();
		String alertText1 = javaScriptAlert1.getText();
		System.out.println("AlertText is " + javaScriptAlert1);
		if(alertText1.equals("Failed! please enter strong password")) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		javaScriptAlert.accept();
		
		System.out.println("Browser Closed!");
		driver.close();
	}
}
