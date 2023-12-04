/*Assignment18: 25 Nov
Verify number of unique office locations in the table.
1. Navigate to https://datatables.net/
2. Find unique offices in the data table.
3. Verify number of unique offices.*/

package jaykumar;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment18 {
	WebDriver driver;
	
	void setUp(String url){
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("STEP - Launch: "+url);
		driver.get(url);
	}
	
	void waitABit(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void webTableTestCases(int expectedNumberOfOffices, Set<String> expectedUniqueOfficeSet) {
		setUp("https://datatables.net/");
		
		System.out.println();
		System.out.println("STEP - Find Unique Employee Offices");
		List<WebElement> listOfOffices = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
		
		Set<String> actualSetOfOffices = new LinkedHashSet<String>();
		for(WebElement e : listOfOffices) {
			String office = e.getText();
			actualSetOfOffices.add(office);
		}
		
		System.out.println("Actual Unique Offices list is: ");
		for(String str : actualSetOfOffices) {
			System.out.println(str);
		}
		
		System.out.println();
		System.out.println("VERIFY - Unique offices list");
		if(expectedUniqueOfficeSet.equals(actualSetOfOffices)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		
		System.out.println();
		System.out.println("VERIFY - Number of unique offices");
		int actualNumberOfoffices = actualSetOfOffices.size();
		System.out.println("Actual number of unique offices is: "+actualNumberOfoffices);
		if(expectedNumberOfOffices==actualNumberOfoffices) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		
		System.out.println();
		System.out.println("STEP - Close browser");
		driver.close();
	}
	
	public static void main(String[] args) {
		String[] offices = {"Tokyo", "London", "San Francisco", "New York", "Edinburgh"};
		Set<String> setOfOffice = new LinkedHashSet<String>(Arrays.asList(offices));
		new Assignment18().webTableTestCases(5, setOfOffice);
	}
}
