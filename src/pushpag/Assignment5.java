//Assignment5 Nov19
//- Navigate to http://automationbykrishna.com/index.html
//- Navigate Basic elements
//- Click 'Javascript confirmation' >> 
//a. Accept and then verify the message by getText()
//b. Decline and then verify the message by getText()

package pushpag;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {

	public static void main(String[] args) throws InterruptedException {

		// 1. Launch Chrome Browser
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// 2. Navigate to automationbykrishna.com
		driver.get("http://automationbykrishna.com");

		driver.manage().window().maximize();

		// 3. Click on Basic Elements link
		WebElement basicElement = driver.findElement(By.id("basicelements"));
		basicElement.click();

		Thread.sleep(1000);

		WebElement alertBtn = driver.findElement(By.xpath("//button[text() = 'Javascript Confirmation']"));
		alertBtn.click();

		// a. Accept and then verify the message by getText()
		Alert alert = driver.switchTo().alert();
		alert.accept();
		WebElement alertBtnMsg = driver.findElement(By.xpath("//p[@id = 'pgraphdemo']"));
		String msg = alertBtnMsg.getText();
		if (msg.equals("You pressed OK!"))
			System.out.println("Test case passed....");
		else
			System.out.println("Test case failed....");

		// b. Decline and then verify the message by getText()
		Thread.sleep(2000);
		alertBtn.click();
		alert.dismiss();
		WebElement alertBtnMsg1 = driver.findElement(By.xpath("//p[@id = 'pgraphdemo']"));
		String msg1 = alertBtnMsg1.getText();
		if (msg1.equals("You pressed Cancel!"))
			System.out.println("Test case passed....");
		else
			System.out.println("Test case failed....");

		Thread.sleep(2000);
		driver.close();
	}

}
