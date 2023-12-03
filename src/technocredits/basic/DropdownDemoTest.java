package technocredits.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownDemoTest {
	WebDriver driver;
	
	void setUp(String url) {
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();// Launch Chrome Browser

		System.out.println("STEP - Maximize browser");
		driver.manage().window().maximize();

		System.out.println("STEP - Navigate to URL");
		driver.get(url);
	}
	
	void waitABit(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void verifyDropdownSelect() {
		setUp("https://www.facebook.com/");
		System.out.println("STEP - Click on Create new account");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		
		waitABit(3000);
		System.out.println("STEP - Select month");
		WebElement monthElement = driver.findElement(By.xpath("//select[@id='month']"));
		Select monthSelect = new Select(monthElement);
		monthSelect.selectByVisibleText("Aug");
		
		System.out.println("STEP - Click on Custom");
		driver.findElement(By.xpath("//input[@value='-1']")).click();
		
		WebElement genderElement = driver.findElement(By.xpath("//select[@name='preferred_pronoun']"));
		Select genderSelect = new Select(genderElement);
		genderSelect.selectByValue("2");
		
		genderSelect.getAllSelectedOptions();
	}
	
	public static void main(String[] args) {
		new DropdownDemoTest().verifyDropdownSelect();
	}
}
