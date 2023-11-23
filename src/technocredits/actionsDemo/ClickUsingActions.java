package technocredits.actionsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClickUsingActions {

	public static void main(String[] args) {
		WebDriver driver = LaunchChromeBrowser.launchBrowser("http://automationbykrishna.com/index.html");
	
		WebElement demoTable = driver.findElement(By.xpath("//a[@id='demotable']"));
				
		Actions actions = new Actions(driver);
		actions.click(demoTable).perform();	
	
	}
}
