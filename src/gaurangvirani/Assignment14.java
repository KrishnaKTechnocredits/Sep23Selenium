/*WAP, print all data for last row
Hint:
Get rows size = 5
Get column size = 4
Note: Assignment should have dynamic data.*/

package gaurangvirani;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment14 {

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
	
	void printAllData() {
		chrome();
		waitABit();
		driver.findElement(By.id("demotable")).click();

		waitABit();

		System.out.println("Print last row :");
		List<WebElement> lastRowElement = driver.findElements(By.xpath("//div[@id='empbasic']//tbody/tr"));
		List<WebElement> totalColumnCount = driver.findElements(By.xpath("//div[@id='empbasic']//thead//th"));
		int rowCount = lastRowElement.size();
		int columnCount = totalColumnCount.size();
		
		for(int index = 1 ; index <= columnCount ; index++) {
			System.out.println(driver.findElement(By.xpath("//div[@id='empbasic']//tbody/tr["+rowCount+"]/td["+index+"]")).getText());
		}
		
		driver.close();
	}
	
	public static void main(String[] args) {
		new Assignment14().printAllData();
	}
}
