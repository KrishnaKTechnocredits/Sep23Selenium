/*Assignment4 Nov19
- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- Click 'Alert' and verify if alert message contains TechnoCredits*/
package denishsantoki;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignemnt4 {

	WebDriver driver;

	void launchChrome() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("Step-->Launch Chrome Browser");
		driver = new ChromeDriver();// launch chrome browser
		// Mazimize current window
		driver.manage().window().maximize();

	}

	void navigateToUrl() {
		String url = "http://automationbykrishna.com";
		driver.navigate().to(url);

	}

	void basicElements() {
		System.out.println("Step-->Click on Basic elements Link");
		WebElement elementOpen = driver.findElement(By.id("basicelements"));
		elementOpen.click();
	}

	void clkAlert() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement e = driver.findElement(By.xpath("//button[@id='javascriptAlert']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
		e.click();
	}

	void alert() {
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert is " + alertText);
		if (alertText.contains("TechnoCredits")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}
	}

	public static void main(String[] args) {
		Assignemnt4 assignment4 = new Assignemnt4();
		assignment4.launchChrome();
		assignment4.navigateToUrl();
		assignment4.basicElements();
		assignment4.clkAlert();
		assignment4.alert();
	}
}
