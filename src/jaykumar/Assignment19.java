/*Assignment19: 25 Nov
Verify number of employees working at each office location.
1. Navigate to https://datatables.net/
2. Find employees working at each office location.
3. Verify number of employees.*/

package jaykumar;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment19 {
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
	
	void webTableTestCases(Map<String, Integer> expectedOfficeMap) {
		setUp("https://datatables.net/");
		
		System.out.println("STEP - Find Offices");
		List<WebElement> listOfOffices = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
		
		System.out.println();
		System.out.println("STEP - Number of employees working at offices");
		Map<String, Integer> actualOfficeMap = new LinkedHashMap<String, Integer>();
		for(int i=0; i<listOfOffices.size(); i++) {
			String key = listOfOffices.get(i).getText();
			if(actualOfficeMap.containsKey(key)) {
				int count = actualOfficeMap.get(key);
				actualOfficeMap.put(key, count+1);
			}else {
				actualOfficeMap.put(key, 1);
			}
		}
		System.out.println(actualOfficeMap);
		
		System.out.println();
		System.out.println("VERIFY - Number of Employees");
		if(expectedOfficeMap.equals(actualOfficeMap)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		
		System.out.println("STEP - Close browser");
		driver.close();
	}
	
	public static void main(String[] args) {
		Map<String, Integer> expectedOfficeMap = new LinkedHashMap<String, Integer>();
		expectedOfficeMap.put("Tokyo", 1);
		expectedOfficeMap.put("London", 3);
		expectedOfficeMap.put("San Francisco", 2);
		expectedOfficeMap.put("New York", 3);
		expectedOfficeMap.put("Edinburgh", 1);
		new Assignment19().webTableTestCases(expectedOfficeMap);
	}
}
