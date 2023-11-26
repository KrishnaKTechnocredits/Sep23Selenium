/*Assignment - 3 : 18th Nov'2023 [30 mins]

1. Launch Chrome Browser
2. Navigate to automationbykrishna.com
3. Click on Basic Elements link
4. Enter firstName
5. Enter lastName
6. Enter cmpName
7. Click on Submit button
8. Verify Alert message should be as expected.*/

package roshnikolhe;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {
	
	public static void main(String[] args) {
		System.out.println("Step1. Launch Chrome Browser");
		//String SetProperty = System.setProperty("webdriver.chrome.driver", "D:\\\\Technocredits\\\\Projects\\\\IDE\\\\Sep23Selenium\\\\ChromeDriver\\\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",".\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();//Launch Chrome Browser
		
		System.out.println("Step2. Maximize Browser");
		driver.manage().window().maximize();
		
		System.out.println("Step3. Navigate to automationbykrishna.com");
		driver.get("http://automationbykrishna.com\\");
		
		System.out.println("Step4. Click on Basic Elements link");
		WebElement basicElement = driver.findElement(By.id("basicelements"));
		basicElement.click();
		
		System.out.println("Step5. Enter firstName");
		WebElement firstName = driver.findElement(By.id("UserFirstName"));
		firstName.sendKeys("Maulik");
		
		System.out.println("Step6. Enter LastName");
		WebElement lastName = driver.findElement(By.id("UserLastName"));
		lastName.sendKeys("Kanani");
		
		System.out.println("Step7. Enter Company Name");
		WebElement cmpName = driver.findElement(By.id("UserCompanyName"));
		cmpName.sendKeys("Technocredits");
		
		System.out.println("Step8. Click on Submit button");
		WebElement submitButton = driver.findElement(By.xpath("//div[@id='firstRow']/div[1]/section/div/div[4]/button"));
		submitButton.click();
	
		System.out.println("Step9. Verify Alert message should be as expected.");
		Alert javaScriptAlert = driver.switchTo().alert();
		String alertText = javaScriptAlert.getText();
		System.out.println("AlertText is " + alertText);
		if(alertText.equals(firstName+ " and " +lastName+ " and " +cmpName)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		javaScriptAlert.accept();

		System.out.println("Browser Closed!");
		driver.close();
		
	}
}

