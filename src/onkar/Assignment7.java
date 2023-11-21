/*- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
a. Checkboxes and radios >> Select 4th option verify 4th checkbox is selected or not
b. Inline checkboxes >> Select 2nd option and verify 2nd checkbox is selected or not

Hint: isSelected() to check if checkbox is selected or not.
Note: Checkbox and radioButton behave the same.*/

package onkar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {
	
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
	
	void checkboxTest() {
		setup("http://automationbykrishna.com");

		System.out.println("Navigate Basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		sleep(3000);
		
		System.out.println("a. Checkboxes and radios >> Select 4th option verify 4th checkbox is selected or not");
		WebElement radio2 = driver.findElement(By.xpath("//input[@id='optionsRadios2']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", radio2);
		radio2.click();
		if(radio2.isSelected())
			System.out.println("Required radio button is selected");
		else
			System.out.println("Test is failed");
		
		System.out.println("b. Inline checkboxes >> Select 2nd option and verify 2nd checkbox is selected or not");
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='inlineCheckbox2']"));
		checkbox.click();
		if(checkbox.isSelected())
			System.out.println("Required checkbox is selected");
		else
			System.out.println("Test is failed");
		
		System.out.println("Closed the browser");
		driver.close();
	}
	
	public static void main(String[] args) {
		new Assignment7().checkboxTest();
	}
}
