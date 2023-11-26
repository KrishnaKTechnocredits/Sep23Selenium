/*Assignment - 2 : 18th Nov'2023 [30 mins]
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
12. Verify alter message should be "Failed! please enter strong password"*/

package jaykumar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {
	WebDriver driver;
	WebElement usernameElement;
	WebElement passwordElement;

	void setUp(String url) {
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("STEP - Launch : " + url);
		driver.get(url);
	}

	void waitABit(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void login(String username, String password) {
		System.out.println("STEP - Enter username");
		usernameElement = driver.findElement(By.id("unameSignin"));
		usernameElement.sendKeys(username);

		System.out.println("STEP - Enter Password");
		passwordElement = driver.findElement(By.id("pwdSignin"));
		passwordElement.sendKeys(password);

		System.out.println("STEP - Click on Login button");
		driver.findElement(By.id("btnsubmitdetails")).click();
	}

	void clearDetails() {
		System.out.println("STEP -  Clear the username and password text");
		usernameElement.clear();
		passwordElement.clear();
	}

	void verifyAlert(String message) {
		System.out.println("STEP - Verify alert message");
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert message is: " + alertText);
		if (alertText.equals(message)) {
			System.out.println("Verify alert test passed");
		} else {
			System.out.println("Verify alert test failed");
		}
		alert.accept();
	}

	void testCases() {
		setUp("http://automationbykrishna.com/");

		System.out.println("STEP - Click on Registration Link");
		driver.findElement(By.id("registration2")).click();
		waitABit(3000);

		login("Jaykumar", "Jay123456");
		verifyAlert("Success!");
		clearDetails();

		login("Jay", "123456");
		verifyAlert("Failed! please enter strong password");
		clearDetails();
	}

	public static void main(String[] args) {
		new Assignment2().testCases();
	}
}
