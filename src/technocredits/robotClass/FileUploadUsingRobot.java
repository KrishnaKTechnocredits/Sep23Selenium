package technocredits.robotClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import technocredits.actionsDemo.LaunchChromeBrowser;

public class FileUploadUsingRobot {

	
	@Test
	public void uploadFile() throws InterruptedException, AWTException  {
		WebDriver driver = LaunchChromeBrowser.launchBrowser("http://automationbykrishna.com/#");
		
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		
		WebElement ele = driver.findElement(By.xpath("//input[@id='exampleInputFile']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", ele);
		
		Thread.sleep(3000);
		
		StringSelection strSelection = new StringSelection("C:\\Users\\harsh\\OneDrive\\Desktop\\New folder\\Sep23Selenium\\chromeDriver\\chromedriver.exe");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection, null);

		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		Thread.sleep(2000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
		
		
	}
}
