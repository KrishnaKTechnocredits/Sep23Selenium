/*Assignment6 Nov19
- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- click 'Javascript prompt' >> 
a. Enter text and then verify the text
b. Decline and then very the text by getText()
*/
package denishsantoki;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {

	WebDriver driver;

	void launchChrome() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("Launch Chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	void navigateUrl() {
		String url = "http://automationbykrishna.com/index.html";
		driver.navigate().to(url);
	}

	void basicElements() {
		System.out.println("Navigate to url");
		driver.findElement(By.id("basicelements")).click();
	}

	void clickJavascriptPrompt() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement e = driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
		e.click();
	}

	void verify() {
		System.out.println("Enter text and then verify the text");
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Denish Santoki");
		String alertText = alert.getText();
		System.out.println("message written in alert is:--" + alertText);
		alert.accept();
		if (true) {
			String text = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
			System.out.println("Text ok is pressed:--" + text);
		}
		System.out.println("Decline and then verify the text");
		clickJavascriptPrompt();
		alert.dismiss();
		if (true) {
			String text1 = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
			System.out.println("When cancel is pressed :--" + text1);
		}
	}

	public static void main(String[] args) {
		Assignment6 assignment6 = new Assignment6();
		assignment6.launchChrome();
		assignment6.navigateUrl();
		assignment6.basicElements();
		assignment6.clickJavascriptPrompt();
		assignment6.verify();
	}
}
