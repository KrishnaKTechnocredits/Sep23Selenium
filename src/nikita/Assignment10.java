package nikita;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment10 {

	WebDriver driver;
	
	void launchUrl() {
		System.setProperty("webdriver.chrome.driver",".\\chromeDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
	}
	
	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void scrollToElement(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
	}
	
	void checkboxesAndRadios() {
		sleep(3000);
		System.out.println("Click on basic elements");
		WebElement basicelement=driver.findElement(By.id("basicelements"));
		basicelement.click();
		sleep(3000);
		WebElement checkbox1=driver.findElement(By.xpath("//div[@class='col-lg-10']/div[1]//input[@type='checkbox']"));
		scrollToElement(checkbox1);
		checkbox1.click();
		if(checkbox1.isSelected()) {
			System.out.println("Test case passed");
		}else
			System.out.println("Test case failed");
		WebElement checkbox2=driver.findElement(By.xpath("//div[@class='col-lg-10']/div[2]//input[@type='checkbox']"));
		checkbox2.click();
		if(checkbox2.isSelected()) {
			System.out.println("Test case passed");
		}else
		{
			System.out.println("Test case failed");
		}
	}
	
	public static void main(String[] args) {
		Assignment10 assignment10= new Assignment10();
		assignment10.launchUrl();
		assignment10.checkboxesAndRadios();
	}
}
