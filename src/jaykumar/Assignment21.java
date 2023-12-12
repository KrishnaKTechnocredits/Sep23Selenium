/*Assignment21: 25 Nov
Verify list of employees whose age is greater than 50.
1. Navigate to https://datatables.net/
2. Find employees whose age is greater than 50.
3. Verify list of employees.
Note: 
Create expected list and compare with actual list.
Covered in session. */

package jaykumar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment21 {
	WebDriver driver;
	
	void setUp(String url){
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("STEP - Launch: "+url);
		driver.get(url);
	}
	
	void webTableTestCases(List<String> expectedEmpList) {
		setUp("https://datatables.net/");
		
		System.out.println();
		System.out.println("STEP - Find Employees List");
		List<String> actualEmpList = new ArrayList<String>();
		int totalRows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[4]")).size();
		for(int rowIndex=1; rowIndex<=totalRows; rowIndex++) {
			WebElement ageElement = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+rowIndex+"]/td[4]"));
			int age = Integer.parseInt(ageElement.getText());
			if(age>50) {
				String emp = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+rowIndex+"]/td[1]")).getText();
				actualEmpList.add(emp);
			}
		}
		
		System.out.println("Employees with age greater than 50 are: ");
		for(String str : actualEmpList) {
			System.out.println(str);
		}
		
		System.out.println();
		System.out.println("VERIFY - List of employees whose age is greater than 50");
		if(expectedEmpList.equals(actualEmpList)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		
		System.out.println("STEP - Close browser");
		driver.close();
	}
	
	public static void main(String[] args) {
		List<String> expectedEmpList = new ArrayList<String>(Arrays.asList("Ashton Cox","Brielle Williamson"));
		new Assignment21().webTableTestCases(expectedEmpList);
	}
}
