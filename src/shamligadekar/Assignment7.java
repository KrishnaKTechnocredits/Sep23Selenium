package shamligadekar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

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
	
	

	void checkboxRadioButtonTestCases() {
		launchBrowser("http://automationbykrishna.com");

		System.out.println("STEP - Click on Basic Elements link");
		driver.findElement(By.id("basicelements")).click();
		wait(3000);

		System.out.println("STEP - Select radio button");
		WebElement radioElement = driver.findElement(By.xpath("//input[@id='optionsRadios2']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", radioElement);
		wait(3000);
		radioElement.click();
		
		
		System.out.println("STEP - Verify radio button selection");
		if(radioElement.isSelected()) {
			System.out.println("Radio button selection test passed");
		}else {
			System.out.println("Radio button selection test failed");
		}
		
		System.out.println("STEP - Select checkbox");
		WebElement checkboxElement = driver.findElement(By.xpath("//input[@id='inlineCheckbox2']"));
		wait(3000);
		checkboxElement.click();
		
		System.out.println("STEP - Verify checkbox selection");
		if(checkboxElement.isSelected()) {
			System.out.println("Checkbox selection test passed");
		}else {
			System.out.println("Checkbox selection test failed");
		}

		System.out.println("STEP - Close browser");
		driver.close();

	}
	public static void main(String[] args) {
		Assignment7 assignment7=new Assignment7();
		assignment7.checkboxRadioButtonTestCases();
	}
}
