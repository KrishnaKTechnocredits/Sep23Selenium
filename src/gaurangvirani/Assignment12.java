/*Verify how many columns and rows are present in Demo tables >> EMPLOYEE MANAGER table
Expected: 
Column count - 5
Row count - 9*/

package gaurangvirani;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment12 {

WebDriver driver;
	
	void chrome() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/index.html");
	}
	
	void waitABit() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void rowColumnCount() {
		chrome();
		waitABit();
		driver.findElement(By.id("demotable")).click();
		waitABit();
		
		List<WebElement> rowCount = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr"));
		
		System.out.println("Row count is "+rowCount.size());
		
		List<WebElement> columnCount = driver.findElements(By.xpath("//div[@id='empmanager']//thead//th"));
		
		System.out.println("Column count is "+columnCount.size());
		
		driver.close();
	}
	
	public static void main(String[] args) {
		new Assignment12().rowColumnCount();
	}
}

















