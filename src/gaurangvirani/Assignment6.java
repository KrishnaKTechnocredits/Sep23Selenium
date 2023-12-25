package gaurangvirani;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {

	WebDriver driver;
	Alert alert;
	String name = "Gaurang";
	
	void chrome() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("basicelements")).click();
	}
	
	void waitABit() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void scrollTillView() {
		System.out.println("1");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(By.id("javascriptPromp")));
		driver.findElement(By.id("javascriptPromp")).click();
		System.out.println("2");
	}
	
	void acceptMessage() {
		alert = driver.switchTo().alert();
		alert.sendKeys(name);
		alert.accept();
		String actualMessage = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if(actualMessage.contains(name)) {
			System.out.println("Verified");
		}else {
			System.out.println("Not verified");
		}
	}
	
	void declineMessage() {
		alert = driver.switchTo().alert();
		alert.dismiss();
		String actualMessage = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if(actualMessage.equals("User cancelled the prompt.")) {
			System.out.println("Verified");
		}else {
			System.out.println("Not verified");
		}
	}
	
	void all() {
		chrome();
		waitABit();
		scrollTillView();
		acceptMessage();
		scrollTillView();
		declineMessage();
		driver.close();	}
	
	public static void main(String[] args) {
		new Assignment6().all();
	}
}
















