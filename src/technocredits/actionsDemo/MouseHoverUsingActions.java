package technocredits.actionsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverUsingActions {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = LaunchChromeBrowser.launchBrowser("https://www.flipkart.com/");
	
		Thread.sleep(3000);
		
		try {
			driver.findElement(By.xpath("//span[@role='button']")).click();
		}catch(NoSuchElementException e) {
			
		}
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//span[text()='Electronics']"))).perform();
		
		Thread.sleep(3000);
		driver.quit();
	
	}
}
