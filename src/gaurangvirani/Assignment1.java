package gaurangvirani;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException  {
		System.setProperty("webdriver.chrome.driver",".\\chromeDriver\\chromedriver.exe");
		System.out.println("Step 1");
		WebDriver driver = new ChromeDriver();
		System.out.println("Step 2");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Step 3");
		String a = driver.getTitle();
		System.out.println(a);
		System.out.println("Step 4");
		driver.get("https://technocredits.graphy.com/courses");
		System.out.println("Step 5");
		String b = driver.getTitle();
		System.out.println(b);
		System.out.println("Step 6");
		driver.navigate().back();
		System.out.println("Step 7");
		String c = driver.getTitle();
		System.out.println(c);
		System.out.println("Step 8");
		driver.navigate().forward();
		System.out.println("Step 9");
		String d = driver.getTitle();
		System.out.println(d);
		System.out.println("Step 10");
		driver.navigate().refresh();
		System.out.println("Step 11");
		String e = driver.getTitle();
		System.out.println(e);
		System.out.println("Step 12");
		Thread.sleep(2000);
		String f = driver.getCurrentUrl();
		System.out.println(f);
		driver.close();
	}
}
