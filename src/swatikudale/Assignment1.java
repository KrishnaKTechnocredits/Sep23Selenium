/*Assignment - 1: 18th Nov'2023 [30 mins] 1. Launch Chrome Browser 2. Navigate to "http://automationbykrishna.com" 3. Verify title should be "Login Signup Demo" 4. Navigate to
 "https://www.technocredits.com/courses" 5. Verify title should be "Krishna’s Courses" 6. Navigate back 7. Verify title should be "Login Signup Demo" 8. Navigate forward 9.
 Verify title should be "Krishna’s Courses" 10. Refresh page 11. Verify title should be "Krishna’s Courses" 12. Verfiy current url should be "https://www.technocredits.com/courses"*/
package swatikudale;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment1 {

	WebDriver driver;

	@BeforeMethod
	void setup() {
		System.out.println("STEP 1/2: Launch Chrome Browser and  Navigate to http://automationbykrishna.com");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get("http://automationbykrishna.com");
	}

	@Test
	void signUp() {

		System.out.println("STEP 3:  Verify title should be Login Signup Demo");
		String pageTitle = driver.getTitle();
		if (pageTitle.equals("Login Signup Demo")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

		System.out.println("STEP 4:  4. Navigate to https://www.technocredits.com/courses ");
		driver.get("https://www.technocredits.com/courses");

		System.out.println("STEP 5: Verify title should be Krishna’s Courses");
		pageTitle = driver.getTitle();
		if (pageTitle.equals("Krishna’s Courses")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

		System.out.println("STEP 6:  Navigate back ");
		driver.navigate().back();

		System.out.println("STEP 7 : Verify title should be \"Login Signup Demo\"");
		pageTitle = driver.getTitle();
		if (pageTitle.equals("Login Signup Demo")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

		System.out.println("STEP 8. Navigate forward");
		driver.navigate().forward();

		System.out.println("STEP :9 Verify title should be \"Krishna’s Courses\"");
		pageTitle = driver.getTitle();
		if (pageTitle.equals("Krishna’s Courses")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

		System.out.println("STEP 10 : Refresh page ");
		driver.navigate().refresh();

		System.out.println("STEP 11: Verify title should be \"Krishna’s Courses\" ");
		pageTitle = driver.getTitle();
		if (pageTitle.equals("Krishna’s Courses")) {
			System.out.println("Test Pass");
		} else
			System.out.println("Test Fail");

		System.out.println("STEP 12: Verfiy current url should be https://www.technocredits.com/courses");
		String currentURL = driver.getCurrentUrl();
		if (currentURL.equals("https://www.technocredits.com/courses")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}
	}

	@AfterMethod
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}
}
