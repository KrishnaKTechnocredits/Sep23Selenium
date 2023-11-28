//Assignment7 Nov19 (Checkbox)
//
//- Navigate to http://automationbykrishna.com/index.html
//- Navigate Basic elements
//a. Checkboxes and radios >> Select 4th option verify 4th checkbox is selected or not
//b. Inline checkboxes >> Select 2nd option and verify 2nd checkbox is selected or not
//
//Hint: isSelected() to check if checkbox is selected or not.
//Note: Checkbox and radioButton behave the same.
package yogeshchhatwani;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Yogesh_Selenium_Assignment7 {
	WebDriver driver;

	@BeforeClass
	void launchChrome() {
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

	@Test
	void checkboxandRadio() {
		System.out.println("Basic elements");
		driver.findElement(By.id("basicelements")).click();

		System.out.println("a. Checkboxes and radios >> Select 4th option verify 4th checkbox is selected or not");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement radio = driver.findElement(By.xpath("//input[@id='optionsRadios2']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", radio);
		radio.click();
		if (radio.isSelected()) {
			System.out.println("Radio button is selected");
		} else {
			System.out.println("Radio button is not selected");
		}
		System.out.println("b. Inline checkboxes >> Select 2nd option and verify 2nd checkbox is selected or not");
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='inlineCheckbox2']"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView(true)", checkbox);
		checkbox.click();
		if (checkbox.isSelected()) {
			System.out.println("Checkbox is selected");
		} else {
			System.out.println("checkbox is noot selected");
		}
	}
	@AfterMethod
	void close() {
		driver.close();
	}
}
