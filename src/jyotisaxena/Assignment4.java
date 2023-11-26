/*
 Assignment4 Nov19
- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- Click 'Alert' and verify if alert message contains TechnoCredits
 */

package jyotisaxena;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {
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

	void verifyAlert() {

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		waitABit(3000);
		WebElement e = driver.findElement(By.id("javascriptAlert"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);// argument[0] current page
		e.click();
		waitABit(3000);
		String actualMsg = driver.switchTo().alert().getText();
		System.out.println("Step - Verify Alert message -->" + actualMsg);

		if (actualMsg.contains("TechnoCredits")) {
			System.out.println("Alert message contains string Techocredits");
		} else {
			System.out.println("Alert message does not contains string Techocredits");
		}

	}

	public static void main(String[] args) {
		Assignment4 ass = new Assignment4();
		ass.setUp("http://automationbykrishna.com");
		ass.verifyAlert();
		ass.driver.close();
	}

}
