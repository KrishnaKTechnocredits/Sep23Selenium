/* - Navigate to https://www.facebook.com/
- Click on 'Create new account'
- Enter name, surname, mobile or email & password
- Select DOB
- Select Gender (Actual gender)
Hint: Use select class
selectByText("");
selectByValue("");
selectByIndex(); */

package sayali;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment8 {

	WebDriver driver;

	void setup(String url) {
		System.out.println("STEP: Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("STEP: Open given URL");
		driver.get(url);
	}

	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void facebookDemo() {
		setup("https://www.facebook.com/");

		System.out.println("STEP: Click on 'Create new account'");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		sleep(3000);

		System.out.println("STEP: Enter name, surname, mobile or email & password");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Sayali");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Honrao");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9172523900");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("123456789");
		System.out.println("Required fields are filled by adding details");

		System.out.println("Select DOB");
		WebElement selectDate = driver.findElement(By.xpath("//select[@id='day']"));
		Select dateSelect = new Select(selectDate);
		dateSelect.selectByValue("23");

		WebElement selectMonth = driver.findElement(By.xpath("//select[@id='month']"));
		Select monthSelect = new Select(selectMonth);
		monthSelect.selectByVisibleText("Nov");

		WebElement selectYear = driver.findElement(By.xpath("//select[@id='year']"));
		Select yearSelect = new Select(selectYear);
		yearSelect.selectByIndex(94);

		System.out.println("Select Gender (Actual gender)");
		WebElement genderRadio = driver.findElement(By.xpath("//input[@value='1']"));
		genderRadio.click();
		if (genderRadio.isSelected())
			System.out.println(
					"Gender is selected : " + driver.findElement(By.xpath("//label[text()='Female']")).getText());
		else
			System.out.println("Gender is not selected correctly");

		System.out.println("Closed the browser");
		driver.close();
	}

	public static void main(String[] args) {
		new Assignment8().facebookDemo();
	}
}