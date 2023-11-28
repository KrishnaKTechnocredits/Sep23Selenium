/*- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- click 'Javascript prompt' >> 
a. Enter text and then verify the text
b. Decline and then verify the text by getText()

Note: 3 Methods should be created*/

package onkar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment6 {
	
	WebDriver driver;
	
	@BeforeMethod
	void setup() {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get("http://automationbykrishna.com");
	}

	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}
	
	@Test
	void verifyJavaPromt() {
		System.out.println("Navigate Basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		sleep(3000);
		
		System.out.println("click 'Javascript prompt'");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		Alert javascriptAlert = driver.switchTo().alert();
		
		System.out.println("a. Enter text and then verify the text");
		String name = "Onkar";
		javascriptAlert.sendKeys(name);
		sleep(3000);
		javascriptAlert.accept();
		String actualText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if (actualText.equals("Hello "+name+"! How are you today?"))
			System.out.println("Text entered in promt is reflected correctly");
		else
			System.out.println("Text entered in promy is not shown correctly");
		
		System.out.println("b. Decline and then verify the text by getText()");
		System.out.println("click 'Javascript prompt'");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		javascriptAlert = driver.switchTo().alert();
		name = "Onkar";
		javascriptAlert.sendKeys(name);
		javascriptAlert.dismiss();
		actualText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if (actualText.equals("User cancelled the prompt."))
			System.out.println("Cancellation message is shown correctly");
		else
			System.out.println("Cancellation message is not shown correctly");
	}
}
