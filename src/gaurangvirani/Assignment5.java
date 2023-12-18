package gaurangvirani;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {

	WebDriver driver;
	
	void chrome() {
		System.out.println("Launch Chrome");
		System.setProperty("webdriver.chrome.driver", ".\\\\chromeDriver\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	void waitaBit() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void basicElements() {
		chrome();
		System.out.println("Navigate Basic elements");
		driver.get("http://automationbykrishna.com/");
		waitaBit();
		driver.findElement(By.id("basicelements")).click();
	}
	
	void scrollTillView() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.id("javascriptConfirmBox")));
		driver.findElement(By.id("javascriptConfirmBox")).click();
	}
	
	void javaScript() {
		basicElements();
		waitaBit();
		scrollTillView();
	}
	
	void acceptMessage() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String actualMessage = driver.findElement(By.id("pgraphdemo")).getText();
		if(actualMessage.contains("You pressed OK!")) {
			System.out.println("Verified");
		}else {
			System.out.println("Not verified");
		}
	}
	
	void declineMessage() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		String actualMessage = driver.findElement(By.id("pgraphdemo")).getText();
		if(actualMessage.contains("You pressed Cancel!")) {
			System.out.println("Verified");
		}else {
			System.out.println("Not verified");
		}
	}
	
	void all() {
		javaScript();
		acceptMessage();
		waitaBit();
		scrollTillView();
		declineMessage();
		driver.close();
	}
	
	public static void main(String[] args) {
		new Assignment5().all();
	}
}
