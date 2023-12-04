/*Verify sort functionality works on list of office locations from the table [consider all  pages].
1. Navigate to https://datatables.net/
2. Find list of office locations from all pages of table.
3. Sort the list of office locations.
4. Verify sort on list of office locations.
Note: 
Expected list - You can find list of offices as it is, then use sort() method of Collections.
Then you can sort the list from UI and take it as actual list.*/

package onkar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment23 {

	WebDriver driver;

	@BeforeMethod
	void setup() {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get("https://datatables.net/");
	}

	@AfterMethod
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}
	
	List<String> findList(int numberOfPages, int numberOfRows, int lastPageRows){
		List<String> listOfOffices = new ArrayList<String>();
		
		for (int index=1; index<numberOfPages; index++) {
			driver.findElement(By.xpath("(//a[@class='paginate_button '] | //a[@class='paginate_button current'])["+index+"]")).click();
			for (int innerIndex=1; innerIndex<=numberOfRows; innerIndex++) {
				String office = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+innerIndex+"]/td[3]")).getText();
				listOfOffices.add(office);
			}
		}
		driver.findElement(By.xpath("(//a[@class='paginate_button '] | //a[@class='paginate_button current'])["+numberOfPages+"]")).click();
		for (int index=1; index<=lastPageRows; index++) {
			String office = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+index+"]/td[3]")).getText();
			listOfOffices.add(office);
		}
		
		return listOfOffices;
	}
	
	@Test
	void verifySortingOnOfficeLocations() {
		String temp = driver.findElement(By.xpath("//div[@id='example_info']")).getText();
		int totalExpectedResults = Integer.parseInt(temp.split(" ")[5]);
		
		List<String> expectedListOfOffices = new ArrayList<String>();
		int numberOfRows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
		int numberOfPages = driver.findElements(By.xpath("//a[@class='paginate_button '] | //a[@class='paginate_button current']")).size();
		
		driver.findElement(By.xpath("(//a[@class='paginate_button '] | //a[@class='paginate_button current'])["+numberOfPages+"]")).click();
		int lastPageRows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
		
		expectedListOfOffices = findList(numberOfPages, numberOfRows, lastPageRows);
		Collections.sort(expectedListOfOffices);
		
		driver.findElement(By.xpath("//thead//th[text()='Office']")).click();
		List<String> sortedListOfOffices = findList(numberOfPages, numberOfRows, lastPageRows);
		
		Assert.assertEquals(sortedListOfOffices.size(), totalExpectedResults);
		System.out.println("Verified total number of results");
		
		Assert.assertEquals(sortedListOfOffices, expectedListOfOffices);
		System.out.println("Sorting on the offices is verified correctly");
	}
}
