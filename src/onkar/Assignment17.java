/*Verify number of unique employee positions in the table.
1. Navigate to https://datatables.net/
2. Find unique employee positions in the data table.
3. Verify number of unique positions.*/

package onkar;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment17 {

	WebDriver driver;
	
	@BeforeMethod
	void setup() {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println("Maximize browser window");
		driver.manage().window().maximize();
		
		System.out.println("Open given URL");
		driver.get("https://datatables.net/");
	}
	
	@AfterMethod
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}
	
	@Test
	void verifyUniqueEmployees() {		
		List<WebElement> listOfPositions = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
		Set<String> uniquePosition = new LinkedHashSet<String>();
		
		for(WebElement e : listOfPositions) {
			uniquePosition.add(e.getText());
		}
		
		System.out.println(uniquePosition);
		Assert.assertEquals(uniquePosition.size(), 8);
	}
}
