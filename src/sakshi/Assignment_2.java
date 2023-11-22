package sakshi;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_2 {
	
	private WebDriver driver;
	
	void loadChromeBrowser() {
		System.out.println("Step 1-> Launch Chrome Browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Step 2 -> Navigate to automationbykrishna.com");
		driver.get("http://automationbykrishna.com/");		
	}
	
	void testLoginFunction() throws InterruptedException{
		System.out.println("Step 3 -> Click on Registration link");
		WebElement registerElement = driver.findElement(By.id("registration2"));
		registerElement.click();
		
		Thread.sleep(3000);
		System.out.println("Step 4 -> Enter username");
		WebElement userNameElement = driver.findElement(By.id("unameSignin"));
		userNameElement.sendKeys("Sakshi");
		
		System.out.println("Step 5 -> Enter password having length > 8 characters");
		WebElement userPwdElement = driver.findElement(By.id("pwdSignin"));
		userPwdElement.sendKeys("Sakshi@123");
		
		System.out.println("Step 6 -> Click on Login button");
		WebElement loginButtonElement = driver.findElement(By.id("btnsubmitdetails"));
		loginButtonElement.click();
		
		System.out.println("Step 7 -> Verify alter message should be \"Success!\"");
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert message is " +alertText);
		if(alertText.equals("Success!")) {
			System.out.println("test pass");
		}else {
			System.out.println("test fail");
		}
		alert.accept();
		
		System.out.println("Step 8 -> clear username and password");
		userNameElement.clear();
		userPwdElement.clear();
		
		System.out.println("Step 9 -> Enter username");
		userNameElement.sendKeys("Ssen");
		
		System.out.println("Step 10 -> Enter password having length < 8 characters");
		userPwdElement.sendKeys("Sakshi");
		
		System.out.println("Step 11 -> Click on Login button");
		loginButtonElement.click();
		
		Alert alertJS = driver.switchTo().alert();
		String alertTextJS = alertJS.getText();
		System.out.println("Step 12 -> Verify alter message should be \"Failed! please enter strong password\"\r\n");
		System.out.println("Alert message is " +alertTextJS);
		if(alertTextJS.equals("Failed! please enter strong password")) {
			System.out.println("test pass");
		}else {
			System.out.println("test fail");
		}
		alert.accept();
	}
	
	public static void main(String[] args) throws InterruptedException {
		Assignment_2 assignment2 = new Assignment_2();
		assignment2.loadChromeBrowser();
		assignment2.testLoginFunction();
	}

}
