package hetalvirani;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
	public static void main(String[] args) {
		System.out.println("Step - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shree\\eclipse-workspace\\SEP23Selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Step - Maximize browser");
		driver.manage().window().maximize();
		
		System.out.println("step-Launch automationbykrishna.com");
		driver.navigate().to("http://automationbykrishna.com/");
		
		System.out.println("step-Print title");
		System.out.println(driver.getTitle());
		
		System.out.println("step-Launch technocredits course");
		driver.navigate().to("https://www.technocredits.com/courses");
		
		System.out.println("step-Print title");
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		
		driver.navigate().refresh();
		System.out.println(driver.getTitle());
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		System.out.println("step-close browser");
		driver.close();
	}
}

