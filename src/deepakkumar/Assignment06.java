/*
 Assignment6 Nov19
- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- click 'Javascript prompt' >> 
a. Enter text and then verify the text
b. Decline and then very the text by getText()

Note: 3 Methods should be created

*/

package deepakkumar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment06 {
	WebDriver dr;
	WebElement e;

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

	public void scrollFunction(WebDriver dr, WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
	}

	public void enterText(String name) {
		String expectedText = "Hello " + name + "! How are you today?";

		launchBrowser("http://automationbykrishna.com/index.html");
		dr.findElement(By.xpath("//a[@id='basicelements']")).click();
		tempWait(4000);

		e = dr.findElement(By.xpath("//button[@id='javascriptPromp']"));
		scrollFunction(dr, e);

		e.click();
		System.out.println("STEP: Enter name Action");
		dr.switchTo().alert().sendKeys(name);
		dr.switchTo().alert().accept();
		String actualText = dr.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();

		if (actualText.equals(expectedText)) {
			System.out.println("PASS, entered text is same as expected!");
		} else
			System.out.println("FAIL, entered text is not same as expected!");
	}

	public void declineAlertAction() {
		System.out.println("STEP: Dismiss Action");
		String expectedText = "User cancelled the prompt.";
		e.click();
		dr.switchTo().alert().dismiss();
		String actualText = dr.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();

		if (actualText.equals(expectedText)) {
			System.out.println("PASS, Cancel Action text is same as expected!");
		} else
			System.out.println("FAIL, Cancel Action text is not same as expected!");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assignment06 output = new Assignment06();
		output.enterText("Deepak");
		output.declineAlertAction();
	}
}
