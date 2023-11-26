/*Assignment - 2 : 18th Nov'2023 [30 mins] 1. Launch Chrome Browser 2. Navigate to automationbykrishna.com 3. Click on Registration link 4. Enter username 5. Enter password having
 length > 8 characters 6. Click on Login button 7. Verify alter message should be "Success!" 8. clear username and password 9. Enter username 10.Enter password having 
 length < 8 characters 11. Click on Login button 12. Verify alter message should be "Failed! please enter strong password"*/
package shrutika;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	WebDriver driver;

	void setupURL(String URL) {
		System.out.println("STEP 1/2: Launch Chrome Browser and  Navigate to http://automationbykrishna.com");
		System.setProperty("webdriver.chrome.driver",
				"D:\\Automation 2023\\ide\\Sept23Selenium\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get(URL);
	}

	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void signUp() {
		setupURL("http://automationbykrishna.com");

		sleep(2000);
		System.out.println("Step 3: Click on Registration link");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();

		sleep(2000);
		System.out.println("Step 4:Enter Username");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Shrutika");

		System.out.println("Step 5 :Enter password having length > 8 characters");
		driver.findElement(By.id("pwdSignin")).sendKeys("Shru45678");

		System.out.println("Step 6: Click on Login Button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		System.out.println("Step 7: Verify alter message should be \"Success!\"");
		Alert javaScriptAlert = driver.switchTo().alert();
		String alertTxt = javaScriptAlert.getText();
		System.out.println("Actual alert Message ->" + alertTxt);
		if (alertTxt.equals("Success!")) {
			System.out.println("Test Pass for giving Required length password ");
		} else {
			System.out.println("Test Fail");
		}
		javaScriptAlert.accept();

		System.out.println("Step 8: clear username and password");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).clear();
		driver.findElement(By.id("pwdSignin")).clear();

		System.out.println("Step 9:  Enter username");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("SBenakatti");

		System.out.println("Step 10 :Enter password having length < 8 characters");
		driver.findElement(By.id("pwdSignin")).sendKeys("Shru");

		System.out.println("Step 11 : Click on Login button ");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		System.out.println("Step 12: Verify alter message should be \"Failed! please enter strong password\"");
		javaScriptAlert = driver.switchTo().alert();
		alertTxt = javaScriptAlert.getText();
		System.out.println("Actual alert Message ->" + alertTxt);
		if (alertTxt.equals("Failed! please enter strong password")) {
			System.out.println("Test Pass for not giving Required length password ");
		} else {
			System.out.println("Test Fail");
		}
		javaScriptAlert.accept();

		System.out.println("Step 13: Browser close");
		driver.close();
	}

	public static void main(String[] args) {
		Assignment2 assignment2 = new Assignment2();
		assignment2.signUp();
	}
}
