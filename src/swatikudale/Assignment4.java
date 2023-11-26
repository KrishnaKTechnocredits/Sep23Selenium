/* Navigate to http://automationbykrishna.com/
Navigate Basic elements
Click 'Alert' and verify if alert message contains TechnoCredits*/
package swatikudale;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	WebDriver driver;

	void setup(String url) {
		System.out.println("Launch Chrome Browser and  Navigate to http://automationbykrishna.com");
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

	void verifyAlert() {
		setup("http://automationbykrishna.com");

		System.out.println("Navigate to Basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		sleep(3000);

		System.out.println("Click 'Alert' and verify if alert message contains TechnoCredits");
		WebElement element = driver.findElement(By.xpath("//button[@id='javascriptAlert']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		Alert javaScriptalert = driver.switchTo().alert();
		String ActualalertText = javaScriptalert.getText();
		System.out.println("Actual Alert->"+ActualalertText);
		if (ActualalertText.contains("TechnoCredits")) {
			System.out.println("Test Pass");
		} else
			System.out.println("Test Fail");
		javaScriptalert.accept();

		System.out.println("Closed the browser");
		driver.close();
	}

	public static void main(String[] args) {
		new Assignment4().verifyAlert();
	}
}
