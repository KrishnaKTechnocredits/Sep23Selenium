/*Assignment10 Nov19 (Multiselect dropdown)
- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- Checkboxes and radios - Select multiple checkboxes*/

package roshnikolhe;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment10 {
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
		WebElement checkbox1 =  driver.findElement(By.xpath("(//div[@class='form-group']//div[@class='checkbox'])[2]//input[@type='checkbox']"));
		WebElement checkbox2 =  driver.findElement(By.xpath("(//div[@class='form-group']//div[@class='checkbox'])[3]//input[@type='checkbox']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", checkbox1);
		checkbox1.click();
		checkbox2.click();
		if (checkbox1.isSelected() && checkbox2.isSelected()) {
			System.out.println("Test Pass");
		}
		else {
			System.out.println("Test Fail");
		}
		
		waitABit(3000);
		System.out.println("Step6. Inline checkboxes - select multiple Inline checkboxes");
		WebElement inlineCheckbox1 = driver.findElement(By.xpath("//input[@id='inlineCheckbox1']"));
		WebElement inlineCheckbox2 = driver.findElement(By.xpath("//input[@id='inlineCheckbox2']"));
		WebElement inlineCheckbox3 = driver.findElement(By.xpath("//input[@id='inlineCheckbox3']"));
		inlineCheckbox1.click();
		inlineCheckbox2.click();
		inlineCheckbox3.click();
		if (inlineCheckbox1.isSelected() && inlineCheckbox2.isSelected() && inlineCheckbox3.isSelected()) {
			System.out.println("Test Pass");
		}
		else {
			System.out.println("Test Fail");
		}
	}
	
	void closeBrowser() {
		driver.close();
	}
	
	public static void main(String[] args) {
		Assignment10 assignment10 = new Assignment10();
		assignment10.setUp();
		assignment10.basicElement();
		assignment10.waitABit(3000);
		assignment10.checkboxesAndRadios();
		assignment10.closeBrowser();
	}

}
