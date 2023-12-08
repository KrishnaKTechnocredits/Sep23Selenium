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

public class TC4 {

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
			
			String selectProduct = "iphone 13 pro";
			String productPath = "//b[text()='"+selectProduct+"']/parent::h5/following-sibling::button[text()=' Add To Cart']";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(productPath)));
			driver.findElement(By.xpath(productPath)).click();
			
			System.out.println("STEP : Product into cart is verify");
			String successFullyMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Product Added To Cart ']"))).getText();
			Assert.assertEquals(successFullyMessage, "Product Added To Cart");
			
			System.out.println("STEP : Click On Cart Button");
			driver.findElement(By.xpath("//li/button[contains(text(),'Cart')]")).click();
			
			String expectedProduct =  driver.findElement(By.xpath("//div[@class='cartSection']/h3")).getText();
			System.out.println("Product Added into cart is : " + expectedProduct);
			
			Assert.assertEquals(expectedProduct.compareToIgnoreCase(expectedProduct), 0);
		}
		
		@AfterClass
		public void tearDown() {
			driver.close();
		}
}
