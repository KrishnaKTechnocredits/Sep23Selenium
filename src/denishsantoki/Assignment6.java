/*Assignment6 Nov19
- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- click 'Javascript prompt' >> 
a. Enter text and then verify the text
b. Decline and then very the text by getText()
*/
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

public class Assignment6 {

	WebDriver driver;
	
	@BeforeClass
	void launchChrome() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("Launch Chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/index.html");
	}
	
	@Test
	void verify() {
		System.out.println("Navigate to url");
		driver.findElement(By.id("basicelements")).click();
		sleep(2000);
		WebElement e = driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
		e.click();
		sleep(2000);
		
		System.out.println("Enter text and then verify the text");
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Denish Santoki");
		String alertText = alert.getText();
		System.out.println("message written in alert is:--" + alertText);
		alert.accept();
		if (true) {
			String text = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
			System.out.println("Text ok is pressed:--" + text);
		}
		System.out.println("Decline and then verify the text");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		Alert javascriptAlert = driver.switchTo().alert();
		String name = "Denish Santoki";
		javascriptAlert.sendKeys(name);
		javascriptAlert.dismiss();
		String actualText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if (actualText.equals("User cancelled the prompt."))
			System.out.println("Cancellation message is shown correctly");
		else
			System.out.println("Cancellation message is not shown correctly");

	}
	
	@AfterClass
	void tearDown() {
		driver.close();
	}
	
	void sleep(int time) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
