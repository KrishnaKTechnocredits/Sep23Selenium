/* Actions scenario: mouse hover on each section & print the total number of option available in it

1. navigate to flipkart
2. mouse hover on each item
3. print the values of each section*/

package gaurangvirani;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment16 {

WebDriver driver;
	
	void chrome() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
	}
	
	void waitABit() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void printList() {
		chrome();
		waitABit();
		
		Actions actions = new Actions(driver);
		
		WebElement fashion = driver.findElement(By.xpath("//span[text()='Fashion']"));
		actions.moveToElement(fashion).build().perform();
		List<WebElement> listOfFashion = driver.findElements(By.xpath("//div[@class='_16rZTH']//a"));
		for(WebElement name : listOfFashion) {
			System.out.print(name.getText()+"  ");
		}
		System.out.println("");
		
		waitABit();
		
		WebElement grocery = driver.findElement(By.xpath("//span[text()='Grocery']"));
		actions.moveToElement(grocery).build().perform();
		
		waitABit();
		
		WebElement electronics = driver.findElement(By.xpath("//span[text()='Electronics']"));
		actions.moveToElement(electronics).build().perform();
		List<WebElement> listOfElectronics = driver.findElements(By.xpath("//div[@class='_16rZTH']//a"));
		for(WebElement name : listOfElectronics) {
			System.out.print(name.getText()+"  ");
		}
		System.out.println("");
		
		waitABit();
		
		WebElement mobiles = driver.findElement(By.xpath("//span[text()='Mobiles']"));
		actions.moveToElement(mobiles).build().perform();
		
		waitABit();
		
		WebElement home = driver.findElement(By.xpath("//span[text()='Home & Furniture']"));
		actions.moveToElement(home).build().perform();
		List<WebElement> listOfHome = driver.findElements(By.xpath("//div[@class='_16rZTH']//a"));
		for(WebElement name : listOfHome) {
			System.out.print(name.getText()+"  ");
		}
		System.out.println("");
		
		waitABit();
		
		WebElement appliances = driver.findElement(By.xpath("//span[text()='Appliances']"));
		actions.moveToElement(appliances).build().perform();
		
		waitABit();
		
		WebElement beauty = driver.findElement(By.xpath("//span[text()='Beauty, Toys & More']"));
		actions.moveToElement(beauty).build().perform();
		List<WebElement> listOfBeauty = driver.findElements(By.xpath("//div[@class='_16rZTH']//a"));
		for(WebElement name : listOfBeauty) {
			System.out.print(name.getText()+"  ");
		}
		System.out.println("");
		
		waitABit();
		
		WebElement travel = driver.findElement(By.xpath("//span[text()='Travel']"));
		actions.moveToElement(travel).build().perform();
		
		waitABit();
		
		WebElement twoWheelers = driver.findElement(By.xpath("//span[text()='Two Wheelers']"));
		actions.moveToElement(twoWheelers).build().perform();
		List<WebElement> listOfTwoWheelers = driver.findElements(By.xpath("//div[@class='_16rZTH']//a"));
		for(WebElement name : listOfTwoWheelers) {
			System.out.print(name.getText()+"  ");
		}
		driver.close();
	}
	
	public static void main(String[] args) {
		new Assignment16().printList();
	}
}













