package technocredits.elementMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import technocredits.actionsDemo.LaunchChromeBrowser;

public class IsEnabledDemo {

	@Test
	public void isDisplayed() throws InterruptedException {
		WebDriver driver = LaunchChromeBrowser
				.launchBrowser("file:///C:/Users/harsh/Downloads/Enable_And_Disable_&_Display_&_Hide%20(1).html");
		WebElement toggle = driver.findElement(By.xpath("//button[text()='Enable & Disable Button']"));
		WebElement inputElement = driver.findElement(By.xpath("//input[@id='myText']"));

		Thread.sleep(2000);
		System.out.println("Element is enabled : " + inputElement.isEnabled());
		inputElement.sendKeys("harsh");
		toggle.click();
		Thread.sleep(2000);
		if (inputElement.isEnabled())
			inputElement.sendKeys("vegada");
		System.out.println("Element is enabled : " + inputElement.isEnabled());
		Thread.sleep(2000);
		driver.quit();

	}

}
