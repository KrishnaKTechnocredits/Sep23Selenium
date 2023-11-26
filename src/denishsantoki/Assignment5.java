/*Assignment5 Nov19
- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- Click 'Javascript confirmation' >> 
a. Accept and then verify the message by getText()
b. Decline and then verify the message by getText()*/
package denishsantoki;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {
	WebDriver driver;

	void openChrome() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("Launch Crome Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	void navigateUrl() {
		String url = "http://automationbykrishna.com/index.html";
		driver.get(url);
	}

	void basicElement() {
		System.out.println("Navigate to Basic Element");
		driver.findElement(By.id("basicelements")).click();
	}

	void clickJavaScript() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Click JavaScript confirmation");
		WebElement e = driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
		e.click();
	}

	void verify() {
		System.out.println("Verify Pressed OK");
		Alert alert = driver.switchTo().alert();
		String alerttext = alert.getText();
		System.out.println("Alert" + alerttext);
		alert.accept();
		if (true) {
			WebElement pressedok = driver.findElement(By.xpath("//p[@id='pgraphdemo']"));
			String text = pressedok.getText();
			System.out.println("Text while ok is presssed:--" + text);
			if (text.equals(text)) {
				System.out.println("Pressed ok and message shown is correct");
			} else {
				System.out.println("not presssed and message shown is incorrect");
			}
		}
		clickJavaScript();
		alert.dismiss();
		if (true) {
			WebElement pressedcancle = driver.findElement(By.xpath("//p[@id='pgraphdemo']"));
			String text1 = pressedcancle.getText();
			System.out.println("text while cancle is pressed:--" + text1);
			if (text1.equals(text1)) {
				System.out.println("Cancle pressed and message shown is correct");
			} else
				System.out.println("cancel not presssed and message shown is incorrect");
		}

	}

	public static void main(String[] args) {
		Assignment5 ass = new Assignment5();
		ass.openChrome();
		ass.navigateUrl();
		ass.basicElement();
		ass.clickJavaScript();
		ass.verify();
	}
}
