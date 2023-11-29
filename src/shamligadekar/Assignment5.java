package shamligadekar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {

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
	
	void verifyConfirmation(String action, String expectedmessage) {
		System.out.println("STEP - Click on Javascript Confirmation");
		WebElement e=driver.findElement(By.xpath("//button[text()='Javascript Confirmation']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
		e.click();
		wait(3000);
		
		System.out.println("STEP-Verify Javascript Confirmation");
		String confirmationText="";
		Alert alert= driver.switchTo().alert();
		
		if(action.equals("accept")) {
			alert.accept();	
			System.out.println("Verify alert after accept");
			confirmationText=driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
			System.out.println("Test after accepting alert :"+confirmationText);
		}
		else if(action.equals("dismiss")) {
			alert.dismiss();	
			System.out.println("Verify alert after dismiss");
			confirmationText=driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
			System.out.println("Test after Dismissing alert :"+confirmationText);
		}
		
		if(confirmationText.equals(expectedmessage)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
	}
	
	void testCases() {
		launchBrowser("http://automationbykrishna.com/");
		System.out.println("STEP-Click on Basic Elements link");
		driver.findElement(By.id("basicelements")).click();
		wait(3000);
		
		verifyConfirmation("accept","You pressed OK!");
		wait(3000);
		verifyConfirmation("dismiss","You pressed Cancel!");
		
		System.out.println("STEP-Browser Close");
		driver.close();
	}
	public static void main(String[] args) {
		Assignment5 assignment5 = new Assignment5();
		assignment5.testCases();

	}

}
