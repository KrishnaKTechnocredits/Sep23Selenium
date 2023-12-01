package akshitak;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assignment16 {
	WebDriver driver;

	@BeforeClass
	void luanchChrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Technocresdits\\Sep2023\\Chrome_Driver\\chromedriver.exe");
		System.out.println("Luanch Chrome");
		driver = new ChromeDriver();
		System.out.println("Maximize window");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Get URL");
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//span[@role='button']")).click();
	}
	
//	@Test (priority = 1)
	void hover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		
	}

	@Test (priority = 2)
	void hoveraGetList() {
		System.out.println("No Section List Available");
		List<WebElement> list =driver.findElements(By.xpath("//div[@class='_3sdu8W emupdz']/a"));
		for(WebElement name: list) {
			hover(name);
			System.out.println(name.getText());
		}	
	}
	
	@Test (priority = 3)
	void hoverList() {
		System.out.println("Section with list :");
		int count = driver.findElements(By.xpath("//div[@class='_3sdu8W emupdz']/div")).size();
		for(int index=count;index>=0;index--) {
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='_3sdu8W emupdz']/div["+index+"]"));
			
			for(WebElement name : list) {
				System.out.println("List of  " + name.getText()+ "=>");
				hover(name);
					List<WebElement> sectionList = driver.findElements(By.xpath("//div[@class='_1UgUYI _2eN8ye']/div/object/a"));
					for(WebElement name1:sectionList) {
						System.out.println(name1.getText());		
				}	
			}
			hover(driver.findElement(By.xpath("//picture[@title='Flipkart']")));
		}	
	}

	@AfterClass
	void tearDown() {
		driver.quit();
	}
}
