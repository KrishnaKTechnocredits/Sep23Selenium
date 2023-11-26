/*
 Assignment - 1: 18th Nov'2023 [30 mins]
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
12. Verify current url should be "https://www.technocredits.com/courses"
 */
package jyotisaxena;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	void launchBrowser() {
		System.out.println("Step - Launch Browser");
		System.setProperty("webdriver.chrome.driver", ".//chromeDriver/chromeDriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("Step - Maximise Browser");
		driver.manage().window().maximize();

		System.out.println("Step - Launch Browser");
		driver.get("http://automationbykrishna.com");

		System.out.println("Step -Verify Title-->" + driver.getTitle());

		System.out.println("Step - Navigate to courses");
		driver.navigate().to("https://www.technocredits.com/courses");

		System.out.println("Step - Verify Title -->" + driver.getTitle());
		driver.navigate().back();

		System.out.println("Step -verify Title--->" + driver.getTitle());

		driver.navigate().forward();
		System.out.println("Step -verify Title--->" + driver.getTitle());

		driver.navigate().refresh();
		System.out.println("Step - Verify Title -->" + driver.getTitle());

		System.out.println("Step- Current Url-->" + driver.getCurrentUrl());

	}

	public static void main(String[] args) {
		Assignment1 ass = new Assignment1();
		ass.launchBrowser();

	}
}
