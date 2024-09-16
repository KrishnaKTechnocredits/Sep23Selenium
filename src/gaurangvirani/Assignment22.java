/*Verify list of employees whose age is less than 50 and works in London office.

1. Navigate to https://datatables.net/
2. Find employees whose age is less than 50 and works in London office.
3. Verify list of employees.
Note: 
Create expected list and compare with actual list.*/

package gaurangvirani;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment22 {

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
	
	void ageEmpl() {
		chrome();
		waitABit();
		
		List<WebElement> listOfAge = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[4]"));
		List<String> lisOfEmpl = new ArrayList<String>();
		for(int index = 1 ; index < listOfAge.size() ; index++) {
			String age = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+index+"]/td[4]")).getText();
			int age1 = Integer.parseInt(age);
			String location = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+index+"]/td[3]")).getText();
			if(age1<50 && location.equals("London")) {
				lisOfEmpl.add(driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+index+"]/td[1]")).getText());
			}
		}
		System.out.println(lisOfEmpl);
		
		List<String> expectedList = new ArrayList<String>();
		expectedList.add("Angelica Ramos");
		expectedList.add("Bradley Greer");
		expectedList.add("Bruno Nash");
		if(lisOfEmpl.equals(expectedList)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		driver.close();
	}
	
	public static void main(String[] args) {
		new Assignment22().ageEmpl();
	}
}