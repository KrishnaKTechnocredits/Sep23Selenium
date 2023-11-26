/*Assignment6 Nov19 - Navigate to http://automationbykrishna.com/index.html -
Navigate Basic elements - click 'Javascript prompt' >>
a. Enter text and then verify the text
b.Decline and then very the text by getText()
Note: 3 Methods should be created */
package swatikudale;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {
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

	void verifyJavaScriptPrompt() {
		setup("http://automationbykrishna.com");
		
		System.out.println("Navigate Basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		sleep(3000);

		// a. Enter text and then verify the text
		System.out.println("click 'Javascript prompt'");
		WebElement element = driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		
		Alert javaScriptalert = driver.switchTo().alert();

		System.out.println("a. Enter text and then verify the text");
		String text = "Swati";
		javaScriptalert.sendKeys(text);
		sleep(3000);
		javaScriptalert.accept();
		String actualText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if (actualText.equals("Hello Swati! How are you today?"))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");

		// b.Decline and then very the text by getText()
		System.out.println("b.Decline and then verify the text by getText()");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		javaScriptalert = driver.switchTo().alert();
		javaScriptalert.dismiss();
		actualText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if(actualText.equals("User cancelled the prompt."))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
		
		System.out.println("Closing Browser");
		driver.close();
	}

	public static void main(String[] args) {
		new Assignment6().verifyJavaScriptPrompt();
	}

}
