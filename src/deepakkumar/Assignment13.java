/*
Assignment13 Nov22
Print Last row data, Demo tables >> EMPLOYEE BASIC INFORMATION table
Note: Get row size - 4

-------------------------------------------------------------------
 */

package deepakkumar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment13 {

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
	
	public void webTableRowPrint() {
		launchBrowser("http://automationbykrishna.com/index.html");
		dr.findElement(By.id("demotable")).click();
		tempWait(3000);
		
		List<WebElement> columnElements = dr.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		int cCount = columnElements.size();
		
		System.out.println("STEP: Printing Last Row in Employee Table");
		for(int index = 1; index <=cCount ; index++ ) {
			System.out.print(dr.findElement(By.xpath("//table[@id='table1']/tbody/tr[5]/td["+index+"]")).getText());
			System.out.print(" | ");
		}
		
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assignment13 output = new Assignment13();
		output.webTableRowPrint();
	}

}
