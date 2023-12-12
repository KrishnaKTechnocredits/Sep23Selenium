//Assignment : 29th Nov 23
//
//1. Navigate to automation by krishna
//2. goto basic element section/tab
//3. upload file (click using actions)
//1. TestNG parameter & Optional parameter

package pushpag;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment29 {
	WebDriver driver;
	

	@BeforeMethod
	public void setBrowser() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to http://automationbykrishna.com/index.html
		System.out.println("Step 1 - http://automationbykrishna.com/index.html");
		driver.navigate().to("http://automationbykrishna.com/index.html");
		wait(3000);
	}
	
	@Test
	public void uploadFile() throws AWTException {
		WebElement basicElement = driver.findElement(By.id("basicelements"));
		basicElement.click();
		wait(3000);
		WebElement fileElement = driver.findElement(By.xpath("//input[@id='exampleInputFile']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", fileElement);
		wait(3000);
		
		StringSelection selectFile = new StringSelection("C:\\Java\\Selenium-Notes-Pushpa .txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selectFile, null);
		
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	@AfterMethod
	public void closeDriver() {
		driver.close();
	}
}
