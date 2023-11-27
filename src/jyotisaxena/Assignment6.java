/*
 Assignment6 Nov19
- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- click 'Javascript prompt' >> 
a. Enter text and then verify the text
b. Decline and then very the text by getText()
 */

package jyotisaxena;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {
	WebDriver driver;

	public void setUp(String url) {
		System.out.println("Step- Launch Browser");
		System.setProperty("webdriver.chrome.driver", ".//chromeDriver/chromeDriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Step- Launched Browser");
		driver.get(url);
	}

	public void waitABit(int ms) {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	public void scrollDown() {
		// driver.findElement(By.xpath("//a[@id='basiclements']"));
		System.out.println("Step- Scroll Down");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		waitABit(3000);
		WebElement e = driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
		System.out.println("Step - Now at Down Side");
	}

	public void javascriptPrompt(String action, String message) {

		System.out.println("Step- verify Javascript Prompt");
		scrollDown();
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		String text = "Jyoti";
		message = "Hello Jyoti! How are you today?";
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys(text);
		waitABit(3000);
		String popupText = "";
		if (action.equals("accept")) {
			System.out.println("Step- Accept Clicked");
			promptAlert.accept();
			System.out.println("Step- Verify entered text");
			popupText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
			System.out.println("Step - verify Text " + popupText);
			if (popupText.equals(message)) {
				System.out.println("Test Pass");
			} else {
				System.out.println("Failure");
			}
		}

		else if (action.equals("dismiss")) {
			waitABit(3000);
			promptAlert.dismiss();
			message = "User cancelled the prompt.";
			System.out.println("Step- Dismiss clicked");
			popupText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
			String dismissMsg = "User cancelled the prompt.";
			System.out.println("After clicking on Dismiss New message will be" + '\n' + dismissMsg);

			if (popupText.equals(message)) {
				System.out.println("Test Fail ");
			} else {
				System.out.println("Not matched");
			}
		}

	}

	void managePromptAlert() {
		setUp("http://automationbykrishna.com");
		System.out.println("Step- BasicElement Link");
		driver.findElement(By.id("basicelements")).click();
		javascriptPrompt("accept", "Pass");
		waitABit(3000);
		javascriptPrompt("dismiss", "Fail");

		System.out.println("Step - Close Browser");
		driver.close();
	}

	public static void main(String[] args) {
		new Assignment6().managePromptAlert();
	}

}
