package gaurangvirani;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment8 {

	WebDriver driver;
	
	void chrome() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}
	
	void waitABit() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void account() {
		chrome();
		waitABit();
		
		System.out.println("Create new Acount");
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
	}
	
	void fillDetails() {
		account();
		waitABit();
		
		System.out.println("Name");
		driver.findElement(By.name("firstname")).sendKeys("Gaurang");
		
		System.out.println("Surname");
		driver.findElement(By.name("lastname")).sendKeys("Virani");
		
		System.out.println("Mobile");
		driver.findElement(By.name("reg_email__")).sendKeys("820078864");
		
		System.out.println("Password");
		driver.findElement(By.name("reg_passwd__")).sendKeys("123456789");
		
		System.out.println("Day");
		driver.findElement(By.name("birthday_day")).click();
		Select se1 = new Select(driver.findElement(By.name("birthday_day")));
		se1.selectByValue("22");
		
		System.out.println("Month");
		driver.findElement(By.name("birthday_month")).click();
		Select se2 = new Select(driver.findElement(By.name("birthday_month")));
		se2.selectByValue("3");;
		
		System.out.println("Year");
		driver.findElement(By.name("birthday_year")).click();
		Select se3 = new Select(driver.findElement(By.name("birthday_year")));
		se3.selectByValue("1993");
		
		System.out.println("Select gender");
		driver.findElement(By.xpath("//input[@value='2']")).click();
		
		driver.close();
	}
	
	public static void main(String[] args) {
		new Assignment8().fillDetails();
	}
}
