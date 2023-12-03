package technocredits.basic;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemoExample {
	
	WebDriver driver;

	@BeforeMethod
	void setUp() {
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();// Launch Chrome Browser

		System.out.println("STEP - Maximize browser");
		driver.manage().window().maximize();

		System.out.println("STEP - Navigate to URL");
		driver.get("http://automationbykrishna.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	void tearDown() {
		driver.close();
	}
	
	@Test
	void printTableData() {
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		String text = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[4]")).getText();
		System.out.println(text);
	}
	
	@Test
	void verifyLastName() {
		Set<String> setOfexpectedLastName = new LinkedHashSet<String>(Arrays.asList("Kanani","Boda","Sharma","Patro"));
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		
		List<WebElement> listOfLastNameElement = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		Set<String> setOfLastName = new LinkedHashSet<String>();
		for(WebElement lastNameElement : listOfLastNameElement) {
			setOfLastName.add(lastNameElement.getText());
		}
		System.out.println("Unique lastname are : " + setOfLastName);
		if(setOfexpectedLastName.equals(setOfLastName)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test fail");
		}
	}
	
	@Test
	void verifyDeptMap() {
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		List<WebElement> listOfDeptElements = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));
		Map<String, Integer> deptMap = new LinkedHashMap<String, Integer>();

		for(WebElement deptElement : listOfDeptElements){
			String dept = deptElement.getText();
			
			if(deptMap.containsKey(dept)){
				int count = deptMap.get(dept);
				deptMap.put(dept,count+1);
			}else{
				deptMap.put(dept,1);
			}
		}
		System.out.println(deptMap);
		///
	}
}
