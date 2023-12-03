package technocredits.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ScrollTest {

	WebDriver driver;

	void setUp(String url) {
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();// Launch Chrome Browser

		System.out.println("STEP - Maximize browser");
		driver.manage().window().maximize();

		System.out.println("STEP - Navigate to URL");
		driver.get(url);
	}

	void waitABit(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void verifySingleSelectDropDown() {
		setUp("http://automationbykrishna.com");
		System.out.println("STEP - Navigate to BasicElements page");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		//waitABit(3000);

		/*
		 * WebElement e = driver.findElement(By.
		 * xpath("//form[@class='form-horizontal adminex-form']//select[1]")); Select
		 * valueSelect = new Select(e); valueSelect.selectByIndex(2);
		 */

		//WebElement e = driver.findElement(By.xpath("//input[@id='optionsRadios2']"));
		//System.out.println(e.isDisplayed());
		
		/*
		 * JavascriptExecutor js = (JavascriptExecutor)driver;
		 * js.executeScript("arguments[0].scrollIntoView(true)", e);
		 */
		
		//System.out.println(e.isDisplayed());
		//e.click();
		
		WebElement e = driver.findElement(By.xpath("//textarea"));
		e.sendKeys("fkjdfa fljasdkf jhafkj asdhf akjdfskfa");
	}

	public static void main(String[] args) {
		new ScrollTest().verifySingleSelectDropDown();
	}
}
