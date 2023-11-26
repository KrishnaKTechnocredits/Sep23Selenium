/*Verify how many columns and rows are present in Demo tables >> EMPLOYEE MANAGER table
Expected: 
Column count - 5
Row count - 9*/

package onkar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment12 {
	
	WebDriver driver;

	void setup(String url) {
		System.out.println("Launch chrome browser");
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

	void findNumberOfRowsAndColumns() {
		setup("http://automationbykrishna.com");

		System.out.println("Navigate to Demo Tables");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		sleep(3000);
		
		List<WebElement> columns = driver.findElements(By.xpath("//div[@id='empmanager']//thead/tr/th"));
		int columnCount = columns.size();
		System.out.println("Number of columns available in given table are : "+columnCount);
		
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr"));
		int rowCount = rows.size();
		System.out.println("Number of columns available in given table are : "+rowCount);
		
		System.out.println("Closed the browser");
		driver.close();
	}
	
	public static void main(String[] args) {
		new Assignment12().findNumberOfRowsAndColumns();
	}
}
