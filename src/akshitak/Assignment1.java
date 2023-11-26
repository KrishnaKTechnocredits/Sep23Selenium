package akshitak;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
	WebDriver driver;
	
	 Assignment1() {
		System.setProperty("webdriver.chrome.driver", "D:\\Technocresdits\\Sep2023\\Chrome_Driver\\chromedriver.exe");
		System.out.println("Launch Chrome");
		driver = new ChromeDriver();
		System.out.println("Maximize Window");
		driver.manage().window().maximize();
	}
	
	 void getTitle() {
		 System.out.println("Navigate to");
			driver.get("http://automationbykrishna.com/");
			System.out.println("Get title");
			String title = driver.getTitle();
			if (title.equals("LoginSignup Demo"))
				System.out.println("Title match");
			else
				System.out.println("Title not match");
	 }
	 
	 void getUrl() {
		 System.out.println("Navigate to Google");
			driver.get("https://www.google.com");
			String title1 = driver.getTitle();
			if (title1.equals("Google"))
				System.out.println("Title match");
			else
				System.out.println("Title not match");

			System.out.println("Backword");
			driver.navigate().back();
			System.out.println(driver.getTitle());

			System.out.println("forward");
			driver.navigate().forward();
			System.out.println(driver.getTitle());

			System.out.println("Backword");
			driver.navigate().back();
			System.out.println(driver.getTitle());

			System.out.println("verify curret URL");
			if (driver.getCurrentUrl().equals("http://automationbykrishna.com/")) {
				System.out.println("Test Pass");
			} else {
				System.out.println("URL incorrect");
			}
			driver.close();
	 }
	
	public static void main(String[] args) {
		Assignment1 ass1 = new Assignment1();		
		ass1.getTitle();
		ass1.getUrl();
	}
}
