package hetalvirani.standAloneScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC3 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	void setup() {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get("https://rahulshettyacademy.com/client/");
	}

	@Test
	public void verifyfilter() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("step : Enter email");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("hetalusadadiya@gmail.com");

		System.out.println("step : Enter password");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Heta@0643");

		System.out.println("step : click loginbutton");
		driver.findElement(By.xpath("//input[@id='login']")).click();

		System.out.println("STEP : Result Count Validet Before Filter Applied");
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='card-body']"), 1));
		int resultCountBefore = driver.findElements(By.xpath("//div[@class='card-body']")).size();
		Assert.assertTrue(resultCountBefore > 1);

		System.out.println("Count Of Top Product : " + resultCountBefore);

		driver.findElement(By.xpath(
				"//section//h6[text()='Categories']/parent::div//label[text()='electronics']/preceding-sibling::input"))
				.click();
		wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//div[@class='card-body']"), 3));
		int resultCountElectronics = driver.findElements(By.xpath("//div[@class='card-body']")).size();
		System.out.println("Count Of Electronics : " + resultCountElectronics);
		Assert.assertTrue(resultCountElectronics == 1);
	}

	@AfterClass
	void tearDown() {
		driver.close();
	}
}
