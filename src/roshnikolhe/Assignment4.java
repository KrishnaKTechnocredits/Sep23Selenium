/*Assignment4 Nov19
- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- Click 'Alert' and verify if alert message contains TechnoCredits
*/

package roshnikolhe;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {
	
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
		
		void javascriptAlert() {
			
			System.out.println("Step5. Click 'Alert' and verify if alert message contains TechnoCredits");
			WebElement alertButton = driver.findElement(By.xpath("//button[@id='javascriptAlert']"));
			alertButton.click();
			waitABit(4000);
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			System.out.println("Alert message contains: " + alertText);
			if(alertText.contains("TechnoCredits")) {
				System.out.println("Test Pass");
			}else {
				System.out.println("Test Fail");
			}
			alert.accept();	
		}
		
		void closeBrowser() {
			System.out.println("Browser Closed!");
			driver.close();
		}
		
		public static void main(String[] args) {
			Assignment4 assignment4 = new Assignment4();
			assignment4.setUp();
			assignment4.verifyLogin();
			assignment4.javascriptAlert();
			assignment4.closeBrowser();
		}
}
