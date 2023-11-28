/*Assignment11 Nov19 (Multiselect dropdown & deselect) - 
Navigate to http://automationbykrishna.com/index.html
	-> Navigate Basic elements - Checkboxes and radios 
	-> Select multiple checkboxes - Checkboxes and radios 
	-> DesSelect atleast 1 checkboxes - Get List of all selected checkboxes.*/

package shrutika;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment11 {

	WebDriver driver;

	@BeforeClass
	void launchChrome() {
		System.out.println("Step 1 : Launch Chrome Browser ");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("Launch Chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@BeforeMethod
	void setUp() {
		System.out.println("Step 2 : Navigate URL");
		String url = "http://automationbykrishna.com/index.html";
		driver.navigate().to(url);
	}

	@Test
	void verifyBasicElementCheckboxAndRadio() {

		System.out.println("Step 3 : Navigate Basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		System.out.println("Step 4 : Checkboxes and radios - Select multiple checkboxes");
		WebElement multipleOptions = driver.findElement(By.xpath("//select[@class='form-control']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", multipleOptions);

		Select options = new Select(multipleOptions);
		List<WebElement> list = options.getOptions();
		int index = 0;
		for (WebElement name : list) {
			options.selectByIndex(index);
			index++;
		}
		System.out.println("Step 5 : Selected first " + index + " option in list");

		System.out.println("Step 6 : DesSelect atleast 1 checkboxes - Get List of all selected checkboxes.");
		options.deselectByIndex(1);

		System.out.println("Step 7 : List of remaining selections");
		List<WebElement> List1 = options.getAllSelectedOptions();
		for (WebElement name : List1) {
			System.out.print(name.getText() + " ");
		}

		System.out.println("Step 8 : Close the Browser");
		driver.close();
	}
}
