/*Assignment - 3 : 18th Nov'2023 [30 mins]
1. Launch Chrome Browser
2. Navigate to automationbykrishna.com
3. Click on Basic Elements link
4. Enter firstName
5. Enter lastName
6. Enter cmpName
7. Click on Submit button
8. Verify Alert message should be as expected.
*/
package jaykumar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {
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
	
	void submitDetails(String fName, String lName, String cmpName) {
		System.out.println("STEP - Enter firstname");
		driver.findElement(By.id("UserFirstName")).sendKeys(fName);
		
		System.out.println("STEP - Enter lastname");
		driver.findElement(By.name("ulname")).sendKeys(lName);
		
		System.out.println("STEP - Enter companyname");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(cmpName);
		
		System.out.println("STEP - Click on submit button");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
	}
	
	void verifyAlert(String message) {
		System.out.println("STEP - Verify Alert");
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert text is: "+alertText);
		if(alertText.equals(message)) {
			System.out.println("Verify alert test passed");
		}else {
			System.out.println("Verify alert test failes");
		}
		alert.accept();
	}
	
	void basicElementTestCases() {
		setUp("http://automationbykrishna.com");
		
		System.out.println("STEP - Click on Basic Elements link");
		driver.findElement(By.id("basicelements")).click();
		waitABit(3000);
		
		submitDetails("Jaykumar", "Bankar", "Dassault Systems");
		
		verifyAlert("Jaykumar and Bankar and Dassault Systems");
	}
	
	public static void main(String[] args) {
	new Assignment3().basicElementTestCases();
	}
}
