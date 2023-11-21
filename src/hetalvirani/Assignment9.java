package hetalvirani;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment9 {

	WebDriver driver;

	void setUp(String url) {
		System.out.println("Step - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shree\\eclipse-workspace\\SEP23Selenium\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Step - Maximize browser");
		driver.manage().window().maximize();

		System.out.println("step - Launch url");
		driver.get(url);
	}

	void wait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void verify() {
		setUp("https://www.facebook.com/");
		System.out.println("step - click on create new account");
		WebElement basicElement = driver.findElement(By.xpath("//a[text()='Create new account']"));
		basicElement.click();

		wait(3000);
		System.out.println("step - Enter username");
		WebElement firstnameElement = driver.findElement(By.xpath("//div/input[@name='firstname']"));
		firstnameElement.sendKeys("Hetal");

		System.out.println("step - Enter lastname");
		WebElement lastnameElement = driver.findElement(By.xpath("//div/input[@name='lastname']"));
		lastnameElement.sendKeys("Virani");

		System.out.println("step - Enter mobnum");
		WebElement mobnumElement = driver.findElement(By.xpath("//div/input[@name='reg_email__']"));
		mobnumElement.sendKeys("9974904906");

		System.out.println("step - Enter newpassword");
		WebElement newpasswordElement = driver.findElement(By.xpath("//div/input[@id='password_step_input']"));
		newpasswordElement.sendKeys("1234567");

		System.out.println("step - select date");
		WebElement dateElement = driver.findElement(By.xpath("//select[@id='day']"));
		Select dateSelect = new Select(dateElement);
		dateSelect.selectByVisibleText("6");

		System.out.println("step - select month");
		WebElement monthElement = driver.findElement(By.xpath("//select[@id='month']"));
		Select monthSelect = new Select(monthElement);
		monthSelect.selectByVisibleText("Mar");

		System.out.println("step - select year");
		WebElement yearElement = driver.findElement(By.xpath("//select[@id='year']"));
		Select yearSelect = new Select(yearElement);
		yearSelect.selectByVisibleText("1993");
		
		System.out.println("step - select Custom");
		WebElement radioBtn = driver.findElement(By.xpath("//input[@value='-1']"));
		radioBtn.click();

		System.out.println("step - select pronoun");
		WebElement genderElement = driver.findElement(By.xpath("//select[@name='preferred_pronoun']"));
		Select genderSelect = new Select(genderElement);
		genderSelect.selectByValue("2");
		
		System.out.println("step - Enter Gender");
		WebElement genElement = driver.findElement(By.xpath("//input[@name='custom_gender']"));
		genElement.sendKeys("Male");

		//driver.close();
	}

	public static void main(String[] args) {
		new Assignment9().verify();
	}
}
