/*Verify number of unique office locations in the table.
1. Navigate to https://datatables.net/
2. Find unique offices in the data table.
3. Verify number of unique offices.*/

package gaurangvirani;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment18 {

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
	
	void uniqueOfc() {
		chrome();
		waitABit();
		List<WebElement> listOfOffice = driver.findElements(By.xpath("//table[@id='example']//tr/td[3]"));
		Set<String> setOfOffice = new HashSet<String>();
		for(WebElement office : listOfOffice) {
			String name = office.getText();
			setOfOffice.add(name);
		}
		System.out.println("Unique offices in datasheet are : "+setOfOffice);
		System.out.println("Total unique office are : "+setOfOffice.size());
		driver.close();
	}
	
	public static void main(String[] args) {
		new Assignment18().uniqueOfc();
	}
}
