/*Assignment6 Nov19
- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- click 'Javascript prompt' >> 
a. Enter text and then verify the text
b. Decline and then verify the text by getText()
Note: 3 Methods should be created*/

package jaykumar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {
	WebDriver driver;
	
	void setUp(String url){
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("STEP - Launch: "+url);
		driver.get(url);
	}
	
	void waitABit(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void alertTestCases() {
		setUp("http://automationbykrishna.com");
		
		System.out.println("STEP - Click on Basic Elements link");
		driver.findElement(By.id("basicelements")).click();
		waitABit(3000);
		
		System.out.println("STEP - Click on Prompt");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		
		System.out.println("STEP - Type text in prompt and accept");
		String name = "Jaykumar";
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(name);
		alert.accept();
		
		System.out.println("STEP - Verify prompt message");
		String promptMessage = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println("Alert text is: "+promptMessage);
		
		String expectedMessage = "Hello "+name+"! How are you today?";
		if(promptMessage.equals(expectedMessage)) {
			System.out.println("Verify prompt message test passed");
		}else {
			System.out.println("Verify prompt message test failed");
		}
		
		System.out.println("STEP - Click on Prompt");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		
		System.out.println("STEP - Cancel the prompt");
		alert = driver.switchTo().alert();
		alert.dismiss();
		
		System.out.println("STEP - Verify prompt message");
		promptMessage = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println("Alert text is: "+promptMessage);
		
		expectedMessage = "User cancelled the prompt.";
		if(promptMessage.equals(expectedMessage)) {
			System.out.println("Verify prompt message test passed");
		}else {
			System.out.println("Verify prompt message test failed");
		}
	}
	
	public static void main(String[] args) {
		new Assignment6().alertTestCases();
	}
}
