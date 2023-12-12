/*Assignment23: 25 Nov
Verify sort functionality works on list of office locations from the table [consider all  pages].
1. Navigate to https://datatables.net/
2. Find list of office locations from all pages of table.
3. Sort the list of office locations.
4. Verify sort on list of office locations.
Note: 
Expected list - You can find list of offices as it is, then use sort() method of Collections.
Then you can sort the list from UI and take it as actual list.*/

package jaykumar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment23 {
	WebDriver driver;
	
	void setUp(String url){
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("STEP - Launch: "+url);
		driver.get(url);
	}
	
	void webTableTestCases() throws InterruptedException {
		setUp("https://datatables.net/");
		
		System.out.println();
		System.out.println("STEP - Find all office locations");
		List<WebElement> pageElements = driver.findElements(By.xpath("//a[@class='paginate_button ' or @class='paginate_button current']"));
		int numberOfPages = pageElements.size();
		
		List<String> expectedOfficeList = new ArrayList<String>();
		for(int i = 1; i <= numberOfPages; i++) {
			List<WebElement> expectedOfficeElementList = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
			for(WebElement expectedOffice : expectedOfficeElementList) {
				expectedOfficeList.add(expectedOffice.getText());
			}
			if(i<6) {
				driver.findElement(By.xpath("//a[text()='"+(i+1)+"']")).click();
			}
		}
		System.out.println(expectedOfficeList);
		
		System.out.println();
		System.out.println("Sorted office list using collection:");
		Collections.sort(expectedOfficeList);
		System.out.println(expectedOfficeList);
		
		System.out.println();
		System.out.println("STEP - Click on sort button");
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[text()='Office']")).click();
		
		System.out.println();
		System.out.println("STEP - Find all sorted office locations");
		List<String> actualOfficeList = new ArrayList<String>();
		for(int i = 1; i <= numberOfPages; i++) {
			List<WebElement> actualOfficeElementList = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
			for(WebElement actualOffice : actualOfficeElementList) {
				actualOfficeList.add(actualOffice.getText());
			}
			if(i<6) {
				driver.findElement(By.xpath("//a[text()='"+(i+1)+"']")).click();
			}
		}
		System.out.println(actualOfficeList);
		
		System.out.println();
		System.out.println("VERIFY - Sort functionality");
		if(expectedOfficeList.equals(actualOfficeList)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		
		System.out.println();
		System.out.println("STEP - Close browser");
		driver.close();
	}
	
	public static void main(String[] args) throws InterruptedException {
		new Assignment23().webTableTestCases();
	}
}
