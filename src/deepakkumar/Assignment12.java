/*
Assignment12 Nov22
Verify how many columns and rows are present in Demo tables >> EMPLOYEE MANAGER table
Expected: 
Column count - 5
Row count - 9
 */

package deepakkumar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment12 {
	WebDriver dr;
	
	public void launchBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get(url);
	}
	
	public void tempWait(int mSecs) {
		try {
			Thread.sleep(mSecs);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void webTableActions() {
		launchBrowser("http://automationbykrishna.com/index.html");
		dr.findElement(By.id("demotable")).click();
		tempWait(3000);
		
		List<WebElement> count = dr.findElements(By.xpath("//table[@class='table table-striped']/thead/tr/th"));
		System.out.println("Column Count -> "+count.size());
		
		count = dr.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
		System.out.println("Row Count -> "+count.size());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assignment12 output = new Assignment12();
		output.webTableActions();
	}

}
