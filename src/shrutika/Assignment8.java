/*- Navigate to https://www.facebook.com/
- Click on 'Create new account'
- Enter name, surname, mobile or email & password
- Select DOB
- Select Gender (Actual gender)

Hint: Use select class
selectByText("");
selectByValue("");
selectByIndex();*/
package shrutika;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment8 {

	WebDriver driver;

	void setup(String url) {
		System.out.println("Step 1: Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("Open given URL");
		driver.get(url);
	}

	void facebookDemo() {
		setup("https://www.facebook.com/");

		System.out.println("Step 2 : Click on 'Create new account'");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();

		System.out.println("Step 3 :Enter name, surname, mobile or email & password");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Shrutika");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Benakatti");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9834147899");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("98765432");
		
		System.out.println("Step 4: Select DOB");
		WebElement selectDate = driver.findElement(By.xpath("//select[@id='day']"));
		Select dateSelect = new Select(selectDate);
		dateSelect.selectByValue("27");

		WebElement selectMonth = driver.findElement(By.xpath("//select[@id='month']"));
		Select monthSelect = new Select(selectMonth);
		monthSelect.selectByVisibleText("Aug");

		WebElement selectYear = driver.findElement(By.xpath("//select[@id='year']"));
		Select yearSelect = new Select(selectYear);
		yearSelect.selectByIndex(31);

		System.out.println("Step 5 : Select gender");
		WebElement genderElement = driver.findElement(By.xpath("//input[@value='1']"));
		genderElement.click();
		
		System.out.println("Step 6 : Verify gender selection");
		if(genderElement.isSelected()) {
			System.out.println("Gender selection test passed");
		}else {
			System.out.println("Gender selection test failed");
		}
		
		System.out.println("Step 7: Closed the browser");
		driver.close();
	}

	public static void main(String[] args) {
		new Assignment8().facebookDemo();
	}
}
