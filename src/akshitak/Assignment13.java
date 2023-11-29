package akshitak;

import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assignment13 {
	WebDriver driver;

	void luanchChrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Technocresdits\\Sep2023\\Chrome_Driver\\chromedriver.exe");
		System.out.println("Luanch Chrome");
		driver = new ChromeDriver();
		System.out.println("Maximize window");
		driver.manage().window().maximize();
	}

	void navigatrURL() {
		luanchChrome();
		System.out.println("Get URL");
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("demotable")).click();
	}

	void printLastRow() {
		navigatrURL();
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table']/tbody/tr[5]"));
		System.out.println("Print Last Row of Table");
		for (WebElement name : list) {
			System.out.println(name.getText() + " ");
			driver.close();
		}
	}

	public static void main(String[] args) {
		new Assignment13().printLastRow();
	}
}
