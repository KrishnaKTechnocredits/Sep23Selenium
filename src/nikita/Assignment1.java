package nikita;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Assignment1 {
	RemoteWebDriver driver;

	void launchUrl() {
		System.setProperty("webdriver.chrome.driver",".\\chromeDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://automationbykrishna.com");

	}

	void checkPageTitle() {
		String pageTitle= driver.getTitle();
		System.out.println(pageTitle);
		String expectedTitle= "Login Signup Demo";
		if(pageTitle.equals(expectedTitle)) {
			System.out.println("Title matched");
		}else {
			System.out.println("title didn't match");
		}
	}

	public static void main(String[] args) {
		Assignment1 assignment1= new Assignment1();
		assignment1.launchUrl();
		assignment1.checkPageTitle();
		assignment1.launchSecondUrl();
		assignment1.TestCases();
	}

	void launchSecondUrl() {
		driver.get("https://www.technocredits.com/courses");
	}
		void verifySecondUrlTitle() {
			String pageTitle=driver.getTitle();
			String expectedTitle="Krishna’s Courses";
			if(pageTitle.equals(expectedTitle)) {
				System.out.println("Title matched for 2nd url");
			}else {
				System.out.println("Title didn't match for 2nd url");
			}
		}

		void TestCases() {
			driver.navigate().back();
			checkPageTitle();
			driver.navigate().forward();
			String expectedTitle2="Krishna’s Courses";
			verifySecondUrlTitle();
			driver.navigate().refresh();
			driver.getTitle();
			verifySecondUrlTitle();
			String currenturl=driver.getCurrentUrl();
			System.out.println(currenturl);
		}
}
