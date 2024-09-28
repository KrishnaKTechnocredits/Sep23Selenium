package nikita;
import java.nio.file.spi.FileSystemProvider;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Assignment2 {
	RemoteWebDriver driver;

	void launchUrl() {
		System.setProperty("webdriver.chrome.driver",".\\chromeDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://automationbykrishna.com");
	}
	
	void register() throws InterruptedException {
		System.out.println("Click on registration link");
		WebElement registration=driver.findElement(By.id("registration2"));
		registration.click();			
	}
	
	void sleep() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void login() {
		System.out.println("Enter username");
		driver.manage().window().maximize();
		sleep();
		WebElement username=driver.findElement(By.xpath("//input[@id='unameSignin']"));
		username.click();
		username.sendKeys("Nikita");
		WebElement password=driver.findElement(By.id("pwdSignin"));
		password.sendKeys("Niki@1234");
		WebElement login=driver.findElement(By.id("btnsubmitdetails"));
		login.click();
		Alert javascriptAlert=driver.switchTo().alert();
		javascriptAlert.accept();
		sleep();
		username.clear();
		password.clear();
		WebElement username1=driver.findElement(By.xpath("//input[@id='unameSignin']"));
		username1.click();
		username.sendKeys("Niki");
		WebElement password1=driver.findElement(By.id("pwdSignin"));
		password1.sendKeys("Niki1");
		login.click();
		sleep();
		Alert javascriptAlert1=driver.switchTo().alert();
		javascriptAlert1.dismiss();
		System.out.println("execution completed");	
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		Assignment2 assignment2= new Assignment2();
		assignment2.launchUrl();
		assignment2.register();
		assignment2.login();
	}
}
