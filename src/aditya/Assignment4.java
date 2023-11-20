package aditya;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("STEP - Launch chrome browser");
		// System.setProperty("webdriver.chrome.driver",
		// ".\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// Launch Chrome Browser

		System.out.println("STEP - Maximize browser");
		driver.manage().window().maximize();

		System.out.println("STEP - Launch Automationbykrishna.com");
		driver.get("http://automationbykrishna.com/");

		System.out.println("Step: print the Title of Automationbykrishna.com");
		String pagetitle = driver.getTitle();
		if (pagetitle.contains("Login Signup Demo"))
			;
		{
			System.out.println("Test Passed" + pagetitle);
		}

		driver.navigate().to("https://www.technocredits.com/courses");
		String pagetitle1 = driver.getTitle();
		if (pagetitle.contains("Krishna’s Courses"));
		{
			System.out.println("Test Passed" + pagetitle1);
		}

		driver.navigate().back();
		if (pagetitle.contains("Login Signup Demo"));
		{
			System.out.println("Test Passed" + pagetitle);
		}

		driver.navigate().forward();
		if (pagetitle.contains("Krishna’s Courses"));
		{
			System.out.println("Test Passed" + pagetitle1);
		}

		driver.navigate().refresh();
		if (pagetitle.contains("Krishna’s Courses"));
		{
			System.out.println("Test Passed" + pagetitle1);
		}

		String CurrentUrl = driver.getCurrentUrl();
		System.out.println("Test Passed CurrentUrl is " + CurrentUrl);
		driver.close();
	}

}
