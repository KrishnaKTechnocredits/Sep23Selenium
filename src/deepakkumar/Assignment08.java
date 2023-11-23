/*
 * Assignment8 Nov19 (Dropdown)
- Navigate to https://www.facebook.com/
- Click on 'Create new accout'
- Enter name, surname, mobile or email & password
- Select DOB
- Select Gender (Actual gender)

Hint: Use select class
selectByText("");
selectByValue("");
selectByIndex();

 */
package deepakkumar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment08 {
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

	public void fbRegistration() {
		launchBrowser("https://www.facebook.com/");
		dr.findElement(By.xpath("//form[@data-testid='royal_login_form']//div[5]/a")).click();
		tempWait(8000);
		dr.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Deepak");
		dr.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Kankhar");
		dr.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("7088768686");
		dr.findElement(By.xpath("//input[@autocomplete='new-password']")).sendKeys("Kankhar");

		Select day = new Select(dr.findElement(By.id("day")));
		day.selectByValue("28");

		Select month = new Select(dr.findElement(By.xpath("//select[@id='month']")));
		month.selectByIndex(8);

		Select year = new Select(dr.findElement(By.id("year")));
		year.selectByVisibleText("1990");

		dr.findElement(By.xpath("//input[@value='2']")).click();

		System.out.println("All the mentioned values selected with Gender as \"Male\"!");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assignment08 output = new Assignment08();
		output.fbRegistration();
	}

}
