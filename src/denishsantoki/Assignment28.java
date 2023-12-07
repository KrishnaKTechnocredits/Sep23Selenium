/*1. Perform isDisplayed on amazon/flipkart

----------------------
1. Perform isEnabled on the HTML form

----------------------
Multi Window Handling

1. Goto Flipkart/Amazon
2. search for the product
3. click on the first result
4. now switch to product page & print the title of the product
*/
package denishsantoki;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Assignment28 {
	
	WebDriver driver;
	WebDriverWait wait;

	public void launchBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 10);
		driver.get(url);
	}
	
	@Test
	public void isDisplayedAmazon() {
		launchBrowser("https://www.amazon.in/");
		WebElement element = driver.findElement(By.xpath("//input[@id='unifiedLocation1ClickAddress']"));
		System.out.println(element.isDisplayed());
		driver.close();
	}
	
	@Test
	public void isDisplayedHTMLForm() {
		launchBrowser("C://Users//DELL//Pictures//Screenshots/Enable_And_Disable_&_Display_&_Hide (1).html");
		WebElement element = driver.findElement(By.xpath("//div[@id='myDIV']"));

		driver.findElement(By.xpath("//button[@onclick = 'myFunction()']")).click();
		boolean isVisible = element.isDisplayed();
		
		if (isVisible) {
			System.out.println(isVisible + ": Element is visible");
		} else
			System.out.println(isVisible + ": Element is not visible");

		driver.close();
	}
	
	@Test
	public void isEnabled() {
		launchBrowser("C://Users//DELL//Pictures//Screenshots/Enable_And_Disable_&_Display_&_Hide (1).html");
		WebElement element = driver.findElement(By.xpath("//input[@id='myText']"));
		System.out.println(element.isEnabled() + ": Text field  is enable and value can be entered!");
		element.sendKeys("SUCCESS");
		driver.findElement(By.xpath("//button[@onclick = 'disable()']")).click();
		System.out.println(element.isEnabled() + ": Text field is disable");

		driver.close();
	}
	
	@Test
	public void windowhandleAmazon() throws InterruptedException {
		launchBrowser("https://www.amazon.in/");
		String mainWindow = driver.getWindowHandle();
		String titleMain = driver.getTitle();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone");
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='iphone 15 pro max']"))).click();
		driver.findElement(By.xpath("//div[@class='aok-relative']")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		String titleChild = null;
		for (String window : windowHandles) {
			if (!mainWindow.equals(window)) {
				driver.switchTo().window(window);
				titleChild = driver.getTitle();
			}
		}
		System.out.println("Main Window Title: " + titleMain);
		System.out.println("Child Window Title: " + titleChild);

		driver.quit();
	}

}
