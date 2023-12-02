package akshitak;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment21 {

	WebDriver driver;

	@BeforeClass
	void luanchChrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Technocresdits\\Sep2023\\Chrome_Driver\\chromedriver.exe");
		System.out.println("Luanch Chrome");
		driver = new ChromeDriver();
		System.out.println("Maximize window");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Get URL");
		driver.get("https://datatables.net/");
	}
	
	@BeforeMethod
	void selectPageSize() {
		Select se = new Select(driver.findElement(By.xpath("//select[@name='example_length']")));
		se.selectByValue("100");
	}

	@Test
	void employeeAgeAbove50() {
		selectPageSize();
		System.out.println("List of employee above 50 age");
		for (int index = 1; index < 57; index++) {
			int age = Integer.parseInt(driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[4]")).getText());
			if (age >= 50) {
				System.out.println(age + " => " + (driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[1]"))).getText());
			}
		}
	}
}
