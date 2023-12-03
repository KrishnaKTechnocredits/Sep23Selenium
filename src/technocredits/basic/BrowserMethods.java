package technocredits.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMethods {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();//Launch Chrome Browser
		
		System.out.println("STEP - Launch Automationbykrishna.com");
		driver.get("http://automationbykrishna.com/");
		driver.get("https://google.com");
		
		System.out.println("STEP - Maximize browser");
		driver.manage().window().maximize();
		
		System.out.println("STEP - Get Current URL");
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		System.out.println("STEP - Get title of current page");
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		

		String source = driver.getPageSource();
		System.out.println(source);
		
		System.out.println("STEP - Close browser");
		driver.close();
	}
}
