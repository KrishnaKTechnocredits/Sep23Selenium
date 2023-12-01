/*- Navigate to https://www.facebook.com/
- Click on 'Create new account'
- Enter name, surname, mobile or email & password
- Select DOB
- Select Gender (Actual gender)

Hint: Use select class
selectByText("");
selectByValue("");
selectByIndex();*/

package onkar;

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
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get("https://www.facebook.com/");
	}

	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}
	
	@Test
	void facebookDemo() {
		System.out.println("Click on 'Create new account'");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		sleep(3000);
		
		System.out.println("Enter name, surname, mobile or email & password");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Onkar");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Patil");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9172523900");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("123456789");
		System.out.println("Required fields are filled by details");
		
		System.out.println("Select DOB");
		WebElement selectDate = driver.findElement(By.xpath("//select[@id='day']"));
		Select dateSelect = new Select(selectDate);
		dateSelect.selectByValue("27");
				
		WebElement selectMonth = driver.findElement(By.xpath("//select[@id='month']"));
		Select monthSelect = new Select(selectMonth);
		monthSelect.selectByVisibleText("Aug");
				
		WebElement selectYear = driver.findElement(By.xpath("//select[@id='year']"));
		Select yearSelect = new Select(selectYear);
		yearSelect.selectByIndex(26);
		
		System.out.println("Select Gender (Actual gender)");
		WebElement genderRadio = driver.findElement(By.xpath("//input[@value='2']"));
		genderRadio.click();
		if(genderRadio.isSelected())
			System.out.println("Gender is selected : "+driver.findElement(By.xpath("//label[text()='Male']")).getText());
		else
			System.out.println("Gender is not selected correctly");
	}
}
