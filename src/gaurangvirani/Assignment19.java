/*Verify number of employees working at each office location.
1. Navigate to https://datatables.net/
2. Find employees working at each office location.
3. Verify number of employees.

Note: please refer to link for expected employee, office map.*/

package gaurangvirani;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment19 {

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
	
	void emplNum() {
		chrome();
		waitABit();
		List<WebElement> listOfOffices = driver.findElements(By.xpath("//table[@id='example']//tbody/tr/td[3]"));
		Set<WebElement> officeUnique = new HashSet<WebElement>(listOfOffices);
		
		System.out.println(officeUnique);
		Map<String, Integer> mapOfOffice = new HashMap<String, Integer>();
		for(WebElement office : listOfOffices) {
			String name = office.getText();
			if(mapOfOffice.containsKey(name)) {
				int count = mapOfOffice.get(name);
				mapOfOffice.put(name, count+1);
			}else {
				mapOfOffice.put(name, 1);
			}
		}
		System.out.println("Employees at each office : "+mapOfOffice);
		
		int count = listOfOffices.size();
		System.out.println(count);
		int expectedEmplyoee = 10;
		if(expectedEmplyoee == count ) {
			System.out.println("Test pass.");
		}else {
			System.out.println("Test fail.");
		}
		driver.close();
	}
	
	public static void main(String[] args) {
		new Assignment19().emplNum();
	}
}