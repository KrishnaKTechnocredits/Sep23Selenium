package gaurangvirani;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {
	
	void chrome(String url) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\eclipse-workspace\\Sep23Selenium\\chromeDriver\\chromedriver.exe");
		System.out.println("STEP : Chrome browser");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("STEP : navigation");
		driver.get(url);
		driver.manage().window().maximize();
		
		System.out.println("Step : registration link");
		driver.findElement(By.id("registration2")).click();
		
		Thread.sleep(2000);
		
		System.out.println("Step : username");
		driver.findElement(By.id("unameSignin")).sendKeys("Gaurang Virani");
		
		System.out.println("Step : password");
		driver.findElement(By.id("pwdSignin")).sendKeys("12345678");
		
		System.out.println("Step : login button");
		driver.findElement(By.id("btnsubmitdetails")).click();
		
		System.out.println("Step : Verify alter message");
		Alert alert = driver.switchTo().alert();
		if(alert.getText().equals("Success!")) {
			System.out.println("Message matched");
		}else {
			System.out.println("Message did not match");
		}
		alert.accept();
		
		System.out.println("Step : clear");
		driver.findElement(By.id("unameSignin")).clear();
		driver.findElement(By.id("pwdSignin")).clear();
		
		System.out.println("Step : username");
		driver.findElement(By.id("unameSignin")).sendKeys("Gaurang");
		
		System.out.println("Step : password");
		driver.findElement(By.id("pwdSignin")).sendKeys("123456");
		
		System.out.println("Step : login button");
		driver.findElement(By.id("btnsubmitdetails")).click();
		
		System.out.println("Step : Verify alter message failed");
		Alert alert1 = driver.switchTo().alert();
		if(alert1.getText().equals("Failed! please enter strong password")) {
			System.out.println("Message matched");
		}else {
			System.out.println("Message did not match");
		}
		alert1.accept();
		
		driver.close();
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		new Assignment2().chrome("http://automationbykrishna.com/");
		
	}
}
