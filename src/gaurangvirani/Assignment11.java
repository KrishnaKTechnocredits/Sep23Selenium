/*- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- Checkboxes and radios - Select multiple checkboxes
- Checkboxes and radios - DesSelect atleast 1 checkboxes
- Get List of all selected checkboxes.*/

package gaurangvirani;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment11 {

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

		System.out.println("Select multiple options");
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", dropdown);
		
		waitABit();
		
		Select select = new Select(dropdown);
		
		for(int index = 0 ; index <4 ; index++) {
			select.selectByIndex(index);
		}
		
		select.deselectByIndex(1);
		
		System.out.println("Get List of all selected checkboxes");
		List<WebElement> list1 = select.getAllSelectedOptions();
		for(WebElement name1 : list1) {
			System.out.println(name1.getText() + " ");
		}
		
		driver.close();
	}
	public static void main(String[] args) {
		new Assignment11().checkBox();
	}
}
