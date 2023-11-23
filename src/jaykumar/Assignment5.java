/*Assignment5 Nov19
- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- Click 'Javascript confirmation' >> 
a. Accept and then verify the message by getText()
b. Decline and then verify the message by getText()*/

package jaykumar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {
	WebDriver driver;

	void setUp(String url) {
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("STEP - Launch: " + url);
		driver.get(url);
	}

	void waitABit(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void verifyConfirmation(String action, String message) {
		System.out.println("STEP - Click on JavaScript Confirmation");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		
		String confirmationText ="";
		Alert alert = driver.switchTo().alert();
		if (action.equals("accept")) {
			alert.accept();
			System.out.println("STEP - Verify alert after accept");
			confirmationText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
			System.out.println("Text after acceting alert: " + confirmationText);
		} else if (action.equals("dismiss")) {
			alert.dismiss();
			System.out.println("STEP - Verify alert after dismiss");
			confirmationText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
			System.out.println("Text after dismissing alert: " + confirmationText);
		}
		
		if (confirmationText.equals(message)) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
	}

	void alertTestCases() {
		setUp("http://automationbykrishna.com");

		System.out.println("STEP - Click on Basic Elements link");
		driver.findElement(By.id("basicelements")).click();
		waitABit(3000);

		verifyConfirmation("accept", "You pressed OK!");
		verifyConfirmation("dismiss", "You pressed Cancel!");

		System.out.println("STEP - Close browser");
		driver.close();
	}

	public static void main(String[] args) {
		new Assignment5().alertTestCases();
	}
}
