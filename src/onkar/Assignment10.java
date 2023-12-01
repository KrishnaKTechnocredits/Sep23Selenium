/*- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- Checkboxes and radios - Select multiple checkboxes*/

package onkar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment10 {

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
	void multiSelect() {
		System.out.println("Navigate to Basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		sleep(3000);
		
		System.out.println("Checkboxes and radios - Select multiple checkboxes");
		WebElement selectOptions1 = driver.findElement(By.xpath("(//div[@class='form-group']//div[@class='checkbox'])[2]//input[@type='checkbox']"));
		WebElement selectOptions2 = driver.findElement(By.xpath("(//div[@class='form-group']//div[@class='checkbox'])[3]//input[@type='checkbox']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", selectOptions1);
		selectOptions1.click();
		selectOptions2.click();
		if (selectOptions1.isSelected() && selectOptions2.isSelected())
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		
		System.out.println("Select Inline checkboxes");
		WebElement inlineCheckbox1 = driver.findElement(By.xpath("//input[@id='inlineCheckbox1']"));
		WebElement inlineCheckbox2 = driver.findElement(By.xpath("//input[@id='inlineCheckbox2']"));
		WebElement inlineCheckbox3 = driver.findElement(By.xpath("//input[@id='inlineCheckbox3']"));
		//.executeScript("arguments[0].scrollIntoView(true)", inlineCheckbox1);
		inlineCheckbox1.click();
		inlineCheckbox2.click();
		inlineCheckbox3.click();
		if (inlineCheckbox1.isSelected() && inlineCheckbox2.isSelected() && inlineCheckbox3.isSelected())
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
	}
}
