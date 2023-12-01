package akshitak;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment9 {
	
	WebDriver driver;

	@BeforeClass
	void luanchChrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Technocresdits\\Sep2023\\Chrome_Driver\\chromedriver.exe");
		System.out.println("Luanch Chrome");
		driver = new ChromeDriver();
		System.out.println("Maximize window");
		driver.manage().window().maximize();
		System.out.println("Get URL");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
	}

	@BeforeMethod
	void createNewAccButton() {
		driver.findElement(By.xpath("//form[@data-testid='royal_login_form']//div[5]//a[@role='button']")).click();
	}

	@Test
	void fillDetails() {
		createNewAccButton();
		System.out.println("Enter First Name");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Techno");
		System.out.println("Enter Last Name");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Credit");
		System.out.println("Enter Email");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("1234567890");
		System.out.println("Enter Password");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Reset@1234");
		System.out.println("Select Day");
		WebElement day = driver.findElement(By.id("day"));
		day.click();
		Select se = new Select(day);
		se.selectByIndex(23);
		System.out.println("Select Month");
		WebElement month = driver.findElement(By.id("month"));
		day.click();
		Select se1 = new Select(month);
		se1.selectByValue("6");
		System.out.println("Select Year");
		WebElement year = driver.findElement(By.id("year"));
		day.click();
		Select se2 = new Select(year);
		se2.selectByVisibleText("1995");
		System.out.println("Select Custom");
		driver.findElement(By.xpath("//span[@data-type='radio']//input[@value='-1']")).click();
		driver.findElement(By.xpath("//select[@name=\"preferred_pronoun\"]")).click();
		WebElement custom = driver.findElement(By.xpath("//select[@name='preferred_pronoun']"));
		Select sec3 = new Select(custom);
		sec3.selectByValue("2");
		System.out.println("Enter pronoun");
		driver.findElement(By.xpath("//input[@name='custom_gender']")).sendKeys("Female");
	}

	@AfterClass
	void tearDown() {
		driver.close();
	}
}
