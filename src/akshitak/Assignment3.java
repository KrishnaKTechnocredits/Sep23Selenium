package akshitak;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {

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
		driver.get("http://automationbykrishna.com/");
	}

	void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	void fillDetails() {
		navigatrURL();
		wait(2000);
		System.out.println("Click Basic Element");
		driver.findElement(By.id("basicelements")).click();
		wait(2000);
		System.out.println("Enter UserFirstName");
		driver.findElement(By.id("UserFirstName")).sendKeys("Akshita");
		wait(2000);
		System.out.println("Enter UserLastName");
		driver.findElement(By.id("UserLastName")).sendKeys("Kadu");
		wait(2000);
		System.out.println("Enter Company Name");
		driver.findElement(By.id("UserCompanyName")).sendKeys("ABC.Ltd");
		wait(2000);
		System.out.println("Click Submit Button");
		driver.findElement(By.xpath("//div[@name='secondSegment'][1]//button[@type='submit']")).click();
	}
	
	void clickAlert() {
		fillDetails();
		Alert alert = driver.switchTo().alert();
		if (alert.getText().equals("Akshita and Kadu and ABC.Ltd"))
			System.out.println("Alert Demo message match");
		else
			System.out.println("Alert Demo message not match");
		alert.accept();
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment3().clickAlert();
	}
}
