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

public class Assignment7 {
	WebDriver driver;

	void launchChrome() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("STEP: Launch Chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	void navigateUrl() {
		String url = "http://automationbykrishna.com/index.html";
		System.out.println("STEP: Navigate to given url");
		driver.navigate().to(url);
	}

	void basicElements() {

		System.out.println("STEP: Navigate to Basic elements");
		driver.findElement(By.id("basicelements")).click();
	}

	void checkboxandRadio() {
		System.out
				.println("STEP: a. Checkboxes and radios >> Select 4th option verify 4th checkbox is selected or not");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
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
		System.out
				.println("STEP: b. Inline checkboxes >> Select 2nd option and verify 2nd checkbox is selected or not");
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='inlineCheckbox2']"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView(true)", checkbox);
		checkbox.click();

		if (checkbox.isSelected()) {
			System.out.println("Checkbox is selected");
		} else {
			System.out.println("checkbox is not selected");
		}
	}

	public static void main(String[] args) {
		Assignment7 assignment7 = new Assignment7();
		assignment7.launchChrome();
		assignment7.navigateUrl();
		assignment7.basicElements();
		assignment7.checkboxandRadio();
	}
}