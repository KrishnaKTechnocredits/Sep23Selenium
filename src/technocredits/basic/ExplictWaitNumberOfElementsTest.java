package technocredits.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplictWaitNumberOfElementsTest {
	
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", ".//chromeDriver//chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
	}

	@Test
	public void verifySideFilters() throws Exception {
		driver.get("https://rahulshettyacademy.com/client/");
		
		System.out.println("STEP: User enters email!");
		driver.findElement(By.id("userEmail")).sendKeys("dgkankhar@gmail.com");
		
		System.out.println("STEP: User enters password!");
		driver.findElement(By.id("userPassword")).sendKeys("Deepak@21");
		
		System.out.println("STEP: User clicks on Login button!");
		driver.findElement(By.id("login")).click();
		
		System.out.println("STEP: Result Count fetch before filter applied");
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class = 'card-body']"), 1));
		int countOfTopProducts = driver.findElements(By.xpath("//div[@class = 'card-body']")).size();
		System.out.println("Count of top products : " + countOfTopProducts);
		
		System.out.println("VERIFY - Count of Top products");
		Assert.assertTrue(countOfTopProducts>1);
		
		System.out.println("STEP : Click on Eletronics checkbox");
		driver.findElement(By.xpath("//section//label[text()='electronics']/parent::div/input")).click();
		wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//div[@class = 'card-body']"), 2));
		
		System.out.println("VERIFY - Count of Electronic products");
		int countOfElectronicsItem = driver.findElements(By.xpath("//div[@class = 'card-body']")).size();
		System.out.println("Count Of ElectronicsItem : " + countOfElectronicsItem);
		Assert.assertTrue(countOfElectronicsItem==1);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
