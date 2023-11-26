/*Assignment6 Nov19
- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- click 'Javascript prompt' >> 
a. Enter text and then verify the text
b. Decline and then very the text by getText()

Note: 3 Methods should be created*/

package roshnikolhe;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {
WebDriver driver;	
	
	void setUp() {
		System.out.println("Step1. Launch Chrome Browser");
		//String setProperty = System.setProperty("webdriver.chrome.driver","D:\\Technocredits\\Projects\\IDE\\Sep23Selenium\\ChromeDriver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println("Step2. Maximize the window");
		driver.manage().window().maximize();
		
		System.out.println("Step3. Navigate to http://automationbykrishna.com/");
		driver.get("http://automationbykrishna.com/");
	}
	

	void verifyLogin() {

	System.out.println("Step4. Navigate to Basic elements");
	WebElement basicElement = driver.findElement(By.xpath("//a[@id='basicelements']"));
	basicElement.click();
	}
	
	void wait(int ms) {
		try {
			Thread.sleep(ms);
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
	}
	
	void javascriptAlertAccept() {
		
		System.out.println("Step5. Click 'Javascript confirmation'");
		WebElement alertButton = driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
		alertButton.click();
		wait(3000);
		Alert alert = driver.switchTo().alert();
		
		System.out.println("Step5.1 Enter text and then verify it");
		alert.sendKeys("Technocredits");
		wait(3000);
		String alertText = alert.getText();
		System.out.println("Alert message contains: " + alertText);
		wait(3000);
		
		alert.accept();	
		
		String text = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println(text);
	}
	
	void javascriptAlertDecline() {
		
		//System.out.println("Step6. Click 'Javascript confirmation'");
		WebElement alertButton = driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
		alertButton.click();
		wait(3000);
		Alert alert = driver.switchTo().alert();
		
		System.out.println("\nStep5.2 Decline and then verify the text");
		alert.dismiss();	
		String text = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println(text);
	}
	
	void closeBrowser() {
		System.out.println("Browser Closed!");
		driver.close();
	}
	
	public static void main(String[] args) {
		Assignment6 assignment6 = new Assignment6();
		assignment6.setUp();
		assignment6.verifyLogin();
		assignment6.wait(3000);
		assignment6.javascriptAlertAccept();
		assignment6.javascriptAlertDecline();
		assignment6.closeBrowser();
	}
}
