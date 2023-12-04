/*Assignment20: 25 Nov
Verify number of employees working at each position.
1. Navigate to https://datatables.net/
2. Find employees working at each position.
3. Verify number of employees.*/

package jaykumar;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment20 {
	WebDriver driver;
	
	void setUp(String url){
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("STEP - Launch: "+url);
		driver.get(url);
	}

	void webTableTestCases(Map<String, Integer> expectedPositionMap) {
		setUp("https://datatables.net/");
		
		System.out.println("STEP - Find list of position");
		List<WebElement> listOfPosition = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
		
		System.out.println();
		System.out.println("STEP - Number of employees working at each position");
		Map<String, Integer> actualPositionMap = new LinkedHashMap<String, Integer>();
		for(WebElement position : listOfPosition) {
			String key = position.getText();
			if(actualPositionMap.containsKey(key)) {
				int count = actualPositionMap.get(key);
				actualPositionMap.put(key, count+1);
			}else {
				actualPositionMap.put(key, 1);
			}
		}
		System.out.println(actualPositionMap);
		
		System.out.println();
		System.out.println("VERIFY - Number of Employees working at each position");
		if(expectedPositionMap.equals(actualPositionMap)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		
		System.out.println("STEP - Close browser");
		driver.close();
	}
	
	public static void main(String[] args) {
		Map<String, Integer> expectedOfficeMap = new LinkedHashMap<String, Integer>();
		expectedOfficeMap.put("Accountant", 1);
		expectedOfficeMap.put("Chief Executive Officer (CEO)", 1);
		expectedOfficeMap.put("Junior Technical Author", 1);
		expectedOfficeMap.put("Software Engineer", 3);
		expectedOfficeMap.put("Integration Specialist", 1);
		expectedOfficeMap.put("Pre-Sales Support", 1);
		expectedOfficeMap.put("Sales Assistant", 1);
		expectedOfficeMap.put("Senior Javascript Developer", 1);
		new Assignment20().webTableTestCases(expectedOfficeMap);
	}
}
