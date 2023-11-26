/*Assignment12 Nov22 Verify how many columns and rows are present in 
Demo tables >> EMPLOYEE MANAGER table Expected: Column count - 5 Row count - 9*/
package swatikudale;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment12 {
	WebDriver driver;

	void setup(String url) {
		System.out.println("Launch Chrome Browser and  Navigate to http://automationbykrishna.com");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get(url);
	}

	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void verifyDemoTableRownNColumns() {
		setup("http://automationbykrishna.com");

		System.out.println("Navigate to Demo Tables");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		sleep(3000);

		// Column count
		List<WebElement> columns = driver.findElements(By.xpath("//div[@id='empmanager']//thead/tr/th"));
		int columnCount = columns.size();
		System.out.println(columnCount + " columns present in demo table");

		// Row Count
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr"));
		int rowCount = rows.size();
		System.out.println(rowCount + " rows present in demo table");

		System.out.println("Browser close");
		driver.close();
	}

	public static void main(String[] args) {
		new Assignment12().verifyDemoTableRownNColumns();
	}
}
