/*Assignment13 Nov22 Print Last row data, 
Demo tables >> EMPLOYEE BASIC INFORMATION table 
Note: Get row size - 4*/
package shrutika;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment13 {
	
	WebDriver driver;

	@BeforeClass
	void launchChrome() {
		System.out.println("Step 1 : Launch Chrome Browser ");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("Launch Chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@BeforeMethod
	void setUp() {
		System.out.println("Step 2 : Navigate URL");
		String url = "http://automationbykrishna.com/index.html";
		driver.navigate().to(url);
	}
	
	@Test
	void printLastRowData() {
		
		System.out.println("Step 3: Navigate to Demo Table");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		
		List<WebElement> column = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		int columnCount = column.size();
		
		System.out.print("Step 4: Last row data : ");
		for(int index=1; index<=columnCount; index++) {
			System.out.print(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[5]/td["+index+"]")).getText());
			System.out.print(" ");
		}
		
		System.out.println("\nStep 5:Close the browser");
		driver.close();
	}
}
