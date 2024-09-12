package nikita;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {

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
	
		void testcase() {
			System.out.println("Click on basic elements");
			WebElement basicelement=driver.findElement(By.id("basicelements"));
			basicelement.click();
			sleep(4000);
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)", "");	
			WebElement javascriptconfirmationbutton=driver.findElement(By.id("javascriptConfirmBox"));
			javascriptconfirmationbutton.click();
			Alert alert= driver.switchTo().alert();
			alert.accept();
			String expacceptalert="You pressed OK!";
			WebElement acceptalertbutton=driver.findElement(By.xpath("//p[text()='You pressed OK!']"));
			String afteracceptbuttontext=acceptalertbutton.getText();
			System.out.println(acceptalertbutton);
			if(afteracceptbuttontext.equals(expacceptalert)) {
				System.out.println("Test case passed");
			}else {
				System.out.println("Test case failed");
			}
			javascriptconfirmationbutton.click();
			alert.dismiss();
			String expdeclinealert="You pressed Cancel!";
			WebElement declinealertbutton=driver.findElement(By.xpath("//p[text()='You pressed Cancel!']"));
			String afterdeclinebuttontext=declinealertbutton.getText();
			if(expdeclinealert.equals(afterdeclinebuttontext)) {
				System.out.println("test case passed");
			}else {
				System.out.println("test case failed");
			}
			
		}
	public static void main(String[] args) {
		Assignment5 assignment5=new Assignment5();
		assignment5.setup("http://automationbykrishna.com/");
		assignment5.testcase();
	}
		
	}

