//1. navigate to https://rahulshettyacademy.com/client/
//2. user enters the username
//3. user enters the password
//4. user click on the login button
//5. user select the "eletronics" check box under "Categories" & validated that result are displayed

package pushpa.standAloneScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC3 {
	WebDriver driver;

	@BeforeClass
	public void setBrowser() {
		System.out.println("Step 1 - launch browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// 1. navigate to https://rahulshettyacademy.com/client/
		System.out.println("Step 2 -  navigate to https://rahulshettyacademy.com/client/");
		driver.navigate().to("https://rahulshettyacademy.com/client/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void verifyCheckboxFilter() throws InterruptedException {
		WebElement userEmailElement = driver.findElement(By.xpath("//input[@id = 'userEmail']"));
		userEmailElement.sendKeys("pushpa.gite1209@gmail.com");
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id = 'userPassword']"));
		passwordElement.sendKeys("Pa$$w0rd");
		WebElement loginElement = driver.findElement(By.xpath("//input[@id = 'login']"));
		loginElement.click();
		Thread.sleep(3000);

		int sizeBeforeFilter = driver.findElements(By.xpath("//div[@class = 'card-body']")).size();
		WebElement electronicsElement = driver.findElement(
				By.xpath("(//section//h6[text() = 'Categories']/parent::div//input[@type = 'checkbox'])[2]"));
		electronicsElement.click();
		Thread.sleep(3000);
		int sizeAfterFilter = driver.findElements(By.xpath("//div[@class = 'card-body']")).size();

		System.out.println(sizeBeforeFilter + " " + sizeAfterFilter);
		Assert.assertNotEquals(sizeBeforeFilter, sizeAfterFilter, "Filtering by electronics failed!");
	}

	@AfterClass
	public void closeDriver() {
		driver.close();
	}
}
