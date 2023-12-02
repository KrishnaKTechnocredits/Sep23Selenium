//Assignment7 Nov19 (Checkbox)
//
//- Navigate to http://automationbykrishna.com/index.html
//- Navigate Basic elements
//a. Checkboxes and radios >> Select 4th option verify 4th checkbox is selected or not
//b. Inline checkboxes >> Select 2nd option and verify 2nd checkbox is selected or not
//
//Hint: isSelected() to check if checkbox is selected or not.
//Note: Checkbox and radioButton behave the same.

package pushpag;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment7 {
	WebDriver driver;
	
	@BeforeMethod
	public void setBrowser() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		wait(3000);
		
		//- Navigate Basic elements
		WebElement basicElement = driver.findElement(By.id("basicelements"));
		basicElement.click();
	}
	
	//a. Checkboxes and radios >> Select 4th option verify 4th checkbox is selected or not
	public void verifyRadioButton() {
		System.out.println("inside verifyRadioButton");
		WebElement radioElement = driver.findElement(By.xpath("//input[@id = 'optionsRadios2']"));
		System.out.println(radioElement.isSelected());
		boolean isRadioButtonSelected = radioElement.isSelected();
		if(isRadioButtonSelected)
			System.out.println("Test case passed...");
		else
			System.out.println("Test case failed...");
	}

	//b. Inline checkboxes >> Select 2nd option and verify 2nd checkbox is selected or not
	public void verifyCheckbox() {
		System.out.println("inside verifyCheckbox");
		WebElement checkBoxElement = driver.findElement(By.xpath("//input[@id = 'inlineCheckbox2']"));
		System.out.println(checkBoxElement.isSelected());
		boolean isCheckBoxSelected = checkBoxElement.isSelected();
		if(isCheckBoxSelected)
			System.out.println("Test case passed...");
		else
			System.out.println("Test case failed...");	
	}
	
	public void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
	@AfterMethod
	public void closeDriver() {
		driver.close();
	}

	@Test
	public void verifyRadioAndCheckBox() {
		verifyRadioButton();
		verifyCheckbox();
	}
}
