/*Assignment : 30th Nov 23

1. complete the TC1 & TC2 from below sheet
https://docs.google.com/spreadsheets/d/1XAsOC5KFoI_AOnB9Zwn4AvSSU0pHXyGgoCexc8Pt-HE/edit#gid=0
*/

package roshnikolhe;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment30 {
	
	WebDriver driver;
	
	void setUp() {
		
		System.out.println("Step Launch Chrome Browser");
		System.setProperty("webdriver.chrome.driver",".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println("Step Maximize the window");
		driver.manage().window().maximize();
		
		System.out.println("Step1. Navigate to https://rahulshettyacademy.com/");
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	void verifyLogin() {
		setUp();
		System.out.println("Step2. Enter username");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("roshnikolhe1@gmail.com");
		System.out.println("Step3. Enter password");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Practice@123");
		System.out.println("Step4. Click on Login");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		
		System.out.println("Step5. Verify that 'Login Successfully' toast message displayed ");
		String loginSuccessMessage = driver.findElement(By.xpath("//div[@aria-label='Login Successfully']")).getText();
		String expectedLoginSuccessMessage = "Login Successfully";
		if(loginSuccessMessage.equals(expectedLoginSuccessMessage)) {
			System.out.println("Test Passed - Login is successful");
		}else {
			System.out.println("Test failed - Login is not successful");
		}

		System.out.println("STEP - Close browser");
		driver.close();
	}
	
	@Test
	void searchFilterTestCase() {
		setUp();
		driver.get("https://rahulshettyacademy.com/client/");

		System.out.println("STEP - Enter user details and Login");
		driver.findElement(By.id("userEmail")).sendKeys("bankarjaykumar@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Jay@131197");
		driver.findElement(By.id("login")).click();

		System.out.println("STEP - Verify all filters have options");
		List<WebElement> categoriesList = driver.findElements(By.xpath("//section//h6[text()='Categories']//parent::div//input[@type='checkbox']"));
		int categoriesListSize = categoriesList.size();

		List<WebElement> subCategoriesList = driver.findElements(By.xpath("//section//h6[text()='Sub Categories']//parent::div//input[@type='checkbox']"));
		int subCategoriesListSize = subCategoriesList.size();

		List<WebElement> searchForList = driver.findElements(By.xpath("//section//h6[text()='Search For']//parent::div//input[@type='checkbox']"));
		int searchForListSize = searchForList.size();

		if (categoriesListSize>0 && subCategoriesListSize>0 && searchForListSize>0) {
			System.out.println("Test Passed - All Filters have options");
		}else if(categoriesListSize==0) {
			System.out.println("Test failed - Categories filter does not have options");
		}else if(subCategoriesListSize==0) {
			System.out.println("Test failed - Sub Categories filter does not have options");
		}else if(searchForListSize==0) {
			System.out.println("Test failed - Search For filter does not have options");
		}

		System.out.println("STEP - Close browser");
		driver.close();
	}
}
