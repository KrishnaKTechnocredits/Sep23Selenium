package akshitak;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment21 {

	WebDriver driver;

	void luanchChrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Technocresdits\\Sep2023\\Chrome_Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	void navigatrURL() {
		luanchChrome();
		driver.get("https://datatables.net/");
	}

	void selectPageSize() {
		navigatrURL();
		Select se = new Select(driver.findElement(By.xpath("//select[@name='example_length']")));
		se.selectByValue("100");
	}

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

	public static void main(String[] args) {
		new Assignment21().employeeAgeAbove50();
	}
}
