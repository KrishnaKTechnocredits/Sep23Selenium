/*Assignment5 Nov19
- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- Click 'Javascript confirmation' >> 
a. Accept and then verify the message by getText()
b. Decline and then verify the message by getText()
*/

package roshnikolhe;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {
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
	
	void waitABit(int ms) {
		try {
			Thread.sleep(ms);
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
	}
	
	void javascriptAlertAccept() {
		
		System.out.println("Step5. Click 'Javascript confirmation'");
		WebElement alertButton = driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']"));
		alertButton.click();
		waitABit(3000);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert message contains: " + alertText);
		
		System.out.println("Step5.1 Accept and then verify the message");
		alert.accept();	
		
		String text = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println(text);
	}
	
	void javascriptAlertDecline() {
		
		//System.out.println("Step5. Click 'Javascript confirmation'");
		WebElement alertButton = driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']"));
		alertButton.click();
		waitABit(3000);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert message contains: " + alertText);
		
		System.out.println("Step5.2 Accept and then verify the message");
		alert.dismiss();	
		
		String text = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println(text);
	}
	
	void closeBrowser() {
		System.out.println("Browser Closed!");
		driver.close();
	}
	
	public static void main(String[] args) {
		Assignment5 assignment5 = new Assignment5();
		assignment5.setUp();
		assignment5.verifyLogin();
		assignment5.javascriptAlertAccept();
		assignment5.javascriptAlertDecline();
		assignment5.waitABit(3000);
		assignment5.closeBrowser();
	}
}
