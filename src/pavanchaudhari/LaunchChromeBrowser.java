package pavanchaudhari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChromeBrowser {

	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();//this will launch chrome browser
		driver.get("https://www.amazon.in/");//this will navigate to url
	}
}
