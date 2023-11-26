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

package jyotisaxena;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {
	WebDriver driver;

	public void launchBrowser(String url) {
		System.out.println("Step - Launch Browser");
		System.setProperty("webdriver.chrome.driver", ".//chromeDriver/chromeDriver.exe");
		System.out.println("Step - Maximise Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("Step - Launched Browser");
		driver.get(url);

	}

	public void waitABit(int ms) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	public void loginInfo(String uName, String password) {
		driver.findElement(By.id("registration2")).click();
		waitABit(3000);
		driver.findElement(By.xpath(".//div[@id='indexBody']//input[@id='unameSignin']")).sendKeys(uName);// Username
		driver.findElement(By.xpath(".//div[@id='indexBody']//input[2]")).sendKeys(password);// password
		driver.findElement(By.xpath(".//div[@id='indexBody']//div[2]/button")).click();

		String displayMsg = driver.switchTo().alert().getText();
		String successMsg = "Success!";
		String failureMsg = "Failed! please enter strong password";

		if (displayMsg.equals(successMsg)) {
			System.out.println("Valid UserName and Password entered-->" + displayMsg);
		} else if (displayMsg.equals(failureMsg)) {
			System.out.println("InValid UserName and Password entered-->" + displayMsg);
		}
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath(".//div[@id='indexBody']//input[@id='unameSignin']")).clear();// Clear Username
		driver.findElement(By.xpath(".//div[@id='indexBody']//input[2]")).clear();// Clear password

	}

	public static void main(String[] args) {
		Assignment2 ass = new Assignment2();
		ass.launchBrowser("http://automationbykrishna.com");
		ass.loginInfo("mkanani", "m@12345678");
		ass.loginInfo("mkanani", "m@1");
		ass.loginInfo("", "m@1");
	}
}
