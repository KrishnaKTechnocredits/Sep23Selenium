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

package pushpag;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {

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

		// 4. Enter firstName
		WebElement userNameElement = driver.findElement(By.name("ufname"));
		userNameElement.sendKeys("Pushpa");

		// 5. Enter lastName
		WebElement userLastNameElement = driver.findElement(By.name("ulname"));
		userLastNameElement.sendKeys("Gite");

		// 6. Enter cmpName
		WebElement usercmpName = driver.findElement(By.name("cmpname"));
		usercmpName.sendKeys("XYZ");

		// 7. Click on Submit button
		WebElement submitBtn = driver.findElement(By.xpath("(//button[text() = 'Submit'])[1]"));
		submitBtn.click();

		// 8. Verify Alert message should be as expected.
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		if (alertText.equals("Pushpa and Gite and XYZ"))
			System.out.println("Test case passed");
		else
			System.out.println("Test case failed");

		alert.accept();

		driver.close();
	}

}
