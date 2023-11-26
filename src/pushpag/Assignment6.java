//Assignment6 Nov19
//- Navigate to http://automationbykrishna.com/index.html
//- Navigate Basic elements
//- click 'Javascript prompt' >> 
//a. Enter text and then verify the text
//b. Decline and then very the text by getText()
//
//Note: 3 Methods should be created

package pushpag;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {
	WebDriver driver;

	public void setBroser() throws InterruptedException {
		// 1. Launch Chrome Browser
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// 2. Navigate to automationbykrishna.com
		driver.navigate().to("http://automationbykrishna.com");
		wait(3000);

		WebElement basicElement = driver.findElement(By.id("basicelements"));
		basicElement.click();
	}

	// a. Enter text and then verify the text
	public void sendTextAndVerify() {
		WebElement alertButton = driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
		alertButton.click();
		wait(3000);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Pushpa");
		wait(3000);
		String alertText = alert.getText();
		System.out.println("Alert message contains: " + alertText);
		wait(3000);
		alert.accept();
		String text = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println(text);
	}

	// b. Decline and then very the text by getText()
	public void declineAndVerifyText() {
		WebElement alertElement = driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
		alertElement.click();
		wait(3000);
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		String text = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println(text);
	}

	void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	public void closeDriver() {
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		Assignment6 assignment6 = new Assignment6();
		assignment6.setBroser();
		assignment6.wait(3000);
		assignment6.sendTextAndVerify();
		assignment6.wait(3000);
		assignment6.declineAndVerifyText();
		assignment6.wait(3000);
		assignment6.closeDriver();
	}

}
