/*Assignment11 Nov19 (Multiselect dropdown & deselect) - 

Navigate to http://automationbykrishna.com/index.html
	-> Navigate Basic elements - Checkboxes and radios 
	-> Select multiple checkboxes - Checkboxes and radios 
	-> DesSelect atleast 1 checkboxes - Get List of all selected checkboxes.*/

package swatikudale;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment11 {
	WebDriver driver;

	@BeforeMethod
	void setup() {
		System.out.println("Launch Chrome Browser and  Navigate to http://automationbykrishna.com");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get("http://automationbykrishna.com");
	}

	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	void verifyBasicElementCheckboxAndRadio() {

		System.out.println("Navigate Basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		sleep(3000);

		System.out.println("Checkboxes and radios - Select multiple checkboxes");
		WebElement multipleOptions = driver.findElement(By.xpath("//select[@class='form-control']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", multipleOptions);

		// Checkboxes and radios - Select multiple checkboxes
		Select options = new Select(multipleOptions);
		List<WebElement> list = options.getOptions();
		int index = 0;
		for (WebElement name : list) {
			options.selectByIndex(index);
			index++;
		}
		System.out.println("Selected first " + index + " option in list");

		System.out.println("DesSelect atleast 1 checkboxes - Get List of all selected checkboxes.");
		options.deselectByIndex(1);

		System.out.println("List of remaining selections");
		List<WebElement> List1 = options.getAllSelectedOptions();
		for (WebElement name : List1) {
			System.out.print(name.getText() + " ");
		}
	}

	@AfterMethod
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}
}
