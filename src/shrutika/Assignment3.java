/*1. Launch Chrome Browser
2. Navigate to automationbykrishna.com
3. Click on Basic Elements link
4. Enter firstName
5. Enter lastName
6. Enter cmpName
7. Click on Submit button
8. Verify Alert message should be as expected.*/

package shrutika;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {

	WebDriver driver;

	void setup(String url) {
		System.out.println("STEP 1/2: Launch Chrome Browser and  Navigate to http://automationbykrishna.com");
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

	void verifyBasicElementTab() {
		setup("http://automationbykrishna.com");

		System.out.println("STEP 3: Click on Basic Elements link");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		sleep(3000);
		System.out.println("STEP 4: Enter firstname");
		String firstName = "Shrutika";
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(firstName);

		System.out.println("STEP 5: Enter lastname");
		String lastName = "Benakatti";
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(lastName);

		System.out.println("STEP 6: Enter cmpName");
		String cmpName = "TCS";
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(cmpName);

		System.out.println("STEP 7: Click on Submit button");
		driver.findElement(By.xpath("//div[@name='secondSegment']//button[@type='submit'][1]")).click();

		System.out.println("STEP 8: Verify Alert message should be as expected");
		Alert javaSctriptAlert = driver.switchTo().alert();
		String actualAlertText = javaSctriptAlert.getText();
		String expectedAlertTest = firstName + " and " + lastName + " and " + cmpName;
		System.out.println(expectedAlertTest);
		if (actualAlertText.equals(expectedAlertTest)) {
			System.out.println("Test Pass");
		} else
			System.out.println("Test Fail");

		javaSctriptAlert.accept();

		System.out.println("Step 9: Browser close");
		driver.close();
	}

	public static void main(String[] args) {
		new Assignment3().verifyBasicElementTab();
	}
}
