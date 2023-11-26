/* Verify how many columns and rows are present in Demo tables >> EMPLOYEE MANAGER table
Expected: 
Column count - 5
Row count - 9 */

package sayali;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment12 {
	WebDriver driver;

	void launchChrome(String url) {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("Launch Chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void verifyData() throws InterruptedException{
		launchChrome("http://automationbykrishna.com");
		System.out.println("Navigate to Demo Table");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		sleep(3000);

		System.out.println("Count Of Columns");
		List<WebElement> listOfColumns = driver.findElements(By.xpath("//table[@class = 'table table-striped']/thead/tr/th"));
		System.out.println("Column count: " + listOfColumns.size());

		System.out.println("Find Number Of Rows");
		List<WebElement> listOfRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
		System.out.println("Rows count: " + listOfRows.size());
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException{
		Assignment12 assignment12 = new Assignment12();
		assignment12.verifyData();
	}
}