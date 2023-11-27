package shamligadekar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {
	
	WebDriver driver;
	
	void launchBrowser(String url) {
		System.out.println("STEP-Launch Browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println("STEP-Maximize Window");
		driver.manage().window().maximize();;
		
		System.out.println("STEP-Navigate to : "+url);
		driver.get(url);
	}
	
	void submitDetails(String fname, String lname,String cmpname) {
		System.out.println("STEP-Enter First Name");
		driver.findElement(By.id("UserFirstName")).sendKeys(fname);
		
		System.out.println("STEP-Enter Last Name");
		driver.findElement(By.id("UserLastName")).sendKeys(lname);
		
		System.out.println("STEP-Enter Company Name");
		driver.findElement(By.id("UserCompanyName")).sendKeys(cmpname);
		
		System.out.println("STEP-Submit Details");
		driver.findElement(By.xpath("//div[@id=\"firstRow\"]/div[1]//button[@onclick='myFunctionPopUp()']")).click();
	}
	
	void verifyAlert(String expectedAlertMessage) {
		System.out.println("STEP-Verify Alert");
		Alert alert= driver.switchTo().alert();
		String actualAlertMessage=alert.getText();
		System.out.println("Alert Text is : "+actualAlertMessage);
		if(actualAlertMessage.equals(expectedAlertMessage)) {
			System.out.println("Verify Alert Test Pass");
		}else {
			System.out.println("Verify Alert Test Fail");
		}
		alert.accept();
	}
	
	void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
	void testcases() {
		launchBrowser("http://automationbykrishna.com/");
		System.out.println("STEP-Click on Basic Elements link");
		driver.findElement(By.id("basicelements")).click();
		wait(3000);
		
		submitDetails("Shamli", "Gadekar", "Atos");
		wait(3000);
		verifyAlert("Shamli and Gadekar and Atos");
		wait(3000);
		
		System.out.println("STEP-Browser Close");
		driver.close();
		
	}

	public static void main(String[] args) {
		Assignment3 assignment3 = new Assignment3();
		assignment3.testcases();		
	}
}
