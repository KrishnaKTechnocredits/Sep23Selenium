/*Verify number of unique employee positions in the table.

1. Navigate to https://datatables.net/
2. Find unique employee positions in the data table.
3. Verify number of unique positions.

for unique positions use set Arraylist.*/

package gaurangvirani;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment17 {

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
	
	void empPosition() {
		chrome();
		waitABit();
		List<WebElement> listOfPositions = driver.findElements(By.xpath("//table[@id='example']//tr/td[2]"));
		Map<String, Integer> mapOfPositions = new HashMap<String, Integer>();
		for(WebElement name : listOfPositions) {
			String name1 = name.getText();
			if(mapOfPositions.containsKey(name1)) {
				int count = mapOfPositions.get(name1);
				mapOfPositions.put(name1, count+1);
			}else {
				mapOfPositions.put(name1, 1);
			}
		}
		System.out.println(mapOfPositions);
	}
	
	public static void main(String[] args) {
		new Assignment17().empPosition();
	}
}






















