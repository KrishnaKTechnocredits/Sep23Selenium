/*Assignment17: 25 Nov
Verify number of unique employee positions in the table.
1. Navigate to https://datatables.net/
2. Find unique employee positions in the data table.
3. Verify number of unique positions.*/

package jaykumar;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment17 {
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
	
	void webTableTestCases(int expectedNumberOfPositions) {
		setUp("https://datatables.net/");
		
		System.out.println("STEP - Find Unique Employee Positions");
		List<WebElement> listOfEmp = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
		
		Set<String> setOfPosition = new LinkedHashSet<String>();
		for(WebElement e : listOfEmp) {
			String position = e.getText();
			setOfPosition.add(position);
		}
		
		System.out.println("Unique positions are: ");
		for(String str : setOfPosition) {
			System.out.println(str);
		}
		
		System.out.println("VERIFY - Number of unique positions");
		int actualNumberOfPositions = setOfPosition.size();
		if(expectedNumberOfPositions==actualNumberOfPositions) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		
		System.out.println("STEP - Close browser");
		driver.close();
	}
	
	public static void main(String[] args) {
		new Assignment17().webTableTestCases(8);
	}
}
