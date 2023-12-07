/*Assignment31:

1. complete the TC3 from below sheet
https://docs.google.com/spreadsheets/d/1XAsOC5KFoI_AOnB9Zwn4AvSSU0pHXyGgoCexc8Pt-HE/edit#gid=0
*/

package jaykumar;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment31 {
	WebDriver driver;
	
	@BeforeMethod
	void setUp(){
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	void loginTestCase() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/client/");
		
		System.out.println("STEP - Enter user details and Login");
		driver.findElement(By.id("userEmail")).sendKeys("bankarjaykumar@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Jay@131197");
		driver.findElement(By.id("login")).click();
		
		System.out.println("STEP - Find count of results before applying filter");
		int countBefore = driver.findElements(By.xpath("//div[@class = 'card']")).size();
		System.out.println("Count before filter: "+countBefore);
		
		System.out.println("STEP - Apply 'Electronics' filter");
		driver.findElement(By.xpath("//section//h6[text()='Categories']/parent::div//label[text()= 'electronics']/preceding-sibling::input")).click();
		
		Thread.sleep(2000);
		System.out.println("STEP - Find count of results after applying filter");
		int countAfter = driver.findElements(By.xpath("//div[@class = 'card']")).size();
		System.out.println("Count after filter: "+countAfter);
		
		System.out.println("VERIFY - Filter applied successfully");
		Assert.assertTrue(countBefore!=countAfter);
		
		System.out.println("STEP - Close browser");
		driver.close();
		
	}		
}
