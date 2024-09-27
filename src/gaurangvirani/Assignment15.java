/*Print all the data for Demo tables >> EMPLOYEE BASIC INFORMATION table
Hint: 2 Loops, out loop - Row, inner loop - Column*/

package gaurangvirani;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment15 {

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
	
	void allData() {
		chrome();
		waitABit();
		driver.findElement(By.id("demotable")).click();
		waitABit();
		
		System.out.println("Print whole table data");
		List<WebElement> lastRowElement = driver.findElements(By.xpath("//div[@id='empbasic']//tbody/tr"));
		List<WebElement> totalColumnCount = driver.findElements(By.xpath("//div[@id='empbasic']//thead//th"));
		int rowCount = lastRowElement.size();
		int columnCount = totalColumnCount.size();
		
		for(int index = 1 ; index <= rowCount ; index++) {
			for(int innerIndex = 1 ; innerIndex <= columnCount ; innerIndex++) {
				System.out.print(driver.findElement(By.xpath("//div[@id='empbasic']//tbody/tr["+index+"]/td["+innerIndex+"]")).getText()+"  ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new Assignment15().allData();
	}
}
















