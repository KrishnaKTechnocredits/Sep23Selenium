/*
 Assignment - 3 : 18th Nov'2023 [30 mins]

1. Launch Chrome Browser
2. Navigate to automationbykrishna.com
3. Click on Basic Elements link
4. Enter firstName
5. Enter lastName
6. Enter cmpName
7. Click on Submit button
8. Verify Alert message should be as expected.
 
*/

package deepakkumar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment03 {

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

	public void verifyAlertMsg(String fName, String lName, String cName) {

		dr.findElement(By.xpath("//a[@id='basicelements']")).click();
		tempWait(5000);
		String expectedMsg = fName + " and " + lName + " and " + cName;
		dr.findElement(By.xpath("//input[@id = 'UserFirstName']")).sendKeys(fName);
		dr.findElement(By.xpath("//input[@id = 'UserLastName']")).sendKeys(lName);
		dr.findElement(By.xpath("//input[@id = 'UserCompanyName']")).sendKeys(cName);
		dr.findElement(By.xpath("//div[@name='secondSegment'][1]/section/div/div[4]/button")).click();
		String actualMsg = dr.switchTo().alert().getText();
		dr.switchTo().alert().accept();
		if (actualMsg.equals(expectedMsg)) {
			System.out.println("PASS, Actual message is as expected!");
			System.out.println("Actual Message: "+actualMsg);
		} else {
			System.out.println("FAIL, Actual message is not as expected!");
			System.out.println("Actual Message: "+actualMsg);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assignment03 output = new Assignment03();
		output.LaunchBrowser("http://automationbykrishna.com");
		output.verifyAlertMsg("Deepak", "Kankhar", "Deloitte Consulting Pvt Ltd");
	}

}
