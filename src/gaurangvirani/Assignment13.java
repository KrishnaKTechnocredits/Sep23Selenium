/*Print Last row data, Demo tables >> EMPLOYEE BASIC INFORMATION table
Note: Get row size - 4*/

package gaurangvirani;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment13 {

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
	
	void printLastRow() {
		chrome();
		waitABit();
		driver.findElement(By.id("demotable")).click();
		
		waitABit();
		
		System.out.println("Print last row :");
		List<WebElement> lastRowElement = driver.findElements(By.xpath("//div[@id='empbasic']//tbody/tr[5]/td"));
		int columnSize = lastRowElement.size();
		
		for(int index = 1 ; index <= columnSize ; index++) {
			System.out.print(driver.findElement(By.xpath("//div[@id='empbasic']//tbody/tr[5]/td["+index+"]")).getText()+"  ");
			if(index<columnSize) {
				System.out.print("  ");
			}else {
				
			}
		}
	}
	
	public static void main(String[] args) {
		new Assignment13().printLastRow();
	}
}


















