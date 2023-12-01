package akshitak;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment5 {

	WebDriver driver;

	@BeforeClass
	void luanchChrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Technocresdits\\Sep2023\\Chrome_Driver\\chromedriver.exe");
		System.out.println("Luanch Chrome");
		driver = new ChromeDriver();
		System.out.println("Maximize window");
		driver.manage().window().maximize();
		System.out.println("Get URL");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationbykrishna.com/");
	}
	
	@BeforeMethod
	void basicElement() {
		System.out.println("Navigate to Basic Element");
		driver.findElement(By.id("basicelements")).click();
		System.out.println("Find Alert button");
		System.out.println("Scroll till aruguments found");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.id("javascriptConfirmBox")));
		driver.findElement(By.id("javascriptConfirmBox")).click();
		System.out.println("Click button");
	}

	@Test (priority =1)
	void acceptAlert() {
		System.out.println("Accept pop-up");
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String msg = driver.findElement(By.id("pgraphdemo")).getText();
		if (msg.equals("You pressed OK!"))
			System.out.println("OK message match");
		else
			System.out.println("OK message not match");
	}

	@Test (priority =2)
	void cancelAlert() {
		Alert alert = driver.switchTo().alert();
		System.out.println("Cancel pop-up");
		alert.dismiss();
		String msg1 = driver.findElement(By.id("pgraphdemo")).getText();
		if (msg1.equals("You pressed Cancel!"))
			System.out.println("Cancel message match");
		else
			System.out.println("Cancel message not match");
	}

	@AfterClass
	void closeBrowser() {
		driver.close();
	}
}
