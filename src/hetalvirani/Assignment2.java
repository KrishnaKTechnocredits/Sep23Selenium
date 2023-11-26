package hetalvirani;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {
	public static void main(String[] args) {
		System.out.println("Step - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shree\\eclipse-workspace\\SEP23Selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("Step - Maximize browser");
		driver.manage().window().maximize();

		System.out.println("step - Launch automationbykrishna.com");
		driver.navigate().to("http://automationbykrishna.com/");

		System.out.println("step - click on Registration link");
		WebElement registrationLinkElement = driver.findElement(By.id("registration2"));
		registrationLinkElement.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("step - Enter username");
		WebElement usernameElement = driver.findElement(By.id("unameSignin"));
		usernameElement.sendKeys("mkanani");

		System.out.println("step - Enter password");
		WebElement passwordElement = driver.findElement(By.id("pwdSignin"));
		passwordElement.sendKeys("mkanani@12345");

		WebElement loginBtn = driver.findElement(By.id("btnsubmitdetails"));
		loginBtn.click();

		System.out.println("VERIFY - Alert message should be \"success!\"");
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("AlertText is " + alertText);
		if(alertText.equals("Success!")) {
			System.out.println("Test pass");
		}else {
			System.out.println("Test fail");
		}
		alert.accept();
		
		usernameElement.clear();
		passwordElement.clear();
		
		System.out.println("step - Enter username");
		WebElement unameElement = driver.findElement(By.id("unameSignin"));
		usernameElement.sendKeys("mkanani");

		System.out.println("step - Enter password");
		WebElement passElement = driver.findElement(By.id("pwdSignin"));
		passwordElement.sendKeys("mka");

		WebElement logBtn = driver.findElement(By.id("btnsubmitdetails"));
		loginBtn.click();

		System.out.println("VERIFY - Alert message should be \"Fail!\"");
		Alert al = driver.switchTo().alert();
		String alText = alert.getText();
		System.out.println("AlertText is " + alText);
		if(alertText.equals("Fail!")) {
			System.out.println("Test pass");
		}else {
			System.out.println("Test fail");
		}
		//alert.accept();
		
		
		// System.out.println("step-close browser");
		// driver.close();
	}
}

