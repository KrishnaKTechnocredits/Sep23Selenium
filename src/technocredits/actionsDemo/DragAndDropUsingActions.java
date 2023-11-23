package technocredits.actionsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropUsingActions {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = LaunchChromeBrowser.launchBrowser("https://jqueryui.com/droppable/");

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		Thread.sleep(3000);
		
		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));

		Actions actions = new Actions(driver);
//		actions.dragAndDrop(source, target).perform();//Option 1
		actions.clickAndHold(source).moveToElement(target).release().build().perform();
		
		Thread.sleep(5000);
		driver.quit();

	}
}
