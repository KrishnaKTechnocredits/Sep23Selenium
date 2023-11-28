//Assignment15 Nov22
//Print all the data for Demo tables >> EMPLOYEE BASIC INFORMATION table
//Hint: 2 Loops, out loop - Row, inner loop - Column

package pushpag;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment15 {
	WebDriver driver;

	public void setBrowser() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to http://automationbykrishna.com/index.html
		System.out.println("Step 1 - http://automationbykrishna.com/index.html");
		driver.navigate().to("http://automationbykrishna.com/index.html");
		wait(3000);
	}

	public void printAllData() throws InterruptedException {
		// - Navigate Demo tables
		System.out.println("Step 2 - Navigate Demo tables");
		WebElement basicElement = driver.findElement(By.id("demotable"));
		basicElement.click();
		wait(3000);

		//Print all the data for Demo tables 
		List<WebElement> listOfCols = driver.findElements(By.xpath("//table[@id = 'table1']/tbody/tr"));
		for (int index = 1; index <= listOfCols.size(); index++) {
			String locator = "//table[@id = 'table1']/tbody/tr[" + index + "]/td";
			List<WebElement> rowElement = driver.findElements(By.xpath(locator));
			for (int i = 1; i <= rowElement.size(); i++) {
				String rowText = driver
						.findElement(By.xpath("//table[@id = 'table1']/tbody/tr[" + index + "]/td[" + i + "]"))
						.getText();
				System.out.print(rowText + "  ");
			}
			System.out.println();
		}
	}

	public void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	public void closeDriver() {
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		Assignment15 assignment15 = new Assignment15();
		assignment15.setBrowser();
		assignment15.wait(3000);
		assignment15.printAllData();
		assignment15.wait(3000);
		assignment15.closeDriver();
	}
}