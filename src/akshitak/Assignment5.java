package akshitak;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {

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
		System.out.println("Scroll till aruguments found");
		wait(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.id("javascriptConfirmBox")));
	}

	void clickConfirmAlert() {
		scrollTillView();
		driver.findElement(By.id("javascriptConfirmBox")).click();
		wait(2000);
		System.out.println("Click button");
	}

	void acceptAlert() {
		System.out.println("Accept pop-up");
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String msg = driver.findElement(By.id("pgraphdemo")).getText();
		if (msg.equals("You pressed OK!"))
			System.out.println("OK message match");
		else
			System.out.println("OK message not match");
		wait(2000);
	}

	void cancelAlert() {
		driver.findElement(By.id("javascriptConfirmBox")).click();
		Alert alert = driver.switchTo().alert();
		wait(2000);
		System.out.println("Cancel pop-up");
		alert.dismiss();
		String msg1 = driver.findElement(By.id("pgraphdemo")).getText();
		if (msg1.equals("You pressed Cancel!"))
			System.out.println("Cancel message match");
		else
			System.out.println("Cancel message not match");
	}

	void verifyMsg() {
		clickConfirmAlert();
		
		acceptAlert();
		cancelAlert();
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment5().verifyMsg();
	}
}
