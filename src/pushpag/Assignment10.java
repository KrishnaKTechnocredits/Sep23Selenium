//Assignment10 Nov19 (Multiselect dropdown)
//- Navigate to http://automationbykrishna.com/index.html
//- Navigate Basic elements
//- Checkboxes and radios - Select multiple checkboxes

package pushpag;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Assignment10 {
	WebDriver driver;
	
	@BeforeClass
	public void setBrowser() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to http://automationbykrishna.com/index.html
		System.out.println("Step 1 - http://automationbykrishna.com/index.html");
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