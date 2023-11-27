/* Print Last row data, Demo tables >> EMPLOYEE BASIC INFORMATION table
Note: Get row size - 4 */

package sayali;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment13 {

	WebDriver driver;

	void launchChrome(String url) {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("Launch Chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void printData() throws InterruptedException {
		launchChrome("http://automationbykrishna.com");
		System.out.println("Navigate to Demo Table");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		sleep(3000);

		List<WebElement> listOfRows = driver.findElements(By.xpath("//table[@id='table1']/thead//th"));
		System.out.println("Last Row Size : " + listOfRows.size());
		System.out.println("Last Row Data: ");
		int lastRowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody//tr")).size();

		for (int index = 1; index <= listOfRows.size(); index++) {
			String text = driver
					.findElement(By.xpath("//table[@id='table1']/tbody//tr[" + lastRowCount + "]/td[" + index + "]"))
					.getText();
			System.out.print(text + " ");
		}
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment13().printData();
	}
}