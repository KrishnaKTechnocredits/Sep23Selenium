package technocredits.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitFBDemoTest {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	void setUp() {
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();// Launch Chrome Browser
		wait = new WebDriverWait(driver, 30);
		
		System.out.println("STEP - Maximize browser");
		driver.manage().window().maximize();

		System.out.println("STEP - Navigate to URL");
		driver.get("https://www.facebook.com/");
	}

	
	@Test
	void verifyDropdownSelect1() {
		System.out.println("STEP - Click on Create new account");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		
		System.out.println("STEP - Select month");
		WebElement monthElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='month']")));
		
		Select monthSelect = new Select(monthElement);
		monthSelect.selectByVisibleText("Aug");
		
		System.out.println("STEP - Click on Custom");
		driver.findElement(By.xpath("//input[@value='-1']")).click();
		
		//WebElement genderElement = driver.findElement(By.xpath("//select[@name='preferred_pronoun']"));
		//wait.until(ExpectedConditions.visibilityOf(genderElement));
		
		WebElement genderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='preferred_pronoun']")));
		
		wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(""), 3));
		Select genderSelect = new Select(genderElement);
		genderSelect.selectByValue("2");
		
		genderSelect.getAllSelectedOptions();
	}
	
	
	@Test
	void verifyDropdownSelect() {
		System.out.println("STEP - Click on Create new account");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		
		System.out.println("STEP - Select month");
		//WebElement monthElement = driver.findElement(By.xpath("//select[@id='month']"));
		//wait.until(ExpectedConditions.visibilityOf(monthElement));
		
		WebElement monthElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='month']")));
		
		Select monthSelect = new Select(monthElement);
		monthSelect.selectByVisibleText("Aug");
		
		System.out.println("STEP - Click on Custom");
		driver.findElement(By.xpath("//input[@value='-1']")).click();
		
		WebElement genderElement = driver.findElement(By.xpath("//select[@name='preferred_pronoun']"));
		Select genderSelect = new Select(genderElement);
		genderSelect.selectByValue("2");
		
		genderSelect.getAllSelectedOptions();
	}
}
