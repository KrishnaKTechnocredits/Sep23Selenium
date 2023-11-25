/*Assignment7 Nov19 (Checkbox)

- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
a. Checkboxes and radios >> Select 4th option verify 4th checkbox is selected or not
b. Inline checkboxes >> Select 2nd option and verify 2nd checkbox is selected or not

Hint: isSelected() to check if checkbox is selected or not.
Note: Checkbox and radioButton behave the same.
*
*/
package roshnikolhe;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {
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
	

	void verifyLogin() {

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
		System.out.println("Step4.a Checkboxes and radios >> Select 4th option verify 4th option is selected or not");
		WebElement radio = driver.findElement(By.xpath("//input[@id='optionsRadios2']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", radio);
		radio.click();
		boolean flag1 = radio.isSelected();
		if(flag1) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		
		System.out.println("Step4.b Checkboxes and radios >> Select 2nd verify 2nd checkbox is selected or not");
		WebElement checkboxInline = driver.findElement(By.xpath("//input[@id='inlineCheckbox2']"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true)", checkboxInline);
		checkboxInline.click();
		checkboxInline.isSelected();
		boolean flag2 = checkboxInline.isSelected();
		if(flag2) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		
		System.out.println("Step4.c Checkboxes and radios >> Select 2nd and 4th options and verify checkboxes are selected or not");
		WebElement checkboxSelect = driver.findElement(By.xpath("//select[@class='form-control m-bot15']//option[2]"));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].scrollIntoView(true)", checkboxSelect);
		checkboxSelect.click();
		checkboxSelect.isSelected();
		boolean flag3 = checkboxSelect.isSelected();
		if(flag3) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		
		
	}
	
	void closeBrowser() {
		driver.close();
	}
	
	public static void main(String[] args) {
		Assignment7 assignment7 = new Assignment7();
		assignment7.setUp();
		assignment7.verifyLogin();
		assignment7.waitABit(3000);
		assignment7.checkboxesAndRadios();
		assignment7.closeBrowser();
	}

}
