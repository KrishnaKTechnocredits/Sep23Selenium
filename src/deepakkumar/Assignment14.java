/*
 * Assignment14 Nov22
WAP, print all data for last row
Hint:
Get rows size = 5
Get column size = 4
Note: Assignment should have dynamic data.

 */

package deepakkumar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment14 {

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

		List<WebElement> rowElements = dr.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		List<WebElement> columnElements = dr.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		int rCount = rowElements.size();
		int cCount = columnElements.size();

		System.out.println("STEP: Printing Last Row in Employee Table");
		for (int index = 1; index <= cCount; index++) {
			System.out
					.print(dr.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rCount + "]/td[" + index + "]"))
							.getText());
			System.out.print(" | ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assignment14 output = new Assignment14();
		output.webTableRowPrint();
	}

}