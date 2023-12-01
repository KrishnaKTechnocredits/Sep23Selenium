package akshitak;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment2 {
	
	WebDriver driver;
	
	@BeforeMethod
	void luanchBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\Technocresdits\\Sep2023\\Chrome_Driver\\chromedriver.exe");
		System.out.println("Launch Chrome");
		driver = new ChromeDriver();
		System.out.println("Maximize Window");
		driver.manage().window().maximize();
		System.out.println("Navigate to");
		driver.get("http://automationbykrishna.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Click on Registration link");
		driver.findElement(By.id("registration2")).click();
		}
	
	@Test
	void registerWithValidCredential() {
		
		System.out.println("Enter UserName");
		driver.findElement(By.id("unameSignin")).sendKeys("Akshita");
		System.out.println("Enter Password");
		driver.findElement(By.id("pwdSignin")).sendKeys("Reset@1234");
		System.out.println("Click Login Button");
		driver.findElement(By.id("btnsubmitdetails")).click();
		System.out.println("Verify Alert Sucess Message");
		Alert alert = driver.switchTo().alert();
		if (alert.getText().equals("Success!"))
			System.out.println("Success Alert message match");
		else
			System.out.println("Success Alert message didnot match");
		alert.accept();
	}
	
	@Test
	void InvalidCredential() {
		System.out.println("Clear userName field");
		driver.findElement(By.id("unameSignin")).clear();
		System.out.println("Clear Password field");
		driver.findElement(By.id("pwdSignin")).clear();
		System.out.println("Enter UserName");
		driver.findElement(By.id("unameSignin")).sendKeys("Akshita");
		System.out.println("Enter Password");
		driver.findElement(By.id("pwdSignin")).sendKeys("Rese");
		System.out.println("Click Login Button");
		driver.findElement(By.id("btnsubmitdetails")).click();
		System.out.println("Verify Alert Sucess Message");
		Alert alert1 = driver.switchTo().alert();
		if (alert1.getText().equals("Failed! please enter strong password"))
			System.out.println("Failed Alert message match");
		else
			System.out.println("Failed Alert message didnot match");
		alert1.accept();
	}

	@AfterMethod
	void closeBrowser() {
		driver.close();
	}
}
