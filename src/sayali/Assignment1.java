/* 1. Launch Chrome Browser
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
12. Verfiy current url should be "https://www.technocredits.com/courses" */

package sayali;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	WebDriver driver;

	void setup(String url) {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get(url);
	}

	void signUpTest() {
		setup("http://automationbykrishna.com");

		System.out.println("Verify the browser title");
		String browserTitle = driver.getTitle();
		if(browserTitle.equals("Login Signup Demo"))
			System.out.println("Browser title is correct : "+browserTitle);
		else
			System.out.println("Test failed");

		System.out.println("Launch Technocredits and verify browser title");
		driver.get("https://www.technocredits.com/courses");
		browserTitle = driver.getTitle();
		if(browserTitle.equals("Krishna’s Courses"))
			System.out.println("Browser title is correct : "+browserTitle);
		else
			System.out.println("Test failed");

		System.out.println("Navigate back and check if title is correct");
		driver.navigate().back();
		browserTitle = driver.getTitle();
		if(browserTitle.equals("Login Signup Demo"))
			System.out.println("Browser title is correct : "+browserTitle);
		else
			System.out.println("Test failed");

		System.out.println("Navigate forward and check if title is correct");
		driver.navigate().forward();
		browserTitle = driver.getTitle();
		if(browserTitle.equals("Krishna’s Courses"))
			System.out.println("Browser title is correct : "+browserTitle);
		else
			System.out.println("Test failed");

		System.out.println("Refresh the page and check if title is correct");
		driver.navigate().refresh();
		browserTitle = driver.getTitle();
		if(browserTitle.equals("Krishna’s Courses"))
			System.out.println("Browser title is correct : "+browserTitle);
		else
			System.out.println("Test failed");

		System.out.println("Verify the current url");
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.equals("https://www.technocredits.com/courses"))
			System.out.println("Test is passed");

		System.out.println("Close browser window");
		driver.close();
	}

	public static void main(String[] args) {
		Assignment1 assignment1 = new Assignment1();
		assignment1.signUpTest();
	}
}