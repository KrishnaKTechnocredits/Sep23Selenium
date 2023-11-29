/*
 * Assignment18: 25 Nov
Verify number of unique office locations in the table.
1. Navigate to https://datatables.net/
2. Find unique offices in the data table.
3. Verify number of unique offices.

 */

package deepakkumar;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment18 {
	WebDriver dr;

	public void launchBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", ".//chromeDriver//chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get(url);
	}

	public void uniquePositionsWebTable() {
		launchBrowser("https://datatables.net/");
		List<WebElement> positionList = dr.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
		Set<String> set = new LinkedHashSet<String>();

		for (WebElement e : positionList) {
			System.out.println(e.getText());
			set.add(e.getText());
		}
		System.out.println("----OUTPUT----");
		System.out.println("Number of Unique Office Locations-> " + set.size());
		System.out.println("Unique Office Locations-> " + set);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assignment18 output = new Assignment18();
		output.uniquePositionsWebTable();
	}

}