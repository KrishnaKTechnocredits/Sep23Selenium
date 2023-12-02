//
//Assignment 16: Actions 
//scenario: mouse hover on each section & print the total number of option available in it
//
//1. navigate to flipkart
//	2. mouse hover on each item
//3. print the values of each section

package pushpag;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment16 {
	WebDriver driver;

	@BeforeMethod
	public void setBrowser() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
	}

	public void wait(int mSecs) {
		try {
			Thread.sleep(mSecs);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void hoverCheck() {
		wait(5000);
		driver.findElement(By.xpath("//span[@role='button']")).click();

		WebElement hoverTwoWheelers = driver.findElement(By.xpath("//div[@aria-label='Two Wheelers']"));
		System.out.println("*****TWO WHEELERS*****");
		hoverStep(hoverTwoWheelers);

		WebElement hoverBeautyToys = driver.findElement(By.xpath("//div[@aria-label='Beauty, Toys & More']"));
		System.out.println("*****BEAUTY, TOYS & MORE*****");
		hoverStep(hoverBeautyToys);

		WebElement hoverFashion = driver.findElement(By.xpath("//div[@aria-label='Fashion']"));
		System.out.println("*****FASHION*****");
		hoverStep(hoverFashion);


		WebElement hoverElectronics = driver.findElement(By.xpath("//div[@aria-label='Electronics']"));
		System.out.println("*****ELECTRONICS*****");
		hoverStep(hoverElectronics);

		WebElement hoverHomeFurniture = driver.findElement(By.xpath("//div[@aria-label='Home & Furniture']"));
		System.out.println("*****HOME & FURNITURE*****");
		hoverStep(hoverHomeFurniture);

	}

	public void hoverStep(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		wait(3000);
		List<WebElement> list = driver.findElements(By.xpath("//object//a"));
		printValues(list);
	}

	public void printValues(List<WebElement> list) {
		int listSize = list.size();
		if (listSize > 0) {
			for (WebElement l : list) {
				String str = l.getText();
				System.out.println(str);
			}
		}
	}

	@AfterMethod
	public void closeDriver() {
		driver.close();
	}
}