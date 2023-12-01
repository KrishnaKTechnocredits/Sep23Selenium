package akshitak;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment9 {
	WebDriver driver;

	void luanchChrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Technocresdits\\Sep2023\\Chrome_Driver\\chromedriver.exe");
		System.out.println("Luanch Chrome");
		driver = new ChromeDriver();
		System.out.println("Maximize window");
		driver.manage().window().maximize();
	}

	void navigatrURL() {
		luanchChrome();
		System.out.println("Get URL");
		driver.get("https://www.facebook.com");
	}

	void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	void createNewAccButton() {
		navigatrURL();
		driver.findElement(By.xpath("//form[@data-testid='royal_login_form']//div[5]//a[@role='button']")).click();
	}

	void fillDetails() {
		createNewAccButton();
		System.out.println("Enter First Name");
		wait(2000);
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Techno");
		System.out.println("Enter Last Name");
		wait(2000);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Credit");
		System.out.println("Enter Email");
		wait(2000);
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("1234567890");
		System.out.println("Enter Password");
		wait(2000);
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Reset@1234");
		wait(2000);
		System.out.println("Select Day");
		WebElement day = driver.findElement(By.id("day"));
		day.click();
		Select se = new Select(day);
		se.selectByIndex(23);
		System.out.println("Select Month");
		wait(2000);
		WebElement month = driver.findElement(By.id("month"));
		day.click();
		Select se1 = new Select(month);
		se1.selectByValue("6");
		System.out.println("Select Year");
		wait(2000);
		WebElement year = driver.findElement(By.id("year"));
		day.click();
		Select se2 = new Select(year);
		se2.selectByVisibleText("1995");
		System.out.println("Select Custom");
		wait(2000);
		driver.findElement(By.xpath("//span[@data-type='radio']//input[@value='-1']")).click();
		wait(2000);
		driver.findElement(By.xpath("//select[@name=\"preferred_pronoun\"]")).click();
		WebElement custom = driver.findElement(By.xpath("//select[@name='preferred_pronoun']"));
		Select sec3 = new Select(custom);
		sec3.selectByValue("2");
		System.out.println("Enter pronoun");
		wait(2000);
		driver.findElement(By.xpath("//input[@name='custom_gender']")).sendKeys("Female");
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment9().fillDetails();
	}
}
