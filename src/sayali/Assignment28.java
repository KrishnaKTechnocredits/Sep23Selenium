/* 1. Perform isDisplayed on amazon/flipkart
----------------------
1. Perform isEnabled on the HTML form
----------------------
Multi Window Handling
1. Goto Flipkart/Amazon
2. search for the product
3. click on the first result
4. now switch to product page & print the title of the product */
package sayali;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment28 {

	WebDriver driver;

	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Testing_Class Sayali\\JavaProject\\Sep23Selenium\\src\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void isDisplayedAmazon() {
		setup();
		driver.get("https://www.amazon.in/");
		WebElement element = driver.findElement(By.xpath("//input[@id='unifiedLocation1ClickAddress']"));
		System.out.println(element.isDisplayed());
		driver.close();
	}

	@Test
	public void isDisplayedHTMLForm() {
		setup();
		driver.get("file:///C:/Users/Siddha/Downloads/Enable_And_Disable_&_Display_&_Hide%20(1).html");
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
		setup();
		driver.get("file:///C:/Users/Siddha/Downloads/Enable_And_Disable_&_Display_&_Hide%20(1).html");
		WebElement element = driver.findElement(By.xpath("//input[@id='myText']"));
		System.out.println(element.isEnabled() + ": Text field enabled, value can be entered!");
		element.sendKeys("SUCCESS");
		driver.findElement(By.xpath("//button[@onclick = 'disable()']")).click();
		System.out.println(element.isEnabled() + ": Text field disabled");
		driver.close();
	}

	@Test
	public void multiWindowHandled() throws InterruptedException {
		setup();
		driver.get("https://www.amazon.in/");
		String mainWindow = driver.getWindowHandle();
		String titleMain = driver.getTitle();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@aria-label='iphone 15 pro max']")).click();
		driver.findElement(By.xpath("//div[@class='aok-relative']")).click();

		Set<String> multiWindowHandles = driver.getWindowHandles();
		String titleChild = null;
		for (String window : multiWindowHandles) {
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