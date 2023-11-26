/*
 Assignment5 Nov19
- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- Click 'Javascript confirmation' >> 
a. Accept and then verify the message by getText()
b. Decline and then verify the message by getText()
 */

package jyotisaxena;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {
	WebDriver driver;

	public void setUp(String url) {
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

	void scrollDown() {

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		waitABit(3000);
		WebElement e = driver.findElement(By.id("javascriptConfirmBox"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);// argument[0] current page
		// e.click();
		waitABit(3000);

	}

	void verifyConfirmation(String action, String msg) {
		System.out.println("STEP - Click on JavaScript Confirmation");
		scrollDown();
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();

		String confirmationText = "";
		Alert alert = driver.switchTo().alert();
		if (action.equals("accept")) {
			alert.accept();
			System.out.println("STEP - Verify alert after accept");
			confirmationText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
			System.out.println("Text after acceting alert: " + confirmationText);
		} else if (action.equals("dismiss")) {
			alert.dismiss();
			System.out.println("STEP - Verify alert after dismiss");
			confirmationText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
			System.out.println("Text after dismissing alert: " + confirmationText);
		}

		if (confirmationText.equals(msg)) {
			System.out.println("Successful");
		} else {
			System.out.println("Failure");
		}
	}

	void manageAlerts() {
		setUp("http://automationbykrishna.com");

		System.out.println("STEP - Click on Basic Elements link");
		driver.findElement(By.id("basicelements")).click();
		waitABit(3000);
		scrollDown();
		verifyConfirmation("accept", "You pressed OK!");
		verifyConfirmation("dismiss", "You pressed Cancel!");

		System.out.println("STEP - Close browser");
		driver.close();
	}

	public static void main(String[] args) {
		Assignment5 ass = new Assignment5();
		ass.manageAlerts();

	}

}
