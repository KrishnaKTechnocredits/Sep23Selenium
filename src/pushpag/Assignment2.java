//Assignment - 2 : 18th Nov'2023 [30 mins]
//
//1. Launch Chrome Browser
//2. Navigate to automationbykrishna.com
//3. Click on Registration link
//4. Enter username
//5. Enter password having length > 8 characters
//6. Click on Login button
//7. Verify alter message should be "Success!"
//8. clear username and password
//9. Enter username
//10.Enter password having length < 8 characters
//11. Click on Login button
//12. Verify alter message should be "Failed! please enter strong password"

package pushpag;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {

		// 1. Launch Chrome Browser
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// 2. Navigate to automationbykrishna.com
		driver.get("http://automationbykrishna.com");
		
		driver.manage().window().maximize();

		// 3. Click on Registration link
		WebElement registrationElement = driver.findElement(By.id("registration2"));
		registrationElement.click();
		Thread.sleep(1000);
		
		//4. Enter username
		WebElement usernameElement = driver.findElement(By.id("unameSignin"));
		usernameElement.sendKeys("Pushpa");
		
		//5. Enter password having length > 8 characters
		WebElement passwordElement = driver.findElement(By.id("pwdSignin"));
		passwordElement.sendKeys("pushpa123");
		
		//6. Click on Login button
		WebElement loginElement = driver.findElement(By.id("btnsubmitdetails"));
		loginElement.click();
		
		//7. Verify alter message should be "Success!"
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();		
		System.out.println(alertText);
		if(alertText.equals("Success!"))
			System.out.println("Login Succesfull....");
		
		alert.accept();
		
		Thread.sleep(1000);
		
		//8. clear username and password
		usernameElement.clear();
		passwordElement.clear();
		
		//9. Enter username
		usernameElement.sendKeys("Pushpa");
		
		//10.Enter password having length < 8 characters
		passwordElement.sendKeys("12345");
		
		//11. Click on Login button
		loginElement.click();
		
		//12. Verify alter message should be "Failed! please enter strong password"
		Alert failedAlert = driver.switchTo().alert();
		String failedAlertText = failedAlert.getText();
		System.out.println(failedAlertText);
		if(failedAlertText.equals("Failed! please enter strong password"))
			System.out.println("Login Failed....");
		
		alert.accept();
		driver.close();
	}

}
