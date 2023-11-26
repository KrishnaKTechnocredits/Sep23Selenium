package onkar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Installation {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
	}
}
