/*Assignment15 Nov22
Print all the data for Demo tables >> EMPLOYEE BASIC INFORMATION table
Hint: 2 Loops, out loop - Row, inner loop - Column*/

package jaykumar;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment15 {
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

	void webTableTestCases(){
		setUp("http://automationbykrishna.com");
		System.out.println("STEP - Click on Demo Tables link");
		driver.findElement(By.id("demotable")).click();
		waitABit(3000);	

		List<WebElement> listOfCol = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		int columnsCount = listOfCol.size();

		List<WebElement> listOfRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		int rowsCount = listOfRow.size();
		
		System.out.println("STEP - Print all table data");
		for(int i=1; i<=rowsCount; i++) {
			for(int j=1; j<=columnsCount; j++) {
				WebElement e = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]"));
				System.out.print(e.getText());
				System.out.print(" ");
			}
			System.out.println();
		}
		
		System.out.println("STEP - Close browser");
		driver.close();
		
	}
	
	public static void main(String[] args) {
		new Assignment15().webTableTestCases();
	}
}
