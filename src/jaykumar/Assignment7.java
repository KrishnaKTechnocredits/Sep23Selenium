/*Assignment7 Nov19 (Checkbox)
- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
a. Checkboxes and radios >> Select 4th option verify 4th checkbox is selected or not
b. Inline checkboxes >> Select 2nd option and verify 2nd checkbox is selected or not
Hint: isSelected() to check if checkbox is selected or not.
Note: Checkbox and radioButton behave the same.*/

package jaykumar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {
	WebDriver driver;
	
	void setUp(String url){
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("STEP - Launch: "+url);
		driver.get(url);
	}
	
	void waitABit(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void scrollToElement(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
	}
	
	void checkboxTestCases() {
		setUp("http://automationbykrishna.com");
		
		System.out.println("STEP - Click on Basic Elements link");
		driver.findElement(By.id("basicelements")).click();
		waitABit(3000);
		
		System.out.println("STEP - Select radio button");
		WebElement radioElement = driver.findElement(By.xpath("//input[@id='optionsRadios2']"));
		scrollToElement(radioElement);
		radioElement.click();
		
		System.out.println("STEP - Verify radio button selection");
		if(radioElement.isSelected()) {
			System.out.println("Radio button selection test passed");
		}else {
			System.out.println("Radio button selection test failed");
		}
		
		System.out.println("STEP - Select checkbox");
		WebElement checkboxElement = driver.findElement(By.xpath("//input[@id='inlineCheckbox2']"));
		checkboxElement.click();
		
		System.out.println("STEP - Verify checkbox selection");
		if(checkboxElement.isSelected()) {
			System.out.println("Checkbox selection test passed");
		}else {
			System.out.println("Checkbox selection test failed");
		}
		
		System.out.println("STEP - Close browser");
		driver.close();
		
	}
	
	public static void main(String[] args) {
		new Assignment7().checkboxTestCases();
	}
}
