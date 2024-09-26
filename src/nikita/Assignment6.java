package nikita;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {
	
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
		js.executeScript("window.scrollBy(0,350)", " ");
		
	}
	
	void handleacceptAlert(String message) {
		Alert alert=driver.switchTo().alert();
		alert.sendKeys(message);
		alert.accept();
		WebElement actualtxt= driver.findElement(By.id("pgraphdemo"));
		String afterAcceptpromtText=actualtxt.getText();
		System.out.println(afterAcceptpromtText);
		if(message.equals(afterAcceptpromtText)) {
			System.out.println("Test case passed");
		}else {
			System.out.println("Test case failed");
		}
	}
	
	void handledeclineAlert(String message) {
		Alert alert=driver.switchTo().alert();
		alert.sendKeys(message);
		alert.dismiss();
		WebElement actualdeclinetxt= driver.findElement(By.id("pgraphdemo"));
		String afterdeclinepromtText=actualdeclinetxt.getText();
		if(message.equals(afterdeclinepromtText)) {
			System.out.println("Test case passed");
		}else {
			System.out.println("Test case failed");
		}	
	}
		
	void testcases(String name) {
		setup("http://automationbykrishna.com/");
		System.out.println("Click on basic elements");
		WebElement basicelement=driver.findElement(By.id("basicelements"));
		basicelement.click();
		sleep(3000);
		scrollDown();
		sleep(2000);
		WebElement javascriptpromptbutton= driver.findElement(By.id("javascriptPromp"));
		javascriptpromptbutton.click();
		handleacceptAlert("Hello" +name+ "How are you today?");
		sleep(2000);
		javascriptpromptbutton.click();
		handledeclineAlert("User cancelled the prompt.");	
	}
	
	public static void main(String[] args) {
		Assignment6 assignment6= new Assignment6();
		assignment6.testcases("Nikita");
	}
}
