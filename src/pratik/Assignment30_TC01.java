/*Assignment : 30th Nov 23

1. complete the TC1 & TC2 from below sheet
https://docs.google.com/spreadsheets/d/1XAsOC5KFoI_AOnB9Zwn4AvSSU0pHXyGgoCexc8Pt-HE/edit#gid=0


Automaiton Test Cases
https://docs.google.com
*/

package pratik;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Assignment30_TC01 {

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

		WebElement loginSuccess = driver.findElement(By.xpath("//div[@aria-label='Login Successfully']"));
		String expectedLogintText = "Login Successfully";

		if (loginSuccess.isDisplayed()) {
			System.out.println("Passed");
		} else
			System.out.println("Failed");

		String actualLoginText = loginSuccess.getText();

		if (actualLoginText.equals(expectedLogintText)) {
			System.out.println("Verify:Login message is as expected");
		} else
			System.out.println("Verify:Login message is not as expected");
		driver.close();
	}
}
