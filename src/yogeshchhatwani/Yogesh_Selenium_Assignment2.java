//
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
package yogeshchhatwani;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Yogesh_Selenium_Assignment2 {
	WebDriver driver;

	@BeforeMethod
	void openChrome() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("Step-->Launch Chrome Browser");
		driver = new ChromeDriver();// launch chrome browser
		driver.manage().window().maximize();
	}

	@Test
	void navigateurl() {
		String url = "http://automationbykrishna.com";
		System.out.println("Step-->Navigate to url");
		driver.navigate().to(url);
		System.out.println("Step-->Click on registration");
		WebElement elementOpen = driver.findElement(By.id("registration2"));
		elementOpen.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Step-->Enter User Name");
		WebElement userName = driver.findElement(By.id("unameSignin"));
		userName.sendKeys("Prince");

		System.out.println("Step-->Enter Password");
		WebElement password = driver.findElement(By.id("pwdSignin"));
		password.sendKeys("prince@1234");

		System.out.println("Step-->Click on login Button");
		WebElement loginButton = driver.findElement(By.xpath("//button[@id='btnsubmitdetails']"));
		loginButton.click();

		System.out.println("Verify--Alert message should be Success");
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert is " + alertText);
		alert.accept();

		userName.clear();
		password.clear();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userName.sendKeys("Prince");
		password.sendKeys("Pri123");

		System.out.println("Step-->Click on login Button");
		WebElement loginButton1 = driver.findElement(By.xpath("//button[@id='btnsubmitdetails']"));
		loginButton1.click();

		if (alert.equals("Failed! enter the strong password")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}
		alert.accept();
	}

	@AfterMethod
	void closeWindow() {
		driver.close();
	}
}
