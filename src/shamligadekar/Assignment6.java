package shamligadekar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {

	WebDriver driver;
	
	void launchBrowser(String url) {
		System.out.println("STEP-Launch Browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println("STEP-Maximize Window");
		driver.manage().window().maximize();;
		
		System.out.println("STEP-Navigate to : "+url);
		driver.get(url);
	}
	
	void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void verifyJavascriptPrompt(String name, String action, String expectedpromptmessageText) {
		
		System.out.println("STEP - Click on Prompt");
		WebElement e=driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
		e.click();
		wait(3000);
		
		String promptmessageText="";
		System.out.println("STEP-Type Text in Prompt and accept");
		Alert alert= driver.switchTo().alert();
		if(action.equals("accept")) {
			alert.sendKeys(name);
			alert.accept();
			System.out.println("Verify alert after accept");
			promptmessageText=driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
			System.out.println("Test after accepting alert :"+promptmessageText);
		}
		else if(action.equals("dismiss")) {
			alert.dismiss();	
			System.out.println("Verify alert after dismiss");
			promptmessageText=driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
			System.out.println("Test after Dismissing alert :"+promptmessageText);
		}
		
		if(promptmessageText.equals(expectedpromptmessageText)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
	}
	
	void testCases() {
		launchBrowser("http://automationbykrishna.com/");
		System.out.println("STEP-Click on Basic Elements link");
		driver.findElement(By.id("basicelements")).click();
		wait(3000);
		
		
		verifyJavascriptPrompt("Shamli", "accept", "Hello Shamli! How are you today?");
		verifyJavascriptPrompt("", "dismiss", "User cancelled the prompt.");
		
		System.out.println("STEP-Browser Close");
		driver.close();
	}
	
	public static void main(String[] args) {
		Assignment6 assignment6 = new Assignment6();
		assignment6.testCases();
	}
}
