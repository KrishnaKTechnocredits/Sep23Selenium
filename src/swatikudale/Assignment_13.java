/*Assignment13 Nov22 Print Last row data, 
Demo tables >> EMPLOYEE BASIC INFORMATION table 
Note: Get row size - 4*/
package swatikudale;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_13 {
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

	void printLastRowData() {
		setup("http://automationbykrishna.com");

		System.out.println("Navigate to Demo Table");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		sleep(3000);
		
		List<WebElement> column = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		int columnCount = column.size();
		
		//Dynamic Xpath
		System.out.print("Last row data : ");
		for(int index=1; index<=columnCount; index++) {
			System.out.print(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[5]/td["+index+"]")).getText());
			System.out.print(" ");
		}
		
		System.out.println("\nBrowser close");
		driver.close();
	}

	public static void main(String[] args) {
		new Assignment_13().printLastRowData();
	}

}
