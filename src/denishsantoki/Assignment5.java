/*Assignment5 Nov19
- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- Click 'Javascript confirmation' >> 
a. Accept and then verify the message by getText()
b. Decline and then verify the message by getText()*/
package denishsantoki;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment5 {
	WebDriver driver;
	
	@BeforeClass
	void openChrome() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("Launch Crome Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/index.html");
	}
	
	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void verify() {
		System.out.println("Navigate Basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		sleep(3000);
		
		System.out.println("Click 'Javascript confirmation'");
		WebElement e = driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
		e.click();
		
		Alert javascriptAlert = driver.switchTo().alert();
		System.out.println("a. Accept and then verify the message by getText()");
		javascriptAlert.accept();
		String actualText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if(actualText.equals("You pressed OK!"))
			System.out.println("Message shown is correct");
		else
			System.out.println("Message shown is incorrect");
		
		System.out.println("b. Decline and then verify the message by getText()");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		javascriptAlert = driver.switchTo().alert();
		javascriptAlert.dismiss();
		actualText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if(actualText.equals("You pressed Cancel!"))
			System.out.println("Message shown is correct");
		else
			System.out.println("Message shown is incorrect");
	}
	
	@AfterClass
	void tearDown() {
		driver.close();
	}
}
