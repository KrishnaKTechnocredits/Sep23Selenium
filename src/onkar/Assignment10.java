/*- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- Checkboxes and radios - Select multiple checkboxes*/

package onkar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment10 {

	WebDriver driver;

	void setup(String url) {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get(url);
	}

	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void multiSelectTest() {
		setup("http://automationbykrishna.com");

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
		
		System.out.println("Closed the browser");
		driver.close();
	}

	public static void main(String[] args) {
		new Assignment10().multiSelectTest();
	}
}
