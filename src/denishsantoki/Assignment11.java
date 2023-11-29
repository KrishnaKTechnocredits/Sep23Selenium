/*Assignment11 Nov19 (Multiselect dropdown & deselect)
- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- Checkboxes and radios - Select multiple checkboxes
- Checkboxes and radios - DesSelect atleast 1 checkboxes
- Get List of all selected checkboxes.*/
package denishsantoki;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment11 {
	
	WebDriver driver;
	
	@BeforeClass
	void launchChrome() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("Launch Chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
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
	void verify() {
		System.out.println("Navigate to Basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		sleep(3000);

		System.out.println("Checkboxes and radios - Select multiple checkboxes");
		WebElement selectOptions = driver.findElement(By.xpath("//select[@class='form-control']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", selectOptions);
		Select optionsSelect = new Select(selectOptions);
		List<WebElement> list = optionsSelect.getOptions();
		
		int index=0;
		for(WebElement name:list) {
			optionsSelect.selectByIndex(index);
			index++;
		}
		sleep(2000);
		System.out.println("Step 4 - DesSelect atleast 1 checkboxes");
		optionsSelect.deselectByIndex(2);

		System.out.println("Step 5 - Get List of all selected checkboxes.");
		List<WebElement> selectedOptions = optionsSelect.getAllSelectedOptions();
		for (WebElement option : selectedOptions) {
			System.out.print(option.getText() + " ");
		}
	}
	
	@AfterClass
	void tearDown() {
		driver.close();
	}
}
