package aditya;
import org.openqa.selenium.Alert;
//Registration Link
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("STEP - Launch chrome browser");
		//System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();//Launch Chrome Browser
		
		System.out.println("STEP - Maximize browser");
		driver.manage().window().maximize();
	
		System.out.println("STEP - Launch Automationbykrishna.com");
		driver.get("http://automationbykrishna.com/");
		
		Thread.sleep(3000);
		System.out.println("Step: Click on Registaration Element");
		WebElement registaionElement = driver.findElement(By.id("registration2"));
		registaionElement.click();
		System.out.println("Registration Element Clicked");
		
		System.out.println("Step: Enter UserName");
		WebElement userName = driver.findElement(By.id("unameSignin"));
		userName.sendKeys("Aditya");
		
		System.out.println("Step: Enter Password");
		WebElement passWord = driver.findElement(By.id("pwdSignin"));
		passWord.sendKeys("EightChar");
		
		System.out.println("Step: Click On SubmitButton");
		WebElement submitButton = driver.findElement(By.id("btnsubmitdetails"));
		submitButton.click();
		
		System.out.println("Step: Capture the Alert text");
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		if(alertText.equals("Success!")) {
		System.out.println("Test Passed: -" +alertText);
		}
		else {
			System.out.println("Test Failed");
		}
		System.out.println("Alert text");
		alert.accept();
		System.out.println("Ok clicked");
		
		Thread.sleep(2000);
		userName.clear();
		passWord.clear();
		
		userName.sendKeys("Aditya");
		passWord.sendKeys("aaa");
		submitButton.click();
		String failedAlertText = alert.getText();
		if(failedAlertText.equals("Failed! please enter strong password")) {
			System.out.println("Failed alert Test Passed: -" +failedAlertText);
			}
			else {
				System.out.println("Test Failed");
			}
		alert.accept();
		driver.close();
		
		
	}
}
