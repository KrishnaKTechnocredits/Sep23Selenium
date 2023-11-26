/*Assignment11 Nov19 (Multiselect dropdown & deselect)
- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- Checkboxes and radios - Select multiple checkboxes
- Checkboxes and radios - DesSelect atleast 1 checkboxes
- Get List of all selected checkboxes.*/

package roshnikolhe;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment11 {
WebDriver driver;	
	
	void setUp() {
		System.out.println("Step1. Launch Chrome Browser");
		//String setProperty = System.setProperty("webdriver.chrome.driver","D:\\Technocredits\\Projects\\IDE\\Sep23Selenium\\ChromeDriver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println("Step2. Maximize the window");
		driver.manage().window().maximize();
		
		System.out.println("Step3. Navigate to http://automationbykrishna.com/");
		driver.get("http://automationbykrishna.com/");
	}
	

	void basicElement() {

		System.out.println("Step4. Navigate to Basic elements");
		WebElement basicElement = driver.findElement(By.xpath("//a[@id='basicelements']"));
		basicElement.click();
	
	}
	
	void waitABit(int ms) {
		try {
			Thread.sleep(ms);
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
	}
	
	void checkboxesAndRadios() {
		System.out.println("Step5. Checkboxes and radios - Select multiple checkboxes");
		WebElement selectOptions = driver.findElement(By.xpath("//select[@class='form-control']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", selectOptions);

		//select multiple checkboxes
		Select options = new Select(selectOptions);
		List<WebElement> list = options.getOptions();
		int index = 0;
		for (WebElement name : list) {
			options.selectByIndex(index);
			index++;
		}
		System.out.println("Selected first " + index + " option in list");

		System.out.println("DeSelect atleast 1 checkboxes - Get List of all selected checkboxes.");
		options.deselectByIndex(1);

		System.out.println("List of remaining selections are");
		List<WebElement> List1 = options.getAllSelectedOptions();
		for (WebElement name : List1) {
			System.out.print(name.getText() + " ");
		}
	}
	
	void closeBrowser() {
		driver.close();
	}
	
	public static void main(String[] args) {
		Assignment11 assignment11 = new Assignment11();
		assignment11.setUp();
		assignment11.basicElement();
		assignment11.waitABit(3000);
		assignment11.checkboxesAndRadios();
		assignment11.closeBrowser();
	}

}