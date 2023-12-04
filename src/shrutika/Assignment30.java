/*Assignment : 30th Nov 23
1. complete the TC1 & TC2 from below sheet
https://docs.google.com/spreadsheets/d/1XAsOC5KFoI_AOnB9Zwn4AvSSU0pHXyGgoCexc8Pt-HE/edit#gid=0
*/
package shrutika;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment30 {

	WebDriver driver;

	@BeforeMethod
	void setup() {

		System.out.println("Step : Launch Chrome Browser and  Navigate to https://rahulshettyacademy.com/client/");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Step : Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Step : Open given URL");
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Test
	void loginTest() {

		System.out.println("Step 1 :  Enter user details and Login");
		driver.findElement(By.id("userEmail")).sendKeys("shrutikad905@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Shrutika@123");
		driver.findElement(By.id("login")).click();

		System.out.println("Step 2 : Validation of successful login");
		String loginSuccessMessage = driver.findElement(By.xpath("//div[@aria-label='Login Successfully']")).getText();
		String expectedLoginSuccessMessage = "Login Successfully";
		if (loginSuccessMessage.equals(expectedLoginSuccessMessage)) {
			System.out.println("Test Pass - Logged in successfully");
		} else {
			System.out.println("Test Fail - Login is unsuccessful");
		}

		System.out.println("Step 3 : Close browser");
		driver.close();
	}

	@Test
	void searchFilterTest() {

		System.out.println("Step 4 : Enter user details and Login");
		driver.findElement(By.id("userEmail")).sendKeys("shrutikad905@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Shrutika@123");
		driver.findElement(By.id("login")).click();

		System.out.println("Step 5 : Verify all filters have options");
		List<WebElement> categoriesList = driver
				.findElements(By.xpath("//section//h6[text()='Categories']//parent::div//input[@type='checkbox']"));
		int categoriesListSize = categoriesList.size();

		List<WebElement> subCategoriesList = driver
				.findElements(By.xpath("//section//h6[text()='Sub Categories']//parent::div//input[@type='checkbox']"));
		int subCategoriesListSize = subCategoriesList.size();

		List<WebElement> searchForList = driver
				.findElements(By.xpath("//section//h6[text()='Search For']//parent::div//input[@type='checkbox']"));
		int searchForListSize = searchForList.size();

		if (categoriesListSize > 0 && subCategoriesListSize > 0 && searchForListSize > 0) {
			System.out.println("Test Pass : All Filters have options");
		} else if (categoriesListSize == 0) {
			System.out.println("Test Fail- Categories filter does not have options");
		} else if (subCategoriesListSize == 0) {
			System.out.println("Test Fail : Sub categories filter does not have options");
		} else if (searchForListSize == 0) {
			System.out.println("Test Fail : Search for filter does not have options");
		}
	}
	
	
	void closeBrowser() {
		System.out.println("Step : Close the browser");
		driver.close();
	}
}
