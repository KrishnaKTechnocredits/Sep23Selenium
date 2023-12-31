/* Actions 
scenario: mouse hover on each section & print the total number of option available in it
1. navigate to flipkart
2. mouse hover on each item
3. print the values of each section */

package sayali;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment16 {
	WebDriver driver;

	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Testing_Class Sayali\\JavaProject\\Sep23Selenium\\src\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
	}

	public void tempWait(int mSecs) {
		try {
			Thread.sleep(mSecs);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void mHoverCheck() {
		tempWait(4000);
		driver.findElement(By.xpath("//span[@role='button']")).click();

		WebElement hoverFashion = driver.findElement(By.xpath("//div[@aria-label='Fashion']"));
		System.out.println("\nFASHION");
		mhoverStep(hoverFashion);

		WebElement hoverTwoWheelers = driver.findElement(By.xpath("//div[@aria-label='Two Wheelers']"));
		System.out.println("TWO WHEELERS");
		mhoverStep(hoverTwoWheelers);

		WebElement hoverGrocery = driver.findElement(By.xpath("//a[@aria-label='Grocery']"));
		System.out.println("\nGROCERY");
		mhoverStep(hoverGrocery);

		WebElement hoverBeautyToys = driver.findElement(By.xpath("//div[@aria-label='Beauty, Toys & More']"));
		System.out.println("\nBEAUTY, TOYS & MORE");
		mhoverStep(hoverBeautyToys);

		WebElement hoverMobiles = driver.findElement(By.xpath("//a[@aria-label='Mobiles']"));
		System.out.println("\nMOBILES");
		mhoverStep(hoverMobiles);

		WebElement hoverAppliances = driver.findElement(By.xpath("//a[@aria-label='Appliances']"));
		System.out.println("\nAPPLIANCES");
		mhoverStep(hoverAppliances);
		tempWait(3000);

		WebElement hoverElectronics = driver.findElement(By.xpath("//div[@aria-label='Electronics']"));
		System.out.println("\nELECTRONICS");
		mhoverStep(hoverElectronics);

		WebElement hoverTravel = driver.findElement(By.xpath("//a[@aria-label='Travel']"));
		System.out.println("\nTRAVEL");
		mhoverStep(hoverTravel);

		WebElement hoverHomeFurniture = driver.findElement(By.xpath("//div[@aria-label='Home & Furniture']"));
		System.out.println("\nHOME & FURNITURE");
		mhoverStep(hoverHomeFurniture);
	}

	public void mhoverStep(WebElement element) {
		tempWait(4000);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		tempWait(3000);
		List<WebElement> list = driver.findElements(By.xpath("//object//a"));
		printValues(list);
	}

	public void printValues(List<WebElement> list) {
		int listSize = list.size();
		System.out.println("Size of the List -> " + listSize);
		if (listSize > 0) {
			for (WebElement l : list) {
				String str = l.getText();
				System.out.println(str);
			}
		} else
			System.out.println("*NO OPTIONS AVAILABLE*");
	}

	@AfterClass
	void closeBrowser() {
		System.out.println("Close browser window");
		driver.close();
	}
}