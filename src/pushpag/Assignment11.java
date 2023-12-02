//Assignment11 Nov19 (Multiselect dropdown & deselect)
//- Navigate to http://automationbykrishna.com/index.html
//- Navigate Basic elements
//- Checkboxes and radios - Select multiple checkboxes
//- Checkboxes and radios - DesSelect atleast 1 checkboxes
//- Get List of all selected checkboxes.

package pushpag;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Assignment11 {
	WebDriver driver;
	
	@BeforeClass
	public void setBrowser() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to http://automationbykrishna.com/index.html
		System.out.println("Step 1 - Navigate to https://www.facebook.com/");
		driver.navigate().to("http://automationbykrishna.com/index.html");
		wait(3000);
	}
	
	@org.testng.annotations.Test
	public void verifyMultipleCheckBoxes() throws InterruptedException {
		// - Navigate Basic elements
		System.out.println("Step 2 - Navigate Basic elements");
		WebElement basicElement = driver.findElement(By.id("basicelements"));
		basicElement.click();
		wait(3000);

		// Scroll Down
		System.out.println("Checkboxes and radios - Select multiple checkboxes");
		WebElement selectOptionElement = driver.findElement(By.xpath("//select[@class='form-control']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", selectOptionElement);

		// - Checkboxes and radios - Select multiple checkboxes
		Select select = new Select(selectOptionElement);
		System.out.println("Step 3 - Checkboxes and radios - Select multiple checkboxes");
		List<WebElement> els = select.getOptions();
		int index = 0;
		for (WebElement el : els) {
			select.selectByIndex(index);
			index++;
		}
		
		wait(2000);
		// - Checkboxes and radios - DesSelect atleast 1 checkboxes
		System.out.println("Step 4 - DesSelect atleast 1 checkboxes");
		select.deselectByIndex(1);

		// Get List of all selected checkboxes.
		System.out.println("Step 5 - Get List of all selected checkboxes.");
		List<WebElement> selectedOptions = select.getAllSelectedOptions();
		for (WebElement option : selectedOptions) {
			System.out.print(option.getText() + " ");
		}
	}

	public void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	@AfterClass
	public void closeDriver() {
		driver.close();
	}
}