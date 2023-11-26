package aditya;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("STEP - Launch chrome browser");
		// System.setProperty("webdriver.chrome.driver",
		// ".\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// Launch Chrome Browser

		System.out.println("STEP - Maximize browser");
		driver.manage().window().maximize();

		System.out.println("STEP - Launch Automationbykrishna.com");
		driver.get("http://automationbykrishna.com/");
		
		System.out.println("Step : Click on basic element");
		WebElement basicElement = driver.findElement(By.id("basicelements"));
		basicElement.click();
		
		System.out.println("Step: Enter First name");
		WebElement firstName = driver.findElement(By.id("UserFirstName"));
		firstName.sendKeys("Aditya");

		System.out.println("Step : Enter Last Name");
		WebElement lastName = driver.findElement(By.id("UserLastName"));
		lastName.sendKeys("Kunjir");
	
		System.out.println("Step : Enter Company Name");
		WebElement CompanyName = driver.findElement(By.id("UserCompanyName"));
		CompanyName.sendKeys("Magic");
		
		System.out.println("Step : Click on Submit Button");
		WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"firstRow\"]/div[1]/section/div/div[4]/button"));
		submitButton.click();
		
		System.out.println("Step : To verify Alert text");
		Alert alert = driver.switchTo().alert();
		String expectedAlertMessage = alert.getText();
		System.out.println(expectedAlertMessage);
		String actualAlertMessage = alert.getText();
		if(expectedAlertMessage.equals(actualAlertMessage)) {
			System.out.println("Alert Text Pass");
		}
		else {
			System.out.println("Alert Text Fail");
		}
		alert.accept();
		driver.close();
		}

}
