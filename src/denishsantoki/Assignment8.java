/*Assignment8 Nov19 (Dropdown)
- Navigate to https://www.facebook.com/
- Click on 'Create new accout'
- Enter name, surname, mobile or email & password
- Select DOB
- Select Gender (Actual gender)*/
package denishsantoki;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment8 {
	WebDriver driver;
	
	@BeforeTest
	void launchChrome() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("Launch Chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}

	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void facebookDemo() {
		System.out.println("Click on Create new account");
		driver.findElement(By.xpath("//a [text() = 'Create new account']")).click();
		sleep(3000);

		System.out.println("Enter name, surname, mobile or email & password");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Denish");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Santoki");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("6355532715");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("13701370");

		System.out.println("Select DOB");
		WebElement selectDate = driver.findElement(By.xpath("//select[@id='day']"));
		Select dateSelect = new Select(selectDate);
		dateSelect.selectByValue("30");

		WebElement selectMonth = driver.findElement(By.xpath("//select[@id='month']"));
		Select monthSelect = new Select(selectMonth);
		monthSelect.selectByVisibleText("Oct");

		WebElement selectYear = driver.findElement(By.xpath("//select[@id='year']"));
		Select yearSelect = new Select(selectYear);
		yearSelect.selectByIndex(21);

		System.out.println("Select Gender (Actual gender)");
		WebElement genderRadio = driver.findElement(By.xpath("//input[@value='2']"));
		genderRadio.click();
		if (genderRadio.isSelected())
			System.out.println(
					"Gender is selected : " + driver.findElement(By.xpath("//label[text()='Male']")).getText());
		else
			System.out.println("Gender is not selected correctly");
	}

	@AfterClass
	void tearDown() {
		driver.close();
	}
}
