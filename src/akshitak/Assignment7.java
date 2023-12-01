package akshitak;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment7 {
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
	void basicElement() {
		System.out.println("Click Basic Element");
		driver.findElement(By.id("basicelements")).click();
	}

	@Test
	void scrollTillView() {
		basicElement();
		WebElement check1 = driver.findElement(
				By.xpath("//form[@class='form-horizontal adminex-form']//div[@class='checkbox'][1]//input"));
		WebElement check2 = driver
				.findElement(By.xpath("//form[@class='form-horizontal adminex-form']//div[@class='radio'][2]//input"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", check1);

		System.out.println("Click checkbox");
		check1.click();
		if (check1.isSelected())
			System.out.println("Checkbox selected sucessfully");
		else
			System.out.println("Failed to select checkbox");

		System.out.println("Click RadioButton");
		check2.click();
		if (check2.isSelected())
			System.out.println("Radio is selected sucessully");
		else
			System.out.println("Failed to select radiobutton");
	}
	
	@AfterClass
	void tearDown() {
		driver.close();
	}
}