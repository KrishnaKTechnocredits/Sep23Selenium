package aditya;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Assignment7 {
	WebDriver driver;
	
	void setup(String url) {
		System.out.println("STEP - Launch chrome browser");
		// System.setProperty("webdriver.chrome.driver",
		// ".\\chromeDriver\\chromedriver.exe");
		driver =new ChromeDriver();// Launch Chrome Browser

		System.out.println("STEP - Maximize browser");
		driver.manage().window().maximize();

		System.out.println("STEP - Launch Automationbykrishna.com");
		driver.get(url);
		
	}
	
	void basicElement(){
		setup("http://automationbykrishna.com/");
		System.out.println("Step: Click on Basic Element");
		WebElement basicElemntTag = driver.findElement(By.xpath("//a[@id='basicelements']"));
		basicElemntTag.click();
	}
	
	public void scrollFunction(WebDriver dr, WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
	}

	public void checkboxRadiobtnCheck() {
		basicElement();
		WebElement checkBox = driver.findElement(By.id("inlineCheckbox2"));
		scrollFunction(driver, checkBox);
		checkBox.click();

		WebElement radio = driver.findElement(By.id("optionsRadios2"));
		radio.click();
		System.out.println("STEP: Checkbox Selection Check!");
		isSelected(checkBox, "Checkbox");
		System.out.println("STEP: Radio Button Selection Check!");
		isSelected(radio, "Radio Button");
		driver.quit();
	}

	public void isSelected(WebElement e, String elementType) {
		if (e.isSelected()) {
			System.out.println("PASS, "+elementType + " is Selected.");
		} else
			System.out.println("FAIL, "+elementType + " is not Selected.");
	}

public static void main(String[] args) {
		Assignment7 as7 = new Assignment7();
		as7.checkboxRadiobtnCheck();
	
}
}
