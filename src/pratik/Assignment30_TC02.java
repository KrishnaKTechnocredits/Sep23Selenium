/*Assignment : 30th Nov 23

1. complete the TC1 & TC2 from below sheet
https://docs.google.com/spreadsheets/d/1XAsOC5KFoI_AOnB9Zwn4AvSSU0pHXyGgoCexc8Pt-HE/edit#gid=0


Automaiton Test Cases
https://docs.google.com
*/

package pratik;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Assignment30_TC02 {

	@Test
	public void verifyLogin() {
		WebDriver driver = LaunchChromeBrowser.launchBrowser("https://rahulshettyacademy.com/client/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("pratikkabra0391@gmail.com");
		System.out.println("STEP:Entered email");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test@123");
		System.out.println("STEP:Entered password");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		System.out.println("STEP:Clicked on login");

		List<WebElement> categories = driver.findElements(
				By.xpath("//section//h6[text()='Categories']/parent::div/div[@class='form-group ng-star-inserted']"));
		int size = categories.size();
		if (size > 0) {
			System.out.println("Categories is not empty");
		} else
			System.out.println("Categories is empty");

		List<WebElement> subCategories = driver.findElements(By
				.xpath("//section//h6[text()='Sub Categories']/parent::div/div[@class='form-group ng-star-inserted']"));
		size = subCategories.size();
		if (size > 0) {
			System.out.println("Sub Categories is not empty");
		} else
			System.out.println("Sub Categories is empty");

		List<WebElement> searchFor = driver.findElements(
				By.xpath("//section//h6[text()='Search For']/parent::div/div[@class='form-group ng-star-inserted']"));
		size = searchFor.size();
		if (size > 0) {
			System.out.println("Search For is not empty");
		} else
			System.out.println("Search For is empty");

		driver.close();
	}
}
