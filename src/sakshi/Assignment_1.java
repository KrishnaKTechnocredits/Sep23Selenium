package sakshi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_1 {
	
	private WebDriver driver;
	
	void loadBrowser() {
		System.out.println("Step 1 -> Load the browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println("Step 2 -> Maximize the browser");
		driver.manage().window().maximize();
		
		System.out.println("Step 3 -> load the mentioned url on the browser");
		driver.get("http://automationbykrishna.com/");
	}
	
	void validateTitle() {
		System.out.println("Step 4 - get the title of url");
		String title = driver.getTitle();
		
		if(title.equals("Login Signup Demo")) {
			System.out.println("test pass " + title);
		}else {
			System.out.println("test fail " + title);
		}
		
		//Navigates to a particular mentioned url
		driver.navigate().to("https://www.technocredits.com/courses");
		title = driver.getTitle();
		if(title.equals("Krishna’s Courses")) {
			System.out.println("test pass " + title);
		}else {
			System.out.println("test fail " + title);
		}
		
		//Navigates to the immediate back url
		driver.navigate().back();
		title = driver.getTitle();
		if(title.equals("Login Signup Demo")) {
			System.out.println("test pass " + title);
		}else {
			System.out.println("test fail " + title);
		}
		
		driver.navigate().forward();
		title = driver.getTitle();
		if(title.equals("Krishna’s Courses")) {
			System.out.println("test pass " + title);
		}else {
			System.out.println("test fail " + title);
		}
		
		driver.navigate().refresh();
		title = driver.getTitle();
		if(title.equals("Krishna’s Courses")) {
			System.out.println("test pass " + title);
		}else {
			System.out.println("test fail " + title);
		}
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
	}
	
	public static void main(String[] args) {
		
		Assignment_1 assignment1 = new Assignment_1();
		assignment1.loadBrowser();
		assignment1.validateTitle();
		
		
	}

}
