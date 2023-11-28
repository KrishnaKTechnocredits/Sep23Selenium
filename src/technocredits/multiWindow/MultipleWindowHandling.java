package technocredits.multiWindow;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import technocredits.actionsDemo.LaunchChromeBrowser;

public class MultipleWindowHandling {

	@Test
	public void isDisplayed() throws InterruptedException {
		WebDriver driver = LaunchChromeBrowser.launchBrowser("https://www.amazon.in/");
		System.out.println(driver.getTitle());
		
	
		Thread.sleep(10000);
		

		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("tv");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
			
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//div[@data-cel-widget='search_result_2']//img")).click();
		String mainWindow = driver.getWindowHandle();
		Set<String> multiWind = driver.getWindowHandles();
		
		for(String currentWind : multiWind) {
			if(!mainWindow.equals(currentWind)) {
				driver.switchTo().window(currentWind);
				System.out.println(driver.getTitle());
			}
		}

		Thread.sleep(5000);
		driver.quit();

	}

}
