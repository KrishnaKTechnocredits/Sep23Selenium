/*- Navigate to https://www.facebook.com/
- >Click on 'Create new account'
- >Enter name, surname, mobile or email & password
- >Select DOB
- >Select Gender (Actual gender)
Hint: Use select class
selectByText("");
selectByValue("");
selectByIndex();*/
package swatikudale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment8 {
	WebDriver driver;

	@BeforeMethod
	void setup() {
		System.out.println("Launch Chrome Browser and  Navigate to facebook.com");
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver/chromedriver");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get("https://www.facebook.com");
	}

	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	void facebookAccountCreateValidation() {
		System.out.println("Click on 'Create new account'");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		sleep(3000);

		System.out.println("Enter name, surname, mobile or email & password");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Swati");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Kudale");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("sk@gmail.com");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("sk@7867361");

		System.out.println("Select DOB");
		WebElement date = driver.findElement(By.xpath("//select[@id='day']"));
		Select selectDate = new Select(date);
		selectDate.selectByValue("15");

		WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
		Select selectMonth = new Select(month);
		selectMonth.selectByVisibleText("Mar");

		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		Select selectYear = new Select(year);
		selectYear.selectByIndex(92);

		System.out.println("Select Gender (Actual gender)");
		WebElement genderSelectRadio = driver.findElement(By.xpath("//input[@value='1']"));
		genderSelectRadio.click();
		if (genderSelectRadio.isSelected())
			System.out.println(
					"Gender is selected : " + driver.findElement(By.xpath("//label[text()='Female']")).getText());
		else
			System.out.println("Gender is not selected properly");
	}

	@AfterMethod
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}
}