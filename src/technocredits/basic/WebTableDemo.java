package technocredits.basic;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableDemo {
	
	WebDriver driver;

	void setUp(String url) {
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();// Launch Chrome Browser

		System.out.println("STEP - Maximize browser");
		driver.manage().window().maximize();

		System.out.println("STEP - Navigate to URL");
		driver.get(url);
	}

	void waitABit(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void verifyTableRowCount() {
		setUp("http://automationbykrishna.com");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		waitABit(2000);
		
		List<WebElement> listOfElements = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println(listOfElements.size());
		if(listOfElements.size() == 5)
			System.out.println("Test pass");
		else
			System.out.println("Test fail");
	}
	
	void printTableData() {
		setUp("http://automationbykrishna.com");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		waitABit(2000);
		
		String text = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[4]")).getText();
		System.out.println(text);
	}
	
	void printLastName() {
		Set<String> setOfexpectedLastName = new LinkedHashSet<String>(Arrays.asList("Kanani","Boda","Sharma","Patro"));
		setUp("http://automationbykrishna.com");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		waitABit(2000);
		
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
	
	void printDeptMap() {
		setUp("http://automationbykrishna.com");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		waitABit(2000);
		
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
	}
	
	public static void main(String[] args) {
		String str = "Showing 1 to 10 of 57 entries";
		int expectedRowCount  = Integer.parseInt(str.split(" ")[5]);
		new WebTableDemo().printDeptMap();
	}
}





















