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
package deepakkumar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment02 {

	WebDriver dr;

	public void LaunchBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get(url);
	}

	public void tempWait(int mSecs) {
		try {
			Thread.sleep(mSecs);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void verifyLogin(String uName, String pw) {

		dr.findElement(By.xpath("//a[@id = 'registration2']")).click();
		tempWait(5000);
		dr.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(uName);
		dr.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(pw);
		dr.findElement(By.xpath("//button[@id = 'btnsubmitdetails']")).click();

		String successMsg = "Success!";
		String failureMsg = "Failed! please enter strong password";
		String message = dr.switchTo().alert().getText();

		if (message.equals(successMsg)) {
			System.out.println("Username and password entered are correct: " + message);
		} else if (message.equals(failureMsg)) {
			System.out.println("Username and password entered are incorrect: " + message);
		}
		dr.switchTo().alert().accept();
		dr.findElement(By.xpath("//input[@id='unameSignin']")).clear();
		dr.findElement(By.xpath("//input[@id='pwdSignin']")).clear();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assignment02 output = new Assignment02();
		output.LaunchBrowser("http://automationbykrishna.com");
		output.verifyLogin("dkankhar", "pass=1234");
		output.verifyLogin("dkankhar", "pas");
	}

}
