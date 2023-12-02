/*Assignment 16: Actions scenario: mouse hover on each section & print the total number of option available in it 
1. navigate to flipkart
2. mouse hover on each item 
3. print the values of each section*/
package shrutika;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment16 {
	WebDriver driver;
	Actions action;

	@BeforeClass
	void launchChrome() {
		System.out.println("Step 1 : Launch Chrome Browser ");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		System.out.println("Launch Chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	void setUp() {
		System.out.println("Step 2 : Navigate URL");
		String url = "https://www.flipkart.com/";
		driver.navigate().to(url);
	}

	void hoverOn(WebElement e) {
		action.moveToElement(e).build().perform();
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='_16rZTH']/object/a"));
		printOptions(list);
		action.moveToElement(driver.findElement(By.xpath("//picture[@title='Flipkart']"))).build().perform();
	}

	void printOptions(List<WebElement> list) {
		int listSize = list.size();
		if (listSize > 0) {
			System.out.println("This section have " + listSize + " options:");
			for (WebElement e : list) {
				System.out.print(e.getText());
				System.out.print(", ");
			}
			System.out.println("");
		} else {
			System.out.println("No options in this section");
		}
	}

	@Test
	void findDropdownMenuItems() {

		System.out.println("Step : Close the Flipkart Login Popup");
		driver.findElement(By.xpath("//span[@role='button']")).click();

		action = new Actions(driver);
		System.out.println("Step : Print options available in each section");
		System.out.println("\n" + "Grocery:");
		hoverOn(driver.findElement(By.xpath("//span[text()='Grocery']")));

		System.out.println("\n" + "Mobiles:");
		hoverOn(driver.findElement(By.xpath("//span[text()='Mobiles']")));

		System.out.println("\n" + "Fashion:");
		hoverOn(driver.findElement(By.xpath("//span[text()='Fashion']")));

		System.out.println("\n" + "Electonics:");
		hoverOn(driver.findElement(By.xpath("//span[text()='Electronics']")));

		System.out.println("\n" + "Home & Furniture:");
		hoverOn(driver.findElement(By.xpath("//span[text()='Home & Furniture']")));

		System.out.println("\n" + "Appliances:");
		hoverOn(driver.findElement(By.xpath("//span[text()='Appliances']")));

		System.out.println("\n" + "Travel:");
		hoverOn(driver.findElement(By.xpath("//span[text()='Travel']")));

		System.out.println("\n" + "Beauty, Toys & More:");
		hoverOn(driver.findElement(By.xpath("//span[text()='Beauty, Toys & More']")));

		System.out.println("\n" + "Two Wheelers:");
		hoverOn(driver.findElement(By.xpath("//span[text()='Two Wheelers']")));
	}

	@AfterMethod
	void close() {
		System.out.println("\n Step: browser close");
		driver.close();
	}
}
