package technocredits.elementMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import technocredits.actionsDemo.LaunchChromeBrowser;

public class IsDisplayDemo {
	
	@Test
	public void isDisplayed() throws InterruptedException {
		WebDriver driver = LaunchChromeBrowser.launchBrowser("file:///C:/Users/harsh/Downloads/Enable_And_Disable_&_Display_&_Hide%20(1).html");
		WebElement visibleToggle = driver.findElement(By.xpath("//button[text()='Visiable & Hidden Button']"));
		WebElement techElement = driver.findElement(By.xpath("//div[@id='myDIV']"));
	
		Thread.sleep(2000);
		System.out.println("Element is visible : "+techElement.isDisplayed());
		visibleToggle.click();
		Thread.sleep(2000);
		System.out.println("Element is visible : "+techElement.isDisplayed());
		Thread.sleep(2000);
		driver.quit();
	}

}
