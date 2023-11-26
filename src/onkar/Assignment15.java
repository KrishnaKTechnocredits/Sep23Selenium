/*Print all the data for Demo tables >> EMPLOYEE BASIC INFORMATION table
Hint: 2 Loops, out loop - Row, inner loop - Column*/

package onkar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment15 {
	
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

	void printAllRows() {
		setup("http://automationbykrishna.com");

		System.out.println("Navigate to Demo Tables");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		sleep(3000);

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		int rowCount = rows.size();

		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")); 
		int columnCount = columns.size();

		System.out.println("Below are the rows of the table : ");
		for(int index=1; index<=rowCount; index++) {
			for (int i=1; i<=columnCount;i++) {
				System.out.print(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td["+i+"]")).getText());
				System.out.print(" ");
			}
			System.out.println("");
		}

		System.out.println("\n"+"Closed the browser");
		driver.close();
	}

	public static void main(String[] args) {
		new Assignment15().printAllRows();
	}	
}
