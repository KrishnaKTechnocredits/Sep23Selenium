package nikita;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	WebDriver driver;
	
	void setup(String url) {
		System.out.println("Launch Browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);	
	}
	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void alertTestCase(String expectedtext) {
		System.out.println("Click on basic elements");
		WebElement basicelement=driver.findElement(By.id("basicelements"));
		basicelement.click();
		sleep(4000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");		
		WebElement alertbutton=driver.findElement(By.xpath("//button[text()='Alert']"));
		sleep(3000);
		alertbutton.click();
		Alert alert= driver.switchTo().alert();
		String actualalertmsg=alert.getText();
		if(actualalertmsg.contains(expectedtext)) {
			System.out.println("Test case passed");
		}
			else
				System.out.println("Test case failed");
		}
	
	public static void main(String[] args) {
		Assignment4 assignment4= new Assignment4();
		assignment4.setup("http://automationbykrishna.com/");
		assignment4.alertTestCase("TechnoCredits");
		
	}
}
