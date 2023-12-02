package akshitak;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment28 {

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

	}

	@Test(priority = 1)
	void displyed() {
		driver.get("https://www.flipkart.com/");
		if (driver.findElement(By.xpath("//div[@class='H6-NpN _3N4_BX']")).isDisplayed()) {
			System.out.println("Login button is Displayed");
		} else
			System.out.println("Login button is not Displayed");
	}

	@Test(priority = 2)
	void enabled() {
		driver.get("http://automationbykrishna.com/index.html#");
		driver.findElement(By.id("registration2")).click();
		if (driver.findElement(By.id("usernameReg")).isEnabled()) {
			System.out.println("Login button is enabled");
		} else
			System.out.println("Login button is not enabled");
	}

	@Test(priority = 3)
	void handleMultipleWindow() {
		driver.get("https://www.amazon.in/");
		String mainWnidow = driver.getWindowHandle();
		String mainTitle = driver.getTitle();
		System.out.println("Main Window : " + mainTitle);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("TV");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='MI 108 cm (43 inches) X Pro 4K Dolby Vision IQ Series Smart Google TV L43M8-5XIN (Black)']")).click();
		
		
		Set<String> multiWindow = driver.getWindowHandles();
		String childWindow= null;
		for (String window : multiWindow) {
			if (!mainWnidow.equals(window)) {
				driver.switchTo().window(window);
				childWindow = driver.getTitle();
				System.out.println("Child Title : " + childWindow);
			}
		}
	}

	@AfterClass
	void tearDown() {
		driver.close();
	}
}