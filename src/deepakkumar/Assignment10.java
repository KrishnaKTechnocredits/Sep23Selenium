/*Assignment10 Nov19 (Multiselect dropdown)
- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- Checkboxes and radios - Select multiple checkboxes
*/

package deepakkumar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment10 {
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

	public void scrollFunction(WebDriver dr, WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
	}

	public void checkboxRadioButton() {
		launchBrowser("http://automationbykrishna.com/index.html");
		dr.findElement(By.xpath("//a[@id='basicelements']")).click();
		tempWait(4000);

		WebElement e = dr.findElement(By.xpath("//input[@id='optionsRadios2']"));
		scrollFunction(dr, e);

		System.out.println("---Both Checkboxes Selected----");
		dr.findElement(By.xpath("//div[@class='col-lg-10']/div[1]//input[@type='checkbox']")).click();
		dr.findElement(By.xpath("//div[@class='col-lg-10']/div[2]//input[@type='checkbox']")).click();

		System.out.println("---Second Radio Button Selected----");
		dr.findElement(By.xpath("//input[@id='optionsRadios2']")).click();

		System.out.println("---Single Select Values selected successfully----");
		Select singleSelect = new Select(dr.findElement(By.xpath("//select[@class = 'form-control m-bot15']")));
		singleSelect.selectByIndex(2);

		System.out.println("---Multi Select Values selected successfully----");
		Select multiSelect = new Select(dr.findElement(By.xpath("//select[@class = 'form-control']")));
		multiSelect.selectByIndex(0);
		multiSelect.selectByIndex(3);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assignment10 output = new Assignment10();
		output.checkboxRadioButton();
	}
}
