/*scenario: mouse hover on each section & print the total number of option available in it
1. navigate to flipkart
2. mouse hover on each item
3. print the values of each section*/

package roshnikolhe;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment16 {
	WebDriver driver;
	Actions action;

	void setUp(String url){
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("STEP - Launch: "+url);
		driver.get(url);
	}

	void waitABit(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void hoverOn(WebElement e) {
		action.moveToElement(e).build().perform();
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='_16rZTH']/object/a"));
		printOptions(list);
		action.moveToElement(driver.findElement(By.xpath("//picture[@title='Flipkart']"))).build().perform();
	}

	void printOptions(List<WebElement> list) {
		int listSize = list.size();
		if(listSize > 0) {
			System.out.println("This section have "+listSize+" options:");
			for (WebElement e: list) {
				System.out.print(e.getText());
				System.out.print(", ");
			}
			System.out.println("");
		}else {
			System.out.println("---No options in this section---");
		}
	}

	void findDropdownMenuItems() {
		setUp("https://www.flipkart.com/");

		System.out.println("STEP - Close the Flipkart Login Popup");
		driver.findElement(By.xpath("//span[@role='button']")).click();
		waitABit(1000);

		action = new Actions(driver);
		System.out.println("STEP - Print options available in each section");
		System.out.println("\n"+"Grocery:");
		hoverOn(driver.findElement(By.xpath("//span[text()='Grocery']")));

		System.out.println("\n"+"Mobiles:");
		hoverOn(driver.findElement(By.xpath("//span[text()='Mobiles']")));

		System.out.println("\n"+"Fashion:");
		hoverOn(driver.findElement(By.xpath("//span[text()='Fashion']")));

		System.out.println("\n"+"Electonics:");
		hoverOn(driver.findElement(By.xpath("//span[text()='Electronics']")));

		System.out.println("\n"+"Home & Furniture:");
		hoverOn(driver.findElement(By.xpath("//span[text()='Home & Furniture']")));

		System.out.println("\n"+"Appliances:");
		hoverOn(driver.findElement(By.xpath("//span[text()='Appliances']")));

		System.out.println("\n"+"Travel:");
		hoverOn(driver.findElement(By.xpath("//span[text()='Travel']")));

		System.out.println("\n"+"Beauty, Toys & More:");
		hoverOn(driver.findElement(By.xpath("//span[text()='Beauty, Toys & More']")));

		System.out.println("\n"+"Two Wheelers:");
		hoverOn(driver.findElement(By.xpath("//span[text()='Two Wheelers']")));

		System.out.println("\n"+"Closed the browser");
		driver.close();
	}

	public static void main(String[] args) {
		new Assignment16().findDropdownMenuItems();
	}
}