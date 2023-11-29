/*Assignment - 2 : 18th Nov'2023 [30 mins] 1. Launch Chrome Browser 2. Navigate to automationbykrishna.com 3. Click on Registration link 4. Enter username 5. Enter password having
 length > 8 characters 6. Click on Login button 7. Verify alter message should be "Success!" 8. clear username and password 9. Enter username 10.Enter password having 
 length < 8 characters 11. Click on Login button 12. Verify alter message should be "Failed! please enter strong password"*/
package swatikudale;

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
		System.out.println("STEP 1/2: Launch Chrome Browser and  Navigate to http://automationbykrishna.com");
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

	@Test
	void signUp() {

		System.out.println("STEP 3: Click on Registration link");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();

		sleep(10000);
		System.out.println("STEP 3: Enter UserName");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Skudale");

		System.out.println("STEP 5: Enter PassWord");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("123456789");

		System.out.println("STEP 6: Click on Login button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		System.out.println("STEP 7: Verify alert message should be Success!");
		Alert javaSctriptAlert = driver.switchTo().alert();
		String alertText = javaSctriptAlert.getText();
		System.out.println("Actual alert Message ->" + alertText);
		if (alertText.equals("Success!")) {
			System.out.println("Test Pass for giving required length PassWord");
		} else {
			System.out.println("Test Fail");
		}
		javaSctriptAlert.accept();

		System.out.println("STEP 8 :clear username and password");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).clear();
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).clear();

		System.out.println("STEP 9: Enter UserName");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Skudale");

		System.out.println("STEP 10: Enter PassWord");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("12345");

		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		System.out.println("STEP 11:Verify alter message should be \"Failed! ");
		javaSctriptAlert = driver.switchTo().alert();
		alertText = javaSctriptAlert.getText();
		System.out.println("Actual alert Message ->" + alertText);
		if (alertText.equals("Failed! please enter strong password")) {
			System.out.println("Test Pass for not giving required length PassWord");
		} else {
			System.out.println("Test Fail");
		}
		javaSctriptAlert.accept();
	}

	@AfterMethod
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}
}