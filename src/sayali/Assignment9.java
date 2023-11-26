/* - Navigate to https://www.facebook.com/
- Click on 'Create new accout'
- Enter name, surname, mobile or email & password
- Select DOB
- Select Gender (Custom)
- Select your pronoun
- Enter Gender
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

public class Assignment9 {

	WebDriver driver;

	void setup(String url) {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get(url);
	}

	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void facebookDemoCustom() {
		setup("https://www.facebook.com/");

		System.out.println("Click on 'Create new account'");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		sleep(2000);

		System.out.println("Enter name, surname, mobile or email & password");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Sayali");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Honrao");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("75675675677");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("5757575757");
		System.out.println("Required fields are filled by details");

		System.out.println("Select DOB");
		WebElement selectDate = driver.findElement(By.xpath("//select[@id='day']"));
		Select dateSelect = new Select(selectDate);
		dateSelect.selectByValue("6");

		WebElement selectMonth = driver.findElement(By.xpath("//select[@id='month']"));
		Select monthSelect = new Select(selectMonth);
		monthSelect.selectByVisibleText("Oct");

		WebElement selectYear = driver.findElement(By.xpath("//select[@id='year']"));
		Select yearSelect = new Select(selectYear);
		yearSelect.selectByIndex(29);

		System.out.println("Select Gender (Custom)");
		WebElement genderRadio = driver.findElement(By.xpath("//input[@value='-1']"));
		genderRadio.click();
		if (genderRadio.isSelected())
			System.out.println(
					"Gender is selected : " + driver.findElement(By.xpath("//label[text()='Custom']")).getText());
		else
			System.out.println("Gender is not selected correctly");

		System.out.println("Select your pronoun");
		WebElement selectPronoun = driver.findElement(By.xpath("//select[@name='preferred_pronoun']"));
		Select pronounSelect = new Select(selectPronoun);
		pronounSelect.selectByValue("2");

		System.out.println("Closed the browser");
		//driver.close();
	}

	public static void main(String[] args) {
		new Assignment9().facebookDemoCustom();
	}
}