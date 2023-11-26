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

package denishsantoki;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch chrome browser
		driver.manage().window().maximize();
		String url = "http://automationbykrishna.com";
		driver.navigate().to(url);// this will navigate to url
		System.out.println(driver.getTitle());
		String url1 = "https://www.technocredits.com/courses";
		driver.navigate().to(url1);
		driver.navigate().back();
		System.out.println(driver.getTitle());
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		driver.navigate().refresh();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}
}
