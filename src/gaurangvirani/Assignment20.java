/*Verify number of employees working at each position.

1. Navigate to https://datatables.net/
2. Find employees working at each position.
3. Verify number of employees.

Note: please refer to link for expected employee, position map.*/

package gaurangvirani;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment20 {

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
	
	void positionEmp(){
		chrome();
		waitABit();
		List<WebElement> listOfPositions = driver.findElements(By.xpath("//table[@id='example']//tbody/tr/td[2]"));
		Map<String, Integer> mapOfPositions = new HashMap<String, Integer>();
		for(WebElement office : listOfPositions) {
			String name = office.getText();
			if(mapOfPositions.containsKey(name)) {
				int count = mapOfPositions.get(name);
				mapOfPositions.put(name, count+1);
			}else {
				mapOfPositions.put(name, 1);
			}
		}
		System.out.println("Employees at each office : "+mapOfPositions);
		
		driver.close();
	}
	
	public static void main(String[] args) {
		new Assignment20().positionEmp();
	}
	
}
