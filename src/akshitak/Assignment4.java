package akshitak;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Assignment4 {
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

	@Test(priority = 1)
	void basicElement() {
		System.out.println("Navigate to Basic Element");
		driver.findElement(By.id("basicelements")).click();
	}

	@Test(priority = 2)
	void scrollTillView() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(By.xpath("//button[@id='javascriptAlert']")));
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		System.out.println("Scroll till view");
	}

	@Test(priority = 3)
	void clickAlert() {
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		System.out.println(message);
		if (message.contains("TechnoCredits"))
			System.out.println("Techno found on alert");
		else
			System.out.println("Techno not found on alert");
		alert.accept();
	}

}
