/*Assignment10 Nov19 (Multiselect dropdown)
- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- Checkboxes and radios - Select multiple checkboxes 
 * */
package shamligadekar;
 

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment10 {
	
WebDriver driver;
	
	void launchBrowser(String url) {
		System.out.println("STEP-Launch Browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println("STEP-Maximize Window");
		driver.manage().window().maximize();
		
		System.out.println("STEP-Navigate to : "+url);
		driver.get(url);
	}
	
	void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void selectMultipleCheckboxes() {
		
		System.out.println("STEP - Select multiple checkboxes");
		WebElement e=driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']//label[@class='col-sm-2 control-label col-lg-2']"));
		scroll(e);
		e.click();
		wait(3000);
		System.out.println("Select multiple checkboxes");
		driver.findElement(By.xpath("//div[@class='col-lg-10']/div[1]//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//div[@class='col-lg-10']/div[2]//input[@type='checkbox']")).click();
		wait(3000);
		
	}
	
	void scroll(WebElement w) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", w);
	}
	
	void testCases() {
		launchBrowser("http://automationbykrishna.com/");
		System.out.println("STEP-Click on Basic Elements link");
		driver.findElement(By.id("basicelements")).click();
		wait(3000);
		selectMultipleCheckboxes();
		
		System.out.println("STEP-Browser Close");
		driver.close();
	}
	
	public static void main(String[] args) {
		Assignment10 assignment10 = new Assignment10();
		assignment10.testCases();
	}
}
