package akshitak;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assignment6 {
	WebDriver driver;

	void luanchChrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Technocresdits\\Sep2023\\Chrome_Driver\\chromedriver.exe");
		System.out.println("Luanch Chrome");
		driver = new ChromeDriver();
		System.out.println("Maximize window");
		driver.manage().window().maximize();
	}

	void navigatrURL() {
		luanchChrome();
		System.out.println("Get URL");
		driver.get("http://automationbykrishna.com/");
	}

	void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	void basicElement() {
		navigatrURL();
		System.out.println("Navigate to Basic Element");
		driver.findElement(By.id("basicelements")).click();
		wait(2000);
		System.out.println("Find Alert button");
	}

	void scrollTillView() {
		basicElement();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.id("javascriptPromp")));
	}

	void clickPromptAlert() {
		scrollTillView();
		System.out.println("Click Prompt alert");
		driver.findElement(By.id("javascriptPromp")).click();
	}

	void sendkeyVerifyMsg() {
		clickPromptAlert();
		wait(2000);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Technocredits");
		alert.accept();
		WebElement msg = driver.findElement(By.id("pgraphdemo"));
		if (msg.getText().equals("Hello Technocredits! How are you today?"))
			System.out.println("Prompt msg is match");
		else
			System.out.println("Promt msg not match");
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment6().sendkeyVerifyMsg();
	}
}
