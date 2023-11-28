//Assignment - 3 : 18th Nov'2023 [30 mins]
//
//1. Launch Chrome Browser
//2. Navigate to automationbykrishna.com
//3. Click on Basic Elements link
//4. Enter firstName
//5. Enter lastName
//6. Enter cmpName
//7. Click on Submit button
//8. Verify Alert message should be as expected.

package yogeshchhatwani;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Yogesh_Selenium_Assignment3 {
	WebDriver driver;

	@BeforeClass
	void launchChrome() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("Step-->Launch Chrome Browser");
		driver = new ChromeDriver();// launch chrome browser
	}

	@BeforeMethod
	void navigateToUrl() {
		String url = "http://automationbykrishna.com";
		driver.navigate().to(url);
		System.out.println("Step-->Click on Basic elements Link");
		WebElement elementOpen = driver.findElement(By.id("basicelements"));
		elementOpen.click();
	}

	public void wait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void firstName() {
		wait(3000);
		System.out.println("Step-->Enter First Name");
		WebElement firstName = driver.findElement(By.xpath("//input[@id='UserFirstName']"));
		firstName.sendKeys("Yogesh");

		System.out.println("Step-->Enter Last Name");
		WebElement lastName = driver.findElement(By.xpath("//input[@id='UserLastName']"));
		lastName.sendKeys("Chhatwani");

		System.out.println("Step-->Enter Company Name");
		WebElement cmpName = driver.findElement(By.xpath("//input[@id='UserCompanyName']"));
		cmpName.sendKeys("Infosys");

		System.out.println("Step-->Click on Submit Button");
		WebElement submit = driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']"));
		submit.click();

		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert is " + alertText);
		alert.accept();
		if (alert.equals(" and  and ")) {
			System.out.println("Test fail");
		} else {
			System.out.println("Test pass");
		}
	}

	@AfterMethod
	void window() {
		driver.close();
	}
}
