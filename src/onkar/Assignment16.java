/*scenario: mouse hover on each section & print the total number of option available in it

1. navigate to flipkart
2. mouse hover on each item
3. print the values of each section*/

package onkar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment16 {
	
	WebDriver driver;

	void setup(String url) {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();

		System.out.println("Open given URL");
		driver.get(url);
	}

	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void hoverOn(WebElement e) {
		Actions action = new Actions(driver);
		sleep(1000);
		action.moveToElement(e).build().perform();
		List<WebElement> list = driver.findElements(By.xpath("//object//a"));
		sleep(1000);
		printValues(list);
		action.moveToElement(driver.findElement(By.xpath("//picture[@title='Flipkart']"))).build().perform();
		sleep(100);
	}
	
	void printValues(List<WebElement> list) {
		int listSize = list.size();
		System.out.println("Current elements is having "+listSize+" values in dropdown");
		if(listSize > 0) {
			for (WebElement e: list) {
				System.out.print(e.getText());
				System.out.print(", ");
			}
			System.out.println("");
		}else {
			System.out.println("---No options in this menu item---");
		}
	}
	
	void findDropdownMenuItems() {
		setup("https://www.flipkart.com/");

		System.out.println("Close the Flipkart Login Popup");
		sleep(3000);
		driver.findElement(By.xpath("//span[@role='button']")).click();
		sleep(500);
		
		System.out.println("\n"+"--> Grocery");
		hoverOn(driver.findElement(By.xpath("//span[text()='Grocery']")));
		
		System.out.println("\n"+"--> Mobiles");
		hoverOn(driver.findElement(By.xpath("//span[text()='Mobiles']")));
		
		System.out.println("\n"+"--> Fashion");
		hoverOn(driver.findElement(By.xpath("//span[text()='Fashion']")));
		
		System.out.println("\n"+"--> Electonics");
		hoverOn(driver.findElement(By.xpath("//span[text()='Electronics']")));
		
		System.out.println("\n"+"--> Home & Furniture");
		hoverOn(driver.findElement(By.xpath("//span[text()='Home & Furniture']")));
		
		System.out.println("\n"+"--> Appliances");
		hoverOn(driver.findElement(By.xpath("//span[text()='Appliances']")));
		
		System.out.println("\n"+"-->Travel");
		hoverOn(driver.findElement(By.xpath("//span[text()='Travel']")));
		
		System.out.println("\n"+"-->Beauty, Toys & More");
		hoverOn(driver.findElement(By.xpath("//span[text()='Beauty, Toys & More']")));
		
		System.out.println("\n"+"--> Two Wheelers");
		hoverOn(driver.findElement(By.xpath(" //span[text()='Two Wheelers']")));
		
		System.out.println("\n"+"Closed the browser");
		driver.close();
	}
	
	public static void main(String[] args) {
		new Assignment16().findDropdownMenuItems();
	}
}
