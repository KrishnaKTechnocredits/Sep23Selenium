package hetalvirani;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {
	public static void main(String[] args) {
		System.out.println("Step - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shree\\eclipse-workspace\\SEP23Selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("Step - Maximize browser");
		driver.manage().window().maximize();

		System.out.println("step - Launch automationbykrishna.com");
		driver.navigate().to("http://automationbykrishna.com/");

		System.out.println("step - click on Basicelements");
		WebElement basicElement = driver.findElement(By.id("basicelements"));
		basicElement.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("step - Enter Firstname");
		WebElement firstnameElement = driver.findElement(By.id("UserFirstName"));
		firstnameElement.sendKeys("mkanani");

		System.out.println("step - Enter Lastname");
		WebElement lastnameElement = driver.findElement(By.id("UserLastName"));
		lastnameElement.sendKeys("mkanani@12345");
		
		System.out.println("step - Enter companyname");
		WebElement cmpnameElement = driver.findElement(By.id("UserCompanyName"));
		cmpnameElement.sendKeys("Technocredits");


		WebElement submitBtn = driver.findElement(By.xpath("//div[@id='firstRow']/div[1]//button"));
		submitBtn.click();

		System.out.println("VERIFY - Alert message should be as expected");
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("AlertText is " + alertText);
		
		alert.accept();
		
		
		System.out.println("step-close browser");
	    driver.close();
	}
}

