/*1. Launch Chrome Browser
2. Navigate to automationbykrishna.com
3. Click on Basic Elements link
4. Enter firstName
5. Enter lastName
6. Enter cmpName
7. Click on Submit button
8. Verify Alert message should be as expected.*/

package sayali;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {

	WebDriver driver;

	void setup(String url) {
		System.out.println("STEP: Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get(url);
	}

	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void testBasicElements() {

		setup("http://automationbykrishna.com");
		System.out.println("STEP: Navigate to automationbykrishna.com");
		System.out.println("STEP: Click on Basic Elements link");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		sleep(3000);

		System.out.println("STEP: Enter first name");
		String firstName = "Sayali";
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(firstName);

		System.out.println("STEP: Enter last name");
		String lastName = "Honrao";
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(lastName);

		System.out.println("STEP: Enter company name");
		String cmpName = "Persistent Systems";
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(cmpName);

		System.out.println("STEP: Click on Submit button");
		driver.findElement(By.xpath("(//div[@name='secondSegment']//button[@type='submit'])[1]")).click();

		System.out.println("STEP: Verify Alert message should be as expected");
		Alert javascriptAlert = driver.switchTo().alert();
		String actualText = javascriptAlert.getText();
		String expectedText = firstName + " and " + lastName + " and " + cmpName;
		if (actualText.equals(expectedText))
			System.out.println("Correct message is displayed in alert window");
		javascriptAlert.accept();

		System.out.println("Closed browser window");
		driver.close();
	}

	public static void main(String[] args) {
		new Assignment3().testBasicElements();
	}
}