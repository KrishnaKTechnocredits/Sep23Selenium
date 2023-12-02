//Assignment21: 25 Nov
//Verify list of employees whose age is greater than 50.
//1. Navigate to https://datatables.net/
//2. Find employees whose age is greater than 50.
//3. Verify list of employees.
//Note: 
//Create expected list and compare with actual list.

package pushpag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Assignment21 {
	WebDriver driver;

	@BeforeMethod
	public void setBrowser() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to https://datatables.net/
		System.out.println("Step 1 - https://datatables.net/");
		driver.navigate().to("https://datatables.net/");
		wait(3000);
	}

	@org.testng.annotations.Test
	public void findListOfEmployees() throws InterruptedException {
		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id = 'example']//tbody//tr"));
		wait(3000);
		String list[] = {"Ashton Cox", "Brielle Williamson"};
		List<String>  expectedList = Arrays.asList(list);
		ArrayList<String> listOfEmp = new ArrayList<String>();
		for (int index = 1; index <= tableRows.size(); index++) {
			String empName = driver.findElement(By.xpath("//table[@id = 'example']//tbody//tr[" + index + "]//td[1]"))
					.getText();
			int age = Integer.parseInt(driver
					.findElement(By.xpath("//table[@id = 'example']//tbody//tr[" + index + "]//td[4]")).getText());

			if (age > 50)
				listOfEmp.add(empName);
		}
		System.out.println("List of Employees whose age > 50 : " + listOfEmp);
		
		if(expectedList.equals(listOfEmp))
			System.out.println("Test Case Passed...");
		else
			System.out.println("Test Case Failed...");
	}

	public void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	@AfterMethod
	public void closeDriver() {
		driver.close();
	}
}