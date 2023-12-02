package shamligadekar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {
	
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
	
	void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void verifyAlert() {
		System.out.println("STEP-Verify Alert");
		Alert alert= driver.switchTo().alert();
		String actualAlertMessage=alert.getText();
		System.out.println("Alert Text is : "+actualAlertMessage);
		if(actualAlertMessage.contains("TechnoCredits")) {
			System.out.println("Test Pass, alert text contains TechnoCredits");
		}else {
			System.out.println("Test Fail, alert text does not contain TechnoCredits");
		}
		wait(3000);
		alert.accept();	
	}
	
	void testCases() {
		launchBrowser("http://automationbykrishna.com/");
		System.out.println("STEP-Click on Basic Elements link");
		driver.findElement(By.id("basicelements")).click();
		wait(3000);
		System.out.println("STEP - Click on Alert");
		WebElement b=driver.findElement(By.xpath("//button[text()='Alert']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", b);
		//js.executeScript("(arguments[0].scrollIntoView(true))", b);)
		b.click();
		wait(3000);
		verifyAlert();
		
		System.out.println("STEP-Browser Close");
		driver.close();
	}

	public static void main(String[] args) {
		Assignment4 assignment4 = new Assignment4();
		assignment4.testCases();		
	}
}
