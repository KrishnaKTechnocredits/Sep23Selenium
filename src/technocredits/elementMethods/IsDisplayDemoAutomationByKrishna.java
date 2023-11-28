package technocredits.elementMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import technocredits.actionsDemo.LaunchChromeBrowser;

public class IsDisplayDemoAutomationByKrishna {

	@Test
	public void isDisplayed() throws InterruptedException {
		WebDriver driver = LaunchChromeBrowser.launchBrowser("http://automationbykrishna.com/#");
		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(2000);
		WebElement doubleCLick = driver.findElement(By.xpath("//a[text()='Double-click on me']"));
		System.out.println("Double visible: "+ doubleCLick.isDisplayed());
	}

}
