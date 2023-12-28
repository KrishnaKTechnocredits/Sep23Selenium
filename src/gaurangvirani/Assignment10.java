/*- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- Checkboxes and radios - Select multiple checkboxes*/

package gaurangvirani;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment10 {

	WebDriver driver;
	
	void chrome() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/index.html");
	}
	
	void waitABit() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void checkBox() {
		chrome();
		waitABit();
		driver.findElement(By.id("basicelements")).click();
		waitABit();
		
		System.out.println("Select first two checkboxes");
		WebElement checkbox1 = driver.findElement(By.xpath("//div[@class='col-lg-10']/div[@class='checkbox'][1]//input"));
		WebElement checkbox2 = driver.findElement(By.xpath("//div[@class='col-lg-10']/div[@class='checkbox'][2]//input"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", checkbox1);
		
		checkbox1.click();
		checkbox2.click();
		
		if(checkbox1.isSelected() && checkbox2.isSelected()) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test fail");
		}
		
		System.out.println("Select last three checkboxes");
		WebElement checkbox3 = driver.findElement(By.xpath("//div[@class='col-lg-10']/label[@class='checkbox-inline'][1]/input"));
		WebElement checkbox4 = driver.findElement(By.xpath("//div[@class='col-lg-10']/label[@class='checkbox-inline'][2]/input"));
		WebElement checkbox5 = driver.findElement(By.xpath("//div[@class='col-lg-10']/label[@class='checkbox-inline'][3]/input"));
		checkbox3.click();
		checkbox4.click();
		checkbox5.click();
		
		if(checkbox3.isSelected() && checkbox4.isSelected() && checkbox5.isSelected()) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		driver.close();
	}
	
	public static void main(String[] args) {
		new Assignment10().checkBox();
	}
		
}












