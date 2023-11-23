package hetalvirani;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.support.ui.Select;

public class Assignment10 {
	WebDriver driver;

	void setUp() {
		System.out.println("Step - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shree\\eclipse-workspace\\SEP23Selenium\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Step - Maximize browser");
		driver.manage().window().maximize();

		System.out.println("step - Launch automationbykrishna.com");
		driver.navigate().to("http://automationbykrishna.com/");
	}

	void wait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void verifyLogin() {
		setUp();
		System.out.println("step - click on Basicelements");
		WebElement basicElement = driver.findElement(By.id("basicelements"));
		basicElement.click();
		
		wait(3000);
		
		System.out.println("step - select multiple checkboxes");
		WebElement checkbox = driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']//div[@class='checkbox'][1]//input"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", checkbox);
		checkbox.click();
		
		WebElement checkbox2 = driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']//div[@class='checkbox'][2]//input"));
		checkbox2.click();
		
		System.out.println("step - select radiobtn");
		WebElement radioBtn = driver.findElement(By.xpath("//div//input[@id='optionsRadios2']"));	
		radioBtn.click();
		
		

	}
	public static void main(String[] args) {
		new Assignment10().verifyLogin();
	}
}
