package technocredits.actionsDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChromeBrowser {

	
	public static WebDriver launchBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();//this will launch chrome browser
		driver.manage().window().maximize();
		driver.get(url);//this will navigate to url
		return driver;
	}
}
