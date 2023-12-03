package technocredits.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplictWaitDemo {

	WebDriver driver;

	@BeforeMethod
	void setUp() {
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();// Launch Chrome Browser

		System.out.println("STEP - Maximize browser");
		driver.manage().window().maximize();

		System.out.println("STEP - Launch Automationbykrishna.com");
		driver.get("http://automationbykrishna.com/");
	}

	@Test
	public void m1() {
		WebDriverWait wait = new WebDriverWait(driver, 30); // 500 ms
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
		
		
		wait.until(ExpectedConditions.alertIsPresent());
	}
}
