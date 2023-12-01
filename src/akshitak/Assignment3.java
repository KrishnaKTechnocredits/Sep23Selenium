package akshitak;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment3 {

	WebDriver driver;

	@BeforeClass
	void luanchChrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Technocresdits\\Sep2023\\Chrome_Driver\\chromedriver.exe");
		System.out.println("Luanch Chrome");
		driver = new ChromeDriver();
		System.out.println("Maximize window");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Get URL");
		driver.get("http://automationbykrishna.com/");
	}
	
	@BeforeMethod
	void fillDetails() {
		System.out.println("Click Basic Element");
		driver.findElement(By.id("basicelements")).click();
		System.out.println("Enter UserFirstName");
		driver.findElement(By.id("UserFirstName")).sendKeys("Akshita");
		System.out.println("Enter UserLastName");
		driver.findElement(By.id("UserLastName")).sendKeys("Kadu");
		System.out.println("Enter Company Name");
		driver.findElement(By.id("UserCompanyName")).sendKeys("ABC.Ltd");
		System.out.println("Click Submit Button");
		driver.findElement(By.xpath("//div[@name='secondSegment'][1]//button[@type='submit']")).click();
	}
	
	@Test
	void clickAlert() {
		Alert alert = driver.switchTo().alert();
		if (alert.getText().equals("Akshita and Kadu and ABC.Ltd"))
			System.out.println("Alert Demo message match");
		else
			System.out.println("Alert Demo message not match");
		alert.accept();
		driver.close();
	}
}
