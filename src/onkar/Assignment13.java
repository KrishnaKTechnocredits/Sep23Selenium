/*Print Last row data, Demo tables >> EMPLOYEE BASIC INFORMATION table
Note: Get row size - 4*/

package onkar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment13 {

	WebDriver driver;

	@BeforeClass
	void setup() {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get("http://automationbykrishna.com");
	}

	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	void closeBrowser() {
		System.out.println("\n"+"Close browser window");
		driver.close();
	}

	@Test
	void printLastRow() {
		System.out.println("Navigate to Demo Tables");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		sleep(3000);
		
		List<WebElement> lastRowElements = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[5]/td"));
		
		System.out.print("Printed elements of the last row : ");
		for(WebElement e : lastRowElements) {
			System.out.print(e.getText());
			System.out.print(" ");
		}
	}	
}
