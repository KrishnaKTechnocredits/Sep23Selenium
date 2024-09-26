package nikita;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

WebDriver driver;
	
	void setup(String url) {
		System.out.println("Launch url");
		System.setProperty("webdriver.chrome.driver",".\\chromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void scrollDown() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)", " ");
		
	}
	

	void scrollToElement(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
	}
	
	
	void testcase() {
		setup("http://automationbykrishna.com/");
		System.out.println("Click on basic elements");
		WebElement basicelement=driver.findElement(By.id("basicelements"));
		basicelement.click();
		sleep(3000);
		WebElement radiobutton4=driver.findElement(By.id("optionsRadios2"));
		scrollToElement(radiobutton4);
		radiobutton4.click();
		System.out.println("Verify if radio button is selected");
		if(radiobutton4.isSelected()) {
			System.out.println("Test case passed");
		}else {
			System.out.println("Test case failed");
		}
		WebElement checkbox2= driver.findElement(By.id("inlineCheckbox2"));
		checkbox2.click();
		System.out.println("Verify if checkbox is selected");
		if(checkbox2.isSelected()) {
			System.out.println("Test case passed");
		}else {
			System.out.println("Test case failed");
		}
		
	}
	
	public static void main(String[] args) {
		Assignment7 assignment7= new Assignment7();
		assignment7.testcase();
	}
}
