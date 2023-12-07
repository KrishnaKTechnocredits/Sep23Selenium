/*Assignment13 Nov22
Print Last row data, Demo tables >> EMPLOYEE BASIC INFORMATION table
Note: Get row size - 4
*/

package roshnikolhe;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment13 {
	WebDriver driver;

	void setUp() {
		System.out.println("Step1. Launch Chrome Browser");
		//String setProperty = System.setProperty("webdriver.chrome.driver","D:\\Technocredits\\Projects\\IDE\\Sep23Selenium\\ChromeDriver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println("Step2. Maximize the window");
		driver.manage().window().maximize();
		
		System.out.println("Step3. Navigate to http://automationbykrishna.com/");
		driver.get("http://automationbykrishna.com/");
	}

	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void printLastRowData() {
		setUp();

		System.out.println("Navigate to Demo Table");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		sleep(3000);

		List<WebElement> column = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		int columnCount = column.size();

		//Dynamic Xpath
		System.out.print("Last row data : ");
		for(int index=1; index<=columnCount; index++) {
			System.out.print(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[5]/td["+index+"]")).getText());
			System.out.print(" ");
		}

		System.out.println("\nBrowser close");
		driver.close();
	}

	public static void main(String[] args) {
		new Assignment13().printLastRowData();
	}

}