package shamligadekar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
	
	WebDriver driver;	
	void launchBrowser() {
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	void navigateToUrl(String url) {
		System.out.println("STEP-Navigate to "+url);
		driver.get(url);
	}
		
	void verifyTitle(String expectedTitle) {
		System.out.println("Verify Title :"+expectedTitle);
		String title=driver.getTitle();
		if(title.equals(expectedTitle)) {
			System.out.println("Verify Title Test Pass");
		}
		else {
			System.out.println("Verify Title Test Fail");
		}		
	}
		
	void verifyCurrentUrl(String url) {
		String currentUrl=driver.getCurrentUrl();
		System.out.println("Current url is :"+currentUrl);
		if(currentUrl.equals(url)) {
			System.out.println("Current Url Test Pass");
		}
		else {
			System.out.println("Current Url Test Fail");
		}
	}
	
	
	void testCases() {
		launchBrowser();
		navigateToUrl("http://automationbykrishna.com/");
		verifyTitle("Login Signup Demo");
		System.out.println("STEP - Navigate to technocredits.com/courses");
		driver.navigate().to("https://www.technocredits.com/courses");
		verifyTitle("Krishna’s Courses");

		System.out.println("STEP - Navigate back");
		driver.navigate().back();
		verifyTitle("Login Signup Demo");

		System.out.println("STEP - Navigate forward");
		driver.navigate().forward();
		verifyTitle("Krishna’s Courses");

		System.out.println("STEP - Refresh page");
		driver.navigate().refresh();
		verifyTitle("Krishna’s Courses");
		verifyCurrentUrl("https://www.technocredits.com/courses");
		closeBrowser();	
	}

	void closeBrowser() {
		driver.close();
	}
	
	public static void main(String[] args) {
		Assignment1 assignment1= new Assignment1();
		assignment1.testCases();
	}
}
