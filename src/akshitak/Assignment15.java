package akshitak;

import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assignment15 {
	WebDriver driver;

	void luanchChrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Technocresdits\\Sep2023\\Chrome_Driver\\chromedriver.exe");
		System.out.println("Luanch Chrome");
		driver = new ChromeDriver();
		System.out.println("Maximize window");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	void navigatrURL() {
		luanchChrome();
		System.out.println("Get URL");
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("demotable")).click();
	}

	void printAllData() {
		navigatrURL();
		List<WebElement> header = driver.findElements(By.xpath("//table[@class='table']/thead/tr"));
		for (WebElement hName : header) {
			System.out.println(hName.getText());

			int rowSize = driver.findElements(By.xpath("//table[@class='table']/tbody/tr")).size();
			for (int index = 0; index <= rowSize; index++) {
				List<WebElement> row = driver.findElements(By.xpath("//table[@class='table']/tbody/tr[" + index + "]"));
				for (WebElement data : row) {
					System.out.println(data.getText());
				}
			}
		}
	}

	public static void main(String[] args) {
		new Assignment15().printAllData();
	}
}
