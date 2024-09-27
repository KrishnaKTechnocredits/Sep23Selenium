/*Verify sort functionality works on list of office locations from the table [consider all  pages].
1. Navigate to https://datatables.net/
2. Find list of office locations from all pages of table.
3. Sort the list of office locations.
4. Verify sort on list of office locations.
Note: 
Expected list - You can find list of offices as it is, then use sort() method of Collections.
Then you can sort the list from UI and take it as actual list.*/

package gaurangvirani;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment23 {

WebDriver driver;
	
	void chrome() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://datatables.net/");
	}
	
	void waitABit() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void verifySort() {
		chrome();
		waitABit();
		
		WebElement sort = driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[3]"));
		sort.click();
		List<String> sortedList = new ArrayList<String>();
		List<WebElement> listOfPage = driver.findElements(By.xpath("//span/a[contains(@class,\"paginate_button \")]"));
		for(int index = 1 ; index <= listOfPage.size() ; index++) {
			driver.findElement(By.xpath("//span/a[contains(@class,\"paginate_button \")]["+index+"]")).click();
			List<WebElement> listOfCurrent = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
			for(WebElement name : listOfCurrent) {
				String office = name.getText();
				sortedList.add(office);
			}
		}
		System.out.println(sortedList);
		
		List<String> expectedList = new ArrayList<String>(sortedList);
		Collections.sort(expectedList);
		if(expectedList.equals(sortedList)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		driver.close();
	}
	
	public static void main(String[] args) {
		new Assignment23().verifySort();
	}
}