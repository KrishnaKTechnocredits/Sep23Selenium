package hetalvirani.standAloneScripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC2 {

	WebDriver driver;

	@BeforeClass
	void setup() {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get("https://rahulshettyacademy.com/client/");
	}

	@Test
	public void verifycategories() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("step : Enter email");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("hetalusadadiya@gmail.com");

		System.out.println("step : Enter password");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Heta@0643");

		System.out.println("step : click loginbutton");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		
		System.out.println("STEP : Verify All Filters Options");
		List<WebElement> categoriesList = driver
				.findElements(By.xpath("//section//h6[text()='Categories']//parent::div//input[@type='checkbox']"));
		int categoriesSize = categoriesList.size();

		List<WebElement> subCategoriesList = driver
				.findElements(By.xpath("//section//h6[text()='Sub Categories']//parent::div//input[@type='checkbox']"));
		int subCategoriesSize = subCategoriesList.size();

		List<WebElement> searchForList = driver
				.findElements(By.xpath("//section//h6[text()='Search For']//parent::div//input[@type='checkbox']"));
		int searchForSize = searchForList.size();

		if (categoriesSize > 0 && subCategoriesSize > 0 && searchForSize > 0) {
			System.out.println("Categories Filter is not empty");
		} else if (categoriesSize == 0) {
			System.out.println("Categories Filter is empty");
		} else if (subCategoriesSize == 0) {
			System.out.println("Categories Filter is empty");
		} else if (searchForSize == 0) {
			System.out.println("Categories Filter is empty");
		}
	}

	@AfterClass
	void tearDown() {
		driver.close();
	}
}
