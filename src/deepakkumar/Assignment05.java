/*
 Assignment05 Nov19
- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- Click 'Javascript confirmation' >> 
a. Accept and then verify the message by getText()
b. Decline and then verify the message by getText()

*/
package deepakkumar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment05 {

	WebDriver dr;

	public void launchBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get(url);
	}

	public void tempWait(int mSecs) {
		try {
			Thread.sleep(mSecs);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void scrollFunction(WebDriver dr1, WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) dr1;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
	}
	
	public void verifyTextAfterAlertAction() {
		dr.findElement(By.xpath("//a[@id='basicelements']")).click();
		tempWait(5000);
		String OKText = "You pressed OK!";
		String cancelText = "You pressed Cancel!";
		
		WebElement e = dr.findElement(By.id("javascriptConfirmBox"));
		scrollFunction(dr, e);
		e.click();
		
		System.out.println("STEP: Alert \"OK\" ACTION");
		dr.switchTo().alert().accept();
		String actualText = dr.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		
		if (actualText.equals(OKText)) {
			System.out.println("PASS, OK Action text is same!");
			System.out.println("Accept Text is: " + actualText);
		} else
			System.out.println("FAIL, OK Action text is not same!");
		
		e.click();

		System.out.println("STEP: Alert \"Cancel\" ACTION");
		dr.switchTo().alert().dismiss();
		actualText = dr.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		
		if (actualText.contains(cancelText)) {
			System.out.println("PASS, Cancel Action text is same!");
			System.out.println("Cancel Text is: " + actualText);
		} else
			System.out.println("FAIL, Cancel Action text is not same!");
	}
	
	public static void main(String[] args) {
		Assignment05 output = new Assignment05();
		output.launchBrowser("http://automationbykrishna.com/index.html");
		output.verifyTextAfterAlertAction();
	}
}
