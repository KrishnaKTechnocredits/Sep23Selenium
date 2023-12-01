package akshitak;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assignment6 {
	WebDriver driver;

	@BeforeClass
	void luanchChrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Technocresdits\\Sep2023\\Chrome_Driver\\chromedriver.exe");
		System.out.println("Luanch Chrome");
		driver = new ChromeDriver();
		System.out.println("Maximize window");
		driver.manage().window().maximize();
		System.out.println("Get URL");
		driver.get("http://automationbykrishna.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeMethod
	void basicElement() {
		System.out.println("Navigate to Basic Element");
		driver.findElement(By.id("basicelements")).click();
		System.out.println("Find Alert button");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.id("javascriptPromp")));
		System.out.println("Click Prompt alert");
		driver.findElement(By.id("javascriptPromp")).click();
	}

	@Test
	void sendkeyVerifyMsg() {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Technocredits");
		alert.accept();
		WebElement msg = driver.findElement(By.id("pgraphdemo"));
		if (msg.getText().equals("Hello Technocredits! How are you today?"))
			System.out.println("Prompt msg is match");
		else
			System.out.println("Promt msg not match");
	}
	
	@AfterClass
	void tearDown() {
		driver.close();
	}
}
