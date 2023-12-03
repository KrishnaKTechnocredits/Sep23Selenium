package technocredits.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();//Launch Chrome Browser
		
		System.out.println("STEP - Maximize browser");
		driver.manage().window().maximize();
		
		System.out.println("STEP - Launch Automationbykrishna.com");
		driver.get("http://automationbykrishna.com/");
		System.out.println(driver.getTitle());
		
		System.out.println("STEP - Navigate to Google");
		driver.navigate().to("https://google.com");
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		String title = driver.getTitle();
		System.out.println("##########Title is ########" + title);
		if(title.equals("Login Signup Demo")) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		
		driver.navigate().forward();
		title = driver.getTitle();
		
		if(title.equals("Google")) {
			System.out.println("Test Pass for forward action");
		}else {
			System.out.println("Test Fail for forward action");
		}
		
		Thread.sleep(3000);
		driver.navigate().refresh();
		/*
		 * System.out.println("STEP - Close browser"); driver.close();
		 */
	}
}
