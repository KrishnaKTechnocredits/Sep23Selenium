//Assignment - 1: 18th Nov'2023 [30 mins]
//1. Launch Chrome Browser
//2. Navigate to "http://automationbykrishna.com"
//3. Verify title should be "Login Signup Demo"
//4. Navigate to "https://www.technocredits.com/courses"
//5. Verify title should be "Krishna’s Courses"
//6. Navigate back
//7. Verify title should be "Login Signup Demo"
//8. Navigate forward
//9. Verify title should be "Krishna’s Courses"
//10. Refresh page
//11. Verify title should be "Krishna’s Courses"
//12. Verfiy current url should be "https://www.technocredits.com/courses"

package pushpag;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");

		// 1. Launch Chrome Browser
		WebDriver driver = new ChromeDriver();

		// 2. Navigate to "http://automationbykrishna.com"
		driver.get("http://automationbykrishna.com");

		// 3. Verify title should be "Login Signup Demo"
		String pageTitle = driver.getTitle();
		if (pageTitle.equals("Login Signup Demo"))
			System.out.println("Title is " + pageTitle);

		// 4. Navigate to "https://www.technocredits.com/courses"
		driver.get("https://www.technocredits.com/courses");

		// 5. Verify title should be "Krishna’s Courses"
		String pageTitle1 = driver.getTitle();
		if (pageTitle1.equals("Krishna’s Courses"))
			System.out.println("Title is " + pageTitle1);

		// 6. Navigate back
		driver.navigate().back();

		// 7. Verify title should be "Login Signup Demo"
		String pageTitleAfterBack = driver.getTitle();
		if (pageTitleAfterBack.equals("Login Signup Demo"))
			System.out.println("Title is " + pageTitleAfterBack);

		// 8. Navigate forward
		driver.navigate().forward();

		// 9. Verify title should be "Krishna’s Courses"
		String pageTitleAfterForward = driver.getTitle();
		if (pageTitleAfterForward.equals("Krishna’s Courses"))
			System.out.println("Title is " + pageTitleAfterForward);

		// 10. Refresh page
		driver.navigate().refresh();

		// 11. Verify title should be "Krishna’s Courses"
		String pageTitleAfterRefresh = driver.getTitle();
		if (pageTitleAfterRefresh.equals("Krishna’s Courses"))
			System.out.println("Title is " + pageTitleAfterRefresh);

		// 12. Verfiy current url should be "https://www.technocredits.com/courses"
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.equals("https://www.technocredits.com/courses"))
			System.out.println("Current Url is " + currentUrl);
		
		driver.close();
	}

}
