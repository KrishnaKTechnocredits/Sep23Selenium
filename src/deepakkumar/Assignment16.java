/*
 * Assignment 16: Actions 
scenario: mouse hover on each section & print the total number of option available in it

1. navigate to flipkart
2. mouse hover on each item
3. print the values of each section

 */
package deepakkumar;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Assignment16 {
	WebDriver dr;

	public void launchBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get(url);
	}

	public void tempWait(int mSecs) {
		try {
			Thread.sleep(mSecs);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void hoverCheck() {
		launchBrowser("https://www.flipkart.com/");
		tempWait(5000);
		dr.findElement(By.xpath("//span[@role='button']")).click();

		WebElement hoverTwoWheelers = dr.findElement(By.xpath("//div[@aria-label='Two Wheelers']"));
		System.out.println("---TWO WHEELERS---");
		hoverStep(hoverTwoWheelers);

		WebElement hoverGrocery = dr.findElement(By.xpath("//a[@aria-label='Grocery']"));
		System.out.println("---GROCERY---");
		hoverStep(hoverGrocery);

		WebElement hoverBeautyToys = dr.findElement(By.xpath("//div[@aria-label='Beauty, Toys & More']"));
		System.out.println("---BEAUTY, TOYS & MORE---");
		hoverStep(hoverBeautyToys);

		WebElement hoverMobiles = dr.findElement(By.xpath("//a[@aria-label='Mobiles']"));
		System.out.println("---MOBILES---");
		hoverStep(hoverMobiles);

		WebElement hoverFashion = dr.findElement(By.xpath("//div[@aria-label='Fashion']"));
		System.out.println("---FASHION---");
		hoverStep(hoverFashion);

		WebElement hoverAppliances = dr.findElement(By.xpath("//a[@aria-label='Appliances']"));
		System.out.println("---APPLIANCES---");
		hoverStep(hoverAppliances);
		tempWait(3000);

		WebElement hoverElectronics = dr.findElement(By.xpath("//div[@aria-label='Electronics']"));
		System.out.println("---ELECTRONICS---");
		hoverStep(hoverElectronics);

		WebElement hoverTravel = dr.findElement(By.xpath("//a[@aria-label='Travel']"));
		System.out.println("---TRAVEL---");
		hoverStep(hoverTravel);

		WebElement hoverHomeFurniture = dr.findElement(By.xpath("//div[@aria-label='Home & Furniture']"));
		System.out.println("---HOME & FURNITURE---");
		hoverStep(hoverHomeFurniture);

	}

	public void hoverStep(WebElement element) {
		Actions action = new Actions(dr);
		action.moveToElement(element).build().perform();
		tempWait(3000);
		List<WebElement> list = dr.findElements(By.xpath("//object//a"));
		printValues(list);
	}

	public void printValues(List<WebElement> list) {
		int listSize = list.size();
		System.out.println("Size of the List -> "+listSize);
		if (listSize > 0) {
			for (WebElement l : list) {
				String str = l.getText();
				System.out.println(str);
			}
		} else
			System.out.println("***NO OPTIONS AVAILABLE***");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assignment16 output = new Assignment16();
		output.hoverCheck();
	}
}
