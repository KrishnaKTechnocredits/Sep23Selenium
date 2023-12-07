/* 1. navigate to https://rahulshettyacademy.com/client/
2. user enters the username
3. user enters the password
4. user click on the login button
5. user select the "electronics" check box under "Categories" & validated that result are displayed
Note: as per the application behavior what you can do is before selection store the total results & after filter take total visible options & both are not same, count must be different */

package sayali;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class Assignment31 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	void setup() {
		System.out.println("STEP: Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get("https://rahulshettyacademy.com/client/");
	}

	@Test
	void validateResultOnAppliedFilter() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("STEP : Enter your Email ID");
		driver.findElement(By.id("userEmail")).sendKeys("sayali.honrao@gmail.com");
		System.out.println("STEP : Enter Password");
		driver.findElement(By.id("userPassword")).sendKeys("Sayali@1441");
		System.out.println("STEP : Click On Login");
		driver.findElement(By.id("login")).click();

		System.out.println("STEP : Validate result count before applying filter");
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='card-body']"), 1));
		int countBeforeApplyFilter = driver.findElements(By.xpath("//div[@class='card-body']")).size();
		Assert.assertTrue(countBeforeApplyFilter > 1);

		System.out.println("Count Of Top Product : " + countBeforeApplyFilter);

		driver.findElement(By.xpath(
				"//section//h6[text()='Categories']/parent::div//label[text()='electronics']/preceding-sibling::input"))
				.click();
		wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//div[@class='card-body']"), 3));
		int countOfElectronics = driver.findElements(By.xpath("//div[@class='card-body']")).size();
		System.out.println("Count Of Electronic Items : " + countOfElectronics);
		Assert.assertTrue(countOfElectronics == 1);
	}

	@AfterClass
	void tearDown() {
		driver.close();
	}
}