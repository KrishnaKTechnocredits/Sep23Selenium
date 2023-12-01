/* Verify sort functionality works on list of office locations from the table [consider all  pages].
1. Navigate to https://datatables.net/
2. Find list of office locations from all pages of table.
3. Sort the list of office locations.
4. Verify sort on list of office locations.
Note: 
Expected list - You can find list of offices as it is, then use sort() method of Collections.
Then you can sort the list from UI and take it as actual list. */

package sayali;

import java.util.ArrayList;
import java.util.Collections;
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
	public void setup() {
		System.out.println("Launch Chrome Browser");
		System.setProperty("webdriver.chrome.driver", "D:\\Testing_Class Sayali\\JavaProject\\Sep23Selenium\\src\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("Navigate to given url");
		driver.navigate().to("https://datatables.net/");
		wait(3000);
	}

	public List<String> findListOfOffices() {

		List<WebElement> totalPages = driver
				.findElements(By.xpath("//a[@class='paginate_button ' or @class='paginate_button current']"));

		ArrayList<String> listOfOffices = new ArrayList<String>();
		for (int i = 1; i <= totalPages.size(); i++) {
			WebElement pageElement = driver.findElement(
					By.xpath("//a[@class='paginate_button ' or @class='paginate_button current'][" + i + "]"));
			pageElement.click();
			wait(2000);
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id = 'example']//tbody//tr"));
			for (int index = 1; index <= rows.size(); index++) {
				String office = driver
						.findElement(By.xpath("//table[@id = 'example']//tbody//tr[" + index + "]//td[3]")).getText();
				listOfOffices.add(office);
			}
		}
		System.out.println("List of office locations from all pages: ");
		Collections.sort(listOfOffices);
		return listOfOffices;
	}


	public List<String> getSortedListOfOffices() {

		WebElement sortElement = driver.findElement(By.xpath("//th[@class='sorting'][2]"));
		sortElement.click();
		wait(2000);

		List<WebElement> totalPages = driver
				.findElements(By.xpath("//a[@class='paginate_button ' or @class='paginate_button current']"));

		ArrayList<String> listOfOffices = new ArrayList<String>();
		for (int i = 1; i <= totalPages.size(); i++) {
			WebElement pageElement = driver.findElement(
					By.xpath("//a[@class='paginate_button ' or @class='paginate_button current'][" + i + "]"));
			pageElement.click();
			wait(2000);
			
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id = 'example']//tbody//tr"));
		
			for (int index = 1; index <= rows.size(); index++) {
				String office = driver
						.findElement(By.xpath("//table[@id = 'example']//tbody//tr[" + index + "]//td[3]")).getText();
				listOfOffices.add(office);
			}
		}
		return listOfOffices;
	}

	@Test
	public void verifySorting() {
		List<String> expectedList = findListOfOffices();
		List<String> actualList = getSortedListOfOffices();
		System.out.println("\nExpected List :");
		System.out.println(expectedList);
		System.out.println("\nActual List :");
		System.out.println(actualList);

		if(expectedList.equals(actualList))
			System.out.println("Test case passed.");
		else
			System.out.println("Test case failed.");
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
		System.out.println("Close browser window");
		driver.close();
	}
}