/*1. Complete the TC 3 from the sheet
2.  practice the [parent, css basic, following-sibling, preceing-sibling, parent, Index based css] on automation by krishna*/
package shrutika;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Assignment31 {

	WebDriver driver;
	@BeforeMethod
	void setup() {
		System.out.println("STEP: Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("STEP: Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("STEP: Open given URL");
		driver.get("https://rahulshettyacademy.com/client/");
	}

	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyLogin() {
		
		System.out.println("STEP: Entered Email address");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("shrutikad905@gmail.com");

		System.out.println("STEP: Entered Password");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Shrutika@123");

		System.out.println("STEP: Clicked on Login Button");
		driver.findElement(By.xpath("//input[@id='login']")).click();

		System.out.println("STEP: Collected before filter count");
		sleep(3000);
		int beforeFilter = driver.findElements(By.xpath("//img[@class='card-img-top']")).size();

		System.out.println("STEP: Selected eletronics under categories");
		driver.findElement(By.xpath(
				"//section//h6[text()='Categories']/parent::div//div[@class='form-group ng-star-inserted']/label[text()='electronics']/preceding-sibling::input"))
				.click();

		System.out.println("STEP: Collected after filter count");
		sleep(3000);
		int afterFilter = driver.findElements(By.xpath("//div[@class='card']")).size();
		if (beforeFilter != afterFilter) {
			System.out.println("VERIFY: Filter applied");
			System.out.println("Test case Passed!");
		} else {
			System.out.println("Test case Failed!");
		}
	}

	void close() {
		System.out.println("Step : Close browser");
		driver.close();
	}
}
