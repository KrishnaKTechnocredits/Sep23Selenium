/*
Assignment7 Nov19 (Checkbox)

- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
a. Checkboxes and radios >> Select 4th option verify 4th checkbox is selected or not
b. Inline checkboxes >> Select 2nd option and verify 2nd checkbox is selected or not

Hint: isSelected() to check if checkbox is selected or not.
Note: Checkbox and radioButton behave the same.

 */
package deepakkumar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment07 {
	WebDriver dr;

	public void launchbrowser(String url) {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get(url);
	}

	public void tempWait(int mSecs) {
		try {
			Thread.sleep(mSecs);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void scrollFunction(WebDriver dr, WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
	}

	public void checkboxRadiobtnCheck() {
		launchbrowser("http://automationbykrishna.com/index.html");
		dr.findElement(By.xpath("//a[@id='basicelements']")).click();
		tempWait(4000);

		WebElement checkBox = dr.findElement(By.id("inlineCheckbox2"));
		scrollFunction(dr, checkBox);
		checkBox.click();

		WebElement radio = dr.findElement(By.id("optionsRadios2"));
		radio.click();
		System.out.println("STEP: Checkbox Selection Check!");
		isSelected(checkBox, "Checkbox");
		System.out.println("STEP: Radio Button Selection Check!");
		isSelected(radio, "Radio Button");
	}

	public void isSelected(WebElement e, String elementType) {
		if (e.isSelected()) {
			System.out.println("PASS, "+elementType + " is Selected.");
		} else
			System.out.println("FAIL, "+elementType + " is not Selected.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assignment07 output = new Assignment07();
		output.checkboxRadiobtnCheck();

	}

}
