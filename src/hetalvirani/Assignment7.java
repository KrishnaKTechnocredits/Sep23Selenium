package hetalvirani;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment7 {
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

		WebElement radioBtn = driver.findElement(By.xpath("//input[@id='optionsRadios2']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", radioBtn);
		radioBtn.click();
		boolean flag = radioBtn.isSelected();
		if(flag) {
			System.out.println("Test pass");
		}else {
			System.out.println("Test fail");
		}
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='inlineCheckbox2']"));
		JavascriptExecutor ja = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", checkbox);
		checkbox.click();
		boolean flag1 = checkbox.isSelected();
		if(flag1) {
			System.out.println("Test pass");
		}else {
			System.out.println("Test fail");
		}
		driver.close();
	}
	public static void main(String[] args) {
		new Assignment7().verifyLogin();
	}
}
