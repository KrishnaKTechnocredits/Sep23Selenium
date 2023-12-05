package technocredits.standaloneScripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import technocredits.actionsDemo.LaunchChromeBrowser;

public class TC5 {

	@Test
	public void verifyLogin() {
		WebDriver driver = LaunchChromeBrowser.launchBrowser("https://rahulshettyacademy.com/client/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("harshhpatel07@gmail.com");
		System.out.println("STEP: Entered Email address");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Hhv@123456");
		System.out.println("STEP: Entered Password");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		System.out.println("STEP: Clicked on Login Button");

		String productSelection = "iphone 13 pro";

		String locatorForAddToCart = String.format(
				"//h5//b[text()='%s']/parent::h5/following-sibling::button[contains(text(),'Add To Cart')]",
				productSelection);

		driver.findElement(By.xpath(locatorForAddToCart)).click();
		System.out.println("STEP: product added to cart");

		

		driver.findElement(By.xpath("//li//button[contains(text(),'Cart')]/i[@class='fa fa-shopping-cart']")).click();
		System.out.println("STEP: click on cart button");

		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		System.out.println("STEP: Clicked on checkout button");
		
		String attValue = driver.findElement(By.xpath("//input[@fdprocessedid='tvcpyb']")).getAttribute("value");
		if(attValue.length()==0) {
			driver.findElement(By.xpath("//input[@fdprocessedid='tvcpyb']")).sendKeys("4542 9846 7822 2293");
			System.out.println("STEP: User enter credit card number");
		}
		
		driver.findElement(By.xpath("//input[@fdprocessedid='avrrjy']")).sendKeys("896");
		
		driver.findElement(By.xpath("//input[@fdprocessedid='niftc4d']")).sendKeys("india");
		
		List<WebElement> listOfWebElements = driver.findElements(By.xpath("//section[@class='ta-results list-group ng-star-inserted']//button"));
		for(WebElement singleELement : listOfWebElements) {
			if(singleELement.getText().equalsIgnoreCase("india")) {
				singleELement.click();
			}
		}
		
//		driver.quit();
	}

}
