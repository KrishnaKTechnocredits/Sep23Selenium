package yogeshchhatwani;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Yogesh_Selenium_Assignment16 {
	WebDriver driver;

	@BeforeClass
	void setup() {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get("https://www.flipkart.com/");
	}

	void sleep(int ms) {

	}

	@AfterClass
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}

	void hoverOn(WebElement e) {
		Actions action = new Actions(driver);

		sleep(1000);
	}

	void printValues(List<WebElement> list) {
		System.out.println("---No options in this menu item---");
	}

	void findDropdownMenuItems() {
		System.out.println("Close the Flipkart Login Popup");
		sleep(3000);
		driver.findElement(By.xpath("//span[@role='button']")).click();
		System.out.println("\n" + "--> Two Wheelers");
		hoverOn(driver.findElement(By.xpath(" //span[text()='Two Wheelers']")));
	}
}
