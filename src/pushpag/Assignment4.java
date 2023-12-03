//Assignment4 Nov19
//- Navigate to http://automationbykrishna.com/index.html
//- Navigate Basic elements
//- Click 'Alert' and verify if alert message contains TechnoCredits

package pushpag;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment4 {

	@Test
	public static void verifyDetails() throws InterruptedException {

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

		// Click 'Alert' and verify if alert message contains TechnoCredits
		WebElement alertBtn = driver.findElement(By.xpath("//button[text() = 'Alert']"));
		alertBtn.click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();

		if (alertText.contains("TechnoCredits"))
			System.out.println("Test case passed...");
		else
			System.out.println("Test case failed....");

		alert.accept();

		driver.close();
	}

}
