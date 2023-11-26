/*- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- Click 'Javascript confirmation' >> 
a. Accept and then verify the message by getText()
b. Decline and then verify the message by getText() */

package sayali;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {

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

	void javascriptConfirmation() {
		setup("http://automationbykrishna.com");

		System.out.println("STEP: Navigate Basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		sleep(3000);

		System.out.println("Click 'Javascript confirmation'");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		Alert javascriptAlert = driver.switchTo().alert();

		System.out.println("STEP: a. Accept and then verify the message by getText()");
		javascriptAlert.accept();
		String actualText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if (actualText.equals("You pressed OK!"))
			System.out.println("Message shown is correct");
		else
			System.out.println("Message shown is incorrect");

		System.out.println("STEP: b. Decline and then verify the message by getText()");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		javascriptAlert = driver.switchTo().alert();
		javascriptAlert.dismiss();
		actualText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if (actualText.equals("You pressed Cancel!"))
			System.out.println("Message shown is correct");
		else
			System.out.println("Message shown is incorrect");

		System.out.println("Browser is closed");
		driver.close();
	}

	public static void main(String[] args) {
		new Assignment5().javascriptConfirmation();
	}
}