/*- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- Checkboxes and radios - Select multiple checkboxes
- Checkboxes and radios - DesSelect atleast 1 checkboxes
- Get List of all selected checkboxes.*/

package onkar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment11 {
	
	WebDriver driver;

	@BeforeMethod
	void setup() {
		System.out.println("Launch chrome browser");
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
	
	@AfterMethod
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}

	@Test
	void multiSelectTest() {
		System.out.println("Navigate to Basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		sleep(3000);

		System.out.println("Checkboxes and radios - Select multiple checkboxes");
		WebElement selectOptions = driver.findElement(By.xpath("//select[@class='form-control']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", selectOptions);
		Select optionsSelect = new Select(selectOptions);
		List<WebElement> list = optionsSelect.getOptions();
		int index = 0;
		for (WebElement name : list) {
			optionsSelect.selectByIndex(index);
			index++;
			/*if(index==4) 
				break;*/
		}
		System.out.println("Selection first "+index+" option in multiselect list");
	}
}
