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

public class Assignment11 {
	
	WebDriver driver;

	void launchChrome(String url) {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("Launch Chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void verify() {
		launchChrome("http://automationbykrishna.com");
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
		driver.close();
	}
	
	public static void main(String[] args) {
		Assignment11 ass = new Assignment11();
		ass.verify();
	}
}
