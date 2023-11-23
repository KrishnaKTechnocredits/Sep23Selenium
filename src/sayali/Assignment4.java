/*- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- Click 'Alert' and verify if alert message contains TechnoCredits */

package sayali;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	WebDriver driver;

	void setup(String url) {
		System.out.println("STEP: Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("STEP: Open given URL");
		driver.get(url);
	}

	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void verifyAlert() {
		setup("http://automationbykrishna.com");

		System.out.println("STEP: Navigate Basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		sleep(3000);

		System.out.println("STEP: Click 'Alert' and verify if alert message contains TechnoCredits");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		Alert javascriptAlert = driver.switchTo().alert();
		String actualMessage = javascriptAlert.getText();
		if (actualMessage.contains("TechnoCredits"))
			System.out.println("Test is passed");
		else
			System.out.println("Test failed");
		javascriptAlert.accept();

		System.out.println("Closed the browser");
		driver.close();
	}

	public static void main(String[] args) {
		new Assignment4().verifyAlert();
	}
}