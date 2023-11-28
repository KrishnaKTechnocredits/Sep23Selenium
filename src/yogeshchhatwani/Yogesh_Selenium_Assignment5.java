//Assignment5 Nov19
//- Navigate to http://automationbykrishna.com/index.html
//- Navigate Basic elements
//- Click 'Javascript confirmation' >> 
//a. Accept and then verify the message by getText()
//b. Decline and then verify the message by getText()
package yogeshchhatwani;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Yogesh_Selenium_Assignment5 {
	WebDriver driver;
	@BeforeClass
	void openChrome() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("Launch Chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
@BeforeMethod
	void navigateUrl() {
		String url = "http://automationbykrishna.com/index.html";
		driver.get(url);
	}

	

	void clkJavascriptConfirmation() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Click javascript confirmation");
		WebElement e = driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
		e.click();
	}
	@Test
	void verify() {
		System.out.println("Navigate to basic elements");
		driver.findElement(By.id("basicelements")).click();
		clkJavascriptConfirmation();
		System.out.println("Verify when pressed OK");
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert is :" + alertText);
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
		clkJavascriptConfirmation();
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

	
}
