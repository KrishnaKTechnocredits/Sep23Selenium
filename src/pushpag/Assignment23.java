//Assignment23: 25 Nov
//Verify sort functionality works on list of office locations from the table [consider all  pages].
//1. Navigate to https://datatables.net/
//2. Find list of office locations from all pages of table.
//3. Sort the list of office locations.
//4. Verify sort on list of office locations.
//Note: 
//Expected list - You can find list of offices as it is, then use sort() method of Collections.
//Then you can sort the list from UI and take it as actual list.

package pushpag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment23 {
	WebDriver driver;

	@BeforeMethod
	public void setBrowser() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to https://datatables.net/
		System.out.println("Step 1 - https://datatables.net/");
		driver.navigate().to("https://datatables.net/");
		wait(3000);
	}

	//Get expected list
	public List<String> findListOfOffices() {

		// Step 1 find total no of pages
		List<WebElement> totalPages = driver
				.findElements(By.xpath("//a[@class='paginate_button ' or @class='paginate_button current']"));

		ArrayList<String> listOfOffices = new ArrayList<String>();
		// Step 2 Iterate through all the pages
		for (int i = 1; i <= totalPages.size(); i++) {
			WebElement pageElement = driver.findElement(
					By.xpath("//a[@class='paginate_button ' or @class='paginate_button current'][" + i + "]"));
			pageElement.click();
			wait(2000);

			// Find List of Employess
			List<WebElement> noOfRows = driver.findElements(By.xpath("//table[@id = 'example']//tbody//tr"));
			// wait(3000);
			for (int index = 1; index <= noOfRows.size(); index++) {
				String office = driver
						.findElement(By.xpath("//table[@id = 'example']//tbody//tr[" + index + "]//td[3]")).getText();
				listOfOffices.add(office);
			}
		}
		Collections.sort(listOfOffices);
		return listOfOffices;
	}

	// get Sorted List
	public List<String> getSortedListOfOffices() {

		// Step 1 click on Sort icon
		WebElement sortElement = driver.findElement(By.xpath("//th[@class='sorting'][2]"));
		sortElement.click();
		wait(2000);

		// Step 2 find total no of pages
		List<WebElement> totalPages = driver
				.findElements(By.xpath("//a[@class='paginate_button ' or @class='paginate_button current']"));

		ArrayList<String> listOfOffices = new ArrayList<String>();
		// Step 3 Iterate through all the pages
		for (int i = 1; i <= totalPages.size(); i++) {
			WebElement pageElement = driver.findElement(
					By.xpath("//a[@class='paginate_button ' or @class='paginate_button current'][" + i + "]"));
			pageElement.click();
			wait(2000);

			// Find List of Employess
			List<WebElement> noOfRows = driver.findElements(By.xpath("//table[@id = 'example']//tbody//tr"));
			// wait(3000);
			for (int index = 1; index <= noOfRows.size(); index++) {
				String office = driver
						.findElement(By.xpath("//table[@id = 'example']//tbody//tr[" + index + "]//td[3]")).getText();
				listOfOffices.add(office);
			}
		}
		return listOfOffices;
	}

	@Test
	public void checkSortFuntionality() {
		List<String> expectedList = findListOfOffices();
		List<String> actualList = getSortedListOfOffices();
		System.out.println("Expected List :");
		System.out.println(expectedList);
		System.out.println("Actual List :");
		System.out.println(actualList);
		
		if(expectedList.equals(actualList))
			System.out.println("Test case passed...");
		else
			System.out.println("Test case failed...");
	}

	public void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	@AfterMethod
	public void closeDriver() {
		driver.close();
	}
}