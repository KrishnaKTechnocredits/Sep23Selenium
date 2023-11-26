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
12. Verfiy current url should be "https://www.technocredits.com/courses"
*/

package roshnikolhe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Assignment1 {
	
	public static void main(String[] args) {
		System.out.println("Step1. Launch Chrome Browser");
		//String setProperty = System.setProperty("webdriver.chrome.driver","D:\\Technocredits\\Projects\\IDE\\Sep23Selenium\\ChromeDriver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",".\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();//Launch Chrome Browser
		
		System.out.println("Step2. Maximize Browser");
		driver.manage().window().maximize();
		
		System.out.println("Step3. Navigate to \"http://automationbykrishna.com\"");
		driver.get("http://automationbykrishna.com/");
		
		System.out.println("Step4. Title will be \"Login Signup Demo\"");
		String getSignUpTitle = driver.getTitle();
		System.out.println(getSignUpTitle);
		
		System.out.println("Step5. Navigate to \"https://www.technocredits.com/courses\"");
		driver.get("https://www.technocredits.com/courses");
		
		System.out.println("Step6. Title will be \"Krishna's Courses\"");
		String getCourseTitle = driver.getTitle();
		System.out.println(getCourseTitle);
		
		System.out.println("Step7. Navigate Back");
		driver.navigate().back();
		
		System.out.println("Step8. Title will be \"Login Signup Demo\"");
		String getSignUpTitleBack = driver.getTitle();
		System.out.println(getSignUpTitleBack);
		
		System.out.println("Step9. Navigate Forward");
		driver.navigate().forward();
		
		System.out.println("Step10. Title will be \"Krishna's Courses");
		String getCourseTitleForward = driver.getTitle();
		System.out.println(getCourseTitleForward);
		
		System.out.println("Step11. Refresh Page");
		driver.navigate().refresh();
		
		System.out.println("Step12. Title will be \"Krishna's Courses\"");
		String getPageTitle = driver.getTitle();
		System.out.println(getPageTitle);
		
		System.out.println("Step13. Current URL will be \"https://www.technocredits.com/courses\"");
		String getCurrentURL = driver.getCurrentUrl();
		System.out.println(getCurrentURL);
		
		System.out.println("Step14. Browser Closed");
		driver.close();
		
		
	}
}
