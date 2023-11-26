/*Assignment - 1: 18th Nov'2023 [30 mins]
1. Launch Chrome Browser
2. Navigate to "http://automationbykrishna.com"
3. Verify title should be "Login Signup Demo"
4. Navigate to "https://www.technocredits.com/courses"
5. Verify title should be "Krishna’s Courses"
6. Navigate back
7. Verify title should be "Login Signup Demo"
8. Navigate forward
9. Verify title should be "Krishna’s Courses"
10. Refresh page
11. Verify title should be "Krishna’s Courses"
12. Verfiy current url should be "https://www.technocredits.com/courses"*/

package jaykumar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
	WebDriver driver;
	
	void setUp() {
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	void getUrl(String url) {
		System.out.println("STEP - Navigate to "+url);
		driver.get(url);
	}
	
	void verifyTitle(String expectedTitle) {
		System.out.println("STEP - Verify Title: "+expectedTitle);
		String titleText = driver.getTitle();
		System.out.println("Page title is: "+titleText);
		
		if(titleText.equals(expectedTitle)) {
			System.out.println("Verify Title Test Pass");
		}else {
			System.out.println("Verify Title Test Fail");
		}
		
	}
	
	void verifyUrl(String url) {
		System.out.println("STEP - Verify url: "+url);
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current url is: "+currentUrl);
		
		if(currentUrl.equals(url)) {
			System.out.println("Verify url Test Pass");
		}else {
			System.out.println("Verify url Test Fail");
		}
	}
	
	void testCases() {
		setUp();
		getUrl("http://automationbykrishna.com");
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
		verifyUrl("https://www.technocredits.com/courses");
	}
	
	public static void main(String[] args) {
		new Assignment1().testCases();
	}
}
