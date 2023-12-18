package gaurangvirani;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {
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
	
	void fillDetails() {
		lauchChrome();
		System.out.println("Navigate to automationbykrishna.com");
		driver.get("http://automationbykrishna.com/");
		
		System.out.println("Click on Basic Elements link");
		driver.findElement(By.id("basicelements")).click();
		
		waitABit();
		
		System.out.println("Enter firstName");
		String firstName = "Gaurang";
		driver.findElement(By.id("UserFirstName")).sendKeys(firstName);
		
		System.out.println("Enter lastName");
		String lastName = "Virani";
		driver.findElement(By.id("UserLastName")).sendKeys(lastName);
		
		System.out.println("Enter cmpName");
		String cmpName = "Technocredits";
		driver.findElement(By.id("UserCompanyName")).sendKeys(cmpName);
		
	}
	
	void clickAlert() {
		fillDetails();
		System.out.println("Click on Submit button");
		driver.findElement(By.xpath("//div[@name='secondSegment'][1]//button[@class='btn btn-primary']")).click();
		
		System.out.println("Verify Alert message should be as expected");
		Alert alert = driver.switchTo().alert();
		if(alert.getText().equals("Gaurang and Virani and Technocredits")) {
			System.out.println("Alert message matched");
		}else {
			System.out.println("Alert message did not match");
		}
		alert.accept();
	}
	
	public static void main(String[] args) throws InterruptedException {
		new Assignment3().clickAlert();
	}
}
