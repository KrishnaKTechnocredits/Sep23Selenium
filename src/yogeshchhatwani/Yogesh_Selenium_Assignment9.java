//Assignment9 Nov19 (Dropdown)
//- Navigate to https://www.facebook.com/
//- Click on 'Create new accout'
//- Enter name, surname, mobile or email & password
//- Select DOB
//- Select Gender (Custom)
//- Select your pronoun
//- Enter Gender
//
//Hint: Use select class
//selectByText("");
//selectByValue("");
//selectByIndex();
package yogeshchhatwani;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Yogesh_Selenium_Assignment9 {
	WebDriver driver;

	@BeforeClass
	void launchChrome() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("Launch chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@BeforeMethod
	void navigateUrl() {
		String url = "https://www.facebook.com/";
		driver.navigate().to(url);
	}

	void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void createNewAcc() {
		System.out.println("click on Create new acc");
		wait(3000);
		WebElement acc = driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
		acc.click();

		wait(3000);
		System.out.println("Enter First Name ");
		WebElement name = driver.findElement(By.xpath("//input[@name='firstname']"));
		name.sendKeys("Yogesh");

		System.out.println("Enter last name");
		WebElement sur = driver.findElement(By.xpath("//input[@name='lastname']"));
		sur.sendKeys("Chhatwani");

		System.out.println("Enter mob number or email");
		WebElement numb = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		numb.sendKeys("8483930879");

		System.out.println("Enter Passsword");
		WebElement pass = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		pass.sendKeys("Yogeesh@123");

		System.out.println("Select date");
		WebElement date = driver.findElement(By.xpath("//select[@id='day']"));
		Select dateSelect = new Select(date);
		dateSelect.selectByValue("1");

		System.out.println("Select month");
		WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
		Select monthSelect = new Select(month);
		monthSelect.selectByVisibleText("Dec");

		System.out.println("Select year");
		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		Select yearSelect = new Select(year);
		yearSelect.selectByValue("1997");

		System.out.println("Select custom in gender");
		WebElement gender = driver.findElement(By.xpath("//input[@value='-1']"));
		gender.click();

		System.out.println("Select pronoun");
		WebElement pronoun = driver.findElement(By.xpath("//select[@name='preferred_pronoun']"));
		Select pronounSelect = new Select(pronoun);
		pronounSelect.selectByVisibleText("He: \"Wish him a happy birthday!\"");
		// pronoun.click();-------->>can be used only when i write xpath as
		// =//select[@name='preferred_pronoun']//option[@value='2']
	}

	@AfterMethod
	void close() {
		driver.close();
	}
}
