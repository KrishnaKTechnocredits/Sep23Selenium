//Assignment6 Nov19
//- Navigate to http://automationbykrishna.com/index.html
//- Navigate Basic elements
//- click 'Javascript prompt' >> 
//a. Enter text and then verify the text
//b. Decline and then very the text by getText()
package yogeshchhatwani;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Yogesh_Selenium_Assignment6 {
	WebDriver driver;
	@BeforeClass
	void launchChrome() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("Open chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	void url() {
		String url = "http://automationbykrishna.com/index.html";
		driver.navigate().to(url);
	}

	void clkJavascriptPrompt() {
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

	@Test
	void enterTextandVreify() {
		System.out.println("Navigate to url");
		driver.findElement(By.id("basicelements")).click();
		clkJavascriptPrompt();
		System.out.println("a. Enter text and then verify the text");
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Yogesh Chhatwani");
		String alertText = alert.getText();
		System.out.println("message written in alert is:--" + alertText);
		alert.accept();
		if (true) {
			String text = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
			System.out.println("Text while ok is pressed:--" + text);
		}
		System.out.println("b. Decline and then very the text by getText()");
		clkJavascriptPrompt();
		alert.dismiss();
		if (true) {
			String text1 = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
			System.out.println("When cancel is pressed :--" + text1);
		}
	}

	@AfterMethod
	void close() {
		driver.close();
	}
}
