package gaurangvirani;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment7 {

	WebDriver driver;
	
	void chrome() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		waitABit();
		driver.findElement(By.id("basicelements")).click();
	}
	
	void waitABit() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void scrollTillView() {
		chrome();
		waitABit();
		

		WebElement click4 = driver.findElement(By.id("optionsRadios2"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", click4);
		
		click4.click();
		if(click4.isSelected()) {
			System.out.println("4th Checkbox is selected");
		}else {
			System.out.println("Failed to select 4th checkbox");
		}
		
		waitABit();

		WebElement click2 = driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']//div[@class='checkbox'][2]//input"));
		js.executeScript("arguments[0].scrollIntoView(true)", click2);
		
		click2.click();
		if(click2.isSelected()) {
			System.out.println("2nd Checkbox is selected");
		}else {
			System.out.println("Failed to select 2nd radiobutton");
		}
		driver.close();
	}
	
	public static void main(String[] args) {
		new Assignment7().scrollTillView();
	}
}
