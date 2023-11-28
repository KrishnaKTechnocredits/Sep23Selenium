//Assignment11 Nov19 (Multiselect dropdown & deselect)
//- Navigate to http://automationbykrishna.com/index.html
//- Navigate Basic elements
//- Checkboxes and radios - Select multiple checkboxes
//- Checkboxes and radios - DesSelect atleast 1 checkboxes
//- Get List of all selected checkboxes.

package yogeshchhatwani;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Yogesh_Selenium_Assignment11 {
	WebDriver driver;

	@BeforeClass
	void openChrome() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("Launch Chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@BeforeMethod
	void navigateUrl() {
		String url = "http://automationbykrishna.com/index.html";
		driver.navigate().to(url);
	}

	void waitaBit(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void checkboxAndRadios() {
		System.out.println("Step-->Click on Basic elements Link");
		WebElement elementOpen = driver.findElement(By.id("basicelements"));
		elementOpen.click();

		System.out.println("Select multiple checkbox and radio Button");
		waitaBit(3000);
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
	void close() {
		driver.close();
	}
}
