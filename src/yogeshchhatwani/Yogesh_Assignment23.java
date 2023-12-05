/*Assignment23: 25 Nov
Verify sort functionality works on list of office locations from the table [consider all  pages].
1. Navigate to https://datatables.net/
2. Find list of office locations from all pages of table.
3. Sort the list of office locations.
4. Verify sort on list of office locations.
Note: 
Expected list - You can find list of offices as it is, then use sort() method of Collections.
Then you can sort the list from UI and take it as actual list.
*/
package yogeshchhatwani;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Yogesh_Assignment23 {
	WebDriver driver;

	@BeforeClass
	void openChrome() {
		// System.setProperty("webdriver.chrome.driver",
		// ".\\chromeDriver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", ".\\src\\yogeshchhatwani\\chromedriver.exe");

		System.out.println("Open chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = "https://datatables.net/";
		System.out.println("Navigate to url");
		driver.navigate().to(url);
	}
	@BeforeMethod
	void select() {
		System.out.println("Select page size");
		Select page =new Select(driver.findElement(By.xpath("//select[@name='example_length']")));
		page.selectByValue("100");
	}

	@AfterMethod
	void close() {
		driver.quit();
	}

	@Test
	void offLoc() {
		List<WebElement> list = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
		ArrayList<String> al = new ArrayList<String>();
		for (WebElement name : list) {
			al.add(name.getText());
		}	
		Collections.sort(al);
		System.out.println("Expected arraylist");
		
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[3]")).click();
		List<WebElement> list1 = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
		ArrayList<String> output = new ArrayList<String>();
		for (WebElement name : list1) {
			output.add(name.getText());
		}
		System.out.println("Sorted List : " + output);
		
		Assert.assertEquals(al, output);

		
	}

}
