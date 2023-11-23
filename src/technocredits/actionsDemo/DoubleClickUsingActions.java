package technocredits.actionsDemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickUsingActions {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = LaunchChromeBrowser.launchBrowser("http://automationbykrishna.com/index.html");
	
		WebElement basicElement = driver.findElement(By.xpath("//a[@id='basicelements']"));
				
		
		Actions actions = new Actions(driver);
		actions.click(basicElement).perform();
		
		Thread.sleep(2000);
		WebElement doubleClickElement = driver.findElement(By.xpath("//a[@ondblclick='doubleClick()']"));

		scrollFunction(driver,doubleClickElement);
		
		actions.doubleClick(doubleClickElement).perform();//Double Click
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
	}
	
	public static void scrollFunction(WebDriver dr, WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
	}
}
