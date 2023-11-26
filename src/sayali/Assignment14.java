/* WAP, print all data for last row
Hint:
Get rows size = 5
Get column size = 4
Note: Assignment should have dynamic data. */

package sayali;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment14 {

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

	void printLastRow() {
		setup("http://automationbykrishna.com");

		System.out.println("Navigate to Demo Tables");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		sleep(3000);

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		int rowCount = rows.size();

		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")); 
		int columnCount = columns.size();

		System.out.print("Last row's data of the given table is: ");
		for(int index=1; index<=columnCount; index++) {
			System.out.print(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowCount+"]/td["+index+"]")).getText());
			System.out.print(" ");
		}

		System.out.println("\n"+"Closed the browser");
		driver.close();
	}

	public static void main(String[] args) {
		new Assignment14().printLastRow();
	}	
}