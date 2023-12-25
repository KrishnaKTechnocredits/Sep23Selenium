package gaurangvirani;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	WebDriver driver;
	
	void lauchChrome() {
		System.out.println("Launch Chrome Browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	void waitABit() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void scrollIntoView() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//button[@id='javascriptAlert']")));
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
	}
	
	void basicElements() {
		lauchChrome();
		System.out.println("Navigation");
		driver.get("http://automationbykrishna.com/");
		
		System.out.println("Click on Basic Elements");
		driver.findElement(By.id("basicelements")).click();
		
		waitABit();
		
		scrollIntoView();
		
		System.out.println("Verify messege");
		Alert alert = driver.switchTo().alert();
		if(alert.getText().contains("TechnoCredits")) {
			System.out.println("Verified message successfully");
		}else {
			System.out.println("Message not verified");
		}
		alert.accept();
		
		driver.close();
	}
	
	public static void main(String[] args) {
		new Assignment4().basicElements();
	}
}










