/* - Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
a. Checkboxes and radios >> Select 4th option verify 4th checkbox is selected or not
b. Inline checkboxes >> Select 2nd option and verify 2nd checkbox is selected or not
Hint: isSelected() to check if checkbox is selected or not.
Note: Checkbox and radioButton behave the same. */

package sayali;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment7 {
	WebDriver driver;

	@BeforeMethod
	void launchChrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Testing_Class Sayali\\JavaProject\\Sep23Selenium\\src\\chromeDriver\\chromedriver.exe");
		System.out.println("STEP: Launch Chrome");
		driver = new ChromeDriver();
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
	void basicElements() {

		System.out.println("STEP: Navigate to Basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		sleep(3000);
		System.out.println(
				"a. Checkboxes and radios >> Select 4th option verify 4th\r\n" + "checkbox is selected or not");
		WebElement option4 = driver.findElement(By.xpath("//input[@id='optionsRadios2']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", option4);
		option4.click();
		if (option4.isSelected())
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");

		System.out.println("b. Inline checkboxes >> Select 2nd option and verify 2nd checkbox is selected or not");
		WebElement option2 = driver.findElement(By.xpath("//input[@id='inlineCheckbox2']"));
		option2.click();

		if (option2.isSelected()) {
			System.out.println("Checkbox is selected");
		} else {
			System.out.println("checkbox is not selected");
		}
	}

	@AfterMethod
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}
}