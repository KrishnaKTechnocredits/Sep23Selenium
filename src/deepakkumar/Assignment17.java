/*
 * Assignment17: 25 Nov
Verify number of unique employee positions in the table.
1. Navigate to https://datatables.net/
2. Find unique employee positions in the data table.
3. Verify number of unique positions.

 */

package deepakkumar;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment17 {
	WebDriver dr;

	public void launchBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", ".//chromeDriver//chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get(url);
	}

	public void uniquePositionsWebTable() {
		launchBrowser("https://datatables.net/");
		List<WebElement> positionList = dr.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
		Set<String> set = new LinkedHashSet<String>();

		for (WebElement e : positionList) {
			System.out.println(e.getText());
			set.add(e.getText());
		}
		System.out.println("----OUTPUT----");
		System.out.println("Number of Unique Positions -> " + set.size());
		System.out.println("Unique Positions -> " + set);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assignment17 output = new Assignment17();
		output.uniquePositionsWebTable();
	}

}
