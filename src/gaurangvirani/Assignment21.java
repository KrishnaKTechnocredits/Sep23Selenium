/*Verify list of employees whose age is greater than 50.
1. Navigate to https://datatables.net/
2. Find employees whose age is greater than 50.
3. Verify list of employees.
Note: 
Create expected list and compare with actual list.
Covered in session.*/

package gaurangvirani;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment21 {

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
	
	void ageEmp() {
		chrome();
		waitABit();
		
		List<WebElement> listOfAge = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[4]"));
		List<String> listOfEmp = new ArrayList<String>();
		for(int index = 1 ; index<=listOfAge.size() ; index++) {
			String age = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+index+"]/td[4]")).getText();
			int age1 = Integer.parseInt(age);
			if(age1>50) {
				listOfEmp.add(driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+index+"]/td[1]")).getText());
			}
		}
		System.out.println(listOfEmp);
		List<String> expectedList = new ArrayList<String>();
		expectedList.add("Ashton Cox");
		expectedList.add("Brielle Williamson");
		if(listOfEmp.equals(expectedList)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		driver.close();
	}
	
	public static void main(String[] args) {
		new Assignment21().ageEmp();
	}
}