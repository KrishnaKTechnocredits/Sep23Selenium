/*Assignment5 Nov19 - Navigate to http://automationbykrishna.com/index.html -
Navigate Basic elements - Click 'Javascript confirmation' >>
a. Accept and then verify the message by getText()
b. Decline and then verify the message by getText() */
package swatikudale;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {

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

	void verifyBasicElementAlert() {
		setup("http://automationbykrishna.com");

		System.out.println("Navigate Basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		sleep(5000);

		System.out.println("Click 'Javascript confirmation'");
		WebElement element = driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		Alert javaScriptalert = driver.switchTo().alert();

		System.out.println("a. Accept and then verify the message by getText()");
		javaScriptalert.accept();
		String actualJavaScriptTest = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if (actualJavaScriptTest.equals("You pressed OK!"))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");

		System.out.println("b.Decline and then verify the message by getText()");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		javaScriptalert = driver.switchTo().alert();
		javaScriptalert.dismiss();
		actualJavaScriptTest = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if (actualJavaScriptTest.equals("You pressed Cancel!"))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");

		System.out.println("Browser close");
		driver.close();
	}

	public static void main(String[] args) {
		new Assignment5().verifyBasicElementAlert();
	}
}
