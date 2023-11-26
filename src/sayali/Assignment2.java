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
12. Verify alert message should be "Failed! please enter strong password"*/

package sayali;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	WebDriver driver;

	void setup(String url) {
		System.out.println("STEP: Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("STEP: Open given URL");
		driver.get(url);
	}

	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void verifyLogin() {
		setup("http://automationbykrishna.com");

		System.out.println("STEP: click on Registration link");
		driver.findElement(By.id("registration2")).click();

		sleep(3000);
		System.out.println("STEP: Enter Username");
		driver.findElement(By.id("unameSignin")).sendKeys("SayaliH06");

		System.out.println("STEP: Enter password having length > 8 characters");
		driver.findElement(By.id("pwdSignin")).sendKeys("Sdh@321456");

		System.out.println("STEP: Click on Login button");
		driver.findElement(By.id("btnsubmitdetails")).click();
		System.out.println("STEP: Verify alert message should be \"Success!\"");
		Alert javascriptAlert = driver.switchTo().alert();
		String alertText = javascriptAlert.getText();
		if (alertText.equals("Success!"))
			System.out.println("Login test with correct password is passed");
		else
			System.out.println("Login test is failed");
		javascriptAlert.accept();

		System.out.println("STEP: clear username and password");
		driver.findElement(By.id("unameSignin")).clear();
		driver.findElement(By.id("pwdSignin")).clear();

		System.out.println("STEP: Enter Username");
		driver.findElement(By.id("unameSignin")).sendKeys("SayaliH06");

		System.out.println("STEP: Enter password having length < 8 characters");
		driver.findElement(By.id("pwdSignin")).sendKeys("321");

		System.out.println("STEP: Click on Login button");
		driver.findElement(By.id("btnsubmitdetails")).click();
		System.out.println("STEP: Verify alert message should be \"Failed! please enter strong password\"");
		javascriptAlert = driver.switchTo().alert();
		alertText = javascriptAlert.getText();
		if (alertText.equals("Failed! please enter strong password"))
			System.out.println("Login test with incorrect password is passed");
		else
			System.out.println("Login test is failed");
		javascriptAlert.accept();

		System.out.println("Close the browser");
		driver.close();
	}

	public static void main(String[] args) {
		new Assignment2().verifyLogin();
	}
}