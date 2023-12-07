package shrutika;

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
	void setup() {

		System.out.println("Step : Launch Chrome Browser and  Navigate to http://automationbykrishna.com");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Step :Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Step :Open given URL");
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
	public void testUploadFile() throws AWTException {
		driver.findElement(By.id("basicelements")).click();
		sleep(2000);
		System.out.println("Step : Moving to basic elements section and upload file under Basic forms");
		WebElement inputFile = driver.findElement(By.xpath("//input[@id='exampleInputFile']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", inputFile);

		sleep(3000);
		
		StringSelection selectFile = new StringSelection("D:\\Automation 2023\\Practice\\Notes\\Assignment.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selectFile, null);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		sleep(2000);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		sleep(2000);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		sleep(2000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	@AfterMethod
	void closeBrowser() {
		System.out.println("Step : Close browser");
		driver.close();
	}
}
