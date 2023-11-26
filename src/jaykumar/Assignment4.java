/*Assignment4 Nov19
- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- Click 'Alert' and verify if alert message contains TechnoCredits*/

package jaykumar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {
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
		
		System.out.println("STEP - Click on Alert");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		
		
		System.out.println("STEP - Verify Alert");
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert text is: "+alertText);
		if(alertText.contains("TechnoCredits")) {
			System.out.println("Test passed, alert text contains TechnoCredits");
		}else {
			System.out.println("Test failed, alert text does not contains TechnoCredits");
		}
		alert.accept();	
	}
	
	public static void main(String[] args) {
		new Assignment4().alertTestCases();
	}
}
