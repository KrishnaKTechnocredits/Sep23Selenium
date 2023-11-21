/*
 Assignment4 Nov19
- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- Click 'Alert' and verify if alert message contains TechnoCredits
*/
package deepakkumar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment04 {

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

	public void alertCheck() {
		dr.findElement(By.xpath("//a[@id='basicelements']")).click();
		tempWait(5000);

		WebElement e = dr.findElement(By.xpath("//button[@id='javascriptAlert']"));
		scrollFunction(dr, e);
		e.click();

		String alertText = dr.switchTo().alert().getText();
		if (alertText.contains("TechnoCredits")) {
			System.out.println("Alert message contains \"TechnoCredits\"");
			System.out.println("Alert Message is: " + alertText);
		} else
			System.out.println("Alert message does not contains \"TechnoCredits\"");

		dr.switchTo().alert().accept();
	}

	public static void main(String[] args) {
		Assignment04 output = new Assignment04();
		output.launchBrowser("http://automationbykrishna.com/index.html");
		output.alertCheck();
	}
}
