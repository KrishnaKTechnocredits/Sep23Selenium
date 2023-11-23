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

package jyotisaxena;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {
	WebDriver driver;

	public void launchBrowser(String url) {
		System.out.println("Step- Launch Browser");
		System.setProperty("webdriver.chrome.driver", ".//chromeDriver/chromeDriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Step- Browser Launched");
		driver.get(url);
	}

	public void waitABit(int mins) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	void loginOnBasicElement(String uFirstName, String lastName, String compName) {
		System.out.println("Step - Basic Elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		waitABit(3000);
		System.out.println("Step - Enter First Name");
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(uFirstName);
		System.out.println("Step - Enter Last Name");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(lastName);
		System.out.println("Step - Enter Company Name");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(compName);
		System.out.println("Step - Submit button");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();

		String actualMsg = driver.switchTo().alert().getText();
		System.out.println("Step - Verify Alert message -->" + actualMsg);

		String expectedAlertMsg = uFirstName + " and " + lastName + " and " + compName;
		if (expectedAlertMsg.equals(actualMsg)) {
			System.out.println("Alert matches successful");
		} else {
			System.out.println("Alert message not matched");
		}
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).clear();
		driver.findElement(By.xpath("//input[@id='UserLastName']")).clear();
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).clear();

	}

	public static void main(String[] args) {
		Assignment3 ass = new Assignment3();
		ass.launchBrowser("http://automationbykrishna.com");
		ass.loginOnBasicElement("Jyoti", "Saxena", "TechnoCredits");
		ass.driver.close();
	}

}
